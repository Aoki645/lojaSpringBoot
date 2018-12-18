package br.com.maoki.loja;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.maoki.loja.entity.Client;
import br.com.maoki.loja.entity.Product;
import br.com.maoki.loja.service.ClientService;
import br.com.maoki.loja.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(
		  locations = "classpath:applicationTest.properties")
public class LojaApplicationTests {
	
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private ProductService productService;
	
	
	@Test
	public void contextLoads() {
		List<Product> listProduct = new ArrayList<>();
		listProduct.add(new Product(new Date(),"TV", 1, new BigDecimal("1000.10"), new Client(1)));
		listProduct.add(new Product(new Date(),"TV", 4, new BigDecimal("1000.10"), new Client(2)));
		listProduct.add(new Product(new Date(),"TV", 5, new BigDecimal("1000.10"), new Client(3)));
		listProduct.add(new Product(new Date(),"TV", 9, new BigDecimal("1000.10"), new Client(4)));
		listProduct.add(new Product(new Date(),"TV", 10, new BigDecimal("1000.10"), new Client(5)));
		for(int i = 1 ; i <= 10; i++) {
			clientService.addClient(new Client(i));
		}
		Product product = null;
		try {
		  productService.addProduto(listProduct);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Inicio"+product.getId());
		
		//Product found = repository.findById(product.getId()).get();
	//	assertThat(product.getNome()).isEqualTo(found.getNome());
		//System.out.println("Fim"+product.getId());
		
		 
	}

}

