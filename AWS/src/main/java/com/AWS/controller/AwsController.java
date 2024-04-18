package com.AWS.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.AWS.service.AwsService;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

@RestController
@RequestMapping(value = "/AWS")
public class AwsController {

	@Autowired
	private AwsService awsService;

	@Autowired
	private AmazonS3 amazonS3;

	private String bucketName = " ";

//
	@PostMapping("/upload/files")
	public String fileUpload(@RequestParam(name = "file") MultipartFile file) throws Exception {
		File fileObj = new File(file.getOriginalFilename());
		FileOutputStream os = new FileOutputStream(fileObj);
		os.write(file.getBytes());

		String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		amazonS3.putObject(bucketName, fileName, fileObj);
		fileObj.delete();

		return "File Uploaded in AWS Bucket" + fileName;

	}

	@GetMapping("/download/getfile")
	public ResponseEntity<ByteArrayResource> fileDownload(@RequestParam(name = "file") String file) throws IOException {

		S3Object s3Object = amazonS3.getObject(bucketName, file);

		S3ObjectInputStream obj = s3Object.getObjectContent();

		byte[] byteObj = IOUtils.toByteArray(obj);

		ByteArrayResource resource = new ByteArrayResource(byteObj);

		return ResponseEntity.ok().contentLength(byteObj.length).header("content-type", "application/octet-stream")
				.header("content-disposition", "attachment;file=\"" + file + "\"").body(resource);

	}

	@DeleteMapping("/deletefile")
	public ResponseEntity<String> fileDelete(@RequestParam(name = "file") String file) {
		amazonS3.deleteObject(bucketName, file);
		return ResponseEntity.ok("File ca be deleted" + file);
	}
/**/	


	/**/
	@PostMapping("/uploadfile")
	public ResponseEntity<String> fileUpload(@RequestParam String file) {
		return ResponseEntity.ok(awsService.generateUrl(UUID.randomUUID() + "." + file, HttpMethod.PUT));
	}

	@GetMapping("/downloadfile")
	public ResponseEntity<String> filedownload(@RequestParam String filename) {
		return ResponseEntity.ok(awsService.generateUrl(UUID.randomUUID() + "." + filename, HttpMethod.GET));

	}
	/**/

}
