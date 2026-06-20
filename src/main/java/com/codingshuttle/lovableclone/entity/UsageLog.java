package com.codingshuttle.lovableclone.entity;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "usage_log")
public class UsageLog {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  User user;

  String action;
  Integer tokensUsed;
  String metadata;
  Instant createdAt;
}
