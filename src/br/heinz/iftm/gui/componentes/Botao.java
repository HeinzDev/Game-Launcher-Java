package br.heinz.iftm.gui.componentes;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Botao extends Button {
	public Botao(String texto, int size) {
		Image image = new Image(getClass().getResourceAsStream(texto));
		ImageView imgVw = new ImageView(image);
		imgVw.setFitHeight(size);
		imgVw.setFitWidth(size);
		imgVw.setOpacity(0.7);

		this.setOnMouseEntered(event -> {
			imgVw.setOpacity(1);
		});
		this.setOnMouseExited(event -> {
			imgVw.setOpacity(0.7);
		});

		this.setGraphic(imgVw);
		this.getStyleClass().add("btn");
		this.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; fx-cursor: hand;");
	}
}
