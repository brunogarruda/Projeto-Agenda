//package br.com.bandtec.AgendaDeObjetivos.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.bandtec.AgendaDeObjetivos.domain.Usuario;
//
//
//@RestController
//public class UsuarioConstroller {
//	private List<Usuario> usuarios;
//		
//	
//	public UsuarioConstroller(List<Usuario> usuarios) {
//		this.usuarios = obterTodosUsuarios();
//	}
//
//	@GetMapping("/usuarios/nome/{nomeDoUsuario}")
//	public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nomeDoUsuario") String nome){
//		List<Usuario> usuariosPorNome = new ArrayList<Usuario>();
//		for(Usuario u : usuarios) {
//			if(u.getNome().equals(nome)) {
//				usuariosPorNome.add(u);
//			}
//		}
//			if(usuariosPorNome.isEmpty()) {
//				return ResponseEntity.noContent().build();	
//			}
//			return ResponseEntity.ok(usuariosPorNome);
//		}
//
//	private List<Usuario> obterTodosUsuarios(){
//		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
//		usuarios.add(new Usuario("Bruno", 20));
//		usuarios.add(new Usuario("Gabriel", 25));
//		usuarios.add(new Usuario("Arruda", 33));
//		return usuarios;
//	}
//	
//	@GetMapping("/usuarios/idade/{idadeDoUsuario}")
//	public ResponseEntity<List<Usuario>> obterPorIdade(@PathVariable("idadeDoUsuario") Integer idade){
//		List<Usuario> usuariosPorIdade = new ArrayList<Usuario>();
//		for(Usuario u : usuarios) {
//			if(u.getIdade().equals(idade)) {
//				usuariosPorIdade.add(u);
//			}
//		}
//			if(usuariosPorIdade.isEmpty()) {
//				return ResponseEntity.noContent().build();	
//			}
//			return ResponseEntity.ok(usuariosPorIdade);
//	}
//	
//	@PostMapping("/usuarios")
//	public ResponseEntity<Usuario> cadastro(@RequestBody Usuario usuario){
//		this.usuarios.add(usuario);
//		return ResponseEntity.ok(usuario);
//	}
//
//}
