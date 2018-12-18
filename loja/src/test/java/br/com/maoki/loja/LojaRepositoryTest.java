package br.com.maoki.loja;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.maoki.loja.dao.ProductRepository;
import br.com.maoki.loja.entity.Client;
import br.com.maoki.loja.entity.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@TestPropertySource(
		  locations = "classpath:applicationTest.properties")

public class LojaRepositoryTest {

	@Autowired
	private ProductRepository productRepository;
	
	
	@Test
	public void contextLoads() {
		Product product = productRepository.save(new Product(null, "TV", 1, new BigDecimal("1000.0"), new Client(1)));
		System.out.println("Inicio"+product.getId());
		try {
		productRepository.save(product);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fim"+product.getId());
		 
	}
}
