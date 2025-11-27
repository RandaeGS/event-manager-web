package com.randaegs.service;

import com.randaegs.domain.dto.AuthResponseDto;
import com.randaegs.domain.dto.LoginRequestDto;
import com.randaegs.domain.dto.UserJwtDto;
import com.randaegs.domain.dto.UserMapper;
import com.randaegs.domain.entity.User;
import com.randaegs.domain.entity.UserRole;
import com.randaegs.rest.JwtClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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

        user.userRole = role;
        user.password = BCrypt.hashpw(user.password, BCrypt.gensalt());
        try {
            user.persist();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }

        UserJwtDto userJwtDto = userMapper.userToUserJwtDto(user);
        String jwt = jwtClient.generateToken(userJwtDto);
        AuthResponseDto responseDto = userMapper.userToAuthResponseDto(userJwtDto, jwt);
        log.info("User created");
        return Response.status(Response.Status.CREATED).entity(responseDto).build();
    }

    public Response login(@Valid @NotNull LoginRequestDto loginRequestDto) {
        User user = User.findByEmail(loginRequestDto.email());

        if (user == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Email not found").build();
        }

        boolean isPasswordCorrect = BCrypt.checkpw(loginRequestDto.password(), user.password);

        if (!isPasswordCorrect) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Wrong password").build();
        }

        UserJwtDto userJwtDto = userMapper.userToUserJwtDto(user);
        String jwt = jwtClient.generateToken(userJwtDto);
        AuthResponseDto responseDto = userMapper.userToAuthResponseDto(userJwtDto, jwt);

        log.info("User logged in");
        return Response.ok().entity(responseDto).build();
    }
}
