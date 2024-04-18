package com.uploadimage.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepo extends JpaRepository<Upload, Long> {

	Upload findByName(String fileName);

}
