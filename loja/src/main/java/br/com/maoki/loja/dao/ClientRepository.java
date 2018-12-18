package br.com.maoki.loja.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maoki.loja.entity.Client;

 
public interface ClientRepository extends JpaRepository<Client, Long>{
	//Collection<Booking> findBookByName(String bookingName); 
}