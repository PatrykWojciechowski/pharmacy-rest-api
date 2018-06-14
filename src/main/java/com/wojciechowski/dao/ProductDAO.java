package com.wojciechowski.dao;

import java.util.List;

import com.wojciechowski.entity.Product;

public interface ProductDAO {

	public List<Product> getProducts();
	public Product getProduct(int productId);
	
}
