package com.codingshuttle.lovableclone.service.impl;

import com.codingshuttle.lovableclone.dto.project.ProjectRequest;
import com.codingshuttle.lovableclone.dto.project.ProjectResponse;
import com.codingshuttle.lovableclone.dto.project.ProjectSummaryResponse;
import com.codingshuttle.lovableclone.dto.project.ProjectUpdateRequest;
import com.codingshuttle.lovableclone.entity.Project;
import com.codingshuttle.lovableclone.entity.User;
import com.codingshuttle.lovableclone.mapper.ProjectMapper;
import com.codingshuttle.lovableclone.repository.ProjectRepository;
import com.codingshuttle.lovableclone.repository.UserRepository;
import com.codingshuttle.lovableclone.service.ProjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;

    public ProjectResponse createProject(ProjectRequest projectRequest) {
        User owner = userRepository.findById(1L).orElseThrow();
        Project project = projectMapper.toProjectEntity(projectRequest);
        project.setUser(owner);
        return projectMapper.toProjectResponse(projectRepository.save(project));
    }

    public List<ProjectSummaryResponse> getUserProjects() {
        Long id = 1L;
        return projectMapper.toListProjectSummaryResponse(projectRepository.findByUserId(id));
    }

    public ProjectResponse getProjectById(Long id) {
        return projectMapper.toProjectResponse(projectRepository.findById(id).orElseThrow());
    }

    public ProjectResponse updateProject(Long id, ProjectUpdateRequest projectUpdateRequest) {
        Project existingProject = projectRepository.findById(id).orElseThrow();
        projectMapper.updateProject(projectUpdateRequest, existingProject);
        return projectMapper.toProjectResponse(projectRepository.save(existingProject));
    }

    public void softDeleteProject(Long id) {
        Project project = projectRepository.findById(id).orElseThrow();
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }
}
