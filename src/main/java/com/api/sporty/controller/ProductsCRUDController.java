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
import com.api.sporty.model.Products;
import com.api.sporty.service.ProductsService;

@RestController
public class ProductsCRUDController {
	
	@Autowired
	private ProductsService service;
	
	private MultiValueMap<String, String> errorMap;
	
	@PostMapping("/Product")
	public Products createProduct(@RequestBody Products product) {
		return service.createProduct(product);
	}

	@PutMapping("/Product")
	public Products updateProduct(@RequestBody Products product) {
		return service.updateProduct(product);
	}

	@GetMapping("/Product/{id}")
	public ResponseEntity<Products> getProductById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(service.getProductById(id),HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Product/{id}")
	public void deleteProductById(@PathVariable int id) {
		service.deleteProductById(id);
	}

}
