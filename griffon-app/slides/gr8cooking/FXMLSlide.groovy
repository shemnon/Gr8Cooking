stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth: 640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "FXML", styleClass: 'content-title'



        label vgrow: 'always', styleClass: "content-content",
"""FXML is a XML serialization of a Scene Graph

Think Interface Builder"""

        //GroovyFX allows references into the FXML

        fxml resource("/FXMLDemoInline.fxml"), vgrow: 'always', {
            buttonCSSID.onAction {
                labelCSSID.text = "Clicked - CSS";
            }
            buttonFXID.onAction {
                labelFXID.text = "Clicked - FXML";
            }
        }

    }

}
