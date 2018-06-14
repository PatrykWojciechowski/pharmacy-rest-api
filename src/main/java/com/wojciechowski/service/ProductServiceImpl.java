package com.wojciechowski.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wojciechowski.dao.ProductDAO;
import com.wojciechowski.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDAO;

	@Transactional
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}

	@Transactional
	public Product getProduct(int productId) {
		return productDAO.getProduct(productId);
	}

	@Transactional
	public void addProduct(Product product) {
		productDAO.addProduct(product);
		
	}
	
}
