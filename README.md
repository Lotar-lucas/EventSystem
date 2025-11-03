# Event System

Sistema de gerenciamento de eventos desenvolvido com Spring Boot.

## 📋 Sobre o Projeto

O Event System é uma aplicação backend para gerenciamento de eventos educacionais, como cursos e oficinas. O sistema permite o cadastro e organização de:

- **Atividades**: Cursos, oficinas e outros eventos educacionais
- **Categorias**: Classificação das atividades
- **Participantes**: Pessoas inscritas nas atividades
- **Blocos**: Períodos de tempo em que as atividades ocorrem

### Modelo de Domínio

O sistema possui as seguintes entidades principais:

- **Activity** (Atividade): Representa um evento educacional com nome, descrição, preço e categoria
- **Category** (Categoria): Classificação das atividades (ex: Curso, Oficina)
- **Participant** (Participante): Pessoas que participam das atividades
- **Block** (Bloco): Horários de início e fim de cada atividade

### Relacionamentos

- Uma atividade pertence a uma categoria
- Uma atividade pode ter vários blocos de horário
- Uma atividade pode ter vários participantes
- Um participante pode estar inscrito em várias atividades (relação muitos-para-muitos)

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.7**
- **Spring Data JPA**: Para persistência de dados
- **Spring Web**: Para criação de APIs REST
- **H2 Database**: Banco de dados em memória para testes e desenvolvimento
- **Maven**: Gerenciamento de dependências

## 📦 Pré-requisitos

Antes de começar, você precisa ter instalado em sua máquina:

- [Java JDK 21](https://www.oracle.com/java/technologies/downloads/#java21) ou superior
- [Maven 3.6+](https://maven.apache.org/download.cgi) (opcional, o projeto inclui o Maven Wrapper)

## 🔧 Como Executar o Projeto

### 1. Clone o repositório

```bash
git clone <url-do-repositorio>
cd EventSystem
```

### 2. Execute o projeto usando Maven Wrapper (recomendado)

**No Linux/Mac/WSL:**
```bash
./mvnw spring-boot:run
```

**No Windows (CMD):**
```cmd
mvnw.cmd spring-boot:run
```

### 3. Ou compile e execute o JAR

**No Linux/Mac/WSL:**
```bash
./mvnw clean package
java -jar target/EventSystem-0.0.1-SNAPSHOT.jar
```

**No Windows (CMD):**
```cmd
mvnw.cmd clean package
java -jar target\EventSystem-0.0.1-SNAPSHOT.jar
```

### 4. Acesse a aplicação

A aplicação estará rodando em: `http://localhost:8080`

## 🗄️ Banco de Dados

O projeto utiliza o banco de dados H2 em memória para desenvolvimento e testes.

### Console H2

Para acessar o console do H2 e visualizar os dados:

1. Acesse: `http://localhost:8080/h2-console`
2. Use as seguintes credenciais:
   - **JDBC URL**: `jdbc:h2:mem:eventdb`
   - **User Name**: `es`
   - **Password**: (deixe em branco)

### Dados Iniciais

O sistema é inicializado com dados de exemplo através do arquivo `import.sql`, incluindo:

- 2 categorias (Curso e Oficina)
- 4 participantes
- 2 atividades (Curso de HTML e Oficina de Github)
- Inscrições de participantes nas atividades
- Blocos de horário para as atividades

## 📁 Estrutura do Projeto

```
EventSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── lotar/com/EventSystem/
│   │   │       ├── EventSystemApplication.java
│   │   │       └── Entities/
│   │   │           ├── Activity.java
│   │   │           ├── Block.java
│   │   │           ├── Category.java
│   │   │           └── Participant.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application-test.properties
│   │       └── import.sql
│   └── test/
│       └── java/
│           └── lotar/com/EventSystem/
│               └── EventSystemApplicationTests.java
├── pom.xml
└── README.md
```

## 🔍 Profiles do Spring

O projeto utiliza profiles para diferentes ambientes:

- **test**: Profile padrão, utiliza banco H2 em memória
  - Configurado em `application-test.properties`
  - Carrega dados iniciais do `import.sql`

## 🛠️ Configurações

### application.properties

```properties
spring.application.name=EventSystem
spring.profiles.active=test
spring.jpa.open-in-view=false
```

### application-test.properties

Configurações do banco H2 para ambiente de desenvolvimento:
- Driver: H2
- URL: jdbc:h2:mem:eventdb
- Console habilitado em: /h2-console
- SQL formatado visível no console

