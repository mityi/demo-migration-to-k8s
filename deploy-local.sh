./gradlew clean build docker

kubectl delete -f ./charts
kubectl delete -f ./charts-local
kubectl apply -f ./charts-local

java -jar ./tool/eureka.jar