package gr8cooking

import griffon.transform.Threading

class Gr8CookingController {
    def model
    def view

    // void mvcGroupInit(Map args) {
    //    // this method is called after model and view are injected
    // }

    // void mvcGroupDestroy() {
    //    // this method is called when the group is destroyed
    // }

    def anAction = { evt = null ->
        // this is how you define an action closure that is called from a view
    }

    @Threading(Threading.Policy.INSIDE_UITHREAD_ASYNC)
    def show() {
        view.presentation.show()
    }

    @Threading(Threading.Policy.INSIDE_UITHREAD_ASYNC)
    def hide() {
        view.presentation.hide()
    }

    @Threading(Threading.Policy.INSIDE_UITHREAD_ASYNC)
    def next() {
        view.deck.shift(-1)
    }

    @Threading(Threading.Policy.INSIDE_UITHREAD_ASYNC)
    def previous() {
        view.deck.shift(1)
    }

    @Threading(Threading.Policy.INSIDE_UITHREAD_ASYNC)
    def zoomIn() {
        view.deck.scaleX /= 1.1
        view.deck.scaleY /= 1.1
        view.presentation.width /= 1.1
        view.presentation.height /= 1.1
    }

    @Threading(Threading.Policy.INSIDE_UITHREAD_ASYNC)
    def zoomOut() {
        view.deck.scaleX *= 1.1
        view.deck.scaleY *= 1.1
        view.presentation.width *= 1.1
        view.presentation.height *= 1.1
    }
}
