package com.xangars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xangars.dao.ProductDao;
import com.xangars.model.Product;

@Service("productService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}
	
	public List<Product> listProductss() {
		return productDao.listProductss();
	}

	public Product getProduct(int prodid) {
		return productDao.getProduct(prodid);
	}
	
	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
	}

}
