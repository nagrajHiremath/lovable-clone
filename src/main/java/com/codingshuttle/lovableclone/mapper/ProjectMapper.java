package com.codingshuttle.lovableclone.mapper;

import com.codingshuttle.lovableclone.dto.project.ProjectRequest;
import com.codingshuttle.lovableclone.dto.project.ProjectResponse;
import com.codingshuttle.lovableclone.dto.project.ProjectSummaryResponse;
import com.codingshuttle.lovableclone.dto.project.ProjectUpdateRequest;
import com.codingshuttle.lovableclone.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    Project toProjectEntity(ProjectRequest projectRequest);

    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryResponse map(Project project);
    List<ProjectSummaryResponse> toListProjectSummaryResponse(List<Project> projects);
    ProjectResponse toProjectResponse(ProjectUpdateRequest projectUpdateRequest);

    void updateProject(ProjectUpdateRequest projectUpdateRequest, @MappingTarget Project existingProject);
}
