package com.codingshuttle.lovableclone.mapper;

import com.codingshuttle.lovableclone.dto.member.MemberResponse;
import com.codingshuttle.lovableclone.entity.ProjectMember;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

  @Mapping(target = "userId", source = "user.id")
  @Mapping(target = "userName", source = "user.name")
  MemberResponse toMemberResponse(ProjectMember projectMember);

  @Mapping(target = "userId", source = "user.id")
  @Mapping(target = "userName", source = "user.name")
  List<MemberResponse> toMemberResponseList(List<ProjectMember> projectMemberList);
}
