# README #

### product-manager ###
Web Service in Rest to manager products.

### Solution ###
* SpringBoot, Tomcat and MongoDB.

### System requirements ###
* Java8 or newer, Maven 3, MongoDB, some REST client or curl app

### Set up ###
* Dependencies
  Declared inside the pom.xml
* Maven configuration
    - Download Maven 3 here:https://maven.apache.org/download.cgi
    - Install and configure following this instrucions: https://maven.apache.org/install.html and https://maven.apache.org/configure.html
* Database configuration
    Normal configuration
    - Download MongoDB here: www.mongodb.org/downloads
    - Install and start the server. Instruction here: http://docs.mongodb.org/manual/
    - Run mongoDB and create a database named product (use the command "use product")
    or Docker configuration
    - Download and install Docker following the instructions here: https://docs.docker.com/get-docker/
    - Install docker-compose following the instructions here: https://docs.docker.com/compose/install/
    - "docker-compose up -d" to start and "docker-compose stop" to stop
* Unit tests
  To run tests: mvn clean install
* Deployment instructions -
  mvn spring-boot:run (ctrl + C to stop)
* GitFlow
    - Download GitFlow in command line: apt-get install git-flow or install IDE plugin
    - Apply GitFlow in repository by: command line "git flow init" or plugin initialization

### Running ###

* I used PostMan, a REST client

### CREATE PRODUCT - Post, Body, raw, Json ###
curl --location 'localhost:8080/product'

### FIND ALL - Get, Body ###
curl --location 'localhost:8080/product' \
--header 'Content-Type: application/json' \
--data '{
"name": "Nome 1"
}'