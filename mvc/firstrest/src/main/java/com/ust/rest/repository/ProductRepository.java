package com.ust.rest.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Repository;

import com.ust.rest.resource.Product;
@Repository
public class ProductRepository {
	private ArrayList<Product> productCache=new ArrayList<>();
	
	

public ProductRepository() {
	Product p1=new Product();
	p1.setProductId(101);
	p1.setName("Laptop");
	p1.setDescription("Macbook Retina Eye");
	p1.setPrice(new BigDecimal (10000));
	p1.setQty(5);
	productCache.add(p1);
	
	Product p2=new Product();
	p2.setProductId(102);
	p2.setName("Phone");
	p2.setDescription("Galaxy m51");
	p2.setPrice(new BigDecimal (90000));
	p2.setQty(6);
	productCache.add(p2);
	
	
	Product p3=new Product();
	p3.setProductId(103);
	p3.setName("Mobile Phone");
	p3.setDescription("Galaxy Note");
	p3.setPrice(new BigDecimal (11000));
	p3.setQty(5);
	productCache.add(p3);
	
	Product p4=new Product();
	p4.setProductId(104);
	p4.setName("Mobile Phone");
	p4.setDescription("iphone14");
	p4.setPrice(new BigDecimal (112000));
	p4.setQty(5);
	productCache.add(p4);
}
	//C -Create
	public boolean addProduct(Product product) {
		if(productCache.add(product))
			return true;
		else
			return false;
	}
	//R -Retrieve
	public Product getProduct(long productId) {
		Iterator<Product>iter=productCache.iterator();
		Product product=null;
				while(iter.hasNext()) {
					product=iter.next();
					if(product.getProductId()==productId)
					{
						break;
					}
				}
					if(product !=null){
						return product;
					}
					else 
						return null;
					
				
			
	}
	public ArrayList<Product> getProducts(){
		return productCache;
	}
	public Product updateProduct(Product productToUpdate) {
		Product searchProduct=null;
		Iterator<Product> iter=productCache.iterator();
		int index=0;
		while(iter.hasNext()) {
			
			searchProduct=iter.next();
			if(searchProduct.getProductId()==productToUpdate.getProductId()) {
				productCache.add(index,productToUpdate);
				productToUpdate=searchProduct;
			}
			index++;
		}
		return productToUpdate;
	}
	public void delete(long productId) {
		Iterator<Product>iter=productCache.iterator();
		int index=0;
		while(iter.hasNext()) {
			Product tempProduct = iter.next();
			if(tempProduct.getProductId()==productId) {
				productCache.remove(index);
				
			}
			index++;
		}
	}
	

}
