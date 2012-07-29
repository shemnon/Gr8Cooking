stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth: 640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "Media", styleClass: 'content-title'

        hbox {

            label """Can play most modern codecs""", vgrow: 'always', styleClass: 'content-content'
            vbox padding: [20,20.20,20], {
                mediaView(layoutX: 20, fitHeight: 240, fitWidth: 320,
                        mediaPlayer: player = mediaPlayer(source: this.class.getResource('NyanCat.mp4'), autoPlay: false))

                hbox(spacing: 10, padding: [10, 20, 10, 10]) {
                    button "Play", onAction: {player.play(); stopButton.visible = true}
                    button "MAKE IT STOP!", onAction: {player.stop()}, visible: false, id: 'stopButton'
                }
            }
        }
    }
}