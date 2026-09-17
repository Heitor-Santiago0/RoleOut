# RolêOut

Aplicação web desenvolvida como projeto acadêmico para cadastro, gerenciamento e sugestão de rolês.

O **RolêOut** permite que usuários cadastrem opções de lazer e utilizem filtros como categoria, cidade e orçamento máximo para encontrar sugestões compatíveis com suas preferências.

## Objetivo

O objetivo do projeto é facilitar a escolha de atividades, eventos e lugares para sair.

Além do gerenciamento dos rolês cadastrados, o sistema possui uma funcionalidade de recomendação baseada nos critérios informados pelo usuário.

A aplicação foi desenvolvida utilizando o padrão de arquitetura **MVC (Model-View-Controller)**, além das camadas **DAO** e **Service**, buscando manter o projeto organizado, modular e de fácil manutenção.

## Funcionalidades

* Cadastro de rolês
* Listagem de rolês cadastrados
* Edição de rolês
* Exclusão de rolês
* Busca de sugestões de rolês
* Filtro de sugestões por categoria
* Filtro de sugestões por cidade
* Filtro de sugestões por orçamento máximo
* Validação dos dados informados
* Persistência de dados em banco MySQL
* Interface web utilizando JSP, HTML e CSS
* Confirmação antes da exclusão de registros

## Sistema de Sugestões

O RolêOut possui uma funcionalidade específica para encontrar opções de rolês com base nas preferências do usuário.

O usuário informa:

* **Categoria desejada**
* **Cidade**
* **Orçamento máximo**

A aplicação utiliza esses dados para consultar os rolês cadastrados no banco de dados e retornar apenas aqueles que correspondem aos critérios informados.

### Exemplo

**Categoria:** Música
**Cidade:** Uberaba
**Orçamento máximo:** R$ 50,00

O sistema poderá retornar rolês cadastrados que atendam a:

* Categoria = Música
* Cidade = Uberaba
* Valor ≤ R$ 50,00

Dessa forma, o RolêOut não funciona apenas como um sistema de cadastro, mas também como uma aplicação de sugestão de opções de lazer.

## Arquitetura

O projeto utiliza o padrão **MVC** em conjunto com as camadas **DAO** e **Service**.

### Model

Responsável pela representação dos dados utilizados pela aplicação.

**Classe principal:**

* `Role`

Essa classe representa um rolê e contém informações como:

* ID
* Nome
* Descrição
* Local
* Cidade
* Data
* Categoria
* Valor

### View

Responsável pela interface apresentada ao usuário.

As páginas foram desenvolvidas utilizando:

* JSP
* HTML5
* CSS3
* JSTL

**Principais telas:**

* Página inicial
* Gerenciamento de rolês
* Cadastro e edição de rolês
* Busca de sugestões
* Resultados das sugestões

### Controller

Responsável por receber as requisições realizadas pelo navegador e encaminhá-las para as demais camadas da aplicação.

**Controllers principais:**

* `RoleController`
* `SugestaoController`

### Service

Responsável pelas regras de negócio e validações da aplicação.

**Classe principal:**

* `RoleService`

Entre suas responsabilidades estão:

* Validar dados dos rolês
* Encaminhar operações para o DAO
* Validar parâmetros utilizados na busca de sugestões

### DAO

Responsável pela comunicação direta com o banco de dados.

**Classe principal:**

* `RoleDAO`

O DAO implementa operações como:

* Inserção
* Consulta
* Atualização
* Exclusão
* Busca de rolês por critérios de sugestão

### Config

Responsável pelas configurações relacionadas à aplicação.

**Classe principal:**

* `ConnectionFactory`

Essa classe é responsável por estabelecer a conexão entre a aplicação Java e o banco de dados MySQL.

## CRUD

O sistema implementa um CRUD completo para gerenciamento dos rolês.

### Create

Permite cadastrar novos rolês.

### Read

Permite listar os rolês existentes.

### Update

Permite alterar informações de um rolê cadastrado.

### Delete

Permite excluir um rolê do sistema.

## Tecnologias Utilizadas

* Java 17
* Jakarta Servlets
* JSP
* JSTL
* Maven
* MySQL 8.4
* JDBC
* Apache Tomcat 10
* Docker
* Docker Compose
* HTML5
* CSS3
* Git
* GitHub

