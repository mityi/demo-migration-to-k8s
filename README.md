### demo-migration-to-k8s

build & run:
```
./deploy.sh
./deploy-local.sh
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
#
k port-forward deployments/client-app 5005:5005
#
telepresence --method inject-tcp --swap-deployment server-app --expose 8081:8080 --env-json server_env.json
``` 