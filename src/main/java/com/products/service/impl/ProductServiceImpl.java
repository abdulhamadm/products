package com.products.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.model.Product;
import com.products.repository.ProductsRepository;
import com.products.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductsRepository repository;
	
	@Override
	public boolean isDiscounted(Long productId) {
		Optional<Product> p= repository.findById(productId);
		return p.isPresent()? p.get().getDisCounted()>0 ? true:false:false ;
	}

	@Override
	public List<String> getAllProducts() {
		List<Product> products = (List<Product>) repository.findAll();
		 products = products.stream().sorted(Comparator.comparingInt(Product::getDisCounted).reversed())
			.collect(Collectors.toList());
		 List<String> result = new ArrayList<>();
		 for(Product p : products){
			 String price = p.getId()+"|";
			 price = p.getDisCounted()>0 ? price +"("+p.getPrice()+")" : price+p.getPrice();
			 result.add(price);
		 }
		return result;
	}

	@Override
	public Map<String, Long> quantitySoldByProductType() {
		List<Product> products = (List<Product>) repository.findAll();
		return products.stream().collect(
	                Collectors.groupingBy(Product::getType, Collectors.summingLong(Product::getPrice)));
	}

	@Override
	public List<Product> sampleData(List<Product> products) {
		repository.saveAll(products);
		return (List<Product>)repository.findAll();
	}

}
