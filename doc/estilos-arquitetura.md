# Estilos de Arquitetura

## Padrão SAGA

O padrão SAGA é uma abordagem para gerenciar a consistência de dados em arquiteturas de microsserviços, especialmente em cenários de transações distribuídas. Ele consiste em uma sequência de transações locais, onde cada transação atualiza um serviço específico e publica uma mensagem ou evento para acionar a próxima etapa da transação. Se uma etapa falhar, o SAGA executa transações compensatórias para desfazer as mudanças feitas pelas transações anteriores12.

>- Características Principais:
    >- Transações Coordenadas: Coordena transações que envolvem múltiplos serviços ou processos.
    >- Compensação e Rollback: Inclui mecanismos para reverter transações em caso de falhas.
    >- Transações Distribuídas: Suporta transações que abrangem múltiplos serviços.
    >- Processamento Assíncrono: Permite maior concorrência e desempenho.
    >- Tratamento de Erros: Fornece uma maneira padronizada de lidar com erros durante a transação.
    >- Escalabilidade: Pode escalar para lidar com transações grandes e complexas