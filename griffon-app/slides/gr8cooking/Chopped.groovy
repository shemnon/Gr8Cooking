
stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth:640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, fillWidth: true, {
        label "Chopped", styleClass: 'content-title'

        hbox padding:[0, 160, 0, 160], {
            imageView resource("/chopped.jpeg")
        }

        label styleClass: "content-content",
"""Watch on Food Network"""

    }

}
