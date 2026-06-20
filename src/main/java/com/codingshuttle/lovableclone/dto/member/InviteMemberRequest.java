package com.codingshuttle.lovableclone.dto.member;

import com.codingshuttle.lovableclone.entity.enums.ProjectRole;

public record InviteMemberRequest(String userName, ProjectRole projectRole) {}
