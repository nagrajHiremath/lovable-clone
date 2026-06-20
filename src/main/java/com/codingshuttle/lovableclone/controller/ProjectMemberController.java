package com.codingshuttle.lovableclone.controller;

import com.codingshuttle.lovableclone.dto.member.InviteMemberRequest;
import com.codingshuttle.lovableclone.dto.member.MemberResponse;
import com.codingshuttle.lovableclone.dto.member.UpdateMemberRoleRequest;
import com.codingshuttle.lovableclone.service.ProjectMemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/project/{projectId}/projectMember")
public class ProjectMemberController {
  private final ProjectMemberService projectMemberService;

  @GetMapping
  public ResponseEntity<List<MemberResponse>> getAllMembers(@PathVariable Long projectId) {
    return ResponseEntity.ok(projectMemberService.getAllMembers(projectId));
  }

  @PostMapping("/invite")
  public ResponseEntity<MemberResponse> inviteMember(
      @PathVariable Long projectId, @RequestBody InviteMemberRequest inviteMemberRequest) {
    return ResponseEntity.ok(projectMemberService.inviteMember(projectId, inviteMemberRequest));
  }

  @PatchMapping
  public ResponseEntity<MemberResponse> updateMemberRole(
      @PathVariable Long projectId,
      @PathVariable Long userId,
      @RequestBody UpdateMemberRoleRequest updateMemberRoleRequest) {
    return ResponseEntity.ok(
        projectMemberService.updateMemberRole(projectId, userId, updateMemberRoleRequest));
  }

  @DeleteMapping
  public ResponseEntity<Void> deleteMember(
      @PathVariable Long projectId, @PathVariable Long userId) {
    projectMemberService.removeProjectMember(projectId, userId);
    return ResponseEntity.noContent().build();
  }
}
