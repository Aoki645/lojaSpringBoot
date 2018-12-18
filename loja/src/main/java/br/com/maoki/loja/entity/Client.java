package br.com.maoki.loja.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Clients")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigoCliente;
	
	public Client() {
		
	}

	public Client(int codigoCliente) {
		super();
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	 
	
}
