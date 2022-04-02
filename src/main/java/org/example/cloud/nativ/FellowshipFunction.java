package org.example.cloud.nativ;

import io.quarkus.funqy.Funq;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class FellowshipFunction {

    @ConfigProperty(name = "custom.greeting")
    String greeting;


    @Funq
    public String greet() {
       return greeting;
    }


    @Funq
    @Transactional
    public Uni<Integer> update(String content, String language) {
        return Uni.createFrom().item(content).onItem()
                .transform(n -> FriendlyMessage.update("content=?1 where language=?2", content, language));
    }


    @Funq
    public FriendlyMessage make(FriendlyMessage content) {
        FriendlyMessage.persist(content);
        return content;
    }


    @Funq
    public List<FriendlyMessage> findAll() {
        return FriendlyMessage.findAll().list();
    }
}