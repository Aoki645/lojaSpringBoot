package br.com.maoki.loja.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@Entity
@Table(name="Clients")
@JacksonXmlRootElement(localName = "Clients")	
public class Client implements Serializable{
	private static final long serialVersionUID = 7273075229290011563L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JacksonXmlProperty(isAttribute = true) 
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

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	 

	 
	
}
