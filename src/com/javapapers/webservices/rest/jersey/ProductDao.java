package com.javapapers.webservices.rest.jersey;

import java.util.HashMap;
import java.util.Map;

public enum ProductDao {
	instance;

	private Map<String, Product> products = new HashMap<String, Product>();

	private ProductDao() {

		// pumping-in some default data
		Product product = new Product("1001", "iPhone 5S", "Mobile");
		products.put("1", product);

		product = new Product("1002", "Sony MDR-XD200", "Headphone");
		products.put("2", product);

		product = new Product("1003", "Bose Wave II", "Home Audio");
		products.put("3", product);
	}

	public Map<String, Product> getProducts() {
		return products;
	}

}
