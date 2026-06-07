package com.codingshuttle.lovableclone.service;

import com.codingshuttle.lovableclone.dto.project.ProjectRequest;
import com.codingshuttle.lovableclone.dto.project.ProjectResponse;
import com.codingshuttle.lovableclone.dto.project.ProjectSummaryResponse;
import com.codingshuttle.lovableclone.dto.project.ProjectUpdateRequest;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects();

    ProjectResponse getProjectById(Long id);

    ProjectResponse createProject(ProjectRequest projectRequest);

    ProjectResponse updateProject(Long id, ProjectUpdateRequest projectUpdateRequest);

    void softDeleteProject(Long id);
}
