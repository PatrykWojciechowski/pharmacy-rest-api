package com.wojciechowski.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wojciechowski.entity.Product;
import com.wojciechowski.exceptionHandling.ProductNotFoundException;
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
	
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable int productId) {
		
		Product product = productService.getProduct(productId);
		
		if(product == null) {
			throw new ProductNotFoundException("Product id not found - " + productId);
		}
		
		return product;
	}
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		
		productService.addProduct(product);
		
		return product;
	}
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product) {
		
		productService.updateProduct(product);
		
		return product;
	}
	
	@DeleteMapping("/products/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		
		Product product = productService.getProduct(productId);

		if (product == null) {
			throw new ProductNotFoundException("Product id not found - " + productId);
		}
				
		productService.deleteProduct(productId);
		
		return "Deleted product id - " + productId;
	}
	
}
