package com.waterkemper;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

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

    @PostMapping(value = "upload-octet-stream", consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<String> upload(@RequestParam("filename") String filename, InputStream file) throws IOException {
        storageFileService.save(filename, file);

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

    @GetMapping("download/textfile")
    public ResponseEntity<Resource> download(HttpServletRequest servletRequest) throws IOException {
        String contentType = MediaType.TEXT_PLAIN_VALUE;
        Resource resource = new ByteArrayResource("Testando escrita de arquivo texto".getBytes(Charset.defaultCharset()));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"textfile.txt\"")
                .body(resource);
    }


    @GetMapping("download/writeservletresponse")
    public void testing(HttpServletResponse response) throws IOException {
        response.getOutputStream().write("Testando envio direto".getBytes());
            response.setContentType("text/plain");
        response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"writeatservlet.txt\"");
        response.flushBuffer();
    }

    @GetMapping("nocontent")
    public ResponseEntity<String> notFoundContent() {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
