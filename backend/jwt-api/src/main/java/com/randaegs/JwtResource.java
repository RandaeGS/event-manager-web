package com.randaegs;

import io.smallrye.jwt.build.Jwt;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("jwt")
public class JwtResource {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public Response getJwt() {
      String jwt = Jwt.claim("username", "randaegs").issuer("backend").subject("jwt").sign();
      return Response.ok(jwt).build();
  }
}
