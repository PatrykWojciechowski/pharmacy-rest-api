package com.wojciechowski.service;

import java.util.List;

import com.wojciechowski.entity.Product;

public interface ProductService {

	public List<Product> getProducts();
	public Product getProduct(int productId);
	public void addProduct(Product product);
	
}
