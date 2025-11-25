package com.randaegs.resource;

import com.randaegs.domain.entity.User;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("auth")
public class AuthResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response signUp(@Valid User user) {
        user.persist();
        return Response.status(Response.Status.CREATED).build();
    }
}
