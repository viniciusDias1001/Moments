# Moments-BACK

Projeto Criado para Discplina de Engenharia de Software, e com proposito de aprendizado.


![image](https://user-images.githubusercontent.com/105192228/234443198-73f9e496-1e1d-480e-8e26-9bfb82156c9b.png)

**SOBRE O PROJETO**

O Moments-BACK é um projeto em Spring Boot que utiliza tecnologias como JPA, Hibernate e Maven. Ele fornece uma API RESTful que permite criar, atualizar, ler e excluir (CRUD) informações sobre momentos (como fotos, mensagens e vídeos) em um banco de dados. Além disso, o projeto inclui recursos como autenticação básica, internacionalização e validação de entrada.

**ASSUNTOS TRABALHADOS E ESTUDADOS NO DECORRER DO PROJETO**

- Criação e Entendimento de um Projeto Spring Boot e sua Arquitetura
- Classes de Configuração e Servisos
- Annotations E Annotations Personalizadas
- Injeção de Depedencias.
- Configurar e se Conectar com Banco de Dados (Como o H2 em Memoria (Para testes) e MySql )
- Mapeamento de Entidades JPA (EntityMenager)
- JPA Repositories
- Query e @Query
- Implementar uma RESTFuL
- Mapear recursos REST
- Conhecimentos nas operações de POST, DELETE, GET, PUT, PATCH
- Conhecendo e utilizando códigos de Status apropiados
- LOMBOK project
- Bean Validation
- Internacionalização
- Autorização de url's de acordo com os perfis de usuario.
- Implementar Autenticação Basic
- Conficuração de WebSecurity
- Build e Deploy
- JAR e WAR
- Cross Origin
- Relacionamento de Entidades
- Testes Postman
- Microservice e-mail

**FERRAMENTAS UTILIZADAS**

As seguintes ferramentas foram utilizadas durante o desenvolvimento do projeto:
- Intellij Idea
- Postman
- CMD
- MAVEN
- Browser
- MySql Workbench


**TECNOLIGIAS UTILIZADAS**

As seguintes tecnologias foram utilizadas durante o desenvolvimento do projeto:


- JAVA | Version - (17)  ![Java](https://img.shields.io/badge/Java-17-blue?logo=java)

- SPRING BOOT |  Version - (3.0.6) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.6.3-brightgreen?logo=spring)
- JPA / HIBERNATE

- MAVEN ![Maven](https://img.shields.io/badge/Maven-3.8.3-blue?logo=apache-maven)



**PRÉ-REQUISITOS PARA RODAR PROJETO**
- JAVA | Version - (17)
- SPRING BOOT |  Version - (3.0.6)
- MAVEN | Version - (3.8.6) ou superior
- MySQL Workbench 8.0 CE

**COMO RODAR PROJETO**

1- Clone o projeto : https://github.com/viniciusDias1001/Moments.git

2 - Abra o projeto e instale as dependencias maven:

![img.png](img.png)

3 - Vá em application.properties e altere as informações para seu banco de dados:

- Crie o DataBase "moments"

- Altere:  pring.datasource.username= e spring.datasource.password= 

![img_1.png](img_1.png)

4 - Ainda no  application.properties configure spring.mail , para mais detalhes sobre essa configuração : https://www.youtube.com/watch?v=ZBleZzJf6ro

5 - Crie as Tabelas no seu banco de dados. Script pronto no meuEsquema.sql

![img_3.png](img_3.png)

5 - Siga para classe ProjectMomentsBackApplication.java e de run no metodo main:

![img_2.png](img_2.png)

Esperamos que este projeto tenha sido útil para o seu aprendizado. Sinta-se à vontade para entrar em contato se tiver alguma dúvida ou sugestão de melhoria. Obrigado por ler!






