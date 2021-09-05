![example workflow](https://github.com/Mikbac/Movie-selector/actions/workflows/maven.yml/badge.svg) 

[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/Mikbac/Movie-selector.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/Mikbac/Movie-selector/context:java) [![Total alerts](https://img.shields.io/lgtm/alerts/g/Mikbac/Movie-selector.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/Mikbac/Movie-selector/alerts/)

![GitHub](https://img.shields.io/github/license/Mikbac/Movie-selector)

# Table of contents
* [Fuzzy logic](#fuzzy-logic)
* [Configuration](#configuration)
* [Installing](#installing)
* [Example](#example)
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
    
* Personalize your questions in:
    
    ```./src/main/resources/import.sql```
    
    Parameters:
    
    | Name | Meaning |
    | --- | --- |
    | description | Description of the question. |
    | base_movie_variable | Described value from IMDB (one of: RUN_TIME, RELEASED, TOTAL_SEASONS, IMDB_VOTES, METASCORE, QUANTITY_LANGUAGES, QUANTITY_COUNTRIES). |
    | variable_name | Name in the fuzzy logic controller. |
    | start_variable | Beginning of range for variable. |
    | end_variable | End of range for variable. |
    | good_value_range | User response range (+/- good_value_range). |


* Personalize movie list:
    
    ```./src/main/resources/import.sql```

### Installing
1. Set [API key](http://www.omdbapi.com/apikey.aspx) (details above).
2. Build and run the application:
```
mvn install
cd target  
java -jar movieSelector-1.0-SNAPSHOT.jar
```
or
```
docker build --tag mikbac/movieselector:1.0 -f Dockerfile .
docker container run -p 8080:8080 --ip 0.0.0.0 --name movieselector mikbac/movieselector:1.0
```
3. Open the browser and hit ```http://localhost:8080/```.

## Example
![ex1](img/Example-1-0.png)    
    
## Built with

* [JDK 11 Oracle](https://www.oracle.com/technetwork/java/index.html)

* [Spring Boot - 2.3.0.RELEASE](https://spring.io/projects/spring-boot) 
    * [Log4j](https://logging.apache.org/log4j/2.x/)
    * [HSQLDB](http://hsqldb.org/)

* [jFuzzyLogic](http://jfuzzylogic.sourceforge.net/html/index.html) - Due to the use of the latest version of the library, the jar file is attached to the project (in Maven repository the library is out of date).

* [Swagger2](https://swagger.io/)
