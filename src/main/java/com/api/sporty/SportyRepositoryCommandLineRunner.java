package com.api.sporty;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.api.sporty.model.Products;
import com.api.sporty.model.PurchaseReport;
import com.api.sporty.model.User;
import com.api.sporty.repository.ProductsRepository;
import com.api.sporty.repository.PurchaseReportRepository;
import com.api.sporty.repository.UserRepository;

@Component
public class SportyRepositoryCommandLineRunner implements CommandLineRunner{

	private static final Logger log = 
			LoggerFactory.getLogger(SportyRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductsRepository productRepository;
	
	@Autowired
	private PurchaseReportRepository purchaseReportRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		User user1 = new User("Jack", "Admin");
		userRepository.save(user1);
		log.info("New User is created : " + user1);
		
		User user2 = new User("Selena", "Customer");
		userRepository.save(user2);
		log.info("New User is created : " + user2);
		
		User user3 = new User("Melanie", "Customer");
		userRepository.save(user3);
		log.info("New User is created : " + user3);
		
		User user4 = new User("John", "Staff");
		userRepository.save(user4);
		log.info("New User is created : " + user4);

		List<User> users = userRepository.findAll();
		log.info("All Users : " + users);					
		

		Products pd1 = new Products("Electronics", 3, "MacBook");
		productRepository.save(pd1);
		log.info("New Product is created : " + pd1);
		
		Products pd2 = new Products("Furniture", 2, "Table");
		productRepository.save(pd2);
		log.info("New Product is created : " + pd2);
		
		Products pd3 = new Products("Electronics", 5, "iPhone");
		productRepository.save(pd3);
		log.info("New Product is created : " + pd3);
		
		Products pd4 = new Products("Clothing", 10, "Shirt");
		productRepository.save(pd4);
		log.info("New Product is created : " + pd4);

		List<Products> products = productRepository.findAll();
		log.info("All Products : " + products);		
		
		
		PurchaseReport pr1 = new PurchaseReport("CustomerBill", "02-09-2014", user1, pd1);
		purchaseReportRepository.save(pr1);
		log.info("New PurchaseReport is created : " + pr1);
		
		PurchaseReport pr2 = new PurchaseReport("VendorBill", "03-06-2015", user2, pd2);
		purchaseReportRepository.save(pr2);
		log.info("New PurchaseReport is created : " + pr2);

		PurchaseReport pr3 = new PurchaseReport("CustomerBill", "03-06-2015", user3, pd3);
		purchaseReportRepository.save(pr3);
		log.info("New PurchaseReport is created : " + pr3);
		
//		PurchaseReport pr4 = new PurchaseReport("CustomerBill", "02-09-2014", user4, pd4);
//		purchaseReportRepository.save(pr4);
//		log.info("New PurchaseReport is created : " + pr4);

		
		List<PurchaseReport> reports = purchaseReportRepository.findAll();
		log.info("All PurchaseReports : " + reports);	
	}
	
}