# [EN] PlayScore

## About the Project

PlayScore is an Android application designed to simplify score tracking during Truco matches. Truco is a popular card game widely played across several Latin American countries, especially in Argentina, Brazil, Uruguay, and Paraguay.
The app allows users to keep track of points for two players or teams, record victories, and view match history through a simple and intuitive interface.

This project was developed as part of the Android learning journey using Kotlin and modern Android development practices.

<img width="276" height="600" alt="imagem 1" src="https://github.com/user-attachments/assets/84da1eb7-fc23-4c56-b051-cfb68edc4cbc" />
<img width="276" height="600" alt="imagem 4" src="https://github.com/user-attachments/assets/6a621896-d775-401d-90d1-f3185f99f738" />
<br>
<img width="276" height="600" alt="imagem 2" src="https://github.com/user-attachments/assets/4e7556b5-816a-400e-af13-38fe236a1c4e" />
<img width="276" height="600" alt="imagem 3" src="https://github.com/user-attachments/assets/80a52c01-10c0-46e8-a9be-649584bba59a" />






---

## Features

## Design Inspiration

PlayScore's color scheme was inspired by the traditional colors of UTFPR (Federal University of Technology – Paraná), where I am currently pursuing a postgraduate specialization in Mobile Application Development. The colors were adapted to provide a familiar visual identity while ensuring good usability and readability.

### Score Tracking

* Add points to each player using quick action buttons (+1, +3, +6, +9, and +12).
* Real-time score updates.
* Reset the current match score without affecting the win history.

### Player Management

* Customize player or team names.
* Display default names when no custom names are configured.
* Temporarily preserve player names during configuration changes.

### Winner Detection

* Automatically detect when a player reaches the winning score.
* Display a winner dialog when a match ends.
* Automatically register victories in the scoring history.

### Win History

* Track the total number of wins for each player.
* Clear the win history when desired.
* Automatically update the history after each completed match.

### Multilingual Support

The application supports multiple languages:

* English
* Portuguese
* Spanish

Translations are managed using Android resource files.

---

## Technologies Used

### Programming Language

* Kotlin

### Platform

* Android SDK

### Android Components

* Activities
* Intents
* Activity Result API
* View Binding
* AlertDialog
* Toast
* onSaveInstanceState
* ConstraintLayout
* ScrollView
* Material Components

### Testing

* JUnit
* Android Instrumented Tests

---

## Concepts Applied

During development, several important Android concepts were implemented:

* Activity navigation
* Data transfer using Intents
* Activity result handling
* Activity lifecycle management
* State persistence with onSaveInstanceState
* Internationalization (i18n)
* Resource organization (Strings, Colors, Drawables, and Layouts)
* Material Design UI customization

---

## Application Structure

### MainActivity

Main screen responsible for match management:

* Score display
* Point control
* Winner detection
* Access to additional features

### EditName Activity

Screen used to configure player or team names.

### ScoreHistory Activity

Screen responsible for displaying the accumulated win history.

---

## Future Improvements

Potential features planned for future versions:

* Data persistence using SharedPreferences
* Permanent history between app sessions
* Detailed match statistics
* Support for different Truco rule variations
* Light and dark themes
* Animations and UI enhancements
* Match result export

---

## Educational Purpose

This project was created to practice fundamental Android development concepts using Kotlin while applying modern development practices, state management, activity communication, and user interface design.

---

## Author

Developed by Gabriel as an Android learning and practice project.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# [PT] PlayScore

## Sobre o Projeto

PlayScore é um aplicativo Android desenvolvido para facilitar a contagem de pontos em partidas de Truco. O aplicativo permite acompanhar a pontuação de dois jogadores ou equipes, registrar vitórias e consultar o histórico de partidas de forma simples e intuitiva.

O projeto foi desenvolvido como parte do processo de aprendizado em desenvolvimento Android utilizando Kotlin e os componentes modernos recomendados pela plataforma.

