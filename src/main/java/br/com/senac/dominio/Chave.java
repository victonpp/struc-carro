package br.com.senac.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Chave implements Serializable{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6579966539493363449L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String codigoChave;

	@OneToOne(mappedBy="chave")
	private Carro carro;
	
	

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public String getCodigoChave() {
		return codigoChave;
	}

	public void setCodigoChave(String codigoChave) {
		this.codigoChave = codigoChave;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
}
