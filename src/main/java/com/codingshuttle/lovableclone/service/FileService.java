package com.codingshuttle.lovableclone.service;

import com.codingshuttle.lovableclone.dto.file.FileNode;
import com.codingshuttle.lovableclone.dto.file.FileResponse;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long projectId);

    FileResponse getFile(Long projectId, String path);
}
