package com.randaegs;

import io.smallrye.jwt.build.Jwt;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/jwt")
public class JwtResource {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response generateJwt(UserJwtDto user) {
        String username, email, role;
        try {
            username = user.username();
            email = user.email();
            role = user.role();
        } catch (NullPointerException exception) {
            return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
        }

        String jwt = Jwt
                .claim("email", email)
                .claim("username", username)
                .groups(role)
                .subject("authentication")
                .sign();
        return Response.ok(jwt).build();
    }
}
