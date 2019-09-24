package br.com.bandtec.AgendaDeObjetivos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.AgendaDeObjetivos.domain.Credenciais;
import br.com.bandtec.AgendaDeObjetivos.domain.Usuario;
import br.com.bandtec.AgendaDeObjetivos.repository.TodosUsuarios;


@RestController
public class LoginController {
	
	@Autowired
	private TodosUsuarios todosUsuarios;

	public LoginController(TodosUsuarios todosusuarios) {
		this.todosUsuarios = todosusuarios;
	}

	@PostMapping("/usuarios")
	public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuario usuario) {
		todosUsuarios.save(usuario);
		return ResponseEntity.ok("Sucesso");
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> fazerLogin(@RequestBody Credenciais credenciais) {
		if(todosUsuarios.existeUsuario(credenciais) == null){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login não encontrado");
		}
			return ResponseEntity.ok("sucesso");
		
	}
		
		
	
	
	

}
