package net.bcsoft.corsi.models;

import java.util.List;

public class Utente {
	
	private Long id;
	
	private String nome;
	
	private String email;
	
	private Integer eta;
	
	private List<String> linguaggi;
	
	

	public Utente(Long id, String nome, String email, Integer eta, List<String> linguaggi) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.eta = eta;
		this.linguaggi = linguaggi;
	}
	
	public Utente( String nome, String email, Integer eta, List<String> linguaggi) {
		super();
		this.nome = nome;
		this.email = email;
		this.eta = eta;
		this.linguaggi = linguaggi;
	}
	
	

	public Utente() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	public List<String> getLinguaggi() {
		return linguaggi;
	}

	public void setLinguaggi(List<String> linguaggi) {
		this.linguaggi = linguaggi;
	}
	
	
	
	
	

}
