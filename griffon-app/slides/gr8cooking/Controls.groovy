stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth: 640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, fillWidth: false, {
        label "Controls", styleClass: 'content-title'

        hbox vgrow: 'always', padding: [0, 0, 20, 20], fillHeight: false, {

            label styleClass: "content-content",
"""\u2022JavaFX has
Nodes for most
of the typical
Controls/
Widgets
"""
            fxml resource('/Controls.fxml')
        }

    }

}
