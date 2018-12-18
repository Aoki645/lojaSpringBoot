package br.com.maoki.loja.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.maoki.loja.dao.Customer;
 
 
@RestController
public class XMLRestController {
	
	 @GetMapping("/customer")
	 public Customer getCustomer(){
		 return new Customer("Peter", "Smith", 30);
	 }
	 
	 @PostMapping("/customer")
	 public String postCustomer(@RequestBody Customer customer){
		 System.out.println(customer);
		 return "Done";
	 }
	 
}