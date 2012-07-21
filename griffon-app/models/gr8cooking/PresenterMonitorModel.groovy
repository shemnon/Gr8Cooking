package gr8cooking

import groovyx.javafx.beans.FXBindable

class PresenterMonitorModel {

    @FXBindable
    boolean running = false

    def deckController
}
