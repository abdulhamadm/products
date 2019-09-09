package com.products.service;

import java.util.List;
import java.util.Map;

import com.products.model.Product;

public interface ProductService {
	boolean isDiscounted(Long productId);
	List<String> getAllProducts();
	Map<String, Long> quantitySoldByProductType();
	List<Product> sampleData(List<Product> products);
}
