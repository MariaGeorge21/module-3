package com.ust.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.TableGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
		 Optional<Product>optional=productRepository.findById(null);
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
//@Transactional //we can use @Transactional to wrap a method in a database transaction
// it allow us to get propagation,isolation,timeout,read-only and rollback conditions for transaction


//working example 1

/*
 * public Product add(Product product) {
 * 
 * Product productT=productRepository.save(product); User user=new User();
 * user.setUserId(5L); user.setDateTime(System.currentTimeMillis()+" 7676767676766"); User
 * userT=userRepository.save(user);
 * 
 * //userRepository.save(user); return productT;
 */
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
@Transactional(propagation=Propagation.NESTED)

public Product add(Product product) {
	
	Product productT=productRepository.save(product);
	addUser();
	
		
			//userRepository.save(user);
   return productT;
   
}
@Transactional(propagation=Propagation.REQUIRES_NEW)
public boolean addUser() {
	User user=new User();
	user.setUserId(5L);
    user.setDateTime(System.currentTimeMillis()+"7676767676767676767767676767676676767676 ");
    try {
	User userT=userRepository.save(user);
    }
    catch(Exception e) {
    	System.out.println(e);
    }
	return true;
}
	 public Product updateProduct(Product product) { return
	  productRepository.save(product); 
	 }
	 public void deleteProduct(long productId) 
	 { productRepository.deleteById(productId); }
	
}
