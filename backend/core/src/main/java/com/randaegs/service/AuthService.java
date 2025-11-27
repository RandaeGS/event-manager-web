package com.randaegs.service;

import com.randaegs.domain.dto.UserMapper;
import com.randaegs.domain.entity.User;
import com.randaegs.domain.entity.UserRole;
import com.randaegs.rest.JwtClient;
import io.smallrye.common.constraint.NotNull;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    @Inject
    @RestClient
    JwtClient jwtClient;

    @Inject
    UserMapper userMapper;

    public Response signUp(@Valid @NotNull User user) {

        UserRole role = UserRole.findByName(user.role);
        if (role == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Role not found").build();
        }

        user.userRole = UserRole.findByName(user.role);
        user.password = BCrypt.hashpw(user.password, BCrypt.gensalt());

        String jwt = jwtClient.generateToken(userMapper.userToUserJwtDto(user));
        log.info("JWT: {}", jwt);
        user.persist();
        return Response.status(Response.Status.CREATED).entity(user).build();
    }
}
