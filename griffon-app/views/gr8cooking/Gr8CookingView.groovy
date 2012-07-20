package gr8cooking

import com.javafx.experiments.scenicview.ScenicView

def items = [
        hbox(padding: 80, style:'-fx-background-color: groovyblue; -fx-border-color: blue;') {
            text(text: "Java", font: "80pt sanserif") {
                fill linearGradient(endX: 0, stops: [[0, orange], [1, chocolate]])
            }
            text(text: "FX", font: "80pt sanserif") {
                fill linearGradient(endX: 0, stops: [[0, cyan], [1, dodgerblue]])
                effect dropShadow(color: dodgerblue, radius: 25, spread: 0.25)
            }
        },
        hbox(padding: 40, style:'-fx-background-color: groovyblue; -fx-border-color: blue;') {
            text(text: "Java", font: "80pt sanserif") {
                fill linearGradient(endX: 0, stops: [[0, orange], [1, chocolate]])
            }
            text(text: "FX", font: "80pt sanserif") {
                fill linearGradient(endX: 0, stops: [[0, cyan], [1, dodgerblue]])
                effect dropShadow(color: dodgerblue, radius: 25, spread: 0.25)
            }
        },
        hbox(padding: 20, style:'-fx-background-color: groovyblue; -fx-border-color: blue;') {
            text(text: "Java", font: "80pt sanserif") {
                fill linearGradient(endX: 0, stops: [[0, orange], [1, chocolate]])
            }
            text(text: "FX", font: "80pt sanserif") {
                fill linearGradient(endX: 0, stops: [[0, cyan], [1, dodgerblue]])
                effect dropShadow(color: dodgerblue, radius: 25, spread: 0.25)
            }
        },
        hbox(padding: 0, style:'-fx-background-color: groovyblue; -fx-border-color: blue;') {
            text(text: "Java", font: "80pt sanserif") {
                fill linearGradient(endX: 0, stops: [[0, orange], [1, chocolate]])
            }
            text(text: "FX", font: "80pt sanserif") {
                fill linearGradient(endX: 0, stops: [[0, cyan], [1, dodgerblue]])
                effect dropShadow(color: dodgerblue, radius: 25, spread: 0.25)
            }
        },
]

stage(title: 'Gr8Cooking', id:'presentation', primary:false) {
    myScene = scene(fill: black, width: 800, height: 600) {
        deck = node(new DisplayShelf(items))
    }
}
