package com.uploadimage.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uploadimage.entity.Upload;
import com.uploadimage.service.UploadService;

@RestController
@RequestMapping("/api")
public class UploadController {

	@Autowired
	private UploadService uploadService;

	@PostMapping("/uploadFilesIntoDB")
	public ResponseEntity<String> storeFilesIntoDB(@RequestParam("file") MultipartFile file,
			@RequestParam("path") String path,@RequestParam("expenseAmount") Double expenseAmount) throws IOException {
		String response = uploadService.storeFile(file, path,expenseAmount);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/getFileByName/{fileName:.+}")
	public ResponseEntity<byte[]> getImage(@PathVariable String fileName) {
		Upload upload = uploadService.getFiles(fileName);
		//byte[] imageData = uploadService.getFiles(fileName);
if(upload!=null) {
	
	 MediaType mediaType = MediaType.IMAGE_JPEG;
	 
     String fileExtension = getFileExtension(upload.getName());
     
     if (fileExtension != null) {
         mediaType = getMediaType(fileExtension);
     }
     
     String contentDisposition = "attachment; filename=" + upload.getName();
     

		return ResponseEntity.status(HttpStatus.OK)
				.header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
				.contentType(mediaType).body(upload.getImageData());
	}else {
		return ResponseEntity.notFound().build();
	}

	}

	private String getFileExtension(String fileName) {
	    int dotIndex = fileName.lastIndexOf('.');
	    return (dotIndex == -1) ? null : fileName.substring(dotIndex + 1);
	}
	private MediaType getMediaType(String fileExtension) {
	    switch (fileExtension.toLowerCase()) {
	        case "jpg":
	        case "jpeg":
	        case"png" :
	        case "pdf":
	        case "mp4":
	            return MediaType.IMAGE_JPEG;
	        default:
	            return MediaType.APPLICATION_OCTET_STREAM;
	    }
	}
}
//	@PostMapping("/uploadFilesIntoFileSystem")
//	public ResponseEntity<String> uploadFileIntoFileSystem(@RequestParam("file") MultipartFile file)
//			throws IOException {
//		String response = uploadService.storeDataIntoFileSystem(file);
//
//		return ResponseEntity.status(HttpStatus.OK).body(response);
//	}
//
////	@GetMapping("/getFilesFromFileSystem/{fileName}")
////	public ResponseEntity<byte[]> downloadImageFromFileSystem(@PathVariable String fileName) {
////		byte[] imageData = uploadService.getFiles(fileName);
////
////		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
////	}
//}
