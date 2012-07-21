package gr8cooking

import com.javafx.experiments.scenicview.ScenicView
import javafx.stage.StageStyle

def items = []
(1..100).each { n ->
    javafx.scene.Node fxnode = stackPane(id: "Pane $n") {
        rectangle(width: 640, height: 480, fill:GROOVYBLUE, stroke: blue)
        hbox(padding: 120) {
            text(text: "Java", font: "80pt sanserif") {
                fill linearGradient(endX: 0, stops: [[0, orange], [1, chocolate]])
            }
            text(text: "FX", font: "80pt sanserif") {
                fill linearGradient(endX: 0, stops: [[0, cyan], [1, dodgerblue]])
                effect dropShadow(color: dodgerblue, radius: 25, spread: 0.25)
            }
            text(text: "$n", font: "80pt sanserif") {
                fill linearGradient(endX: 0, stops: [[0, yellow], [1, green]])
                effect dropShadow(color: green, radius: 25, spread: 0.25)
            }
        }
    }
    items << fxnode
}


stage(title: 'Gr8Cooking', id: 'presentation', primary: false, style: StageStyle.TRANSPARENT) {
    myScene = scene(fill: black, width: 1024, height: 768) {
        deck = node(new DisplayShelf(items))
    }
}
