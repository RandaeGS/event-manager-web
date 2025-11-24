package com.randaegs.resource;

import com.randaegs.domain.entity.Role;
import com.randaegs.domain.entity.User;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("auth")
public class AuthResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response signUp() {
        return Response.ok(User.listAll()).build();
    }
}
