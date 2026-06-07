package com.codingshuttle.lovableclone.dto.member;

import com.codingshuttle.lovableclone.entity.enums.ProjectRole;

public record InviteMemberRequest(
        String userEmail,
        ProjectRole projectRole
) {
}
