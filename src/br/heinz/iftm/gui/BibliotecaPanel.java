package br.heinz.iftm.gui;

import br.heinz.iftm.gui.componentes.Botao;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class BibliotecaPanel extends VBox {
    private BorderPane mainLayout;

    public BibliotecaPanel() {
        this.setStyle("-fx-background-color: #181c24;");
        this.setPrefSize(1920, 1080);

        // Create the three panels
        HomePanel homePanel = new HomePanel();
        SearchPanel searchPanel = new SearchPanel();
        SettingsPanel settingsPanel = new SettingsPanel();

        // Left Panel
        Rectangle clip2 = new Rectangle(70, 980);
        clip2.setArcHeight(30);
        clip2.setArcWidth(30);

        Botao homeButton = new Botao("/images/home.png", 40);
        Botao searchButton = new Botao("/images/search.png", 40);
        Botao gearButton = new Botao("/images/gear.png", 40);

        homeButton.setOnAction(e -> switchPanel(homePanel));
        searchButton.setOnAction(e -> switchPanel(searchPanel));
        gearButton.setOnAction(e -> switchPanel(settingsPanel));

        VBox panelButtons = new VBox();
        panelButtons.setStyle("-fx-background-color: #26273b;");
        panelButtons.setAlignment(Pos.CENTER);
        panelButtons.setSpacing(15);
        panelButtons.setMinHeight(990);
        panelButtons.getChildren().addAll(homeButton, searchButton, gearButton);
        panelButtons.getStylesheets().add(getClass().getResource("/styles/button.css").toExternalForm());
        panelButtons.setClip(clip2);

        VBox leftPanel = new VBox();
        leftPanel.setStyle("-fx-background-color: #181c24;");
        leftPanel.setMinWidth(90.0);
        leftPanel.setAlignment(Pos.CENTER);
        leftPanel.setPadding(new Insets(0, 10, 0, 10));
        leftPanel.getChildren().addAll(panelButtons);

        // Main Layout
        mainLayout = new BorderPane();
        mainLayout.setPrefSize(1920, 1080);
        mainLayout.setLeft(leftPanel);
        mainLayout.setCenter(homePanel);

        this.getChildren().add(mainLayout);
    }

    private void switchPanel(VBox panel) {
        mainLayout.setCenter(panel);
    }
}
