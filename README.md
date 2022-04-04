# **Jumbo test application**
## Requirements
- JAVA 11
- DOCKER
- MAVEN

**Before running the application for creating database and redis server** 
> without this phase you can't run the application
```bash
docker-compose up -d
```


## Building application
```bash
mvn clean install
```

## Running application from terminal
```bash
java -jar target/supermatten-0.0.1-SNAPSHOT.jar
```
