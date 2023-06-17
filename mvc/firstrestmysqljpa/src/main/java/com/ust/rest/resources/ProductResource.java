
package com.ust.rest.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.rest.resource.Product;
import com.ust.rest.services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/api.1.0/product")
//@Api (value="Product Service API 2.0",description="Rest endpoints for product API")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ProductResource {
	@Autowired
	ProductService service;
	  
	  @GetMapping("/retrieve/{productId}") 
	 @ApiOperation(value="Returns" +"the customer entity")
	  public Product fetchProduct(@PathVariable long productId) { 
		  return service.getProduct(productId);
	  
	  }
	  
	  @GetMapping
	 
		public String test() {
			return "test() called";
		}
	  
	  @GetMapping("/retrieve/all")
	   
	  @ApiOperation(value="Returns" +"the customer entity")
	  public List<Product> fetchProducts(){
	  return service.getProducts(); }
	 
	@PostMapping("/create")
	
	@ApiOperation(value="Returns" +"the customer entity")
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		Exception exception = null;
		Product tempProduct=null;
		try {
			tempProduct=service.add(product);
	}
		catch(Exception e) {
			exception=e;
		}
		if(tempProduct!=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(tempProduct);
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
		}
	}
	
	//(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
	  @PutMapping("/update")
	 
	  
//	  @ApiOperation(value="Returns" +"the customer entity")
	  public Product updateProduct(@RequestBody Product product) {
		  return service.update(product);}
	  
	  @DeleteMapping
	  
	  @RequestMapping(value="delete/{productId}") 
	  @ApiOperation(value="Returns" +"the customer entity")
	  public void deleteProduct(@PathVariable long productId) {
	  service.deleteProduct(productId);
	  
	  }
	 
	
	
	

}
