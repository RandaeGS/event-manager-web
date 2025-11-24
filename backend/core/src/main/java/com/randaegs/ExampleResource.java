package com.randaegs;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("greet")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("goodbye")
    @RolesAllowed("admin")
    @Produces(MediaType.TEXT_PLAIN)
    public String goodbye() {
        return "goodbye from Quarkus REST";
    }
}
