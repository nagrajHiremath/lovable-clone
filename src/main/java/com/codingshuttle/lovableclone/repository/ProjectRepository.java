package com.codingshuttle.lovableclone.repository;

import com.codingshuttle.lovableclone.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {}
