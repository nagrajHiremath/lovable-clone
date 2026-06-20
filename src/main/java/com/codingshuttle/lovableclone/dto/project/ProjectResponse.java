package com.codingshuttle.lovableclone.dto.project;

import java.time.Instant;

public record ProjectResponse(
    Long id, String name, Long userId, Instant createdAt, Instant updatedAt, Instant deletedAt) {}
