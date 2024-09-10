# Arquitetura Hexagonal - 2024

## Estrutura do projeto

```bash
src
└── main
    ├── java
    │   └── com
    │       └── exemplo
    │           ├── application
    │           │   ├── service
    │           │   └── port
    │           │       ├── in
    │           │       └── out
    │           ├── domain
    │           │   ├── model
    │           │   ├── repository
    │           │   └── service
    │           ├── infrastructure
    │           │   ├── adapter
    │           │   │   ├── in
    │           │   │   └── out
    │           │   ├── configuration
    │           │   └── repository
    │           ├── web
    │           │    ├── controller
    │           │    └── dto
    │           ├── security
    │           │   ├── config
    │           │   ├── service
    │           │   └── filter
    │           ├── util
    │           │    ├── helper
    │           │    └── constants
    │           ├── exception
    │           │    ├── handler
    │           │    └── custom
    │           ├── logging
    │           │    ├── config
    │           │    └── service
    │           ├── integration
    │           │    ├── client
    │           │    └── dto
    │           ├── command
    │           │   ├── handler
    │           │   ├── model
    │           │   └── service
    │           └── query
    │               ├── handler
    │               ├── model
    │               └── service
    └── resources
        ├── application.yml
        ├── application-dev.yml
        ├── application-test.yml
        ├── application-uat.yml
        ├── application-stag.yml
        ├── application-prod.yml
        │
        ├── messages_bra.properties
        ├── messages_arg.properties
        └── messages.properties

```

### Descrição dos Pacotes
  - application: Contém a lógica de aplicação e os casos de uso.
    - service: Serviços da aplicação.
    - port: Interfaces que definem os contratos de entrada (in) e saída (out).
  - domain: Contém as entidades de domínio e a lógica de negócio.
    - model: Modelos de domínio.
    - repository: Interfaces dos repositórios de domínio.
    - service: Serviços de domínio.
  - infrastructure: Implementações de infraestrutura e configurações.
    - adapter: Implementações dos adaptadores de entrada (in) e saída (out).
    - configuration: Configurações da aplicação.
    - repository: Implementações dos repositórios.
  - web: Contém os controladores e DTOs para a camada web.
    - controller: Controladores REST.
    - dto: Objetos de transferência de dados.
  - security: Gerencia a segurança da aplicação, incluindo autenticação e autorização.
    - config: Configurações de segurança, como definições de políticas de segurança e configurações de autenticação.
    - service: Serviços relacionados à segurança, como gerenciamento de usuários e permissões.
    - filter: Filtros de segurança, como filtros de autenticação e autorização.
  - util: Contém classes utilitárias e funções auxiliares que são usadas em várias partes da aplicação.
    - helper: Classes de ajuda que fornecem métodos utilitários comuns.
    - constants: Definições de constantes usadas em toda a aplicação.
  - exception: Gerencia o tratamento de exceções na aplicação.
    - handler: Classes que lidam com exceções globais e específicas.
    - custom: Exceções personalizadas definidas para a aplicação.
  - logging: Gerencia a configuração e o gerenciamento de logs.
    - config: Configurações de logging, como definições de níveis de log e destinos de log.
    - service: Serviços relacionados ao logging, como formatação e envio de logs.
  - integration: Gerencia a integração com sistemas externos.
    - client: Clientes para se comunicar com APIs externas.
    - dto: Objetos de transferência de dados usados para integração com sistemas externos.
  - command: Responsável por gerenciar as operações de escrita (comandos) que alteram o estado do sistema.
    - handler: Classes que lidam com a execução de comandos.
    - model: Modelos específicos para comandos.
    - service: Serviços relacionados ao processamento de comandos.
  - query: Responsável por gerenciar as operações de leitura (consultas) que recuperam dados do sistema.
    - handler: Classes que lidam com a execução de consultas.
    - model: Modelos específicos para consultas.
    - service: Serviços relacionados ao processamento de consultas.
  - test: Contém classes de teste para garantir a qualidade do código.
    - unit: Testes unitários que verificam a funcionalidade de componentes individuais.
    - integration: Testes de integração que verificam a interação entre diferentes componentes do sistema.

## Convenções adotadas

[O código deve seguir essas convenções para estilo](/doc/checkstyle.md)
