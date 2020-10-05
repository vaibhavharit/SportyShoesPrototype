package com.api.sporty.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sporty.exceptionHandler.BusinessException;
import com.api.sporty.model.Products;
import com.api.sporty.repository.ProductsRepository;
import com.api.sporty.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsRepository repository;
	
	@Override
	public Products createProduct(Products product) {
		return repository.save(product);
	}

	@Override
	public Products updateProduct(Products product) {
		return repository.save(product);
	}

	@Override
	public Products getProductById(int id) throws BusinessException {
		Products product = null;
		try {
			if (id <= 0) {
				throw new BusinessException("ID cannot be zero or negative");
			}	
			product = repository.findById(id).get();
		} catch(NoSuchElementException e) {
			throw new BusinessException("No Product found with id = " + id);
		}
		return product;
	}

	@Override
	public void deleteProductById(int id) {
		repository.deleteById(id);
	}
	
	@Override
	public List<Products> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public List<Products> getAllProductsByProductType(String ProductType) {
		return repository.findByProductType(ProductType);
	}

	@Override
	public List<Products> getAllProductsByProductName(String ProductName) {
		return repository.findByProductName(ProductName);
	}

}
