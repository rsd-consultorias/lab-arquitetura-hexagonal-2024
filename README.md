# lab-arquitetura-hexagonal-2024

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
    │           └── web
    │               ├── controller
    │               └── dto
    └── resources
        └── application.properties

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
  -   adapter: Implementações dos adaptadores de entrada (in) e saída (out).
    - configuration: Configurações da aplicação.
    - repository: Implementações dos repositórios.
  - web: Contém os controladores e DTOs para a camada web.
    - controller: Controladores REST.
    - dto: Objetos de transferência de dados.
