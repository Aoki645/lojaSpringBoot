package br.com.maoki.loja.service.impl;

import static br.com.maoki.utils.Utils.zero;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maoki.loja.dao.ProductRepository;
import br.com.maoki.loja.entity.Product;
import br.com.maoki.loja.service.ProductService;;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productDao;
	
	@Override
	public void addProduto(List<Product> products) {
		for (Product product : products) {
			product.setQuantidade(zero(product.getQuantidade()).equals(0)? 1 :  product.getQuantidade());			
			product.setDataCadastro(product.getDataCadastro() == null?new Date():product.getDataCadastro());
			if(product.getQuantidade().intValue() >= 5 &&  product.getQuantidade().intValue() < 10) {
				product.setValor(product.getValor().multiply(BigDecimal.valueOf(product.getQuantidade())).multiply(BigDecimal.valueOf(0.95)));
			}else if(product.getQuantidade().intValue() >= 10) {
				product.setValor(product.getValor().multiply(BigDecimal.valueOf(product.getQuantidade())).multiply(BigDecimal.valueOf(0.90)));
			}else {
				product.setValor(product.getValor().multiply(BigDecimal.valueOf(product.getQuantidade())));
			}
			productDao.save(product);
		}
		
	}

	 
	
}
