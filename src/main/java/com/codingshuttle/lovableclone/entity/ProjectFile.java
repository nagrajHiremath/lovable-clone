package com.codingshuttle.lovableclone.entity;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "project_file")
public class ProjectFile {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  Long id;

  @ManyToOne
  @JoinColumn(name = "projectId")
  Project project;

  String path;
  String minIoObjectKey;

  //    User createdBy;
  //    User updatedBy;

  @CreationTimestamp Instant createdAt;

  @UpdateTimestamp Instant updatedAt;
}
