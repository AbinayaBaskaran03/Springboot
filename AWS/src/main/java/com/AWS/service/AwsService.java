package com.AWS.service;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;

@Service
public class AwsService {

	@Autowired
	private AmazonS3 s3;

	@Value("${aws.s3.bucketName}")
	private String bucketName;

	public String generateUrl(String filename, HttpMethod http) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, 1);
		URL url = s3.generatePresignedUrl(bucketName, filename, cal.getTime(), http);
		return url.toString();
	}

}
