package com.arkon.autobranding.view

import com.arkon.autobranding.controller.BitriseController
import javafx.scene.control.Alert
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.stage.FileChooser
import tornadofx.*

class BitriseView : View("DirectoryChooser") {
    val controller: BitriseController by inject()
    override val root = controller.root

    init {
        controller.prepareWindows(currentStage)
        scrollpane {
            with(root) {
                title = "AutoBranding"
                center = form {
                    hbox {
                        fieldset("Fill the metada for the branding") {
                            field("YAML File") {
                                hbox {
                                    controller.yamlFileText = textfield()
                                    button("Open") {
                                        action {
                                            controller.yamlFile = chooseFile(
                                                "Select bitrise.yml",
                                                arrayOf(FileChooser.ExtensionFilter("YAML", "*.yml")),
                                                FileChooserMode.Single
                                            )
                                            if (!controller.yamlFile.isEmpty() && controller.yamlFile[0]?.name?.contains(
                                                    ".yml"
                                                )!!
                                            ) {
                                                controller.yamlFileText.text = "${controller.yamlFile[0]}"
                                            } else {
                                                alert(
                                                    Alert.AlertType.ERROR,
                                                    "Error",
                                                    "You did not select any file, or your file is not yaml",
                                                    owner = currentWindow
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                            field("Target name") {
                                controller.targetName = textfield().text
                            }
                            field("Snapshot scheme name") {
                                controller.snapshotSchemeName = textfield().text
                            }
                            field("Target plis path") {
                                controller.targetPlistPath = textfield().text
                            }
                            field("App identifier") {
                                controller.appIdentifier = textfield().text
                            }
                            field("App name") {
                                controller.appName = textfield().text
                            }
                            field("App Version") {
                                controller.appVersion = textfield().text
                            }
                            controller.descriptionEn =
                                field("Description EN") {
                                    textarea {
                                        prefRowCount = 5
                                        vgrow = Priority.ALWAYS
                                    }.text
                                }
                            controller.descriptionEs =
                                field("Description ES") {
                                    textarea {
                                        prefRowCount = 5
                                        vgrow = Priority.ALWAYS
                                    }.text
                                }
                            controller.descriptionPt =
                                field("Description PT") {
                                    textarea {
                                        prefRowCount = 5
                                        vgrow = Priority.ALWAYS
                                    }.text
                                }
                            controller.descriptionCh =
                                field("Description CH") {
                                    textarea {
                                        prefRowCount = 5
                                        vgrow = Priority.ALWAYS
                                    }.text
                                }
                            controller.keywordsEn =
                                field("Keywords EN") {
                                    textfield().text
                                }
                            controller.keywordsEs =
                                field("Keywords ES") {
                                    textfield().text
                                }
                            controller.keywordsPt =
                                field("Keywords PT") {
                                    textfield().text
                                }
                            controller.keywordsCh =
                                field("Keywords CH") {
                                    textfield().text
                                }
                        }
                        vbox {
                            controller.checkboxsHBox =
                                hbox {
                                    checkbox("English", controller.isEnglish) {
                                        action {
                                            controller.hideShowLanguageFields(
                                                controller.descriptionEn,
                                                controller.keywordsEn,
                                                controller.isEnglish
                                            )
                                        }
                                    }
                                    checkbox("Spanish", controller.isSpanish) {
                                        action {
                                            controller.hideShowLanguageFields(
                                                controller.descriptionEs,
                                                controller.keywordsEs,
                                                controller.isSpanish
                                            )
                                        }
                                    }
                                    checkbox("Portuguese", controller.isPortuguese) {
                                        action {
                                            controller.hideShowLanguageFields(
                                                controller.descriptionPt,
                                                controller.keywordsPt,
                                                controller.isPortuguese
                                            )
                                        }
                                    }
                                    checkbox("Chinese", controller.isChinese) {
                                        action {
                                            controller.hideShowLanguageFields(
                                                controller.descriptionCh,
                                                controller.keywordsCh,
                                                controller.isChinese
                                            )
                                        }
                                    }
                                }
                            controller.buttonsHbox =
                                hbox {
                                    button("Create Workflow") {
                                        action {
                                            println(controller.descriptionPt)
                                        }
                                    }
                                }
                        }
                    }
                }
                controller.prepareFields()
            }
        }
    }
}