<img width="276" height="600" alt="imagem 5" src="https://github.com/user-attachments/assets/0fc3de6a-8a40-4b45-8570-d383b75c4fdf" />
<img width="276" height="600" alt="imagem 8" src="https://github.com/user-attachments/assets/195fe6f6-86c8-4b97-bda8-9bbe0e6264c1" />
<br>
<img width="276" height="600" alt="imagem 6" src="https://github.com/user-attachments/assets/2b45b58c-c9bc-48a4-9348-9e666772e314" />
<img width="276" height="600" alt="imagem 7" src="https://github.com/user-attachments/assets/0b324f66-761e-4894-ac59-3f5830b2464d" />

---

## Funcionalidades

## Inspiração do Design

O esquema de cores do PlayScore foi inspirado nas cores tradicionais da UTFPR (Universidade Tecnológica Federal do Paraná), onde atualmente estou cursando uma pós-graduação em Desenvolvimento de Aplicações Móveis. As cores foram adaptadas para fornecer uma identidade visual familiar, mantendo boa usabilidade e legibilidade na interface.

### Controle de Pontuação

* Adicionar pontos para cada jogador através de botões rápidos (+1, +3, +6, +9 e +12).
* Atualização automática da pontuação em tempo real.
* Reinício da pontuação atual sem afetar o histórico de vitórias.

### Gerenciamento de Jogadores

* Personalização dos nomes dos jogadores ou equipes.
* Exibição de nomes padrão quando nenhum nome personalizado é definido.
* Persistência temporária dos nomes durante mudanças de configuração da aplicação.

### Detecção de Vencedor

* Identificação automática quando um jogador atinge a pontuação necessária para vencer.
* Exibição de um diálogo informando o vencedor da partida.
* Registro automático da vitória no histórico.

### Histórico de Vitórias

* Exibição do número total de vitórias de cada jogador.
* Possibilidade de limpar o histórico de vitórias.
* Atualização automática após cada partida concluída.

### Suporte Multilíngue

O aplicativo possui suporte para múltiplos idiomas:

* Português
* Inglês
* Espanhol

As traduções são gerenciadas através do sistema de recursos do Android.

---

## Tecnologias Utilizadas

### Linguagem

* Kotlin

### Plataforma

* Android SDK

### Componentes Android

* Activities
* Intents
* Activity Result API
* View Binding
* AlertDialog
* Toast
* onSaveInstanceState
* ConstraintLayout
* ScrollView
* Material Components

### Testes

* JUnit
* Instrumented Tests (Android)

---

## Conceitos Aplicados

Durante o desenvolvimento deste projeto foram utilizados diversos conceitos importantes do desenvolvimento Android:

* Navegação entre Activities
* Troca de dados utilizando Intents
* Recebimento de resultados entre telas
* Gerenciamento do ciclo de vida das Activities
* Preservação de estado com onSaveInstanceState
* Internacionalização (i18n)
* Organização de recursos (Strings, Colors, Drawables e Layouts)
* Personalização de interface com Material Design

---

## Estrutura do Aplicativo

### MainActivity

Tela principal responsável pelo controle da partida:

* Exibição da pontuação
* Controle dos pontos
* Identificação do vencedor
* Acesso às demais funcionalidades

### EditName Activity

Tela utilizada para configurar os nomes dos jogadores ou equipes.

### ScoreHistory Activity

Tela responsável por exibir o histórico de vitórias acumuladas durante a utilização do aplicativo.

---

## Melhorias Futuras

Algumas funcionalidades planejadas para futuras versões:

* Persistência de dados utilizando SharedPreferences
* Histórico permanente entre sessões do aplicativo
* Estatísticas detalhadas das partidas
* Suporte para diferentes modalidades de Truco
* Tema claro e escuro
* Animações e melhorias visuais
* Exportação de resultados

---

## Objetivo Educacional

Este projeto foi desenvolvido com o objetivo de praticar conceitos fundamentais do desenvolvimento Android moderno utilizando Kotlin, seguindo boas práticas de organização de código, gerenciamento de estado e construção de interfaces gráficas.

---

## Autor

Desenvolvido por Gabriel como projeto de estudo e prática em desenvolvimento Android.
