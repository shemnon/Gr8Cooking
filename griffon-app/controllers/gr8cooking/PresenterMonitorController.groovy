package gr8cooking

class PresenterMonitorController {
    def model
    def view

    def startPresentation = { evt = null ->
        ApplicationHolder.application.createMVCGroup('gr8Cooking')
        ApplicationHolder.application.controllers.gr8Cooking.show()
        model.running = true
    }

    def nextSlide = { evt = null ->
        ApplicationHolder.application.controllers.gr8Cooking.next()
    }
    def previousSlide = { evt = null ->
        ApplicationHolder.application.controllers.gr8Cooking.previous()
    }
}
