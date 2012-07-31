stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth: 640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "Effects", styleClass: 'content-title'
//
//        fxml resource("/Effects.fxml")

        hbox padding: [20, 20, 20, 20], spacing: 30, {


            vbox spacing: 20, hgrow: 'always', {
                stackPane(styleClass: 'effectBox') {
                    effect bloom()
                    text("Bloom", styleClass: 'effectText')
                }
                stackPane(styleClass: 'effectBox') {
                    effect boxBlur()
                    text("Box Blur", styleClass: 'effectText')
                }
                stackPane(styleClass: 'effectBox') {
                    effect colorAdjust(hue: 0.555)
                    text("ColorAdjust", styleClass: 'effectText')
                }
                stackPane(styleClass: 'effectBox') {
                    effect displacementMap(scaleX: 0.9, scaleY: 0.9, offsetX: 0.2, offsetY: 0.1)
                    text("Displacement", styleClass: 'effectText')
                }
                stackPane(styleClass: 'effectBox') {
                    effect dropShadow()
                    text("dropShadow", styleClass: 'effectText')
                }
            }
            vbox spacing: 20, hgrow: 'always', {
                stackPane(styleClass: 'effectBox') {
                    effect gaussianBlur()
                    text("Gaussian Blur", styleClass: 'effectText')
                }
                stackPane(styleClass: 'effectBox') {
                    effect glow()
                    text("Glow", styleClass: 'effectText')
                }
                stackPane(styleClass: 'effectBox') {
                    effect innerShadow()
                    text("Inner Shadow", styleClass: 'effectText')
                }
                stackPane(styleClass: 'effectBox') {
                    effect lighting()
                    text("Lighting", styleClass: 'effectText')
                }
                stackPane(styleClass: 'effectBox') {
                    effect motionBlur()
                    text("Motion Blur", styleClass: 'effectText')
                }
            }
            vbox spacing: 20, hgrow: 'always', {
                stackPane(styleClass: 'effectBox') {
                    effect motionBlur {
                        reflection {
                            glow()
                        }
                    }

                    text("Multi", styleClass: 'effectText')
                }
                stackPane(styleClass: 'effectBox') {
                    effect perspectiveTransform(ulx: 30, uly:6, llx: 30, lly: 30, urx: 150, ury: -6, lrx: 150, lry: 42)
                    text("Perspective", styleClass: 'effectText')
                }
                stackPane(styleClass: 'effectBox') {
                    effect reflection()
                    text("Reflection", styleClass: 'effectText')
                }
                stackPane(styleClass: 'effectBox') {
                    effect sepiaTone()
                    text("Sepia Tone", styleClass: 'effectText')
                }
                stackPane {
                    stackPane(styleClass: 'effectBox') {
                        effect shadow()
                        text("Shadow", styleClass: 'effectText', style: '-fx-fill: white;')
                    }
                    text("Shadow", styleClass: 'effectText', style: '-fx-fill: white;')
                }
            }
        }
    }
}
