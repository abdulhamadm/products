package com.products.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.products.model.Product;
import com.products.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/isDiscounted")
	public boolean isDiscounted(@RequestParam Long productId){
		return service.isDiscounted(productId);
	}
	
	@GetMapping("/getAllProducts")
	public List<String> getAllProducts(){
		return service.getAllProducts();
	}
	
	@GetMapping("/quantitySoldByProductType")
	public Map<String, Long> quantitySoldByProductType(){
		return service.quantitySoldByProductType();
	}
	
	//Sample Data
	@GetMapping("/sampleData")
	public List<Product> sampleData(){
		List<Product> products = new ArrayList<Product>();
		Product p1= new Product();
		p1.setType("ABC");
		p1.setPrice(new Long(100));
		p1.setDisCounted(0);
		products.add(p1);
		
		Product p2= new Product();
		p2.setType("ABC");
		p2.setPrice(new Long(200));
		p2.setDisCounted(1);
		products.add(p2);
		
		Product p3= new Product();
		p3.setType("XYZ");
		p3.setPrice(new Long(500));
		p3.setDisCounted(0);
		products.add(p3);
		return service.sampleData(products);
	}
}
