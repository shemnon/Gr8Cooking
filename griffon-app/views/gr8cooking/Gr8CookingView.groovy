package gr8cooking

import javafx.stage.StageStyle

def slides = []

def slideNames = [
        Title,
        AboutMe,
]

slideNames.each { slideName ->
    if (app.views.containsKey(slideName)) {
        slides << app.views[slideName]
    } else {
        slides << build(slideName)
    }

}

stage(title: 'Gr8Cooking', id: 'presentation', primary: false, centerOnScreen: true) {
    myScene = scene(fill: black, width: 1024, height: 768) {
        deck = node(new DisplayShelf(slides))
    }
}
