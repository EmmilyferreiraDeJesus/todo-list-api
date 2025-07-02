# 📋 To-Do List API

API para gerenciamento de tarefas (To-Do List), desenvolvida com o objetivo de praticar os principais conceitos e ferramentas do ecossistema **Spring Boot**.

---

## 🚀 Tecnologias utilizadas

- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **MySQL**
- **Spring Doc OpenAPI (Swagger)**
- **Lombok**
- **Bean Validation (Jakarta Validation)**
- **Testes Unitários com WebTestClient**

---

## 🛠️ Funcionalidades da API

Essa API permite:

- ✅ Criar novas tarefas  
- ✅ Listar todas as tarefas  
- ✅ Atualizar tarefas existentes  
- ✅ Excluir tarefas  
- ✅ Documentação automática dos endpoints via Swagger  

---

## 🧪 Testes com WebTestClient

### O que é o WebTestClient?

O **WebTestClient** é uma ferramenta do Spring usada para testar endpoints HTTP de forma rápida e sem necessidade de subir o servidor manualmente.

Ele permite fazer **requisições simuladas** e validar as respostas da API de maneira fluente.

### Recursos usados nos testes:

| Recurso | O que faz? |
|---|---|
| `.post()`, `.get()`, `.put()`, `.delete()` | Faz requisições simuladas |
| `.uri("/todos")` | Define a URL do endpoint a ser testado |
| `.bodyValue(objeto)` | Envia um objeto como corpo da requisição |
| `.exchange()` | Executa a requisição |
| `.expectStatus().isOk()`, `.isBadRequest()` | Valida o status da resposta |
| `.expectBody().jsonPath()` | Valida campos específicos na resposta JSON |

### Exemplos de cenários testados:

- ✅ Criar tarefa com sucesso
- ✅ Criar tarefa com erro de validação
- ✅ Atualizar tarefa com sucesso
- ✅ Atualizar tarefa com erro
- ✅ Deletar tarefa com sucesso
- ✅ Deletar tarefa com falha
- ✅ Listar todas as tarefas

---

## Como Executar


```bash
# Clone o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git

# Acesse a pasta do projeto
cd seu-repositorio

# Configure o application.properties (ex: conexão com o banco MySQL)

# Execute o projeto
./mvnw spring-boot:run
```

Acesse o Swagger em:

```bash
http://localhost:8080/swagger-ui/index.html
```

---

## 🌐 Endpoints da API

### 📍 Listar tarefas (POST)

- POST http://localhost:8080/todos

```json
[
  {
  "id": 1,
  "nome": "Pedro Alves",
  "descricao": "Ir ao dentista",
  "realizado": false,
  "prioridade": 5
  }
]
```

### 📍 Listar tarefas (GET)

- GET http://localhost:8080/todos

```json
[
  {
  "id": 1,
  "nome": "Pedro Alves",
  "descricao": "Ir ao dentista",
  "realizado": false,
  "prioridade": 5
  }
]
```

### 📍 Listar tarefas (PUT)

- PUT http://localhost:8080/todos

```json
[
  {
  "id": 1,
  "nome": "Pedro",
  "descricao": "Ir ao dentista",
  "realizado": true,
  "prioridade": 5
  }
]
```

### 📍 Listar tarefas (DELETE)

- DELETE http://localhost:8080/todos/1

```json
[ ]
```

