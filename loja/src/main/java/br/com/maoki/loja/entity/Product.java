package br.com.maoki.loja.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
  
@Entity
@Table(name="Products")
@JacksonXmlRootElement(localName = "Products")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 @JacksonXmlProperty(isAttribute = true)
	private long id;
	
	@JacksonXmlProperty   
	private Date dataCadastro;
	@NotNull
	@JacksonXmlProperty   
	private String nome;
	@JacksonXmlProperty   
	@NotNull
	private BigDecimal valor;
	@JacksonXmlProperty   
	private Integer quantidade;
	@JacksonXmlProperty   
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_cliente", nullable = false)
	private Client client;
	
	
	public Product() {		
	}

	public Product(Date dataCadastro, String nome, Integer quantidade, BigDecimal valor, Client client) {
		super();
		this.dataCadastro = dataCadastro;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		this.client = client;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", dataCadastro=" + dataCadastro + ", nome=" + nome + ", quantidade=" + quantidade
				+ "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
