package com.randaegs;

import io.smallrye.jwt.build.Jwt;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("jwt")
public class JwtResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateJwt(Map<String, Object> user) {
        String username, email, role;
        try {
            username = user.get("username").toString();
            email = user.get("email").toString();
            role = user.get("role").toString();
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
