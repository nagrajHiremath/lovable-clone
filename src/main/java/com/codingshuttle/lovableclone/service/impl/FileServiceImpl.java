package com.codingshuttle.lovableclone.service.impl;

import com.codingshuttle.lovableclone.dto.file.FileNode;
import com.codingshuttle.lovableclone.dto.file.FileResponse;
import com.codingshuttle.lovableclone.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FileServiceImpl implements FileService {
    public List<FileNode> getFileTree(Long projectId) {
        return null;
    }

    public FileResponse getFile(Long projectId, String path) {
        return null;
    }
}
