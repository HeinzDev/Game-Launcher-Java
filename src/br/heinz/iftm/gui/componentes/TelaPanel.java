package br.heinz.iftm.gui.componentes;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaPanel extends JPanel implements ActionListener {
	private JPanel telas;
	private CardLayout controleTela;
	private JFrame janela;
	
	
	public TelaPanel(JPanel telas, JFrame janela) {
		this.telas = telas;
		this.controleTela = (CardLayout) telas.getLayout();
		this.janela = janela;
		this.setBackground(Color.decode("#202028"));
		this.setLayout(null);
		
		Imagem botaoFechar = new Imagem("close.png");
		Imagem botaoMinimizar = new Imagem("minimize.png");
		botaoFechar.setBounds(1880, 0, 36, 36);
		botaoMinimizar.setBounds(1830, 3, 30, 30);
		
		botaoFechar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				janela.dispose();
			}
		});
		
		botaoMinimizar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				janela.setState(JFrame.ICONIFIED);
			}
		});
		
		this.add(botaoMinimizar);
		this.add(botaoFechar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		executarBotao(e);
	}
	
	protected void executarBotao(ActionEvent e) {
		
	}
	
	protected void trocarTela(String identificador) {
		System.out.println(identificador);
		controleTela.show(telas, identificador);
	}
}
