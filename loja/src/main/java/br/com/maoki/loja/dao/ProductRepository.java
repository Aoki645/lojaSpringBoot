
package br.com.maoki.loja.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maoki.loja.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Long>{
	//Collection<Booking> findBookByName(String bookingName); 
}
