package com.api.sporty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.sporty.model.Products;
import com.api.sporty.service.ProductsService;

@RestController
public class ProductsSearchController {

	@Autowired
	ProductsService service;
	
	@GetMapping("/Product")
	public List<Products>  getAllProducts() {
		return service.getAllProducts();
	}
	
	@GetMapping("/Product/ProductType/{ProductType}")
	public List<Products> getAllProductsByProductType(@PathVariable String ProductType) {
		return service.getAllProductsByProductType(ProductType);
	}
	
	@GetMapping("/Product/ProductName/{ProductName}")
	public List<Products>getAllProductsByProductName(@PathVariable String ProductName) {
		return service.getAllProductsByProductName(ProductName);
	}
	
}
