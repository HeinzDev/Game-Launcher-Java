package br.heinz.iftm.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

import br.heinz.iftm.gui.componentes.Botao;
import br.heinz.iftm.modelos.Jogo;

public class BibliotecaPanel extends VBox {
    private HBox hbox; 
    private ImageView imagemFundo;
    private Label labelJogo;
    private Button botaoJogar;
    private ArrayList<Jogo> jogos;
    private Jogo jogoSelecionado;

    public BibliotecaPanel() {
        this.jogos = new ArrayList<>();
        this.setStyle("-fx-background-color: #181c24;");
        this.setPrefSize(1920, 1080);

        //Games ScrollPane
        hbox = new HBox(22);
        hbox.setStyle("-fx-background-color: #202028;");
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setPrefWidth(2000);

        ScrollPane scrollPane = new ScrollPane(hbox);
        scrollPane.setPrefHeight(450);
        scrollPane.setMaxWidth(1780);
        scrollPane.setPadding(new Insets(0,10,0,10));
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.getStylesheets().add(getClass().getResource("/styles/scroll.css").toExternalForm());

        imagemFundo = new ImageView();


        //Rounded borders mask
        Rectangle clip = new Rectangle(1800, 980);
        clip.setArcWidth(40); 
        clip.setArcHeight(40);

        imagemFundo.setClip(clip);


        //Game Title and Play button
        labelJogo = new Label();
        labelJogo.setVisible(false);
        labelJogo.setPadding(new Insets(20, 0, 0, 20));
        labelJogo.getStyleClass().add("text");


        botaoJogar = new Button("Play");
        botaoJogar.setVisible(false);
        botaoJogar.setPadding(new Insets(10, 20, 10, 20));
        botaoJogar.getStyleClass().add("botao");

        botaoJogar.setOnMouseEntered(event -> {
            botaoJogar.setScaleX(1.05);
            botaoJogar.setScaleY(1.05);
        });

        botaoJogar.setOnMouseExited(event -> {
            botaoJogar.setScaleX(1.0);
            botaoJogar.setScaleY(1.0);
        });

        botaoJogar.setOnAction(event -> {try { 
            executarJogo(); 
        } catch (Exception e) {e.printStackTrace();}});


        //Game Selection containers
        HBox labelContainer = new HBox();
        labelContainer.setAlignment(Pos.TOP_LEFT);
        labelContainer.getChildren().add(labelJogo);
        labelContainer.setMinHeight(300.0);

        HBox ScrollContainer = new HBox();
        ScrollContainer.setPadding(new Insets(0,10,0,10));
        ScrollContainer.getChildren().add(scrollPane);

        HBox buttonContainer = new HBox();
        buttonContainer.setStyle("-fx-padding: 10px;");
        buttonContainer.setAlignment(Pos.CENTER_RIGHT);
        buttonContainer.getChildren().add(botaoJogar);

        VBox itemsLayout = new VBox(10);
        itemsLayout.setAlignment(Pos.TOP_LEFT);
        itemsLayout.setPadding(new Insets(20));
        itemsLayout.getChildren().addAll(labelContainer, ScrollContainer, buttonContainer);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imagemFundo, itemsLayout);
        stackPane.setMaxWidth(1840.0);



        //Left Panel
        Rectangle clip2 = new Rectangle(70, 980);
        clip2.setArcHeight(30);
        clip2.setArcWidth(30);

        Botao homeButton = new Botao("/images/home.png", 40);
        Botao searchButton = new Botao("/images/search.png", 40);
        Botao gearButton = new Botao("/images/gear.png", 40);


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
        leftPanel.setPadding(new Insets(0,10,0,10));
        
        leftPanel.getChildren().addAll(panelButtons);
        

        //Add left panel and Game Select on center
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPrefSize(1920, 1080);
        mainLayout.setLeft(leftPanel);
        mainLayout.setCenter(stackPane);

        this.getChildren().add(mainLayout);

        carregarJogos();
        exibirJogos();
    }
    
    private void exibirJogos() {
        int imgSize = 300;
    
        for (Jogo jogo : jogos) {
            String icone = jogo.getIcone();
            ImageView imagem = new ImageView(new Image(getClass().getResourceAsStream("/images/" + icone)));
            imagem.setFitWidth(imgSize);
            imagem.setFitHeight(400);
            imagem.setPreserveRatio(true);
            imagem.setOnMouseClicked(e -> selecionarJogo(jogo));
    
            hbox.getChildren().add(imagem);
        }
    }

    private void carregarJogos() {
        String jsonString = lerJsonJogos();
        if (jsonString == null || jsonString.isEmpty()) {
            System.out.println("O JSON está vazio ou não foi carregado.");
            return;
        }

        JSONArray jsonArray = new JSONArray(jsonString);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jogoObject = (JSONObject) jsonArray.get(i);
            Jogo jogo = new Jogo(jogoObject);
            jogos.add(jogo);
        }
    }

    private void selecionarJogo(Jogo jogo) {
        jogoSelecionado = jogo;
        botaoJogar.setVisible(true);
        labelJogo.setText(jogo.getNome());
        labelJogo.setVisible(true);

        String fundo = jogo.getFundo();
            trocarImagemFundo(fundo);
    }

    private void trocarImagemFundo(String imagem) {
        imagemFundo.setImage(new Image(getClass().getResourceAsStream("/images/" + imagem)));
        imagemFundo.setFitWidth(1800);
        imagemFundo.setFitHeight(990);
    }

    private void executarJogo() throws Exception {
        if (jogoSelecionado == null) {
            throw new Exception("Nenhum jogo selecionado");
        }

        String command = "steam steam://rungameid/" + jogoSelecionado.getCaminho();
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String lerJsonJogos() {
        File arquivoJson = new File("jogos.json");
        StringBuilder conteudoArquivo = new StringBuilder();

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivoJson));

            String linha = leitor.readLine();
            while (linha != null) {
                conteudoArquivo.append(linha);
                linha = leitor.readLine();
            }

            leitor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conteudoArquivo.toString();
    }
}
