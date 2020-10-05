package com.api.sporty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.sporty.model.Products;
import com.api.sporty.model.PurchaseReport;
import com.api.sporty.model.User;


@Repository
public interface PurchaseReportRepository extends JpaRepository<PurchaseReport, Integer> {
	
	@Query("SELECT us FROM PurchaseReport pr INNER JOIN pr.user us")
	public List<User> findByUserId();
	
	@Query("SELECT pd FROM PurchaseReport pr INNER JOIN pr.product pd")
	public List<Products> findByProductId();
	
//	@Query("SELECT pr FROM PurchaseReport pr WHERE pr.purchaseReportId=10")
//	public List<PurchaseReport> findByPurchaseReportId();
	
	public List<PurchaseReport> findByPurchaseReportCategory(String PurchaseReportCategory);
	public List<PurchaseReport> findByPurchaseReportDate(String PurchaseReportDate);

}
