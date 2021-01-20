package com.xangars.dao;

import java.util.List;

import com.xangars.model.Product;

public interface ProductDao {
	
	public void addProduct(Product product);

	public List<Product> listProductss();
	
	public Product getProduct(int prodid);
	
	public void deleteProduct(Product product);
}
