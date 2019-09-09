package com.products;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.products.model.Product;
import com.products.repository.ProductsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {
	
	@Autowired
	private ProductsRepository repository;

	@Test
	public void save() {
		Product p1= new Product();
		p1.setType("ABC");
		p1.setPrice(new Long(100));
		p1.setDisCounted(0);
		repository.save(p1);
		
		Product p2= new Product();
		p2.setType("ABC");
		p2.setPrice(new Long(200));
		p2.setDisCounted(1);
		repository.save(p2);
		
		Product p3= new Product();
		p3.setType("XYZ");
		p3.setPrice(new Long(500));
		p3.setDisCounted(0);
		repository.save(p3);
	}

}
