

1st way to create quarkus application:

visit :https://code.quarkus.io/

fill the required fields and from extensions pick RESTEasy JSON-B


2nd way through maven :

#!/usr/bin/env bash 
mvn -U io.quarkus:quarkus-maven-plugin:create \
        -DprojectGroupId=org.agoncal.quarkus.starting \
        -DprojectArtifactId=rest-book \
        -DclassName="org.practice.quarkus.BookResource" \
        -Dpath="/api/books" \
        -Dextensions="resteasy-jsonb"


It already provides basic get controller,when run output is displayed on

http://localhost:8080/api/books

check through curl command:
curl http://localhost:8080/api/books


mvn quarkus:dev

to check dev ui :http://localhost:8080/q/dev/


------------------------------------------------
JAX-RS : Specification for Exposing REST Web Services and Consuming REST Web Services

contains api like : @GET @POST @Path @PathParam @Produces @Consumes

---------
CDI: Context and Dependency Injection

APi : @Inject @Qualifier @ApplicationScoped @RequestScoped @Observes

---------
to kill the process in windows:

netstat -ano | findstr :8080

taskkill /PID 1234 /F

-------

written junit tests

to run tests you can edit configuration and add junit to run it directly 
or you can simply do mvn test

----------

Microprofile Configuration Api:

Api -> Description

@ConfigProperty ->Binds the injection point with a configured value
ConfigProvider -> Central class to access a Config
Config -> Resolves the property value by searchig through all the configuration sources
ConfigSource ->Provides configuration values from a specific place
Converter -> Converts a configured values from a String to a Java type 


you can store values of variable in application.properties and use @ConfigProperty on that variable and it will get read from application.properties

also we can pass it on runtime , it will have more preference then properties file , you just have to run command like:

mvn quarkus:dev -Dbooks.genre="Information technology"

-----------------------

Quarkus is highly configurable keys starting with "quarkus." Extensions are configurable
All in application.properties

to check out configuration options visit : https://quarkus.io/guides/all-config

