package br.heinz.iftm.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Janela extends Application {

    private BorderPane root;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Minha Aplicação");
        primaryStage.initStyle(StageStyle.UNDECORATED);

        root = new BorderPane();
        LoginPanel loginPanel = new LoginPanel(this);
        BibliotecaPanel bibliotecaPanel = new BibliotecaPanel();

        root.setCenter(loginPanel);
        root.setTop(createHeader());

        Scene scene = new Scene(root, 1920, 1080);
        scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setCenterPanel(Pane newPanel) {
        root.setCenter(newPanel);
    }

    private HBox createHeader() {
        Image minimizeImage = new Image(getClass().getResourceAsStream("/images/minimize.png"));
        Image closeImage = new Image(getClass().getResourceAsStream("/images/close.png"));

        ImageView minimizeIcon = new ImageView(minimizeImage);
        minimizeIcon.setFitWidth(25);
        minimizeIcon.setFitHeight(25);

        ImageView closeIcon = new ImageView(closeImage);
        closeIcon.setFitWidth(25);
        closeIcon.setFitHeight(25);

        Button btnMinimize = new Button();
        btnMinimize.setGraphic(minimizeIcon);
        btnMinimize.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        btnMinimize.setOnAction(e -> primaryStage.setIconified(true));

        Button btnClose = new Button();
        btnClose.setGraphic(closeIcon);
        btnClose.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        btnClose.setOnAction(e -> primaryStage.close());

        HBox header = new HBox(10);
        header.setStyle("-fx-background-color: #181c24; -fx-padding: 5;");
        header.getChildren().addAll(new Pane(), btnMinimize, btnClose);

        HBox.setHgrow(header.getChildren().get(0), javafx.scene.layout.Priority.ALWAYS);

        return header;
    }

    public static void main(String[] args) {
        launch(args);
    }
}