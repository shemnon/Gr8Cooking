package gr8cooking

import javafx.stage.StageStyle
import groovyx.javafx.GroovyFX
import javafx.animation.Animation
import com.sun.org.apache.xpath.internal.NodeSet


def slideNames = [
        Title,
        AboutMe,
        Agenda,

        JavaFX1,
        JavaFX2,
        GroovyFXSlide,

        JavaFX2BigPoints,
        SceneGraph,
        Nodes,
        LayoutNodes,

        PropertiesAndBinding,

        Controls,

        CSSStyling,

        AnimationSlide,

        Effects,

        MediaSlide,

        Web,

        FXMLSlide,

        Tooling,

        LegacyInterop,

        QnA,
        Thanks,

]
def slides = []


slideNames.each { slideName ->
    println "slide - $slideName"
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
