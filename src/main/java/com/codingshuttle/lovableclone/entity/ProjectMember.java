package com.codingshuttle.lovableclone.entity;

import com.codingshuttle.lovableclone.entity.enums.ProjectRole;
import jakarta.persistence.*;
import java.time.Instant;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "project_member")
public class ProjectMember {
  @EmbeddedId ProjectMemberId projectMemberId;

  @ManyToOne
  @MapsId("projectId")
  Project project;

  @ManyToOne
  @MapsId("userId")
  User user;

  @Enumerated(EnumType.STRING)
  ProjectRole projectRole;

  Instant invitedAt;
  Instant AcceptedAt;
}
