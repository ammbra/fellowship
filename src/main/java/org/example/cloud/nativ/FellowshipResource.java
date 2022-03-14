package org.example.cloud.nativ;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("welcome")
public class FellowshipResource {

    @ConfigProperty(name = "custom.greeting")
    String greeting;

    @Inject
    FriendService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greet() {
       return greeting;
    }

    @PUT
    @Path("{language}/{content}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Integer> update(@PathParam("content") String content, @PathParam("language") String language) {
        return service.update(content, language);
    }

    @POST
    @Transactional
    public Friend make(Friend content) {
        Friend.persist(content);
        return content;
    }

    @GET
    @Path("all")
    public List<Friend> findAll() {
        return Friend.findAll().list();
    }
}