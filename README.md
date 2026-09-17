RolêOut 🎉

Aplicação web para cadastro e sugestão de rolês, desenvolvida como projeto acadêmico.

O RolêOut permite cadastrar rolês e, a partir de informações fornecidas pelo usuário, buscar sugestões de acordo com critérios como categoria, cidade e orçamento máximo.

📌 Objetivo

O objetivo do projeto é facilitar a escolha de atividades e lugares para sair, permitindo que o usuário encontre opções de rolês compatíveis com suas preferências.

A aplicação foi desenvolvida utilizando uma arquitetura baseada no padrão MVC (Model-View-Controller), separando as responsabilidades da aplicação e facilitando sua manutenção.

✨ Funcionalidades

Cadastro de rolês;

Listagem dos rolês cadastrados;

Edição de rolês;

Exclusão de rolês;

Busca de sugestões de rolês;

Filtro de sugestões por:

Categoria;

Cidade;

Valor máximo;

Validação dos dados cadastrados;

Interface web utilizando JSP;

Persistência dos dados em banco de dados MySQL.

🧩 Arquitetura

O projeto utiliza o padrão MVC:

Model

Responsável pela representação dos dados da aplicação.

Exemplo:

Role

View

Responsável pela interface apresentada ao usuário.

Tecnologias utilizadas:

JSP;

HTML;

CSS.

Controller

Responsável por receber as requisições do usuário, chamar os serviços necessários e encaminhar as respostas para as páginas.

Service

Contém as regras de negócio da aplicação, como validações e a lógica de busca das sugestões.

DAO

Responsável pela comunicação com o banco de dados MySQL.

🛠️ Tecnologias utilizadas

Java

JSP (JavaServer Pages)

Servlets

Maven

MySQL

Docker

Docker Compose

HTML5

CSS3

Git e GitHub

Apache Tomcat

🗄️ Banco de dados

O sistema utiliza o MySQL para armazenar os dados dos rolês cadastrados.

A aplicação utiliza o Docker Compose para facilitar a configuração do ambiente e execução do banco de dados.

▶️ Como executar o projeto

Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

Java JDK;

Maven;

Docker e Docker Compose;

Uma IDE compatível com projetos Java/Maven, como NetBeans ou IntelliJ IDEA.

Executando

Clone este repositório:

git clone https://github.com/Heitor-Santiago0/RoleOut.git

Entre na pasta do projeto:

cd RoleOut

Inicie os serviços necessários utilizando o Docker Compose:

docker compose up -d

Compile o projeto com Maven:

mvn clean package

Execute a aplicação em um servidor compatível com Jakarta EE/Servlets, como o Apache Tomcat.

📂 Estrutura do projeto

A estrutura principal segue a organização de um projeto Maven:

RoleOut/
├── src/
│   └── main/
│       ├── java/
│       │   └── br/com/roleout/
│       │       ├── controller/
│       │       ├── dao/
│       │       ├── model/
│       │       └── service/
│       │
│       └── webapp/
│           ├── index.jsp
│           └── ...
│
├── docker-compose.yml
├── pom.xml
└── README.md

A estrutura pode variar conforme a organização final dos arquivos do projeto.

💡 Como funciona a sugestão de rolês

O usuário informa os critérios desejados, como:

Categoria do rolê;

Cidade;

Orçamento máximo.

O sistema utiliza essas informações para consultar os rolês cadastrados no banco de dados e apresentar as opções que correspondem aos critérios informados.

Dessa forma, o sistema não serve apenas para cadastrar rolês: ele também possui uma funcionalidade específica para encontrar sugestões de acordo com as preferências do usuário.

🎓 Projeto acadêmico

Projeto desenvolvido para fins acadêmicos no curso de Análise e Desenvolvimento de Sistemas (ADS).

👨‍💻 Autor

Heitor Santiago
Vinícius Henrique

GitHub: https://github.com/Heitor-Santiago0

RolêOut — encontre um rolê que combina com você! 🎉
