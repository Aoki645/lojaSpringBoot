
package br.com.maoki.loja.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.maoki.loja.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("SELECT p FROM Product p WHERE p.dataCadastro = :dataCadastro")
    public List<Product> findProductByDataCadastro(@Param("dataCadastro") Date dataCadastro);
	
	@Query("SELECT p FROM Product p WHERE p.numeroControle = :numeroControle")
    public List<Product> findProductByNumeroControle(@Param("numeroControle") Long numeroControle);
}
