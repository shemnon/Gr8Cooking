package gr8cooking

import javafx.stage.StageStyle
import javafx.event.EventHandler

application(title: 'Presentation Controller', x:50, y: 100, style:StageStyle.UTILITY) {
    onCloseRequest {
        controller.exit()
    }

    scene(fill: white) {
        fxml resource("/Controller.fxml"), {
            previousButton.onAction controller.previousSlide
            nextButton.onAction controller.nextSlide

            zoomInButton.onAction controller.zoomOut
            zoomOutButton.onAction controller.zoomIn

            playButton.onAction controller.startPresentation
            stopButton.onAction controller.stopPresentation

            inspectButton.onAction controller.inspectSlide
            ejectButton.onAction controller.exit

            println refreshButton.onAction
            refreshButton.onAction controller.applyStyle
            println refreshButton.onAction

            stylesheetCombo.items.clear()
            stylesheetCombo.items.addAll(['Gr8ConfUS.css', 'Awsomeness.css', 'fail.css'])
            stylesheetCombo.value = 'Gr8ConfUS.css'
            println stylesheetCombo.onAction
            println controller.applyStyle
            model.stylesheetProperty.bind(stylesheetCombo.selectionModel.selectedItemProperty())
            stylesheetCombo.onAction  = controller.applyStyle as EventHandler
            println stylesheetCombo.onAction

            [previousButton, nextButton, zoomInButton, zoomOutButton, stopButton, inspectButton].each {
                it.disableProperty().bind(model.runningProperty.not())
            }
            playButton.disableProperty().bind(model.runningProperty)
        }
    }
}
