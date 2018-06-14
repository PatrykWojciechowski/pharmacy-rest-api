package com.wojciechowski.dao;

import java.util.List;

import com.wojciechowski.entity.Product;

public interface ProductDAO {

	public List<Product> getProducts();
	public Product getProduct(int productId);
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(int productId);
	
}
