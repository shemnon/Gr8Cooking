
stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth:640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "Groovy FX", styleClass: 'content-title'

        label vgrow: 'always', styleClass: "content-content",
"""GroovyFX is the Groovy Language Bindings for JavaFX

\u2022 SwingBuilder Style builders
\u2022 AST Transformations
\u2022 Griffon Plug-in
\u2022 Griffon Archetype
"""

    }

}