## Banco de Dados

O sistema utiliza **MySQL** para armazenamento dos dados.

A principal tabela da aplicação é:

`roles`

Ela possui os seguintes campos:

* `id`
* `nome`
* `descricao`
* `local`
* `cidade`
* `data`
* `categoria`
* `valor`

O campo `id` é utilizado como chave primária e possui incremento automático.

O banco de dados é executado através de um container Docker.

## Estrutura do Projeto

```text
RoleOut/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── br/
│       │       └── com/
│       │           └── roleout/
│       │               ├── config/
│       │               │   └── ConnectionFactory.java
│       │               │
│       │               ├── controller/
│       │               │   ├── RoleController.java
│       │               │   └── SugestaoController.java
│       │               │
│       │               ├── dao/
│       │               │   └── RoleDAO.java
│       │               │
│       │               ├── model/
│       │               │   └── Role.java
│       │               │
│       │               └── service/
│       │                   └── RoleService.java
│       │
│       └── webapp/
│           ├── index.jsp
│           ├── css/
│           │   └── style.css
│           ├── images/
│           └── WEB-INF/
│               ├── web.xml
│               └── views/
│                   ├── role-form.jsp
│                   ├── role-list.jsp
│                   ├── sugestao-form.jsp
│                   └── sugestao-list.jsp
│
├── docker-compose.yml
├── pom.xml
├── .gitignore
└── README.md
```

## Pré-requisitos

Para executar o projeto, é necessário possuir:

* Java JDK 17
* Apache Maven
* Docker
* Docker Compose
* Git
* Navegador web

Também pode ser utilizado qualquer editor ou IDE compatível com Java e Maven, como:

* Visual Studio Code
* Apache NetBeans
* IntelliJ IDEA

## Como Executar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/Heitor-Santiago0/RoleOut.git
```

### 2. Entrar na pasta do projeto

```bash
cd RoleOut
```

### 3. Compilar o projeto

```bash
mvn clean package
```

Esse comando gera o arquivo:

```text
target/RoleOut.war
```

### 4. Iniciar os containers

```bash
docker compose up -d
```

O Docker Compose irá iniciar:

* MySQL
* Apache Tomcat

### 5. Verificar os containers

```bash
docker ps
```

Os containers esperados são:

```text
roleout-mysql
roleout-tomcat
```

### 6. Acessar a aplicação

Abra o navegador e acesse:

```text
http://localhost:8080/RoleOut/
```

## Principais Endereços

**Página inicial**

```text
http://localhost:8080/RoleOut/
```

**Gerenciamento de Rolês**

```text
http://localhost:8080/RoleOut/roles
```

**Busca de Sugestões**

```text
http://localhost:8080/RoleOut/sugestoes
```

## Fluxo da Aplicação

```text
Usuário
   ↓
View (JSP)
   ↓
Controller
   ↓
Service
   ↓
DAO
   ↓
MySQL
```

A View envia uma requisição ao Controller.

O Controller utiliza o Service para executar a lógica necessária.

O Service aplica as regras de negócio e utiliza o DAO.

O DAO realiza as operações no banco de dados MySQL.

Os dados retornam pelas mesmas camadas até serem apresentados novamente ao usuário.

## Versionamento

O projeto utiliza **Git** para controle de versão e **GitHub** para armazenamento do repositório remoto.

**Repositório:**

https://github.com/Heitor-Santiago0/RoleOut

## Projeto Acadêmico

Projeto desenvolvido para fins acadêmicos no curso de **Análise e Desenvolvimento de Sistemas**.

## Integrantes

### Heitor Santiago

**RA:** 5174491

**GitHub:**
https://github.com/Heitor-Santiago0

### Vinicius Henrique

**RA:** 5174473

## Considerações Finais

O RolêOut foi desenvolvido com o objetivo de aplicar conceitos de desenvolvimento web em Java, arquitetura MVC, persistência de dados, organização em camadas e controle de versão.

Além do CRUD completo de rolês, a aplicação possui uma funcionalidade de sugestão baseada nas preferências do usuário, permitindo que os rolês cadastrados sejam utilizados para encontrar opções de lazer compatíveis com categoria, cidade e orçamento.
