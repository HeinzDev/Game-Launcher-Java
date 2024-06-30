package br.heinz.iftm.gui.componentes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Imagem extends JLabel {
	public Imagem(String nome) {
		super();
		ImageIcon icone = new ImageIcon(Imagem.class.getResource("/images/" + nome));
		setIcon(icone);
		repaint();
	}
}

