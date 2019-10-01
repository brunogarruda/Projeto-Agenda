package br.com.bandtec.AgendaDeObjetivos.controller;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.bandtec.AgendaDeObjetivos.domain.Objetivo;

public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id_usuario;
	
	private String nome;
	
	private Integer idade;
	
	@OneToMany(mappedBy = "usuario")
	private List<Objetivo> objetivos;
	
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
