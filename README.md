#Desafio Attornatus

Este projeto é parte do processo seletivo da Attornatus.


Além do proposto, fiz o deploy no Heroku utilizando PostgreSQL.
  https://desafio-attornatus.herokuapp.com/

O arquivo Insomnia_route_test pode ser usado para testar diretamente as rotas.



## Avaliação Desenvolvedor Back-end Attornatus

O objetivo deste documento é identificar seus conhecimentos quanto às tecnologias utilizadas no cotidiano de desenvolvimento da equipe de Back-end na Attornatus Procuradoria Digital.

Esta análise propõe avaliar os seguintes temas: 
    • Qualidade de código
    • Java, Spring boot
    • API REST
    • Testes

A entrega deverá ser feita da seguinte forma:
    • O prazo para entrega da avaliação será de até 7 dias após envio da mesma
    • Encaminhar este documento com as perguntas respondidas e com o link do código público em sua conta do GitHub
    • Opcionalmente, caso você consiga fazer o build da aplicação, poderá também informar o link de acesso


Qualidade de código

    1. Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?
R: Para uma implementação de uma nova funcionalidade, se faz necessário a clara definição dos Requisitos e Regras de Negócios, assim delimitando o escopo da implementação. Com isto, é possível elaborar testes de validação, os quais norteiam o desenvolvimento dessa nova funcionalidade.

    2. Em qual etapa da implementação você considera a qualidade de software?
R: Por mais que a preocupação com a qualidade do software seja uma preocupação constante, ela deve ser integrada em uma etapa do ciclo de desenvolvimento. Por haver diversos modelos, acredito que seja mais fácil afirmar, de maneira genérica, que o momento seria entre o desenvolvimento e a entrega.

Desafio Java

Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:  
    • Criar uma pessoa
    • Editar uma pessoa
    • Consultar uma pessoa
    • Listar pessoas
    • Criar endereço para pessoa
    • Listar endereços da pessoa
    • Poder informar qual endereço é o principal da pessoa  

Uma Pessoa deve ter os seguintes campos:  
    • Nome
    • Data de nascimento
    • Endereço:
        ◦ Logradouro
        ◦ CEP
        ◦ Número
        ◦ Cidade

Requisitos  
    • Todas as respostas da API devem ser JSON  
    • Banco de dados H2

Diferencial
    • Testes
    • Clean Code
 
Será levado em avaliação 
    • Estrutura, arquitetura e organização do projeto  
    • Boas práticas de programação  
    • Alcance dos objetivos propostos.
