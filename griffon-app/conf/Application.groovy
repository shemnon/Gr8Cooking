application {
    title = 'Gr8Cooking'
    startupGroups = ['presenterMonitor']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "presenterMonitor"
    'presenterMonitor' {
        model      = 'gr8cooking.PresenterMonitorModel'
        view       = 'gr8cooking.PresenterMonitorView'
        controller = 'gr8cooking.PresenterMonitorController'
    }

    // MVC Group for "gr8Cooking"
    'gr8Cooking' {
        model      = 'gr8cooking.Gr8CookingModel'
        view       = 'gr8cooking.Gr8CookingView'
        controller = 'gr8cooking.Gr8CookingController'
    }

}
