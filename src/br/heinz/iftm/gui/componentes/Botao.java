package br.heinz.iftm.gui.componentes;

import java.awt.Color;

import javax.swing.JButton;

public class Botao extends JButton {
	public Botao(String texto) {
		super(texto);
		this.setBounds(1920 / 2, 600, 120, 50);
		this.setBackground(Color.decode("#6d5dd3"));
		this.setFocusPainted(false);
		this.setBorderPainted(false);
	}
}
