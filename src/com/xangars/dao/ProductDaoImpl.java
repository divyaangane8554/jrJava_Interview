package com.xangars.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xangars.model.Product;


@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}

	@SuppressWarnings("unchecked")
	public List<Product> listProductss() {
		return (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).list();
	}

	public Product getProduct(int prodid) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, prodid);
	}

	public void deleteProduct(Product product) {
		sessionFactory.getCurrentSession().createQuery("DELETE from Product WHERE prodid = "+product.getProdId()).executeUpdate();
	}

}
