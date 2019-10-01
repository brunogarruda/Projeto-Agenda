package br.com.bandtec.AgendaDeObjetivos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.AgendaDeObjetivos.domain.Usuario;
import br.com.bandtec.AgendaDeObjetivos.repository.TodosUsuarios;


@RestController
public class UsuarioConstroller {
	
	@Autowired
	private TodosUsuarios todosUsuarios;
		
	
	public UsuarioConstroller(TodosUsuarios todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}

	@GetMapping("/usuarios/nome/{nomeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nomeDoUsuario") String nome){
		List<Usuario> usuarios = todosUsuarios.findByNome(nome);
		if (usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuarios);
		}

	private  ResponseEntity<List<Usuario>> obterTodosUsuarios(){
		List<Usuario> usuarios = todosUsuarios.findAll();
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/usuarios/idade/{idadeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorIdade(@PathVariable("idadeDoUsuario") Integer idade){
		List<Usuario> usuariosPorIdade = todosUsuarios.findByIdade(idade);
		
			if(usuariosPorIdade.isEmpty()) {
				return ResponseEntity.noContent().build();	
			}
			return ResponseEntity.ok(usuariosPorIdade);
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastro(@RequestBody Usuario usuario){
		usuario = todosUsuarios.save(usuario);
		return ResponseEntity.ok(usuario);
	}

}
