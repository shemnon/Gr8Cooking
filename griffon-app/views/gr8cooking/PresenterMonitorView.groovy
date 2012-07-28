package gr8cooking

import javafx.stage.StageStyle

application(title: 'Presentation Controller', x:50, y: 100, style:StageStyle.UTILITY) {
    scene(fill: black) {
        vbox {
            hbox {
                button '<<', id:'previous', onAction: controller.previousSlide, disable: bind(model.runningProperty.not())
                button '>>', id:'next', onAction: controller.nextSlide, disable: bind(model.runningProperty.not())
            }
            hbox {
                button '-', id:'previous', onAction: controller.zoomIn, disable: bind(model.runningProperty.not())
                button '+', id:'next', onAction: controller.zoomOut, disable: bind(model.runningProperty.not())
            }
            button "Start", id:'start', onAction: controller.startPresentation, disable: bind(model.runningProperty)
            button "Stop", id:'stop', onAction: controller.stopPresentation, disable: bind(model.runningProperty.not())
            button "Inspect", id:'inspect', onAction: controller.inspectSlide, disable: bind(model.runningProperty.not())
            button "Exit", id:'exit', onAction: controller.exit

            hbox {
                button "()", onAction: controller.applyStyle
                label "Style:"
                comboBox id:'styleCombo', onAction: controller.applyStyle, items: ['Gr8ConfUS.css', 'Awsomeness.css', 'fail.css'], editable:true, value:'Gr8ConfUS.css'
            }
        }
    }
}
