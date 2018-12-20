package br.com.maoki.loja;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.com.maoki.loja.dao.ProductRepository;
import br.com.maoki.loja.entity.Client;
import br.com.maoki.loja.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=LojaApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ComponentScan
@EnableAutoConfiguration
@TestPropertySource(locations = "classpath:applicationTest.properties")

public class LojaApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	private static final String URL_POST_PRODUCT = "http://localhost:8080/addProduct";
	private static final String URL_GET_PRODUCT = "http://localhost:8080/findProduct";


	private static List<Product> newProducts = new ArrayList<>();
	private static Map<String, String> variables = new HashMap<>();
	
	private static List<Product> newProducts10 = new ArrayList<>();
	private static Map<String, String> variables10 = new HashMap<>();
	
	private static List<Product> newProducts11 = new ArrayList<>();
	private static Map<String, String> variables11 = new HashMap<>();
	
	private static List<Product> newProductsDesconto5 = new ArrayList<>();
	private static Map<String, String> variablesDesconto5 = new HashMap<>();
	
	private static List<Product> newProductsDesconto10 = new ArrayList<>();
	private static Map<String, String> variablesDesconto10 = new HashMap<>();
	
	static {		
		newProducts.add(new Product(1L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		variables.put("numeroControleValue", "1");
		
		
		newProducts10.add(new Product(2L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts10.add(new Product(3L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts10.add(new Product(4L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts10.add(new Product(5L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts10.add(new Product(6L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts10.add(new Product(7L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts10.add(new Product(8L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts10.add(new Product(9L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts10.add(new Product(10L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts10.add(new Product(11L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		variables10.put("numeroControleValue", "2");
		
		newProducts11.add(new Product(12L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts11.add(new Product(13L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts11.add(new Product(14L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts11.add(new Product(15L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts11.add(new Product(16L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts11.add(new Product(17L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts11.add(new Product(18L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts11.add(new Product(19L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts11.add(new Product(20L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts11.add(new Product(21L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));
		newProducts11.add(new Product(22L,null, "TV", 1 , new BigDecimal("1000.00"), new Client(1)));		
		variables11.put("numeroControleValue", "12");
		
		newProductsDesconto5.add(new Product(23L,new Date(new java.util.Date().getTime()), "TV", 5 , new BigDecimal("1000.00"), new Client(1)));
		variablesDesconto5.put("numeroControleValue", "23");		
		
		newProductsDesconto10.add(new Product(24L,new Date(new java.util.Date().getTime()), "TV", 10 , new BigDecimal("1000.00"), new Client(1)));
		variablesDesconto10.put("numeroControleValue", "24");
	}

	@Test
	public void testAdicaoDataNullLojaResource() throws Exception { 
		//POST
		RestTemplate restTemplate = new RestTemplate();	
		restTemplate.postForEntity(URL_POST_PRODUCT,newProducts,Product.class);
			
		//GET
		Product[] products = restTemplate.getForObject(URL_GET_PRODUCT+"?numeroControle={numeroControleValue}",   Product[].class, variables);	
		assertNotNull(products[0].getDataCadastro());
				
	}
	
	@Test
	public void testAdicao10LojaResource() throws Exception { 
		//POST
		RestTemplate restTemplate = new RestTemplate();	
		restTemplate.postForEntity(URL_POST_PRODUCT,newProducts10,Product.class);
			
		//GET
		Product[] products = restTemplate.getForObject(URL_GET_PRODUCT+"?numeroControle={numeroControleValue}",   Product[].class, variables10);	
		assertEquals(newProducts10.get(0).getNumeroControle(), products[0].getNumeroControle());
			
		
	}

	@Test
	public void testAdicao11LojaResource() throws Exception { 
		//POST
		RestTemplate restTemplate = new RestTemplate();	
		restTemplate.postForEntity(URL_POST_PRODUCT,newProducts11,Product.class);
			
		//GET
		Product[] products = restTemplate.getForObject(URL_GET_PRODUCT+"?numeroControle={numeroControleValue}",   Product[].class, variables11);	
		assertEquals(products.length, 0);			
		
	}
	
	@Test
	public void testDesconto5LojaResource() throws Exception { 
		//POST
		RestTemplate restTemplate = new RestTemplate();	
		restTemplate.postForEntity(URL_POST_PRODUCT,newProductsDesconto5,Product.class);
			
		//GET
		Product[] products = restTemplate.getForObject(URL_GET_PRODUCT+"?numeroControle={numeroControleValue}",   Product[].class, variablesDesconto5);	
		assertEquals(products[0].getValor(), new BigDecimal("4750.0"));		
		
	}
	
	@Test
	public void testDesconto10LojaResource() throws Exception { 
		//POST
		RestTemplate restTemplate = new RestTemplate();	
		restTemplate.postForEntity(URL_POST_PRODUCT,newProductsDesconto10,Product.class);
			
		//GET
		Product[] products = restTemplate.getForObject(URL_GET_PRODUCT+"?numeroControle={numeroControleValue}",   Product[].class, variablesDesconto10);	
		assertEquals(products[0].getValor(), new BigDecimal("9000.0"));			
		
	}

}

