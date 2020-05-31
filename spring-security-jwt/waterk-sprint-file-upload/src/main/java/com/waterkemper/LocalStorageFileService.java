package com.waterkemper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class LocalStorageFileService implements StorageFile {

    public static final String DIRECTORY_UPLOADS = "upload";

    private final Path fileStorageLocation;

    @Autowired
    public LocalStorageFileService() throws FileStorageException {
        this.fileStorageLocation = Paths.get(DIRECTORY_UPLOADS)
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String save(String filename, InputStream inputStream) throws IOException {
        Files.write(fileStorageLocation.resolve(filename), inputStream.readAllBytes());

        return filename;
    }

    public String save(MultipartFile multipartFile) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        Objects.requireNonNull(originalFilename, "File doesn`t has a name");

        Files.write(fileStorageLocation.resolve(originalFilename), multipartFile.getInputStream().readAllBytes());

        return originalFilename;
    }

    public Resource loadFileAsResource(String fileName) throws FileNotFoundException {
        try {
            Path filePath = fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new RuntimeException("File not found " + fileName, ex);
        }
    }
}
