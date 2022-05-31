# carRestApi

REST API using Java, Spring Boot, H2, Swagger

### How to run

To run Spring Boot application. In project root directory

```shell
mvn spring-boot:run
```

### Swagger

```shell
Browser:  http://localhost:8080/swagger-ui/index.html#/
```

### H2

To access H2 database navigate to

```shell
Browser: http://localhost:8080/h2-console/

Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:mydb
User Name: sa
Password: 

```

### Available cars

On Spring Boot start-up Liquibase inserts 25 cars in H2 database.

##### Makes

```shell
BMW, Bentley, Chevrolet, Dodge, Ford, GMC, Isuzu, Jaguar, Lexus, Lotus, Mercedes-Benz,
Plymouth, Pontiac, Porsche, Rambler, Volkswagen,
```

### Export/Import

To export cars from database to ```cars.json```, navigate to
```/html/index.html ```
open file in your browser
and press ```Download``` button. To import, select file and press ```Upload```.
If no ```.json``` file handy, there is one in ```/html```.
