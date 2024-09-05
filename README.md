**Português (Brasil)** | [English version](README_en.md)

# Game Launcher

O **Game Launcher** é uma aplicação simples feita em Java com o framework Swing, servindo como um inicializador de jogos da Steam. O projeto visa oferecer uma interface intuitiva para os usuários acessarem seus jogos de forma prática.
<p align="center"><img src="https://i.imgur.com/5WJsli2.png"></p>

## Resumo

- [Dependências](#dependências)
- [Configurações](#configurações)
- [Executando a Aplicação](#executando-a-aplicação)
- [Contribuindo](#contribuindo)
- [Criador](#criador)

## Configurações

### Build

Setup do projeto em ambiente de desenvolvimento:

```
mvn clean install
```

### Json Files

O Game Launcher requer um arquivo `jogos.json` externo para a renderização dos jogos. Na raiz do repositório, há um arquivo de exemplo.

Para a inicialização correta, é necessário incluir o ID de cada jogo no parâmetro **"caminho"** o arquivo `.json`. Você pode obter esse ID na página da Steam ou em seu arquivo `.desktop`.

<p align="center"><img src="https://i.imgur.com/HKgOsoL.jpeg"></p>
<p align="center"><img src="https://i.imgur.com/9UC5rm6.png"></p>


## Executando a Aplicação

1. Baixe a [release](https://github.com/HeinzDev/Game-Launcher-Java/releases) ou compile o código manualmente.

2. Adicione o arquivo `jogos.json` ao diretório do projeto.

3. Execute no terminal:

   ```bash
   $ java -jar gamelauncher.jar

## Contribuindo

Se você deseja contribuir para o projeto, siga estes passos:

1. Faça um fork do repositório.
2. Crie um novo branch para sua funcionalidade: `git checkout -b nome-da-funcionalidade`.
3. Faça commit das suas alterações: `git commit -m 'Adicione alguma funcionalidade'`.
4. Faça push para o branch: `git push origin nome-da-funcionalidade`.
5. Envie uma solicitação pull.

## Criador

<div id="header" align="center">
  <a href="https://github.com/HeinzDev/">
    <img src="https://i.imgur.com/RtsYtRt.png" width="100"/>
  </a>
  <a href="https://github.com/HeinzDev/">
    <h3>HeinzDev</h3>  
  </a>
</div>
