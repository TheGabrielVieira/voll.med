# 🏥 Voll.med API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

API REST desenvolvida para gerenciamento de uma clínica médica, permitindo o controle de médicos, pacientes e agendamento de consultas.

---

## 🚀 Tecnologias utilizadas

* Java 21+
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Maven
* MySQL
* Flyway (migrations)
* SpringDoc (Swagger/OpenAPI)

---

## 📌 Sobre o projeto

O Voll.med é uma API REST que simula o backend de um sistema de clínica médica.

A aplicação permite:

* Cadastro e gerenciamento de médicos
* Cadastro e gerenciamento de pacientes
* Agendamento de consultas
* Cancelamento de consultas
* Autenticação e autorização via JWT

---

## 🧱 Arquitetura

O projeto segue uma arquitetura em camadas:

```
controller → service → repository → database
```

### Camadas:

* **Controller**

    * Responsável por receber requisições HTTP

* **Service**

    * Contém regras de negócio

* **Repository**

    * Comunicação com o banco de dados (JPA)

* **Security**

    * Configuração de autenticação com JWT

---

## 🔐 Autenticação

A autenticação é feita utilizando JWT.

Fluxo:

1. Usuário faz login via `/login`
2. Recebe um token JWT
3. Envia o token no header:

```
Authorization: Bearer {token}
```

---

## 📂 Endpoints principais

### 🔑 Autenticação

* `POST /login`

---

### 👨‍⚕️ Médicos

* `GET /medico`
* `GET /medico/{id}`
* `POST /medico`
* `PUT /medico`
* `DELETE /medico/{id}`

---

### 🧑‍🤝‍🧑 Pacientes

* `GET /paciente`
* `GET /paciente/{id}`
* `POST /paciente`
* `PUT /paciente`
* `DELETE /paciente/{id}`

---

### 📅 Consultas

* `POST /consultas`
* `DELETE /consultas`

---

## 🗄️ Banco de dados

O projeto utiliza **MySQL** com controle de versão via **Flyway**.

As migrations são executadas automaticamente ao iniciar a aplicação.

---

## ⚙️ Como rodar o projeto

### 📌 Pré-requisitos

* Java 21+
* Maven
* MySQL instalado

---

### 🛠️ Passo a passo

#### 1. Clone o repositório

```bash
git clone https://github.com/TheGabrielVieira/voll.med.git
cd voll.med
```

---

#### 2. Configure o banco de dados

Crie um banco no MySQL:

```sql
CREATE DATABASE vollmed_db;
```

---

#### 3. Configure o application.properties

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost/vollmed_db
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

api.security.token.secret=${JWT_SECRET}
```

---

#### 4. Execute o projeto

```bash
mvn spring-boot:run
```

Ou:

```bash
./mvnw spring-boot:run
```

---

## 🌐 Acesso

* API: http://localhost:8080
* Swagger: http://localhost:8080/swagger-ui.html

---

## 📖 Documentação da API

A documentação interativa é gerada automaticamente com SpringDoc (Swagger).

---

## 🧪 Testes

(Adicionar futuramente)

Sugestão:

* Testes unitários com JUnit
* Testes de integração com Spring Boot Test

---

## 📌 Melhorias futuras

* Implementação de testes automatizados
* Deploy (Railway / Docker)
* Paginação e filtros avançados
* Logs estruturados
* CI/CD

---

## 📬 Exemplos de Requisições

### 🔐 Login

**Request:**

```http
POST /login
Content-Type: application/json
```

```json
{
  "login": "admin",
  "senha": "123456"
}
```

**Response:**

```json
{
  "token": "jwt_token_aqui"
}
```

---

### 👨‍⚕️ Cadastro de Médico

**Request:**

```http
POST /medico
Authorization: Bearer {token}
Content-Type: application/json
```

```json
{
  "nome": "Dr. João Silva",
  "email": "joao@med.com",
  "crm": "123456",
  "especialidade": "CARDIOLOGIA",
  "endereco": {
    "logradouro": "Rua A",
    "bairro": "Centro",
    "cep": "12345678",
    "cidade": "Recife",
    "uf": "PE"
  }
}
```

**Response:**

```json
{
  "id": 1,
  "nome": "Dr. João Silva",
  "email": "joao@med.com"
}
```

---

### 🧑 Paciente

**Request:**

```http
POST /paciente
Authorization: Bearer {token}
Content-Type: application/json
```

```json
{
  "nome": "Maria Souza",
  "email": "maria@email.com",
  "cpf": "12345678900",
  "telefone": "81999999999"
}
```

---

### 📅 Agendamento de Consulta

**Request:**

```http
POST /consultas
Authorization: Bearer {token}
Content-Type: application/json
```

```json
{
  "idMedico": 1,
  "idPaciente": 1,
  "data": "2026-05-10T10:00:00"
}
```

---

### ❌ Cancelamento de Consulta

**Request:**

```http
DELETE /consultas
Authorization: Bearer {token}
Content-Type: application/json
```

```json
{
  "idConsulta": 1,
  "motivo": "PACIENTE_DESISTIU"
}
```
## 📬 Postman

## Testando a API com Postman

Para facilitar os testes da API, foi disponibilizada uma collection do Postman com todos os endpoints.

### 📥 Importar a collection

1. Baixe o arquivo:

👉 [Download da Collection](./docs/vollmed_collection.json)

2. Abra o Postman
3. Clique em **Import**
4. Selecione o arquivo baixado

---

### 🔐 Autenticação automática

Após realizar o login, o token JWT será salvo automaticamente para uso nas próximas requisições.

Caso necessário, configure manualmente:

```
Authorization: Bearer {{token}}
```

---

### ⚙️ Variáveis utilizadas

A collection utiliza variáveis para facilitar o uso:

* `{{base_url}}` → URL da API (ex: http://localhost:8080)
* `{{token}}` → Token JWT gerado no login

---

### 🚀 Fluxo recomendado

1. Execute **Login**
2. O token será salvo automaticamente
3. Execute os demais endpoints normalmente

---

### 📁 Estrutura da collection

* Auth
* Médicos
* Pacientes
* Consultas

---

Isso permite testar toda a API sem necessidade de configuração manual.

## 🤝 Contribuição

Contribuições são bem-vindas!

1. Fork o projeto
2. Crie uma branch (`feature/minha-feature`)
3. Commit suas alterações
4. Abra um Pull Request

---

## 📄 Licença

Este projeto é apenas para fins de estudo.
