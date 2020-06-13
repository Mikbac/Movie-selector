

# Table of contents
* [Fuzzy logic](#fuzzy-logic)
* [Configuration](#configuration)
* [Built with](#built-with)

## Fuzzy logic

### Question rating:
![ex1](img/Movie-2-0.png)

### Movies rating:
![ex1](img/Score-2-0.png)

## Configuration
* Set [API key](http://www.omdbapi.com/apikey.aspx) (```omdb.api.key```) in:
    
    ```./src/main/resources/config/application.properties```
    
* Set path to the fuzzy logic controller (```fuzzy.logic.controller.path```) in:
    
    ```./src/main/resources/config/application.properties```

## Built with

* [JDK 11](https://www.oracle.com/technetwork/java/index.html)

* [Spring Boot - 2.3.0.RELEASE](https://spring.io/projects/spring-boot) 
    * [Log4j](https://logging.apache.org/log4j/2.x/)
    * [HSQLDB](http://hsqldb.org/)

* [jFuzzyLogic](http://jfuzzylogic.sourceforge.net/html/index.html) 

* [Swagger2](https://swagger.io/)