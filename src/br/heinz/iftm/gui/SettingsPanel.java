package br.heinz.iftm.gui;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SettingsPanel extends VBox {
    public SettingsPanel() {
        this.setStyle("-fx-background-color: #181c24;");
        Label label = new Label("Settings Panel");
        label.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");
        this.getChildren().add(label);
    }
}