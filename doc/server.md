# Diferenças entre Tomcat, Jetty e Undertow

## Tomcat
- **Desempenho**: Tomcat é conhecido por ser robusto e amplamente utilizado, mas pode não ser o mais rápido em termos de desempenho bruto.
- **Uso de Recursos**: Tem um uso de memória moderado.
- **Configuração**: Configuração baseada em XML, mas também suporta configuração programática.
- **Compatibilidade**: Suporta uma ampla gama de especificações Java EE.
- **Comunidade**: Grande comunidade e ecossistema maduro.

## Jetty
- **Desempenho**: Jetty é conhecido por sua alta taxa de transferência e baixa latência, tornando-o adequado para aplicações de alto desempenho.
- **Uso de Recursos**: Consome mais memória na inicialização (cerca de 311 MB).
- **Configuração**: Configuração centralizada em XML, altamente configurável com suporte a uma ampla gama de extensões e módulos.
- **Compatibilidade**: Suporte robusto para a API Servlet e outras especificações Java EE.
- **Comunidade**: Comunidade madura com um ecossistema bem estabelecido.

## Undertow
- **Desempenho**: Undertow é projetado para ser leve e eficiente, com o melhor desempenho entre os três em termos de velocidade.
- **Uso de Recursos**: Consome menos memória e recursos de CPU, ideal para ambientes com recursos limitados.
- **Configuração**: Abordagem de configuração programática, facilitando a incorporação e configuração dentro das aplicações.
- **Compatibilidade**: Totalmente compatível com a API Servlet, mas pode não oferecer todas as funcionalidades avançadas que Jetty oferece.
- **Comunidade**: Comunidade menor, mas em crescimento.

# Outros Servidores Suportados pelo Spring Boot

Além de Tomcat, Jetty e Undertow, o Spring Boot também suporta outros servidores como:

- **Netty**: Um framework de rede assíncrono que oferece controle granular sobre os aspectos de rede, ideal para construir protocolos personalizados e aplicações altamente especializadas.
- **Reactor Netty**: Usado principalmente em aplicações reativas com Spring WebFlux.

# Melhor Desempenho para Alta Disponibilidade

Para alta disponibilidade e desempenho, **Undertow** é frequentemente considerado a melhor escolha devido ao seu baixo consumo de recursos e alta eficiência. No entanto, a escolha do servidor também pode depender de outros fatores, como a compatibilidade com tecnologias existentes, facilidade de configuração e suporte da comunidade.
