package com.arkon.autobranding.controller

import javafx.beans.property.SimpleBooleanProperty
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.stage.Stage
import tornadofx.*
import java.io.File
import java.net.URL
import javax.swing.ImageIcon

class BitriseController: Controller() {
    val root = BorderPane()
    var border2 = BorderPane()
    lateinit var targetName: String
    lateinit var snapshotSchemeName: String
    lateinit var appIdentifier: String
    lateinit var targetPlistPath: String
    lateinit var appName: String
    lateinit var appVersion: String

    lateinit var yamlFileText: TextField

    var descriptionEn = Field()
    var descriptionEs = Field()
    var descriptionPt = Field()
    var descriptionCh = Field()
    var keywordsEn = Field()
    var keywordsEs = Field()
    var keywordsPt = Field()
    var keywordsCh = Field()

    var yamlFile: List<File?> = mutableListOf()

    var isEnglish = SimpleBooleanProperty()
    var isSpanish = SimpleBooleanProperty()
    var isPortuguese = SimpleBooleanProperty()
    var isChinese = SimpleBooleanProperty()


    var checkboxsHBox = HBox()
    var buttonsHbox = HBox()
    var createYmlButton = Button()
    val logo: Image =
        Image("file:///Users/carlossoler/IdeaProjects/AutoBranding/src/main/resources/odiloLogo.png")
    var iconURL: URL = URL("file:///Users/carlossoler/IdeaProjects/AutoBranding/src/main/resources/odiloLogo.png")
    var imageIcon: java.awt.Image = ImageIcon(iconURL).image
    val dockLogo: java.awt.Image = imageIcon

    fun prepareWindows(stage: Stage?) {
        com.apple.eawt.Application.getApplication().setDockIconImage(dockLogo)
        addStageIcon(logo)
        stage?.minWidth = 1000.00
        stage?.minHeight = 950.00
    }

    fun prepareFields() {
        descriptionEn.isVisible = false
        descriptionEn.isManaged = false
        descriptionEs.isVisible = false
        descriptionEs.isManaged = false
        descriptionPt.isVisible = false
        descriptionPt.isManaged = false
        descriptionCh.isVisible = false
        descriptionCh.isManaged = false
        keywordsEn.isVisible = false
        keywordsEn.isManaged = false
        keywordsEs.isVisible = false
        keywordsEs.isManaged = false
        keywordsPt.isVisible = false
        keywordsPt.isManaged = false
        keywordsCh.isVisible = false
        keywordsCh.isManaged = false

        root.bottom = buttonsHbox
        root.top = checkboxsHBox
        buttonsHbox.alignment = Pos.BOTTOM_RIGHT
        buttonsHbox.padding = Insets(20.00)
        buttonsHbox.resize(createYmlButton.width, createYmlButton.height)
        checkboxsHBox.spacing = 10.00
        checkboxsHBox.alignment = Pos.TOP_RIGHT
        checkboxsHBox.padding = Insets(20.00)
    }

    fun hideShowLanguageFields(descriptionField: Field, keywordField: Field, isLanguage: SimpleBooleanProperty) {
        if (isLanguage.value) {
            descriptionField.isVisible = true
            descriptionField.isManaged = true
            keywordField.isVisible = true
            keywordField.isManaged = true
        } else {
            descriptionField.isVisible = false
            descriptionField.isManaged = false
            keywordField.isVisible = false
            keywordField.isManaged = false
        }
    }
}