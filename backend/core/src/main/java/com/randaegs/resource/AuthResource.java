package com.randaegs.resource;

import com.randaegs.domain.entity.User;
import com.randaegs.service.AuthService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    private static final Logger log = LoggerFactory.getLogger(AuthResource.class);
    @Inject
    AuthService authService;

    @Path("signUp")
    @POST
    @Transactional
    public Response signUp(@Valid @NotNull User user) {
        return authService.signUp(user);
    }
}
