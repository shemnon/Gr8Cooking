
stackPane(styleClass: 'slide', maxWidth: 640, maxHeight: 480, width: 640, height: 480, minWidth:640, minHeight: 480) {
    rectangle(styleClass: 'filler', width: 640, height: 480)

    vbox width: 640, {
        label "Tooling", styleClass: 'content-title'

        label vgrow: 'always', styleClass: "content-content",
"""\u2022 Scenic View
  Live Viewing and Editing of Scene Graph

\u2022 Scene Builder
  Stand Alone and Integrated Visual Design

(Some of this presentation was written in Scene Builder)
"""

    }

}
