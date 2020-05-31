package com.waterkemper;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/v1/api/")
public class UploadController {

    private final StorageFile storageFileService;

    public UploadController(StorageFile storageFileService) {
        this.storageFileService = storageFileService;
    }

    @PostMapping(value = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String filename = storageFileService.save(multipartFile);

        return ResponseEntity.ok("File saved: " + filename);
    }

    @GetMapping("download/{filename}")
    public ResponseEntity<Resource> download(@PathVariable("filename") String filename, HttpServletRequest servletRequest) throws IOException {
        Resource resource = storageFileService.loadFileAsResource(filename);

        String contentType = servletRequest.getServletContext().getMimeType(resource.getFilename());

        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
