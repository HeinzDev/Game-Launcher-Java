package br.heinz.iftm.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import org.json.JSONArray;
import org.json.JSONObject;

import br.heinz.iftm.gui.componentes.Botao;
import br.heinz.iftm.gui.componentes.Imagem;
import br.heinz.iftm.gui.componentes.TelaPanel;
import br.heinz.iftm.modelos.Jogo;


public class BilbiotecaPanel extends TelaPanel {
    private ArrayList<Jogo> jogos;
    private JPanel grid;
    private Imagem imagemFundo;
    private Jogo jogoSelecionado;
    private JLabel labeljogo;
    private Botao botaoJogar;

//    private static final String STEAM_APPS_PATH = "/home/heinz/.local/share/Steam/steamapps/";

    public BilbiotecaPanel(JPanel telas, JFrame janela) {
        super(telas, janela);
        this.jogos = new ArrayList<Jogo>();
        
        grid = new JPanel(new FlowLayout(FlowLayout.CENTER, 22, 22));
        grid.setBackground(Color.decode("#202028"));
        grid.setBorder(BorderFactory.createEmptyBorder());
        grid.setBorder(null);

        carregarJogos();
        exibirJogos();
        
        JScrollPane scrollPane = new JScrollPane(grid);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Color.decode("#202028")); // Define a cor de fundo do viewport
        scrollPane.getHorizontalScrollBar().setUnitIncrement(18);
        scrollPane.setBounds(50, 350, 1820, 470);

        // Configuração da UI para a barra de rolagem
        scrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.decode("#303038");
                this.trackColor = Color.decode("#202028");
            }
        });
        
        
        labeljogo = new JLabel("Teste");
        labeljogo.setForeground(Color.white);
        
        labeljogo.setFont(new Font("Roboto", Font.BOLD, 40));
        labeljogo.setBounds(50,50,1000,100);
        labeljogo.setVisible(false);
        
        botaoJogar = new Botao("JOGAR");
        botaoJogar.setBounds(1600, 850, 160, 60);
        botaoJogar.setFont(new Font("Roboto", Font.BOLD, 20));
        botaoJogar.setForeground(Color.WHITE);
        botaoJogar.setVisible(false);
        botaoJogar.addActionListener(e -> {
			try {
				executarJogo();
			} catch (Exception e1) {e1.printStackTrace();}});
        
        this.add(labeljogo);
        this.add(botaoJogar);
        this.add(scrollPane);
//      this.add(imagemFundo);
    }

    private void carregarJogos() {
        String jsonString = lerJsonJogos();
        JSONArray jsonArray = new JSONArray(jsonString);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jogoObject = (JSONObject) jsonArray.get(i);
            jogos.add(new Jogo(jogoObject));
        }

        // Obtém os IDs dos jogos da Steam
//        Map<String, String> steamGameIds = getSteamGameIds();
//        for (Jogo jogo : jogos) {
//            String nomeJogo = jogo.getNome();
//            System.out.println(steamGameIds.get(nomeJogo));
//            if (steamGameIds.containsKey(nomeJogo)) {
//                jogo.setCaminho(steamGameIds.get(nomeJogo));
//            }
//        }
    }

//    private Map<String, String> getSteamGameIds() {
//        Map<String, String> gameIds = new HashMap<>();
//        Pattern pattern = Pattern.compile("\"appid\"\\s+\"(\\d+)\"");
//        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(STEAM_APPS_PATH), "*.acf")) {
//            for (Path entry : stream) {
//                String content = new String(Files.readAllBytes(entry));
//                Matcher matcher = pattern.matcher(content);
//                if (matcher.find()) {
//                    String appId = matcher.group(1);
//                    String gameName = entry.getFileName().toString().replace(".acf", "");
//                    gameIds.put(gameName, appId);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return gameIds;
//    }

    private void exibirJogos() {
        int imgSize = 300;
        int posX = 50;
        int posY = 50;
        final int POS_MAX_X = 1650;

        //formato de grid
//        int altura = (int) Math.ceil((double) jogos.size() / 5);
//        altura = altura * 422 + 40; // ajuste o padding final
//        grid.setPreferredSize(new Dimension(500, altura));

        for (Jogo jogo : jogos) {
            String icone = jogo.getIcone();
            Imagem imagem = new Imagem(icone);
            imagem.setBounds(posX, posY, imgSize, 400);

            posX += 50 + imgSize;
            if (posX > POS_MAX_X) {
                posX = 50;
                posY += 450;
            }

            imagem.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                	selecionarJogo(jogo);

                    

                }
            });

            grid.add(imagem);
        }
    }
    
    private void selecionarJogo(Jogo jogo) {
    	jogoSelecionado = jogo;
    	botaoJogar.setVisible(true);
    	labeljogo.setText(jogo.getNome());
    	labeljogo.setVisible(true);
    	
        String id = jogo.getCaminho();
        String fundo = jogo.getFundo();
        trocarImagemFundo(fundo);
        
        if (id != null) {
            //executarJogo(id);
        } else {
            System.out.println("ID do jogo não encontrado.");
        }
        repaint();
        revalidate();
    }
    
    private void trocarImagemFundo(String imagem) {
    	if(imagemFundo != null) {
    		remove(imagemFundo);
    	}
    	System.out.println(imagem);
        imagemFundo = new Imagem(imagem);
        imagemFundo.setBounds(0, 0, 1920, 1080);
        add(imagemFundo);
        
    }

    private void executarJogo() throws Exception {
    	if(jogoSelecionado == null) {
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

    public void executarBotao(ActionEvent e) {
        trocarTela("Tela login");
    }
}
