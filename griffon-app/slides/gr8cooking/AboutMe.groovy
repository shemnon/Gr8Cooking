
stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth:640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "About Danno Ferrin", styleClass: 'content-title'

        label vgrow: 'always', styleClass: "content-content",
                """\u2022 First Contributed to Groovy by
  filling in gaps in the SwingBuilder
\u2022 Wrote First AST Transformations
    \u2022 @Bindable and @Vetoable
\u2022 @Grab was a fun weekend hack
\u2022 Co-founded Griffon with James Williams
  and Andres Almiray
\u2022 Works at Intelligent Software Solutions
  in Colorado Springs, CO"""


    }

}
