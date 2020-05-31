package com.waterkemper;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface StorageFile {
    String save(String filename, InputStream inputStream) throws IOException;

    String save(MultipartFile multipartFile) throws IOException;

    Resource loadFileAsResource(String fileName) throws FileNotFoundException;
}
