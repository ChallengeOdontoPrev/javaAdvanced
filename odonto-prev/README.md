# Odonto Validation

Serviço de Validação de Consultas Odontológicas

### Link p/ apresentação da solução: https://www.youtube.com/watch?v=wJah-rw1eGQ&ab_channel=Kau%C3%A3Silveira

## Integrantes do Grupo

### Kauã Almeida Silveira
- **Responsável por:** API em Java Spring Boot, integração com o banco de dados Oracle, e API Python com Roboflow para visão computacional.
### Rafael Vida
- **Responsável por:** DevOps no Azure e QA, garantindo o pipeline de integração contínua e a qualidade do software.
### Gustavo Maia
- **Responsável por:** Desenvolvimento do App em Kotlin para Android e site em C#.

## Instruções para Rodar a Aplicação

## Pré-requisitos para rodar a API Spring Boot:
- Java 17 ou superior instalado (para a API Spring Boot)
- Maven instalado (para a API Spring Boot)
- As configurações do banco de dados Oracle estão no arquivo `application.properties` na pasta `src/main/resources`,
  não é necessário instalar o banco de dados Oracle, pois a aplicação está utilizando um banco de dados disponibilizado
  em um servidor remoto da FIAP.

## Passo a Passo:

1. **Clone o repositório:**
   ```git clone https://github.com/ChallengeOdontoPrev/javaAdvanced.git```
2. **Acesse a pasta do projeto no intellij:**
   ```javaAdvanced/odontoprev```
3. **Defina o JDK no Intellij para Run & build do projeto**
4. **Rode a aplicação Spring Boot, localizada na pasta raiz**
   ```OdontoPrevApplication.java```

## Como testar a API Spring Boot:

1. **Importe o arquivo de coleção do Postman:**
   ```ChallengeOdontoPrev.postman_collection.json```
2. **Importe o arquivo de ambiente do Postman:**
   ```Auth.postman_environment.json```
3. **Execute as requisições do Postman para testar a API**

## Endpoints da API Spring Boot:

Observação: Vale ressaltar que a API Spring Boot está utilizando
Spring Security com JWT para autenticação e autorização. Logo, é necessário
realizar o login para obter o token JWT e inseri-lo no Authorization das requisições, de todos recursos, como bearer token.

### Autenticação (`/auth`)
- **POST** `/auth/login`  
  **Descrição:** Realiza login e retorna um token de autenticação.
  ```json
  {
    "email": "kaua.silveira@gmail.com",
    "password": "kaua2011"
  }
  
- **POST** `/auth/signup`  
  **Descrição:** Cria uma nova conta para um usuário.
  ```json
  {
    "email": "kaua.silveira@gmail.com",
    "password": "kaua2011",
    "name": "kaua",
    "role": "DENTISTA",
    "cro": "48569874",
    "clinicId": 161
  } 
  ```
  

- **POST** `/auth/forgot-password`

    **Descrição:** Envia um e-mail para redefinição de senha.

    **Query Params:**
    email: E-mail do usuário que deseja redefinir a senha.
    Exemplo: /auth/forgot-password?email=ti.kaua.silveira@drummond.com.br


- **POST** `/auth/reset-password`

    **Descrição:** Redefine a senha do usuário com base no token de autenticação.
	
    **Query Params:**

    **token:** Token JWT recebido no e-mail.

    **newPassword:** Nova senha.

    **confirmNewPassword:** Confirmação da nova senha.

    **Exemplo:** /auth/reset-password?token=<jwt_token>&newPassword=kk&confirmNewPassword=kk

### Clínicas (`/clinics`)
- **GET** `/clinics`

	**Descrição:** Retorna a lista de clínicas disponíveis.

- **POST** `/clinics`

	**Descrição:** Insere uma nova clínica.
	```json
	{
	  "name": "Clinica Odonto Alvorada",
	  "cnpj": "9785461/546164-78",
	  "address": {
	    "street": "Rua pacheco",
	    "number": "92",
	    "city": "São Paulo",
	    "state": "SP",
	    "zipCode": "03728-064"
	  },
	  "phone": "11 975122387",
	  "email": "OdontoAlvoradas@gmail.com"
	}

### Pacientes (`/patients`)
- **GET** `/patients`

	**Descrição:** Retorna a lista de pacientes cadastrados.

- **POST** `/patients`

	**Descrição:** Insere um novo paciente.
	```json
	{
	  "name": "Kaua Almeida",
	  "rg": "758924780",
	  "birthDate": "2004-11-20",
	  "numCard": 7852145
	}

### Consultas (`/appointments`)
- **GET** `/appointments`

	**Descrição:** Retorna todas as consultas agendadas.

- **POST** `/appointments`

	**Descrição:** Cria uma nova consulta.
	```json
	{
	  "dateAppointment": "2024-10-01",
	  "timeAppointment": "14:30",
	  "patientId": 141,
	  "procedureTypeId": 65
	}

### Tipos de Procedimentos (`/proceduresType`)
- **GET** `/proceduresType`

	**Descrição:** Retorna os tipos de procedimentos disponíveis.

## Diagrama de Entidade-Relacionamento (DER)

![DER](./DER.png)
