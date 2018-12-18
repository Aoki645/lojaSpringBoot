package br.com.maoki.loja.controller;

import static br.com.maoki.utils.Utils.zero;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.maoki.loja.dao.ClientRepository;
import br.com.maoki.loja.dao.ProductRepository;
import br.com.maoki.loja.entity.Product;

@RestController
public class LojaController {



	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ClientRepository clientRepository;


	@GetMapping(name="products",produces = { MediaType.APPLICATION_XML_VALUE})
	public List<Product> getAllProduts() {		
		return productRepository.findAll();
	}

	@PostMapping(name="addProduct",consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addProduct(@RequestBody List<Product> products) {
		if(products.size() <= 10) {
			for (Product product : products) {
				Product existProduct = productRepository.findById(product.getId()).orElse(null);
				System.out.println(existProduct == null);
				if(existProduct == null){

					product.setQuantidade(zero(product.getQuantidade()).equals(0)? 1 :  product.getQuantidade());			

					product.setDataCadastro(product.getDataCadastro() == null?new Date():product.getDataCadastro());

					if(product.getQuantidade().intValue() >= 5 &&  product.getQuantidade().intValue() < 10) {
						product.setValor(product.getValor().multiply(BigDecimal.valueOf(product.getQuantidade())).multiply(BigDecimal.valueOf(0.95)));
					}else if(product.getQuantidade().intValue() >= 10) {
						product.setValor(product.getValor().multiply(BigDecimal.valueOf(product.getQuantidade())).multiply(BigDecimal.valueOf(0.90)));
					}else {
						product.setValor(product.getValor().multiply(BigDecimal.valueOf(product.getQuantidade())));
					}

					productRepository.save(product);
				}
			}
		}
	}
}
