package org.example.cloud.nativ;


import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.kubernetes.client.KubernetesTestServer;
import io.quarkus.test.kubernetes.client.WithKubernetesTestServer;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertThrows;


@WithKubernetesTestServer
@QuarkusTest
public class ServiceClientTest {

    @KubernetesTestServer
    private KubernetesServer mockKubernetes;

    private String pathToCustomConfig;

    private String flavoredInput = """
            apiVersion: v1
            kind: Service
            metadata:
              annotations:
                app.quarkus.io/build-timestamp: 2022-02-14 - 13:56:17 +0000
              labels:
                app.kubernetes.io/name: fellowship-not-working
                app.kubernetes.io/version: 1.0.0-SNAPSHOT
            spec:
              ports:
                - name: http
                  port: 80
                  targetPort: 8080
              selector:
                app.kubernetes.io/name: fellowship-not-working
                app.kubernetes.io/version: 1.0.0-SNAPSHOT
              type: now
            """;

    @Test
    public void testServiceFile() throws URISyntaxException, FileNotFoundException {
        pathToCustomConfig = "./src/main/kubernetes/service.yml";
        Service test = mockKubernetes.getClient().services().load(pathToCustomConfig).get();
        assertThrows(KubernetesClientException.class, () ->  mockKubernetes.getClient().services().create(test)) ;
    }

    @Test
    public void testCustomYAMLInput() throws URISyntaxException, FileNotFoundException {
        assertThrows(KubernetesClientException.class, () ->  mockKubernetes.getClient().services().load(flavoredInput).dryRun()) ;
    }
}