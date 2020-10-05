package com.api.sporty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.sporty.exceptionHandler.BusinessException;
import com.api.sporty.model.PurchaseReport;
import com.api.sporty.service.PurchaseReportService;

@RestController
public class PurchaseReportCRUDController {
	
	@Autowired
	private PurchaseReportService service;
	
	private MultiValueMap<String, String> errorMap;
	
	@PostMapping("/PurchaseReport")
	public PurchaseReport createPurchaseReport(@RequestBody PurchaseReport purchaseReport) {
		return service.createPurchaseReport(purchaseReport);
	}

	@PutMapping("/PurchaseReport")
	public PurchaseReport updatePurchaseReport(@RequestBody PurchaseReport purchaseReport) {
		return service.updatePurchaseReport(purchaseReport);
	}

	@GetMapping("/PurchaseReport/{id}")
	public ResponseEntity<PurchaseReport> getPurchaseReportById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(service.getPurchaseReportById(id),HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/PurchaseReport/{id}")
	public void deletePurchaseReportById(@PathVariable int id) {
		service.deletePurchaseReportById(id);
	}


}
