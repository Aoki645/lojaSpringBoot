package br.com.maoki.loja.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.maoki.loja.entity.Product;

@Component
public interface ProductService {
	void addProduto(List<Product> product);	
	List<Product> findProduct(Long numeroControle, Date dataCadastro);
}
