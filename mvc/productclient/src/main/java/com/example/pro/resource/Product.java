package com.example.pro.resource;

import java.math.BigDecimal;



	
	public class Product {
	//nerationtype strategy is autope is the strategy which the jpa should use or follow to generate primary key values.the default is auto that is when strategy is not specified the jpa uses auto.
	//  when the database is mysql  generaratype auto will create an hibernet sequence in the database for the generation of primary keys
		// generation type.identity-for this strategy to work first we have to create a table in mysql  database and explicitly specify the auto increment column as checked for the primary key column and it application.property file #spring.jpa.hibernate.ddl-auto=update this should not be set if set it should have value as update
		private long productId;
		private String name;
		private String description;
		private BigDecimal price;
		private int qty;
		
		 public long getProductId() { return productId; } public void
		  setProductId(long productId) { this.productId = productId; } public String
		  getName() { return name; } public int getQty() { return qty; } public void
		  setQty(int qty) { this.qty = qty; } public void setName(String name) {
		 this.name = name; } public String getDescription() { return description; }
		  public void setDescription(String description) { this.description =
		 description; } public BigDecimal getPrice() { return price; } public void
		  setPrice(BigDecimal price) { this.price = price; }
		 

	}


