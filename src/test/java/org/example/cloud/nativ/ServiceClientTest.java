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

    @Test
    public void testServiceFile() throws URISyntaxException, FileNotFoundException {
        pathToCustomConfig = "./src/main/k8s/service.yml";
        Service test = mockKubernetes.getClient().services().load(pathToCustomConfig).get();
        assertThrows(KubernetesClientException.class, () ->  mockKubernetes.getClient().services().create(test)) ;
    }

}