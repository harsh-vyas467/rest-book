# 🚀 Quarkus Quick Start Guide

## ✅ Creating a Quarkus Application

### 1. Using Quarkus Code Generator
- Visit: [https://code.quarkus.io](https://code.quarkus.io)
- Fill in:
        - **Group ID**
        - **Artifact ID**
        - **Class name**
- Add Extension: `RESTEasy JSON-B`
- Download and unzip the generated project

---

### 2. Using Maven CLI
```bash
mvn -U io.quarkus:quarkus-maven-plugin:create \
    -DprojectGroupId=org.agoncal.quarkus.starting \
    -DprojectArtifactId=rest-book \
    -DclassName="org.practice.quarkus.BookResource" \
    -Dpath="/api/books" \
    -Dextensions="resteasy-jsonb"
▶️ Running the App
Start in Dev Mode
```bash
mvn quarkus:dev

Access REST Endpoint
URL: http://localhost:8080/api/books

Test with cURL
```bash
curl http://localhost:8080/api/books
Access Dev UI
URL: http://localhost:8080/q/dev/

📘 JAX-RS (Java API for RESTful Services)
Used to expose and consume REST APIs:

```bash
@GET
@POST
@Path
@PathParam
@Produces
@Consumes
🧩 CDI (Context and Dependency Injection)
Common annotations:

```bash
@Inject
@Qualifier
@ApplicationScoped
@RequestScoped
@Observes
🛑 Freeing Port 8080 on Windows
```bash
netstat -ano | findstr :8080
taskkill /PID <PID> /F
🧪 Running Unit Tests
Run tests using:

```bash
mvn test
Or configure JUnit in your IDE to run directly.

⚙️ MicroProfile Config API
Key Annotations
API	Description
@ConfigProperty	Inject config value
ConfigProvider	Access global config
Config	Resolve config values
ConfigSource	Represents a config source
Converter	Converts strings to Java types

Example
properties

# application.properties
books.genre=Information Technology
```java
@ConfigProperty(name = "books.genre")
String genre;
Override at Runtime

```bash
mvn quarkus:dev -Dbooks.genre="Technology"
⚙️ Configuration
Config keys start with quarkus.

Defined in application.properties

See full list: Quarkus Config Options

📂 Quarkus Profiles
Use different profiles for different environments:

```bash
mvn quarkus:dev                          # default
mvn quarkus:dev -Dquarkus.profile=staging
📦 JAR Packaging Types
Type	Description
Fast-JAR	Optimized with classpath index (default)
Legacy JAR	Standard JAR with app code and runtime
Uber-JAR	All dependencies in one JAR

Commands
```bash
mvn package                             # Fast-JAR
mvn package -Dquarkus.package.type=legacy-jar
mvn package -Dquarkus.package.type=uber-jar
mvn package -DskipTests                 # Skip tests
java -jar target/quarkus-app/quarkus-run.jar
🧊 Native Executables
No JVM required

Small and fast, but slow to compile

```bash
mvn package -Pnative
🐳 Building Docker Images
JVM Image

mvn package \
  -Dquarkus.container-image.build=true \
  -Dquarkus.package.type=jar \
  -Dquarkus.container-image.tag=jvm

docker run -i --rm -p 8080:8080 your-image:tag
Native Image
mvn package \
  -Dquarkus.package.type=native \
  -Dquarkus.native.container-build=true \
  -Dquarkus.container-image.build=true \
  -Dquarkus.container-image.tag=native

docker run -i --rm -p 8080:8080 your-image:tag

