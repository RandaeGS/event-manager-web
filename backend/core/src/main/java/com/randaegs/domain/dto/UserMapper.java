package com.randaegs.domain.dto;

import com.randaegs.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    @Mapping(target = "role", source = "userRole.name")
    @Mapping(target = "username", expression = "java(user.firstName + ' ' + user.lastName)")
    UserJwtDto userToUserJwtDto(User user);

    AuthResponseDto userToAuthResponseDto(UserJwtDto userJwtDto, String jwt);
}
