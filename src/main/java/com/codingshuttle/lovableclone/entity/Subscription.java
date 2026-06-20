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
@Table(name = "subscription")
public class Subscription {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  User user;

  @OneToOne
  @JoinColumn(name = "plan_id")
  Plan plan;

  String stripeCustomerId;
  String stripSubscriptionId;
  Instant startDate;
  Instant endDate;
  Instant createdAt;
  Instant updatedAt;
}
