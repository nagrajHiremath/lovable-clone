package com.codingshuttle.lovableclone.controller;

import com.codingshuttle.lovableclone.dto.file.FileNode;
import com.codingshuttle.lovableclone.dto.file.FileResponse;
import com.codingshuttle.lovableclone.service.FileService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/projects/{projectId}/files")
public class FileController {

  private final FileService fileService;

  @GetMapping
  public ResponseEntity<List<FileNode>> getFileTree(@PathVariable Long projectId) {
    return ResponseEntity.ok(fileService.getFileTree(projectId));
  }

  @GetMapping("{*path}")
  public ResponseEntity<FileResponse> getFile(Long projectId, String path) {
    return ResponseEntity.ok(fileService.getFile(projectId, path));
  }
}
