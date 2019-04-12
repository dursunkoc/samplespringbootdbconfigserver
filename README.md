# Sample Spring Boot Configuration Server & Client

## Sample Springboot Configuration Server
- In order to run the sampledbconfigserver application you need install a postgresql database which can be connected as in "sampledbconfigserver\src\main\java\com\aric\samples\dev\PostgresDevelopmentConfiguration.java" or you can modify this class to connect your own database.
- In your postgresql you need to create a schema named "CONFIG", if you want to use another schema please see the "sampledbconfigserver\src\main\java\com\aric\samples\domain\Properties.java" file.

- In order to run the config server use the following command inside "sampledbconfigserver" directory.

    ```
    > mvn spring-boot:run -Dspring-boot.run.profiles=pg-dev,jdbc
    ```

- Next create a sample configuration record using following `POST` request.

    ```
    > curl -H "Content-Type: application/json" -d "{\"application\":\"sampleconfigclient\",\"profile\":\"default\",\"label\":\"master\",\"key\":\"name_x.property_xx\",\"value\":99}" -X POST http://localhost:8082/api/props
    ```

- Now you try to run the sampleconfigclient. Run it using the following command.

    ```
    > mvn spring-boot:run
    ```
- And test the client using the following `GET` request.

    ```
    > curl -X GET http://localhost:8080/api
    ```