package br.com.restserviceexample.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

import br.com.restserviceexample.model.Product;
import br.com.restserviceexample.service.ProductService;

@Controller
public class SystemController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> evaluateANewsByTitle(@RequestParam(value = "title", defaultValue = "World") String title) {
		System.out.println("Parameter that receive is: " + title);

		return ResponseEntity.ok("{\"message\" : \"It's a successful news\" }");

	}
	
	@RequestMapping(value = "/registering_product", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registeringProduct(@RequestParam(value = "name", defaultValue = "product_default") String name){
		System.out.println("Parameter received: " + name);
		try{
			Product pro = new Product();
			pro.setName(name);
			this.productService.saveProduct(pro);
			return ResponseEntity.ok("{\"message\" : \"Product saved successful.\" }");
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\" :\"Product no saved.\" }");
		}
	}
}
