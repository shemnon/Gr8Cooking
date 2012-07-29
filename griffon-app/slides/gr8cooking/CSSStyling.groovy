
stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth:640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "CSS Styling", styleClass: 'content-title'

        label vgrow: 'always', styleClass: "content-content",
"""\u2022 All Nodes are Stylable via a CSS Styling Mechanism

\u2022 This is Not Full HTML5/CSS3 Styling
    \u2714 Selectors
    \u2714 Full Cascading Rules
    \u2714 CSS proeprty Values
    \u2718 Most HTML proeprties
    \u2714 Many JavaFX Properties
"""

    }

}
