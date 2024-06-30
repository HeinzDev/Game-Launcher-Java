package br.heinz.iftm.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.heinz.iftm.gui.componentes.Botao;
import br.heinz.iftm.gui.componentes.Imagem;
import br.heinz.iftm.gui.componentes.TelaPanel;

public class LoginPanel extends TelaPanel {
	
	public LoginPanel(JPanel telas, JFrame janela) {
		super(telas, janela);
		

		
		JTextField txtLogin = new JTextField();
		txtLogin.setBounds(910, 480, 220, 30);
		JTextField txtSenha = new JTextField();
		txtSenha.setBounds(910, 420, 220, 30);
		
		JButton botaoLogin = new Botao("Fazer Login");
		botaoLogin.addActionListener(this);
		this.add(botaoLogin);
		this.add(txtLogin);
		this.add(txtSenha);
	}
	
	public void executarBotao(ActionEvent e) {
		trocarTela("Tela principal");
	}

}
