stackPane(id: "About Me") {
    rectangle(width: 640, height: 480, fill: GROOVYBLUE, stroke: blue)
    hbox(padding: 120) {
        text(text: "Java", font: "80pt sanserif") {
            fill linearGradient(endX: 0, stops: [[0, orange], [1, chocolate]])
        }
        text(text: "FX", font: "80pt sanserif") {
            fill linearGradient(endX: 0, stops: [[0, cyan], [1, dodgerblue]])
            effect dropShadow(color: dodgerblue, radius: 25, spread: 0.25)
        }
        text(text: "Magnets!", font: "80pt sanserif") {
            fill linearGradient(endX: 0, stops: [[0, yellow], [1, green]])
            effect dropShadow(color: green, radius: 25, spread: 0.25)
        }
    }
}