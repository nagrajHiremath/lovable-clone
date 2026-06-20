package com.codingshuttle.lovableclone.dto.member;

import com.codingshuttle.lovableclone.entity.enums.ProjectRole;
import java.time.Instant;

public record MemberResponse(
    Long userId, String userName, ProjectRole projectRole, Instant invitedAt, Instant AcceptedAt) {}
