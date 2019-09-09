package com.products.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.products.model.Product;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Long>{

}
