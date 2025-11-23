# 🌙 Lyra - Sistema de Apoio ao Bem-Estar Emocional

> *"Quando a mente respira, o talento floresce"*

## 📋 Sobre o Projeto

O **Lyra** é uma aplicação voltada para apoiar o bem-estar emocional de trabalhadores que enfrentam estresse e sobrecarga na rotina profissional.

Através de relatos enviados pelo usuário, o sistema identifica o nível de risco emocional utilizando **Inteligência Artificial (Google Gemini)** e gera recomendações personalizadas que podem ajudar no momento. Cada interação é registrada, permitindo acompanhar como o estado emocional evolui ao longo do tempo através de check-ins diários.

O objetivo do Lyra é oferecer um apoio **rápido, acessível e acolhedor** para quem precisa de suporte emocional, funcionando como uma primeira linha de cuidado e direcionamento para recursos profissionais quando necessário.

---

## 🎥 Demonstração

### 📹 Vídeos

**[Video Pitch](https://youtu.be/wgGoX74THr0?si=ZcIJOhYXlemUCCgA)**
**[Video Demonstraçao da Aplicaçao](https://youtube.com/shorts/NnNIxhkZLLQ?si=mGLdyrWPQKvp8eBb)**

### 🌐 Deploy da API

A API está disponível em produção no Azure:

**URL:** https://lyrags2025webapp.azurewebsites.net

> **⚠️ Nota sobre Autenticação:**  
> Ao acessar a URL raiz (`/`) diretamente no navegador, você verá a seguinte mensagem:
> ```json
> {
>   "path": "/",
>   "error": "Não autorizado",
>   "message": "Full authentication is required to access this resource",
>   "status": 401
> }
> ```
> Isso é **esperado e correto**! A API utiliza autenticação JWT (JSON Web Token), portanto todos os endpoints (exceto `/api/auth/signin` e `/api/auth/signup`) requerem um token válido no header da requisição. A aplicação está funcionando perfeitamente! 🚀

---

## 👥 Integrantes do Projeto

| Nome | RM | Turma |
|------|-----|-------|
| **Caroline de Oliveira** | RM559123 | 2TDSB |
| **Giulia Corrêa Camillo** | RM554473 | 2TDSB |
| **Lavinia Soo Hyun Park** | RM555679 | 2TDSB |

---

## 🙏 Agradecimentos

Agradecemos ao **Professor Luis Roberto Guerreiro Lopes** pela mentoria, paciência e ensinamentos valiosos durante toda essa jornada acadêmica.

---

## 🏗️ Arquitetura do Projeto

O Lyra foi desenvolvido seguindo uma arquitetura em camadas, utilizando as melhores práticas de desenvolvimento Spring Boot:

```
lyra/
├── config/              # Configurações (Security, CORS, WebClient, RabbitMQ)
├── controller/          # Camada de controle (REST APIs)
├── dto/                 # Data Transfer Objects (Request/Response)
├── exception/           # Tratamento de exceções customizadas
├── model/               # Entidades JPA (User, Role, etc.)
├── repository/          # Camada de acesso a dados (Spring Data JPA)
├── security/            # Configurações de segurança (JWT, UserDetails)
├── service/             # Lógica de negócio
└── consumer/            # Consumidores de mensagens (RabbitMQ)
```

### 🔧 Tecnologias Utilizadas

#### Backend
- **Java 17** - Linguagem de programação
- **Spring Boot 3.5.7** - Framework principal
- **Spring Security** - Autenticação e autorização
- **Spring Data JPA** - Persistência de dados
- **Flyway** - Versionamento de banco de dados
- **JWT (JSON Web Token)** - Autenticação stateless
- **Lombok** - Redução de boilerplate code

#### Banco de Dados
- **SQL Server** - Banco de dados em produção (Azure)
- **H2 Database** - Banco de dados em memória para desenvolvimento

#### Integrações
- **Google Gemini AI** - Análise de humor e geração de recomendações
- **RabbitMQ** - Mensageria assíncrona
- **WebClient (Spring WebFlux)** - Chamadas HTTP reativas
- **Integração com API .NET** - Comunicação com sistema externo

#### DevOps
- **Docker** - Containerização
- **Azure App Service** - Hospedagem em nuvem
- **Azure Pipelines** - CI/CD
- **Maven** - Gerenciamento de dependências

---

## ⚙️ Funcionalidades

### 🔐 Autenticação e Autorização
- **Cadastro de usuários** (`POST /api/auth/signup`)
- **Login com JWT** (`POST /api/auth/signin`)
- **Controle de acesso baseado em roles** (USER, ADMIN)
- **Tokens JWT com expiração configurável**

### 😊 Análise de Humor com IA
- **Análise de humor utilizando Google Gemini AI** (`POST /api/humor/analisar`)
- **Classificação automática de risco emocional** (0 = Leve, 1 = Moderado, 2 = Grave, 3 = Gravíssimo)
- **Geração de resumo empático do relato**
- **Recomendações personalizadas baseadas no nível de risco**
- **Sistema de fallback** para casos de falha na IA

### 📊 Check-in Diário
- **Registro de check-in diário** (`POST /api/checkin`)
  - Humor do dia
  - Descrição detalhada
  - Horas de sono
  - Hidratação (copos de água)
- **Consulta do último check-in** (`GET /api/checkin`)
- **Histórico de evolução emocional**

### 👤 Gerenciamento de Usuários
- **Perfil do usuário autenticado** (`GET /api/users/me`)
- **Atualização de dados pessoais**
- **Gerenciamento de roles e permissões**

### 🔗 Integrações Externas
- **Integração com sistema .NET** para processamento adicional
- **Envio de notificações via RabbitMQ**
- **Comunicação assíncrona entre microserviços**

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

- **Java 17** ou superior
- **Maven 3.6+**
- **Docker** (opcional, para RabbitMQ e SQL Server)
- **Conta Google Cloud** com API Gemini habilitada
- **SQL Server** (ou use H2 para desenvolvimento)

### 1️⃣ Clonar o Repositório

```bash
git clone <url-do-repositorio>
cd LyraJava
```

### 2️⃣ Configurar Variáveis de Ambiente

Crie um arquivo `application.properties` em `src/main/resources/` com as seguintes configurações:

```properties
# Configurações do Servidor
server.port=8080

# Configurações do Banco de Dados (SQL Server)
spring.datasource.url=jdbc:sqlserver://<seu-servidor>:1433;databaseName=lyradb
spring.datasource.username=<seu-usuario>
spring.datasource.password=<sua-senha>
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Flyway
spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true

# JWT
app.jwt.secret=<sua-chave-secreta-jwt>
app.jwt.expiration-ms=86400000

# Google Gemini AI
gemini.api.key=<sua-api-key-gemini>
gemini.api.url=https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent

# API .NET
dotnet.api.url=<url-da-api-dotnet>
dotnet.api.timeout=10

# RabbitMQ
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

### 3️⃣ Executar com Maven

```bash
# Compilar o projeto
./mvnw clean install

# Executar a aplicação
./mvnw spring-boot:run
```

### 4️⃣ Executar com Docker

```bash
# Build da imagem
docker build -t lyra-app .

# Executar o container
docker run -p 8080:8080 lyra-app
```

### 5️⃣ Acessar a Aplicação

A API estará disponível em: `http://localhost:8080`

---

## 📚 Documentação da API

### Autenticação

#### Cadastro de Usuário
```http
POST /api/auth/signup
Content-Type: application/json

{
  "firstName": "João",
  "lastName": "Silva",
  "email": "joao@example.com",
  "password": "senha123",
  "roles": ["user"]
}
```

#### Login
```http
POST /api/auth/signin
Content-Type: application/json

{
  "email": "joao@example.com",
  "password": "senha123"
}
```

**Resposta:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "type": "Bearer",
  "id": 1,
  "email": "joao@example.com",
  "firstName": "João",
  "lastName": "Silva",
  "roles": ["ROLE_USER"]
}
```

### Análise de Humor

#### Analisar Humor
```http
POST /api/humor/analisar
Authorization: Bearer <seu-token-jwt>
Content-Type: application/json

{
  "humor": "ANSIOSO",
  "descricao": "Estou me sentindo muito sobrecarregado com o trabalho e não consigo dormir direito."
}
```

**Resposta:**
```json
{
  "resumoRecebido": "Sobrecarga de trabalho causando ansiedade e insônia",
  "nivel": 2,
  "recomendacoes": [
    "Considere conversar com um profissional de saúde mental",
    "Pratique técnicas de respiração antes de dormir",
    "Estabeleça limites claros entre trabalho e vida pessoal"
  ],
  "contatosEmergencia": "CVV: 188 | CAPS: Procure a unidade mais próxima"
}
```

### Check-in Diário

#### Registrar Check-in
```http
POST /api/checkin
Authorization: Bearer <seu-token-jwt>
Content-Type: application/json

{
  "humor": "FELIZ",
  "humorDescricao": "Tive um dia produtivo e consegui finalizar minhas tarefas",
  "sono": 8,
  "hidratacao": 6
}
```

#### Consultar Último Check-in
```http
GET /api/checkin
Authorization: Bearer <seu-token-jwt>
```

---

## 🧪 Testes

```bash
# Executar todos os testes
./mvnw test

# Executar com cobertura
./mvnw test jacoco:report
```

---

## 📦 Deploy

### Azure App Service

O projeto está configurado para deploy automático no Azure através do arquivo `azure-pipelines.yml`.

**Passos:**
1. Configure as variáveis de ambiente no Azure App Service
2. Configure o pipeline no Azure DevOps
3. O deploy será automático a cada push na branch principal

---

## 🔒 Segurança

- **Autenticação JWT** com tokens de curta duração
- **Senhas criptografadas** com BCrypt
- **CORS configurado** para origens específicas
- **Validação de entrada** em todos os endpoints
- **Proteção contra SQL Injection** via JPA
- **Rate limiting** (recomendado adicionar em produção)

---


## 🌟 Recursos de Apoio

Se você ou alguém que você conhece está passando por dificuldades emocionais:

- **CVV (Centro de Valorização da Vida):** 188 (24h, gratuito)
- **CAPS (Centro de Atenção Psicossocial):** Procure a unidade mais próxima
- **SAMU:** 192
- **Emergência:** 190

**Lembre-se: Buscar ajuda é um sinal de força, não de fraqueza.** 💙

</div>
