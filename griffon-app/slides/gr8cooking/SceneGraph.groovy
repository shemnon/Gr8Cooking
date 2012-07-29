stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth: 640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "JavaFX Scene Graph", styleClass: 'content-title'

        hbox vgrow: 'always', {
            fxml resource("/SceneGraph.fxml")
            label hgrow: 'always', styleClass: "content-content",
        """\u2022 JavaFX uses a
Display List

\u2022 Swing, et. al. use
Retained Mode Graphics"""
        }

    }

}
