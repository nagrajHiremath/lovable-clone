package com.codingshuttle.lovableclone.dto.member;

import com.codingshuttle.lovableclone.entity.enums.ProjectRole;

public record UpdateMemberRoleRequest(

        ProjectRole projectRole
) {
}
