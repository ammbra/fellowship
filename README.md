# fellowship Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .
This application is using Dev Services, so please make sure that you have a Docker daemon running.
## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/fellowship-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.


## Related Guides

- RESTEasy Reactive ([guide](https://quarkus.io/guides/resteasy-reactive)): Reactive implementation of JAX-RS with additional features. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- SmallRye Health ([guide](https://quarkus.io/guides/microprofile-health)): Monitor service health

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

### SmallRye Health

Monitor your application's health using SmallRye Health

[Related guide section...](https://quarkus.io/guides/smallrye-health)

## Deploy to Kubernetes

Please run the command below to deploy to Kubernetes
````
mvn clean package -Dquarkus.kubernetes.deploy=true
````

Obtain the path to the deployed service:

````
kubectl get service fellowship -o jsonpath='{.status.loadBalancer.ingress[0].hostname}'
````

Export URL to the service using:

````
export URL=http://$( kubectl get service fellowship -o jsonpath='{.status.loadBalancer.ingress[0].hostname}')
````

Run the hey command bellow to determine how the resource usage:

````
hey -n 100 -c 20 $URL/welcome/all
````

