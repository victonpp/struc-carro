package br.com.senac.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Carro implements Serializable{
	

	private static final long serialVersionUID = -363936214098484714L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
 //relacionamento das classes com o banco
	@OneToOne
	@JoinColumn(name="chave_id")
	private Chave chave;
	
	@OneToOne
	@JoinColumn(name="documento_id")
	private Documento documento;
	
	@ManyToOne
	@JoinColumn(name="fabricante_id")
	private Fabricante fabi;
	
	@ManyToMany
	@JoinTable(name="CARRO_ACESSORIO", joinColumns = @JoinColumn (name = "carro_id"), inverseJoinColumns = @JoinColumn (name = "acessorio_id"))
	 private List<Acessorio> acessorios;
	
	
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Fabricante getFabi() {
		return fabi;
	}

	public void setFabi(Fabricante fabi) {
		this.fabi = fabi;
	}

	public Chave getChave() {
		return chave;
	}

	public void setChave(Chave chave) {
		this.chave = chave;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
