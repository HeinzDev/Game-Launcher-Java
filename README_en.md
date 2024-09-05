**English version** | [PT-BR version](README.md)

# Game Launcher

The **Game Launcher** is a simple Java application using the Swing framework, serving as a Steam game launcher. The project aims to provide an intuitive interface for users to access their games easily.
<p align="center"><img src="https://i.imgur.com/5WJsli2.png"></p>

## Overview

- [Dependencies](#dependencies)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Contributing](#contributing)
- [Creator](#creator)

## Configuration

### Build

Project setup for development environment:

```
mvn clean install
```

### Json Files

The Game Launcher requires an external `jogos.json` file for rendering the games. There is a sample file in the repository's root.

For correct initialization, each game ID must be included in the **"path"** parameter of the `.json` file. You can obtain this ID from the Steam page or from its `.desktop` file.

<p align="center"><img src="https://i.imgur.com/HKgOsoL.jpeg"></p>
<p align="center"><img src="https://i.imgur.com/9UC5rm6.png"></p>

## Running the Application

1. Download the [release](https://github.com/HeinzDev/Game-Launcher-Java/releases) or compile the code manually.

2. Add the `jogos.json` file to the project directory.

3. Run in the terminal:

   ```bash
   $ java -jar gamelauncher.jar

## Contributing

If you wish to contribute to the project, follow these steps:

1. Fork the repository.
2. Create a new branch for your feature:
`git checkout -b feature-name`.
3. Commit your changes: 
`git commit -m 'Add some feature'`.
4. Push to the branch: 
`git push origin feature-name`.
5. Submit a pull request.

## Creator
<div id="header" align="center">
  <a href="https://github.com/HeinzDev/">
    <img src="https://i.imgur.com/RtsYtRt.png" width="100"/>
  </a>
  <a href="https://github.com/HeinzDev/">
    <h3>HeinzDev</h3>  
  </a>
</div>
