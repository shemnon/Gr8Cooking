stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth:640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "Agenda", styleClass: 'content-title'

        label vgrow: 'always', styleClass: "content-content",
"""\u2022 Appetizer
  JavaFX - No Code!

\u2022 Entrée
  GroovyFX - All Code!

\u2022 Desert
  Griffon - Live Code?
"""

    }

}
