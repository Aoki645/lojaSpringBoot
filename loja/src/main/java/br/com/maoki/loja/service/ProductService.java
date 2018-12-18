package br.com.maoki.loja.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.maoki.loja.entity.Product;

@Component
public interface ProductService {
	void addProduto(List<Product> product);
}
