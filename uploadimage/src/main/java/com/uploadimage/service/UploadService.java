package com.uploadimage.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.uploadimage.entity.Upload;
import com.uploadimage.entity.UploadRepo;
@Service
public class UploadService {
	@Autowired
	private UploadRepo UploadRepo;
	
	private final String FILE_PATH = "D:\\java";

	public String storeFile(MultipartFile file,String path,Double expenseAmount) throws IOException {
		Upload upload = Upload
		.builder()
		.name(file.getOriginalFilename())
		.type(file.getContentType())
		.imageData(file.getBytes())
		//.expenseAmount(expenseAmount)
		.build();
		upload.setPath(path);
		upload = UploadRepo.save(upload);
		
		if (upload.getId() != null) {
			return "File uploaded successfuly into database";
		}
		
		return null;
	}
	
	
//	
//	public String storeDataIntoFileSystem(MultipartFile file) throws IOException {
//		String filePath = FILE_PATH + file.getOriginalFilename();
//		
//		Upload upload = Upload
//		.builder()
//		.name(file.getOriginalFilename())
//		.path(filePath)
//		.type(file.getContentType())
//		.imageData(file.getBytes())
//		.build();
//		
//		upload = UploadRepo.save(upload);
//		
//		file.transferTo(new File(filePath));
//		
//		if (upload.getId() != null) {
//			return "File uploaded successfully into database";
//		}
//		
//		return null;
//	}
//	
//	public byte[] downloadFilesFromFileSystem(String fileName) throws IOException {
//		String path = UploadRepo.findByName(fileName).getPath();
//		
//		return Files.readAllBytes(new File(path).toPath());
//	}
//


	public Upload getFiles(String fileName) {
		return UploadRepo.findByName(fileName);
	}
}
