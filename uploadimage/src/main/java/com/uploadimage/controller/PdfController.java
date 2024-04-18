package com.uploadimage.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import com.uploadimage.entity.PdfEntity;
import com.uploadimage.repository.PdfRepo;
import com.uploadimage.service.PdfService;



@RestController
@RequestMapping("/downloadpdf")
public class PdfController {

		@Autowired
		private PdfService pdfService;

		@Autowired
		private PdfRepo pdfRepo;

		@GetMapping("/generate-pdf")
		public ResponseEntity<byte[]> generatePdf(Model model) {
			List<PdfEntity> dataList = pdfRepo.findAll();
	try {
			model.addAttribute("data", dataList);

			Context context = new Context();
			context.setVariables(model.asMap());

			byte[] pdfBytes = pdfService.generatePdfFromTemplate("pdf", context);

			HttpHeaders headers = new HttpHeaders();
			//headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("inline", "Employee.pdf");

			return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	}


