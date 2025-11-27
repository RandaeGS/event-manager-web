package com.randaegs.resource;

import com.randaegs.domain.dto.LoginRequestDto;
import com.randaegs.domain.entity.User;
import com.randaegs.service.AuthService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    AuthService authService;

    @Path("signUp")
    @POST
    @Transactional
    public Response signUp(@Valid @NotNull User user) {
        return authService.signUp(user);
    }

    @Path("login")
    @POST
    @Transactional
    public Response login(@Valid @NotNull LoginRequestDto loginRequestDto) {
        return authService.login(loginRequestDto);
    }
}
