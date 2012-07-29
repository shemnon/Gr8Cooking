stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth: 640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "WebView", styleClass: 'content-title'

        hbox vgrow: 'always', padding:[20, 20, 20, 20], {
            label vgrow: 'always', styleClass: "content-content", hgrow: 'always',
"""WebView Embeds a WebKit Powered HTML Renderer"""
            web = webView minWidth: 300, prefWidth: 300, maxWidth: 300, minHeight: 300, prefHeight: 300, maxHeight: 300
            web.engine.load('http://gr8conf.us/')
        }
    }

}
