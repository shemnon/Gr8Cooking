
stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth:640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "Layout Nodes", styleClass: 'content-title'

        label vgrow: 'always', styleClass: "content-content",
"""\u2022 Each Layout Has It's Own Node
  \u2022 AnchorPane
  \u2022 BorderPane
  \u2022 FlowPane
  \u2022 GridPane,
  \u2022 HBox / VBox
  \u2022 StackPane,
  \u2022 TilePane"""

    }

}
