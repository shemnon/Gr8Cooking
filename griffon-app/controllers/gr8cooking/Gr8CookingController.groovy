package gr8cooking

import griffon.transform.Threading
import com.javafx.experiments.scenicview.ScenicView

class Gr8CookingController {
    def model
    def view

    void mvcGroupInit(Map<String, Object> args) {
        applyStyle('Gr8ConfUS.css')
    }

    @Threading(Threading.Policy.INSIDE_UITHREAD_ASYNC)
    def show() {
        view.presentation?.show()
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

    @Threading(Threading.Policy.INSIDE_UITHREAD_ASYNC)
    def inspectSlide() {
        // buggy, inspect all instead
        //ScenicView.show(view.deck.centeredItem)
        ScenicView.show(view.myScene)
    }

    @Threading(Threading.Policy.INSIDE_UITHREAD_ASYNC)
    def applyStyle(def style) {
        view.myScene.stylesheets.clear()
        view.myScene.stylesheets << style
    }

}
