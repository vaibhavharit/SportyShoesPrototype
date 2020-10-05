package com.api.sporty.service;

import java.util.List;

import com.api.sporty.exceptionHandler.BusinessException;
import com.api.sporty.model.Products;
import com.api.sporty.model.PurchaseReport;
import com.api.sporty.model.User;

public interface PurchaseReportService {
	
	public PurchaseReport createPurchaseReport(PurchaseReport purchaseReport);
	public PurchaseReport updatePurchaseReport(PurchaseReport purchaseReport);
	public PurchaseReport getPurchaseReportById(int id) throws BusinessException;
	public void deletePurchaseReportById(int id);
	
	public List<PurchaseReport> getAllPurchaseReports();
	public List<PurchaseReport> getAllPurchaseReportsByPurchaseReportCategory(String PurchaseReportCategory);
	public List<PurchaseReport> getAllPurchaseReportsByPurchaseReportDate(String PurchaseReportDate);
	
//	public List<PurchaseReport> findByPurchaseReportId();
	public List<User> findByUserId();
	public List<Products> findByProductId();
}
