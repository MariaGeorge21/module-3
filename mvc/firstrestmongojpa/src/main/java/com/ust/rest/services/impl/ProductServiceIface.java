package com.ust.rest.services.impl;

import java.util.List;

import com.ust.rest.resource.Product;

public interface ProductServiceIface {
	public Product add(Product product);
    public Product getProduct(String productId);
    public Product updateProduct(Product product);
    public void deleteProduct(String productId) ;
    public List<Product> getProducts();

}
