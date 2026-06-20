package com.codingshuttle.lovableclone.service.impl;

import com.codingshuttle.lovableclone.dto.member.InviteMemberRequest;
import com.codingshuttle.lovableclone.dto.member.MemberResponse;
import com.codingshuttle.lovableclone.dto.member.UpdateMemberRoleRequest;
import com.codingshuttle.lovableclone.entity.Project;
import com.codingshuttle.lovableclone.entity.ProjectMember;
import com.codingshuttle.lovableclone.entity.ProjectMemberId;
import com.codingshuttle.lovableclone.entity.User;
import com.codingshuttle.lovableclone.mapper.ProjectMemberMapper;
import com.codingshuttle.lovableclone.repository.ProjectMemberRepository;
import com.codingshuttle.lovableclone.repository.ProjectRepository;
import com.codingshuttle.lovableclone.repository.UserRepository;
import com.codingshuttle.lovableclone.service.ProjectMemberService;
import java.time.Instant;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {

  ProjectMemberRepository projectMemberRepository;
  ProjectMemberMapper projectMemberMapper;
  UserRepository userRepository;
  ProjectRepository projectRepository;

  public List<MemberResponse> getAllMembers(Long projectId) {
    return projectMemberMapper.toMemberResponseList(
        projectMemberRepository.findByProjectId(projectId));
  }

  public MemberResponse inviteMember(Long projectId, InviteMemberRequest inviteMemberRequest) {

    User user = userRepository.findByUsername(inviteMemberRequest.userName()).orElseThrow();
    Project project = projectRepository.findById(projectId).orElseThrow();
    ProjectMemberId projectMemberId = new ProjectMemberId(projectId, user.getId());

    ProjectMember projectMember =
        ProjectMember.builder()
            .projectMemberId(projectMemberId)
            .projectRole(inviteMemberRequest.projectRole())
            .invitedAt(Instant.now())
            .project(project)
            .user(user)
            .build();

    return projectMemberMapper.toMemberResponse(projectMemberRepository.save(projectMember));
  }

  public MemberResponse updateMemberRole(
      Long projectId, Long userId, UpdateMemberRoleRequest updateMemberRoleRequest) {
    ProjectMember projectMember =
        projectMemberRepository.findById(new ProjectMemberId(projectId, userId)).orElseThrow();
    projectMember.setProjectRole(updateMemberRoleRequest.projectRole());
    return projectMemberMapper.toMemberResponse(projectMemberRepository.save(projectMember));
  }

  public void removeProjectMember(Long projectId, Long userId) {
    projectMemberRepository.deleteById(new ProjectMemberId(projectId, userId));
  }
}
