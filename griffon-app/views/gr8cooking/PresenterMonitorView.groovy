package gr8cooking

application(title: 'Presentation Controller', x:0) {
    scene(fill: black) {
        vbox {
            hbox {
                button '<<', id:'previous', onAction: controller.previousSlide, disable: bind(model.runningProperty.not())
                button '>>', id:'next', onAction: controller.nextSlide, disable: bind(model.runningProperty.not())
            }
            button "Start", id:'start', onAction: controller.startPresentation
        }
    }
}
