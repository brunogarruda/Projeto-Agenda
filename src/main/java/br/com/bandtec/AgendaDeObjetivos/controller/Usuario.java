package br.com.bandtec.AgendaDeObjetivos.controller;

public class Usuario {
	
	@Id
	@GeneratedValue
	private String nome;
	private Integer idade;
	
	@Embedded
	private Credenciais credenciais;
	
	public Usuario(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	
	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}
	
	
	
}
