package com.randaegs.resource;

import com.randaegs.domain.entity.User;
import com.randaegs.domain.entity.UserRole;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("auth")
public class AuthResource {

    private static final Logger log = LoggerFactory.getLogger(AuthResource.class);

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
        user.password = BCrypt.hashpw(user.password, BCrypt.gensalt());
        log.info("Signing up user {}", user.password);
        user.persist();
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @GET
    public Response getUsers() {
        List<User> users = User.listAll();
        return Response.ok(users).build();
    }
}
