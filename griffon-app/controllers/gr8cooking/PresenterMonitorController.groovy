package gr8cooking

class PresenterMonitorController {
    def model
    def view

    def startPresentation = { evt = null ->
        if (model.deckController == null) {
            def (m, v, c) = app.createMVCGroup('gr8Cooking')
            model.deckController = c
        }
        model.deckController.show()
        model.running = true
    }

    def stopPresentation = { evt = null ->
        if (model.deckController) {
            model.deckController.hide()
        }
        model.running = false
    }

    def exit = {evt = null ->
        javafx.application.Platform.exit()
        System.exit(0) // Mac 7u6ea hack
    }

    def nextSlide = { evt = null ->
        model.deckController.next()
    }
    def previousSlide = { evt = null ->
        model.deckController.previous()
    }

    def zoomIn = { evt = null ->
        model.deckController.zoomIn()
    }
    def zoomOut = { evt = null ->
        model.deckController.zoomOut()
    }

    def inspectSlide = { evt = null ->
        model.deckController.inspectSlide()
    }

    def applyStyle = { evt = null ->
        model.deckController?.applyStyle(view.styleCombo.value)
    }
}
