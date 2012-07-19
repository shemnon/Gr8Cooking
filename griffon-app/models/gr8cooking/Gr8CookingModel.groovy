package gr8cooking

import groovyx.javafx.beans.FXBindable
import griffon.util.GriffonNameUtils

class Gr8CookingModel {
    @FXBindable String message

    void mvcGroupInit(Map args) {
        message = "Welcome to ${GriffonNameUtils.capitalize(app.config.application.title)}, a JavaFX application"
    }
}
