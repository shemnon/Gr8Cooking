
stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth:640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "JavaFX Legacy Interop", styleClass: 'content-title'

        label vgrow: 'always', styleClass: "content-content",
"""\u2022 JavaFX 2.0 can be Embedded in
  \u2022 Swing
  \u2022 SWT

Embedding is one way, you cannot embed Swing in JavaFX 2.x
"""

    }

}
