
stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth:640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, fillWidth: true, {
        title = label "Secret Ingerdient", styleClass: 'content-title'

        stackPane vgrow:'never', {
            secret = imageView resource("/dog-food-bowl-bone.jpeg"), visible:false

            button = button "?", style:"-fx-font-size: 92", onAction: {
                button.visible = false
                secret.visible = true
                title.text = "Dogfood!"
            }
        }


    }

}
