# Aplicação de Gerenciamento de Pessoas e Contatos

## Descrição

Esta aplicação permite o gerenciamento de dados de pessoas e seus contatos, incluindo criação, leitura, atualização e exclusão de informações de pessoas e contatos.

## Tecnologias

- **Backend:** Java com Spring Boot
- **Banco de Dados:** H2 (banco de dados em memória)
- **Documentação de API:** OpenAPI (Swagger)

## Como executar a aplicação

### 1. Clone o repositório

Clone o repositório da aplicação para sua máquina local:

```bash
git clone https://github.com/nilsonmazurchi/AppContatos.git
```

## 2. Execute a aplicação
Após clonar o repositório, entre na pasta do projeto e execute o seguinte comando para iniciar o servidor:

```bash
./mvnw spring-boot:run
```

Ou, se estiver utilizando Maven, pode usar:

```bash
mvn spring-boot:run
```

A aplicação será executada localmente na porta 8080.

## 3. Banco de Dados
O banco de dados utilizado pela aplicação é o H2, que é um banco de dados em memória. As informações são armazenadas apenas durante a execução do servidor. Ao reiniciar o servidor, o banco de dados será reiniciado.

## 4. Acessando a documentação do OpenAPI (Swagger)
A documentação da API está disponível através do Swagger. Para acessá-la, basta abrir o navegador e acessar a URL abaixo:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Lá você encontrará a lista de todos os endpoints disponíveis, suas descrições, parâmetros e exemplos de uso.

## 5. Endpoints

### Pessoa
**Gerenciamento de Pessoas**

- **GET** `/api/pessoas/{id}`
  - Obtém os dados de uma Pessoa por ID.
- **PUT** `/api/pessoas/{id}`
  - Atualiza uma Pessoa existente por ID.
- **DELETE** `/api/pessoas/{id}`
  - Remove uma Pessoa por ID.
- **GET** `/api/pessoas`
  - Lista todas as Pessoas.
- **POST** `/api/pessoas`
  - Cria uma nova Pessoa.
- **GET** `/api/pessoas/maladireta/{id}`
  - Obtém os dados de uma Pessoa por ID para Mala Direta.

### Contato
**Gerenciamento de Tipos de Contatos**

- **PUT** `/api/contatos/{id}`
  - Atualiza um tipo de contato existente.
- **DELETE** `/api/contatos/{id}`
  - Remove um tipo de contato por ID.
- **POST** `/api/contatos/nome`
  - Adiciona um novo tipo de contato a uma Pessoa por Nome.
- **POST** `/api/contatos/id`
  - Adiciona um novo tipo de contato a uma Pessoa por ID.
- **GET** `/api/contatos/pessoa/{idPessoa}`
  - Lista todos os tipos de contatos de uma pessoa pelo ID.
- **GET** `/api/contatos/{id}`
  - Retorna os dados de um tipo de contato por ID.

## 6. Contribuição
Se você quiser contribuir para o projeto, fique à vontade para enviar um pull request. Qualquer sugestão ou melhoria é bem-vinda!

## 7. Licença
Este projeto está licenciado sob a MIT License.