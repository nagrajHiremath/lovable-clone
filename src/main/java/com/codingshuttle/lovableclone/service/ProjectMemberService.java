package com.codingshuttle.lovableclone.service;

import com.codingshuttle.lovableclone.dto.member.InviteMemberRequest;
import com.codingshuttle.lovableclone.dto.member.MemberResponse;
import com.codingshuttle.lovableclone.dto.member.UpdateMemberRoleRequest;
import java.util.List;

public interface ProjectMemberService {
  List<MemberResponse> getAllMembers(Long projectid);

  MemberResponse inviteMember(Long projectId, InviteMemberRequest inviteMemberRequest);

  MemberResponse updateMemberRole(
      Long projectId, Long userId, UpdateMemberRoleRequest updateMemberRoleRequest);

  void removeProjectMember(Long projectId, Long userId);
}
