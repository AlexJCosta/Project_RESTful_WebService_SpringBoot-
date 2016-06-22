package br.com.restserviceexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restserviceexample.dao.springdata.repository.ProductRepository;
import br.com.restserviceexample.model.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public void saveProduct(Product product) {
		productRepository.save(product);
		
	}

}
