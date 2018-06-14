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

	@Override
	public void addProduct(Product product) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//by overwriting the id with0, we set it to null/empty and ignore any id sent in the request
		//if the id is zero then Hibernate will insert instead of update
		product.setId(0);
		
		currentSession.saveOrUpdate(product);
	}

	@Override
	public void updateProduct(Product product) {
	
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(product);
	}

	@Override
	public void deleteProduct(int productId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentSession.createQuery("delete from Product where id=:productId");
				theQuery.setParameter("productId", productId);
				
		theQuery.executeUpdate();	
	}

}
