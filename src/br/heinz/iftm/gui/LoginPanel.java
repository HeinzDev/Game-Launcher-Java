package br.heinz.iftm.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class LoginPanel extends StackPane {

    public LoginPanel(Janela janela) {
        VBox vbox = new VBox(10);
        vbox.setStyle("-fx-background-color: #202028; -fx-padding: 20;");
        vbox.setAlignment(Pos.CENTER);

        TextField txtLogin = new TextField();
        txtLogin.setPromptText("Login");
        txtLogin.setMaxWidth(220);
        
        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Senha");
        txtSenha.setMaxWidth(220);
        
        Button botaoLogin = new Button("Login");
        botaoLogin.setOnAction(e -> executarBotao(janela));
        botaoLogin.setStyle("-fx-background-color: #29294d; -fx-font-size: 25; -fx-text-fill: white; -fx-pointer: hand;");

        vbox.getChildren().addAll(txtLogin, txtSenha, botaoLogin);
        
        this.getChildren().add(vbox);
        // Centraliza o VBox dentro do StackPane
        StackPane.setAlignment(vbox, javafx.geometry.Pos.CENTER);
    }

    private void executarBotao(Janela janela) {
        janela.setCenterPanel(new BibliotecaPanel());
    }
}