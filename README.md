

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