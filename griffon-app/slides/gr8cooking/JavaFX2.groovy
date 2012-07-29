
stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth:640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "JavaFX Version 2.x", styleClass: 'content-title'

        label vgrow: 'always', styleClass: "content-content",
"""\u2022 Relaunched at JavaOne 2010

\u2022 Pure Java APIs
    \u2022 Improved Polygot Interop
    \u2022 JavaFX Script Given to Community
    \u2022 Embedable in Swing and SWT

\u2022 Desktop Only (for now)
    \u2022 Demoed on iOS and Android
    \u2022 APIs to Support Touchscreens
"""

    }

}
