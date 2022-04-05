package org.example.cloud.nativ;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.reactive.RestPath;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("welcome")
public class FellowshipResource {

    @ConfigProperty(name = "custom.greeting")
    String greeting;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greet() {
       return greeting;
    }

    @PUT
    @Path("{language}/{content}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Uni<Integer> update(@RestPath String content, @RestPath  String language) {
        return Uni.createFrom().item(language).onItem()
                .transform(n -> FriendlyMessage.update("content=?1 where language=?2", content, language));
    }

    @POST
    @Transactional
    public FriendlyMessage make(FriendlyMessage content) {
        FriendlyMessage.persist(content);
        return content;
    }

    @GET
    @Path("all")
    public List<FriendlyMessage> findAll() {
        return FriendlyMessage.listAll();
    }
}