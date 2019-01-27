### demo-migration-to-k8s

build & run:
```
./deploy.sh
 ```

check:
```
curl localhost:8080/hi
curl localhost:8080/server/greeting
```

utils:
```
k get pods
k get services
#
k logs -f deployment/client-app
k get deployment client-app -o yaml --export
k get service greeting-client -o yaml --export
```  