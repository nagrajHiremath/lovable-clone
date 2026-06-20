package com.codingshuttle.lovableclone.mapper.auth;

import com.codingshuttle.lovableclone.dto.auth.SignUpRequest;
import com.codingshuttle.lovableclone.dto.auth.UserProfileResponse;
import com.codingshuttle.lovableclone.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthMapper {

  @Mapping(source = "username", target = "username")
  User toUserEntity(SignUpRequest signUpRequest);

  UserProfileResponse toUserProfileResponse(User newUser);
}
