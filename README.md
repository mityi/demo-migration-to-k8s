### demo-migration-to-k8s

build & run:
```
./deploy.sh
 ```

check:
```
curl jug.nsk.ru/hi
curl jug.nsk.ru/server/greeting
```

utils:
```
k get pods
k get services
#
k logs -f deployment/client-app
k get deployment client-app -o yaml --export
k get service greeting-client -o yaml --export
#
helm install stable/nginx-ingress --name my-nginx
```  