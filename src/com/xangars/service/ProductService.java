package com.xangars.service;

import java.util.List;

import com.xangars.model.Product;

public interface ProductService {
	
	public void addProduct(Product product);

	public List<Product> listProductss();
	
	public Product getProduct(int prodid);
	
	public void deleteProduct(Product product);
}
