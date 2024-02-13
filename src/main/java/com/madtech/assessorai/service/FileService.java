package com.madtech.assessorai.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String saveFile(MultipartFile file) throws IOException;
    String convertToMp3(MultipartFile file) throws IOException;
    void deleteFile(String filePath) throws IOException;
}
