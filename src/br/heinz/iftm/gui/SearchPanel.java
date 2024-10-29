package br.heinz.iftm.gui;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SearchPanel extends VBox {
    public SearchPanel() {
        this.setStyle("-fx-background-color: #181c24;");
        Label label = new Label("Search Panel");
        label.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");
        this.getChildren().add(label);
    }
}
