package com.wojciechowski.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wojciechowski.entity.Product;
import com.wojciechowski.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		
		return productService.getProducts();
	}
	
	
}
