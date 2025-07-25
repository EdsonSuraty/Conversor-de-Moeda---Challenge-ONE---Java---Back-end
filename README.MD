# Conversor de Moedas - Challenge Back-End ONE 🪙

![Status](https://img.shields.io/badge/status-concluído-brightgreen)
![Java](https://img.shields.io/badge/java-17-blue)
![Maven](https://img.shields.io/badge/build-maven-red)

Projeto de um conversor de moedas interativo, desenvolvido como parte do Challenge de Back-End do programa ONE (Oracle Next Education) em parceria com a Alura. A aplicação consome uma API de taxas de câmbio em tempo real para realizar as conversões.

---

### 📋 Tabela de Conteúdos
* [Descrição do Projeto](#-descrição-do-projeto)
* [Funcionalidades](#-funcionalidades)
* [Tecnologias Utilizadas](#-tecnologias-utilizadas)
* [Como Executar o Projeto](#-como-executar-o-projeto)
* [Demonstração](#-demonstração)
* [Agradecimentos](#-agradecimentos)

---

### 📖 Descrição do Projeto
O Conversor de Moedas é uma aplicação de console que permite ao usuário obter as taxas de câmbio mais recentes e converter valores entre seis pares de moedas pré-definidos. A aplicação foi construída em Java, utilizando o `HttpClient` para comunicação com a API [ExchangeRate-API](https://www.exchangerate-api.com/) e a biblioteca Gson para a manipulação dos dados JSON recebidos. Este projeto visa aplicar os conceitos de orientação a objetos, manipulação de APIs e tratamento de exceções.

---

### ✨ Funcionalidades
- **[✔] Menu Interativo:** Interface de usuário via console que permite a seleção de opções de forma contínua.
- **[✔] Conversão de Moedas:** Realiza a conversão para 6 pares de moedas:
  - Dólar (USD) ↔ Real (BRL)
  - Euro (EUR) ↔ Real (BRL)
  - Peso Argentino (ARS) ↔ Real (BRL)
- **[✔] Taxas de Câmbio em Tempo Real:** Integração com a `ExchangeRate-API` para obter as cotações mais atuais.
- **[✔] Tratamento de Erros:** A aplicação é robusta e lida com entradas inválidas do usuário e possíveis falhas na comunicação com a API.
- **[✔] Configuração Segura:** A chave da API é lida de um arquivo de configuração local, não sendo exposta no código-fonte.

---

### 🚀 Tecnologias Utilizadas
- **Java 17:** Versão LTS do Java, utilizando recursos como Records e Text Blocks.
- **Maven:** Gerenciador de dependências e de build do projeto.
- **Java `HttpClient`:** API nativa do Java (a partir do Java 11) para realizar requisições HTTP.
- **Gson:** Biblioteca da Google para converter objetos Java em sua representação JSON e vice-versa.

---

### ▶️ Como Executar o Projeto

#### Pré-requisitos
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) ou superior.
- [Maven](https://maven.apache.org/download.cgi) 3.8 ou superior.
- Git.

#### Configuração da API Key
1. Faça o cadastro gratuito no site [ExchangeRate-API](https://www.exchangerate-api.com/) para obter sua chave de API.
2. Na raiz do projeto, crie um arquivo chamado `config.properties`.
3. Dentro deste arquivo, adicione a seguinte linha, substituindo `SUA_CHAVE_AQUI` pela chave que você obteve:
   ```properties
   api_key=SUA_CHAVE_AQUI
   
### Passos para Execução
````
# Clone este repositório
$ git clone [https://github.com/EdsonSuraty/Conversor-de-Moeda---Challenge-ONE---Java---Back-end.git](https://github.com/EdsonSuraty/Conversor-de-Moeda---Challenge-ONE---Java---Back-end.git)

# Acesse a pasta do projeto no terminal
$ cd Conversor-de-Moeda---Challenge-ONE---Java---Back-end

# Compile e empacote o projeto com o Maven
$ mvn clean install

# Execute o arquivo .jar gerado na pasta 'target'
$ java -jar target/conversor-de-moeda-1.0-SNAPSHOT.jar
````

### 🖥️ Demonstração
A aplicação em funcionamento no console:

````
***************************************************
Seja bem-vindo(a) ao Conversor de Moedas!

1) Dólar Americano (USD) =>> Real Brasileiro (BRL)
2) Real Brasileiro (BRL) =>> Dólar Americano (USD)
3) Euro (EUR) =>> Real Brasileiro (BRL)
4) Real Brasileiro (BRL) =>> Euro (EUR)
5) Peso Argentino (ARS) =>> Real Brasileiro (BRL)
6) Real Brasileiro (BRL) =>> Peso Argentino (ARS)
7) Sair
***************************************************
Escolha uma opção válida: 2
Digite o valor que deseja converter: 150
----------------------------------------
Valor 150.00 [BRL] corresponde ao valor final de =>> 27.62 [USD]

----------------------------------------
````

### 🙏 Agradecimentos
Agradeço à Alura e à Oracle pela oportunidade de aprendizado e desenvolvimento através do programa ONE (Oracle Next Education).