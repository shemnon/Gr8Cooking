
stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth:640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "Nodes", styleClass: 'content-title'

        label vgrow: 'always', styleClass: "content-content",
"""\u2022 Every Graphic Item is a Node
  \u2022 Shapes
  \u2022 Parent
    \u2022 Controls
    \u2022 Regions (layout)
    \u2022 Web
  \u2022 Image
  \u2022 Media"""

    }

}
