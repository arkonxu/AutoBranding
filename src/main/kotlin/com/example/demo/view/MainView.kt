package com.example.demo.view

import javafx.beans.property.SimpleBooleanProperty
import javafx.geometry.Pos
import javafx.scene.control.Alert
import javafx.scene.control.CheckBox
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import org.apache.commons.io.FileUtils
import tornadofx.*
import java.io.File
import java.net.URL
import javax.swing.ImageIcon
import javax.xml.soap.Node

class MainView : View("DirectoryChooser") {
    override val root = borderpane()

    private lateinit var targetName: String
    private lateinit var snapshotSchemeName: String
    private lateinit var appIdentifier: String
    private lateinit var targetPlistPath: String
    private lateinit var appName: String
    private lateinit var descriptionEn: String
    private lateinit var descriptionEs: String
    private lateinit var descriptionPt: String
    private lateinit var keywordsEn: String
    private lateinit var keywordsEs: String
    private lateinit var keywordsPt: String
    private lateinit var appVersion: String
    private var isEnglish = SimpleBooleanProperty()
    private var isSpanish = SimpleBooleanProperty()
    private var isPortuguese = SimpleBooleanProperty()
    private var isChinese = SimpleBooleanProperty()
    lateinit var descriptions: MutableList<Node>
    private var yamlFile: File? = null
    private var brandings: List<File>? = null
    private var copyAssets: MutableList<File> = mutableListOf()
    private val logo: Image =
        Image("file:///Users/carlossoler/IdeaProjects/AutoBranding/src/main/resources/odiloLogo.png")
    var iconURL: URL = URL("file:///Users/carlossoler/IdeaProjects/AutoBranding/src/main/resources/odiloLogo.png")
    var imageIcon: java.awt.Image = ImageIcon(iconURL).image
    private val dockLogo: java.awt.Image = imageIcon

    init {
        com.apple.eawt.Application.getApplication().setDockIconImage(dockLogo)
        addStageIcon(logo)
        with(root) {
            title = "AutoBranding"
            center = form {
                hbox {
                    fieldset("Fill the metada for the branding") {
                        field("YAML File") {
                            hbox {
//                            yamlFile = textfield()
//                            button("Open") {
//                                action {
//                                    assetsToCopy = chooseDirectory("Single + non/block")
//                                    if (assetsToCopy != null) {
//                                        assetsToCopyTf.text = "${assetsToCopy}"
//                                    }
//                                }
//                            }
                            }
                        }
                        field("Target name") {
                            targetName = textfield().text
                        }
                        field("Snapshot scheme name") {
                            snapshotSchemeName = textfield().text
                        }
                        field("Target plis path") {
                            targetPlistPath = textfield().text
                        }
                        field("App identifier") {
                            appIdentifier = textfield().text
                        }
                        field("App name") {
                            appName = textfield().text
                        }
                        field("App Version") {
                            appVersion = textfield().text
                        }
                        field("Description EN") {
                            descriptionEn = textarea {
                                prefRowCount = 5
                                vgrow = Priority.ALWAYS
                            }.text

                            isVisible = false
                            isManaged = false
                        }
                        field("Description ES") {
                            descriptionEs = textarea {
                                prefRowCount = 5
                                vgrow = Priority.ALWAYS
                            }.text

                            isVisible = false
                            isManaged = false
                        }
                        field("Description PT") {
                            descriptionPt = textarea {
                                prefRowCount = 5
                                vgrow = Priority.ALWAYS
                            }.text

                            isVisible = false
                            isManaged = false
                        }
                        field("Keywords EN") {
                            keywordsEn = textfield().text
                        }
                        field("Keywords ES") {
                            keywordsEs = textfield().text
                        }
                        field("Keywords PT") {
                            keywordsPt = textfield().text
                        }
                        button("Print") {
                            action {
                                println(descriptionPt)
                            }
                        }
                    }
                    hbox {
                        checkbox("English", isEnglish) {
                            action {
                                if(isEnglish.value) {

                                    (root.center.getChildList()?.get(0) as HBox).getChildList()?.get(0)?.getChildList()
                                        ?.get(8)?.isVisible = true
                                    (root.center.getChildList()?.get(0) as HBox).getChildList()?.get(0)?.getChildList()
                                        ?.get(8)?.isManaged = true
                                } else {
                                    (root.center.getChildList()?.get(0) as HBox).getChildList()?.get(0)?.getChildList()
                                        ?.get(8)?.isVisible = false
                                    (root.center.getChildList()?.get(0) as HBox).getChildList()?.get(0)?.getChildList()
                                        ?.get(8)?.isManaged = false
                                }
                            }
                        }
                        checkbox("Spanish", isSpanish) {
                            action {
                                if(isSpanish.value) {
                                    (root.center.getChildList()?.get(0) as HBox).getChildList()?.get(0)?.getChildList()
                                        ?.get(9)?.isVisible = true
                                    (root.center.getChildList()?.get(0) as HBox).getChildList()?.get(0)?.getChildList()
                                        ?.get(9)?.isManaged = true
                                } else {
                                    (root.center.getChildList()?.get(0) as HBox).getChildList()?.get(0)?.getChildList()
                                        ?.get(9)?.isVisible = false
                                    (root.center.getChildList()?.get(0) as HBox).getChildList()?.get(0)?.getChildList()
                                        ?.get(9)?.isManaged = false
                                }
                            }
                        }
                        checkbox("Portuguese", isPortuguese) {
                            action {
                                if(isPortuguese.value) {
                                    (root.center.getChildList()?.get(0) as HBox).getChildList()?.get(0)?.getChildList()
                                        ?.get(10)?.isVisible = true
                                    (root.center.getChildList()?.get(0) as HBox).getChildList()?.get(0)?.getChildList()
                                        ?.get(10)?.isManaged = true
                                } else {
                                    (root.center.getChildList()?.get(0) as HBox).getChildList()?.get(0)?.getChildList()
                                        ?.get(10)?.isVisible = false
                                    (root.center.getChildList()?.get(0) as HBox).getChildList()?.get(0)?.getChildList()
                                        ?.get(10)?.isManaged = false
                                }
                            }
                        }
                        checkbox("Chinese", isChinese) {
                            action {
                                println(isChinese)
                            }
                        }
                        spacing = 10.00
                    }
                }
            }
        }
    }
}