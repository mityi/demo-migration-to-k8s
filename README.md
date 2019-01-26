### demo-migration-to-k8s

build & run eureka:
```
./gradlew clean build
```

run:
```
java -jar ./client/build/libs/client-0.0.1.jar
java -jar ./server/build/libs/server-0.0.1.jar
 ```
 
check:
```
curl localhost:8080/hi
curl localhost:8080/server/greeting
```