import javafx.animation.Timeline
import javafx.animation.KeyFrame
import javafx.animation.KeyValue
import javafx.animation.Interpolator

stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth: 640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "Animation and Transition", styleClass: 'content-title'

        gridPane(hgap: 5, vgap: 10, padding: 25, alignment: "top_center", minHeight: 400, prefHeight: 400, maxHeight:400) {
            columnConstraints(hgrow: 'always')
            columnConstraints(hgrow: 'never')
            columnConstraints(minWidth: 100, hgrow: 'sometimes')


            label styleClass: "content-content", row: 0, column: 0,
"""\u2022 Timeline: Animations on any property"""

            slider id: 'slide', min: 0, max: 100, row: 0, column: 1, width: 150, height: 50
            timely = timeline(cycleCount: 2, autoReverse: true)
            ((Timeline)timely).keyFrames <<
                    new KeyFrame(0.s,
                            new KeyValue(slide.valueProperty(), 0.0, Interpolator.EASE_BOTH)
                    )
            ((Timeline)timely).keyFrames <<
                    new KeyFrame(4.s,
                            new KeyValue(slide.valueProperty(), 100, Interpolator.EASE_BOTH))
//             ,  {
//                to(0.s) {
//                    change(slide, 'value') to 0.0 tween EASE_BOTH
//                }
//                to(4.s) {
//                    change(slide, 'value') to 4.0 tween EASE_BOTH
//                }
//        }
            button "Slide", onAction: {timely.play()}, row: 0, column: 2


            label styleClass: "content-content", row: 1, column: 0,
"""\u2022 Transitions: Preconfigured for Common Animations
"""

            rectangle width: 150, height: 50, fill: red, row: 1, column: 1, {
                fader = fadeTransition 4.s, from: 1.0, to: 0.0
            }
            button "Fade", onAction: {fader.play()}, row: 1, column: 2
        }

    }

}
