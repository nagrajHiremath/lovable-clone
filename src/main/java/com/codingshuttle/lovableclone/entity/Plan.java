package com.codingshuttle.lovableclone.entity;

import jakarta.persistence.*;
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
@Table(name = "plan")
public class Plan {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  Long id;

  String stripePriceId;
  Integer maxProjectsPerDay;
  Integer maxTokensPerDay;
  Boolean unlimitedAI;
  Boolean isActive;
}
