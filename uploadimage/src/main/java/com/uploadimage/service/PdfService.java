package com.uploadimage.service;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

@Service
public class PdfService {
	
		@Autowired
		private TemplateEngine templateEngine;

		public byte[] generatePdfFromTemplate(String templateName, Context context) {
			String processedHtml = templateEngine.process(templateName, context);

			try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
				ITextRenderer renderer = new ITextRenderer();
				renderer.setDocumentFromString(processedHtml);
				renderer.layout();
				renderer.createPDF(outputStream, true);
				renderer.finishPDF();
				return outputStream.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}




