
stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth:640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "JavaFX 2 Overview", styleClass: 'content-title'

        label vgrow: 'always', styleClass: "content-content",
"""\u2022 Scene Graph
\u2022 Properties, Events, and Binding
\u2022 Controls
\u2022 CSS Styling
\u2022 Animations
\u2022 Effects
\u2022 Media
\u2022 Web View
\u2022 Tooling
\u2022 Legacy Interop
"""

    }

}
