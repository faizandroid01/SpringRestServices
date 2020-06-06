package com.faiz.learn.webcontrollers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.faiz.learn.service.ParseFromExcelService;

@RestController
public class ExcelController {

	@Autowired
	private ParseFromExcelService excelService;

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/saveBookFromExcel", consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE }, produces = "application/json")
	public ResponseEntity saveBooksFromExcel(@RequestParam(value = "files") MultipartFile[] files) throws IOException {

		// service call to save data
		excelService.saveFromMultipleExcels(files);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
