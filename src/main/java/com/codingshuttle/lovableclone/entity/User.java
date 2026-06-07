package com.codingshuttle.lovableclone.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    String passwordHash;
    String name;
    String email;
    String avatarUrl;
    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt;

}
