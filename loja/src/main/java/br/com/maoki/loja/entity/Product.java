package br.com.maoki.loja.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
  
@Entity
@Table(name="Products")
@JacksonXmlRootElement(localName = "Product")
public class Product implements Serializable{
	private static final long serialVersionUID = 119581862692346478L;

	@Id	 
	@JacksonXmlProperty(isAttribute = true)
	private Long numeroControle;
	
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

	@JacksonXmlProperty(localName ="client")   	 	 
	@ManyToOne(optional = false)
    @JoinColumn(name = "codigo_cliente", nullable = false) 
	private Client client;
	
	
	public Product() {		
	}

	public Product(Long numeroControle, Date dataCadastro, String nome, Integer quantidade, BigDecimal valor, Client client) {
		super();
		this.numeroControle = numeroControle;
		this.dataCadastro = dataCadastro;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		this.client = client;
	}
	public Product(Long numeroControle, Date dataCadastro) {
		super();
		this.numeroControle = numeroControle;
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "Product [id=" + numeroControle + ", dataCadastro=" + dataCadastro + ", nome=" + nome + ", quantidade=" + quantidade
				+ "]";
	}

	public Long getNumeroControle() {
		return numeroControle;
	}

	public void setNumeroControle(Long numeroControle) {
		this.numeroControle = numeroControle;
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

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	

}
