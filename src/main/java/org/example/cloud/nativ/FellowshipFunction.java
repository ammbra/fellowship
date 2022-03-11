package org.example.cloud.nativ;

import io.quarkus.funqy.Funq;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FellowshipFunction {

    @ConfigProperty(name = "custom.greeting")
    String greeting;

    @Inject
    FellowshipReactiveService service;

    @Funq
    public String greet() {
        return greeting;
    }

    @Funq
    public Friend make(Friend content) {
        Friend.persist(content);
        return content;
    }

    @Funq
    public List<Friend> findAll() {
        return Friend.findAll().list();
    }


    @Funq
    public Uni<Integer> update(String content, String language) {
        return service.update(content, language);
    }

}