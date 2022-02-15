package org.example.cloud.nativ;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Path("welcome")
public class FellowshipResource {

    @ConfigProperty(name = "custom.greeting")
    String greeting;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting() {
        return greeting;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Friend make(Friend message) {
        Friend.persist(message);
        return message;
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Friend> findAll() {
        return Friend.findAll().list();
    }
}