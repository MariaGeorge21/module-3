package com.ust.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ust.rest.repository.ProductRepository;
import com.ust.rest.repository.UserRepository;
import com.ust.rest.resource.Product;
import com.ust.rest.resource.User;
@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;
	
	 public Product getProduct(long productId) { 
		 Optional<Product>optional=productRepository.findById(productId);
		 if(optional.isPresent()) {
			 return optional.get();
		 }
	 else {
		 return null;
	 }
}


	 public List<Product> getProducts(){
		 return productRepository.findAll();
	 }
@Transactional //we can use @Transactional to wrap a method in a database transaction
// it allow us to get propagation,isolation,timeout,read-only and rollback conditions for transaction


 public Product add(Product product) {
 
 Product productT=productRepository.save(product); User user=new User();
 user.setUserId(5L); user.setDateTime(System.currentTimeMillis()+" "); User
  userT=userRepository.save(user);
  
 userRepository.save(user); return productT;
 
			/*
			 * if(userT!=null && productT!=null) { return true; } else { throw new
			 * RuntimeException("record not inserted"); }
			 */
// public boolean validate(Product product) {
//	 if(product.getName().equals("lenova")) {
//		 return true;
//		 
//	 }
//	 else {
//		 return false;
//	 }
// }
}
	 public Product update(Product product) {
		 Optional<Product> optional=productRepository.findById(product.getProductId());
		
		  Product tempProduct=optional.get();
		  tempProduct.setName(product.getName());
		  tempProduct.setPrice(product.getPrice());
		  tempProduct.setDescription(product.getDescription());
		  tempProduct.setQty(product.getQty());
		 return productRepository.save(tempProduct); 
		 }
		
	 
	 public void deleteProduct(long productId) 
	 { productRepository.deleteById(productId); }


	public Optional<Product> findyById(long productId) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
