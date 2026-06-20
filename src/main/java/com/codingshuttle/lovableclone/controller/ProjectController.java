package com.codingshuttle.lovableclone.controller;

import com.codingshuttle.lovableclone.dto.project.ProjectRequest;
import com.codingshuttle.lovableclone.dto.project.ProjectResponse;
import com.codingshuttle.lovableclone.dto.project.ProjectSummaryResponse;
import com.codingshuttle.lovableclone.dto.project.ProjectUpdateRequest;
import com.codingshuttle.lovableclone.service.ProjectService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {

  private final ProjectService projectService;

  @GetMapping()
  public ResponseEntity<List<ProjectSummaryResponse>> getMyProject() {
    return ResponseEntity.ok(projectService.getUserProjects());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id) {
    return ResponseEntity.ok(projectService.getProjectById(id));
  }

  @PostMapping
  public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest projectRequest) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(projectService.createProject(projectRequest));
  }

  @PatchMapping("{id}")
  public ResponseEntity<ProjectResponse> updateProject(
      @PathVariable Long id, @RequestBody ProjectUpdateRequest projectUpdateRequest) {
    return ResponseEntity.ok(projectService.updateProject(id, projectUpdateRequest));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<String> softDeleteProject(@PathVariable Long id) {
    projectService.softDeleteProject(id);
    return ResponseEntity.ok("Delete Success");
  }
}
