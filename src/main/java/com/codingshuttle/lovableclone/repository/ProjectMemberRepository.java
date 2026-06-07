package com.codingshuttle.lovableclone.repository;

import com.codingshuttle.lovableclone.entity.ProjectMember;
import com.codingshuttle.lovableclone.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {
    List<ProjectMember> findByProjectId(Long projectId);
}
