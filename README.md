# Aplicação RESTful com SpringBoot

Simples API RestFul representando algumas ações bancárias como:

  Abrir conta,
  Consultar saldo,
  Depositar,
  Sacar,
  Transferir

  Start do projeto

  https://start.spring.io/

  Dependências utilizadas:

  JPA: https://spring.io/guides/gs/accessing-data-jpa

  mysql: https://spring.io/guides/gs/accessing-data-mysql/

  WebTools: https://spring.io/blog/2015/06/17/devtools-in-spring-boot-1-3

  swagger-2: ##


## Configurando a conexão

  ```java
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/banco");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
  ```
  ## Configurando base de dados


##Como usar:

  Basta `importar o projeto via MAVEN` em sua IDE preferêncial, e posteriormente executar a aplicação.
