package com.randaegs.resource;

import com.randaegs.domain.entity.User;
import com.randaegs.domain.entity.UserRole;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("auth")
public class AuthResource {

    @Path("signUp")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response signUp(@Valid @NotNull User user) {

        UserRole role = UserRole.findByName(user.role);
        if (role == null){
            return Response.status(Response.Status.BAD_REQUEST).entity("Role not found").build();
        }

        user.userRole = UserRole.findByName(user.role);
        user.persist();
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @GET
    public Response getUsers() {
        List<User> users = User.listAll();
        return Response.ok(users).build();
    }
}
