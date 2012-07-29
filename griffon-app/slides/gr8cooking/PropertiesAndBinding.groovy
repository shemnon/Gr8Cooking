
stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth:640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "Properties and Binding", styleClass: 'content-title'

        label vgrow: 'always', styleClass: "content-content",
"""\u2022 Swing Properties are a Pattern

\u2022 JavaFX Properties are
First Class Objects, and a Pattern

\u2022 First Class Properties Enables Direct Listening and Binding
"""

    }

}
