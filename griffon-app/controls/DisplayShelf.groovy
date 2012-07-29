import groovyx.javafx.beans.FXBindable
import javafx.animation.Interpolator
import javafx.animation.KeyFrame
import javafx.animation.KeyValue
import javafx.animation.Timeline
import javafx.beans.property.DoubleProperty
import javafx.beans.value.ChangeListener
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.effect.PerspectiveTransform
import javafx.scene.effect.ReflectionBuilder
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.layout.Region
import javafx.scene.layout.StackPane
import javafx.scene.shape.Rectangle
import javafx.util.Duration


/**
 * A ui control which displays a browse able display shelf of nodes
 */
public class DisplayShelf extends Region {
    private static final Duration DURATION = Duration.millis(500);
    private static final Interpolator INTERPOLATOR = Interpolator.EASE_BOTH;
    private static final double SPACING = 50;
    private static final double SCALE_SMALL = 0.7;
    private static final int SPILLOVER = 8;
    private List<PerspectiveNode> items;
    private StackPane left = new StackPane();
    private StackPane center = new StackPane();
    private StackPane right = new StackPane();
    private int centerIndex = 0;
    private Timeline timeline;
    private Rectangle clip = new Rectangle();

    public DisplayShelf(List<Node> nodes) {
        // set background gradient using css
        style = "-fx-background-color: linear-gradient(to bottom," +
                " black 60, #141414 60.1%, black 100%);";
        // create items
        items = [];

        nodes.each {Node node ->
            PerspectiveNode that = new PerspectiveNode(node);

            that.translateX = 4000
            that.scaleX = SCALE_SMALL
            that.scaleY = SCALE_SMALL
            that.angle = 135

            items << that
        }
        // create content
        children.addAll(left, right, center);
        // listen for keyboard events
        focusTraversable = true;
        onKeyPressed = {KeyEvent ke ->
            if (ke.code == KeyCode.LEFT) {
                shift(1);
            } else if (ke.code == KeyCode.RIGHT) {
                shift(-1);
            }
        } as EventHandler<KeyEvent>

        // update
        update();
        left.id = "Left"
        center.id = "Center"
        right.id = "Right"
    }

    @Override protected void layoutChildren() {
        // update clip to our size
        clip.width = width
        clip.height = height
        [left, center, right].each {
            it.layoutX = 0
            it.layoutY = 0
            it.width = width
            it.height = height
        }
    }

    private void update() {
        // move items to new homes in groups
        [left, center, right].each { it.children.clear()}
        int max = Math.min(SPILLOVER, centerIndex)
        if (max > 0) {
            left.children.addAll(items[(centerIndex-max)..(centerIndex-1)])
        }
        center.children.addAll(items[centerIndex])
        max = Math.min(items.size()-1, centerIndex+SPILLOVER)
        if (max < items.size() && ((centerIndex+1) < items.size())) {
            right.children.addAll(items[max..(centerIndex+1)])
        }
        // stop old timeline if there is one running
        if (timeline != null) timeline.stop();
        items*.visible = false
        // add keyframes for left items
        def keyFrames = []
        PerspectiveNode centerItem = items[centerIndex];
        double offset = centerItem.width / 2 + 10
        for (int i = 0; i < left.children.size(); i++) {
            final PerspectiveNode it = left.children[i];
            double newX = -left.children.size() *
                    SPACING + SPACING * i - offset;
            keyFrames << new KeyFrame(DURATION,
                    new KeyValue(it.translateXProperty(), newX, INTERPOLATOR),
                    new KeyValue(it.scaleXProperty(), SCALE_SMALL, INTERPOLATOR),
                    new KeyValue(it.scaleYProperty(), SCALE_SMALL, INTERPOLATOR),
                    new KeyValue(it.angleProperty, 45.0, INTERPOLATOR))
            it.visible = true
        }
        // add keyframe for center item
        keyFrames << new KeyFrame(DURATION,
                new KeyValue(centerItem.translateXProperty(), 0, INTERPOLATOR),
                new KeyValue(centerItem.scaleXProperty(), 1.0, INTERPOLATOR),
                new KeyValue(centerItem.scaleYProperty(), 1.0, INTERPOLATOR),
                new KeyValue(centerItem.angleProperty, 90.0, INTERPOLATOR))
        centerItem.visible = true
        // add keyframes for right items
        for (int i = right.children.size() - 1; i >= 0; i--) {
            final PerspectiveNode it = right.children[i];
            final double newX = SPACING * right.children.size() - SPACING * i + offset;
            keyFrames << new KeyFrame(DURATION,
                    new KeyValue(it.translateXProperty(), newX, INTERPOLATOR),
                    new KeyValue(it.scaleXProperty(), SCALE_SMALL, INTERPOLATOR),
                    new KeyValue(it.scaleYProperty(), SCALE_SMALL, INTERPOLATOR),
                    new KeyValue(it.angleProperty, 135.0, INTERPOLATOR))
            it.visible = true
        }
        // play animation
        // create timeline to animate to new positions
        timeline = new Timeline(* keyFrames);
        timeline.play();
    }

    void shiftToCenter(PerspectiveNode item) {
        for (int i = 0; i < left.children.size(); i++) {
            if (left.children.get(i) == item) {
                int shiftAmount = left.children.size() - i;
                shift(shiftAmount);
                return;
            }
        }
        if (center.children.get(0) == item) {
            return;
        }
        for (int i = 0; i < right.children.size(); i++) {
            if (right.children.get(i) == item) {
                int shiftAmount = -(right.children.size() - i);
                shift(shiftAmount);
                return;
            }
        }
    }

    void shift(int shiftAmount) {
        if (centerIndex <= 0 && shiftAmount > 0) return;
        if (centerIndex >= items.size() - 1 && shiftAmount < 0) return;
        centerIndex -= shiftAmount;
        update();
    }

    Parent getCenteredItem() {
        return center.children[0]
    }
}

/**
 * A Node that displays it's children with some 2.5D perspective rotation around the Y axis.
 */
public class PerspectiveNode extends Parent {
    private static final double REFLECTION_SIZE = 0.25;
    private PerspectiveTransform pTransform = new PerspectiveTransform();

    @FXBindable
    double angle

    double width;
    double height;
    double radius_h;
    double back;

    def preSize(double w, double h) {
        width = w
        height = h + h * REFLECTION_SIZE
        radius_h = w / 2
        back = w / 10
    }
    /** Angle Property */
    public PerspectiveNode(Node view) {
        angleProperty.addListener({DoubleProperty property, double oldValue, double newValue ->
            // when angle changes calculate new transform
            double lx = (radius_h - Math.sin(Math.toRadians(newValue)) * radius_h - 1);
            double rx = (radius_h + Math.sin(Math.toRadians(newValue)) * radius_h + 1);
            double uly = (-Math.cos(Math.toRadians(newValue)) * back);
            double ury = -uly;
            pTransform.ulx = lx;
            pTransform.uly = uly;
            pTransform.urx = rx;
            pTransform.ury = ury;
            pTransform.lrx = rx;
            pTransform.lry = height + uly;
            pTransform.llx = lx;
            pTransform.lly = height + ury;
            opacity = (100 - Math.abs(90 - newValue)) / 100.0
        } as ChangeListener<Double>)
        angle = 45
        preSize(view.prefWidth(-1), view.prefHeight(-1))
        view.effect = ReflectionBuilder.create().topOffset(10).fraction(REFLECTION_SIZE).build();
        effect = pTransform;
        children.addAll(view);
    }
}
