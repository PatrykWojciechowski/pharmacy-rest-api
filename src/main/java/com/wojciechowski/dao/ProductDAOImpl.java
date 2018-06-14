package com.wojciechowski.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wojciechowski.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Product> getProducts() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Product> theQuery = 
				currentSession.createQuery("from Product order by name",
						Product.class);
		
		List<Product> products = theQuery.getResultList();
						
		return products;
	}

	@Override
	public Product getProduct(int productId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Product product = currentSession.get(Product.class, productId);
		
		return product;
		
	}

}
