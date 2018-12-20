package br.com.maoki.loja.resource;


 
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.maoki.loja.entity.Product;
import br.com.maoki.loja.service.ProductService;

@RestController
public class LojaResource {
	final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


	@Autowired
	private ProductService productService;
	
	
	@GetMapping(name="findProduct",produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Product> findProduct(
			@RequestParam(required = false, name="dataCadastro")  Date dataCadastro,
			@RequestParam(required = false, name="numeroControle") Long numeroControle) {	
		return productService.findProduct(numeroControle,dataCadastro );
	}

	@PostMapping(name="addProduct",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public void  addProduct(@RequestBody List<Product> products) {
		productService.addProduto(products);
	}
}
