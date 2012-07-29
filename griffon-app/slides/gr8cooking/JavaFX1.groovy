
stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth:640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "JavaFX Version 1.x", styleClass: 'content-title'

        label vgrow: 'always', styleClass: "content-content",
"""\u2022 Started in 2006 as 'F3'

\u2022 Used Custom Language JavaFX Script
    \u2022 Poor Polygot Interop
    \u2022 Only JFX Script Could Touch GUI
    \u2022 Not Embedable in Legacy Toolkits

\u2022 Desktop, Mobile, and TV
    \u2022 Anemic Uptake on Phones
    \u2022 No TVs Shipped in US
"""

    }

}
