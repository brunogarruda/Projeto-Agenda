package br.com.bandtec.AgendaDeObjetivos.controller;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import br.com.bandtec.AgendaDeObjetivos.domain.Credenciais;
import br.com.bandtec.AgendaDeObjetivos.domain.Usuario;
import br.com.bandtec.AgendaDeObjetivos.repository.TodosUsuarios;

public class LoginControllerTest {
	private LoginController controller;
	private TodosUsuarios todosusuarios;
	
	
	@Before
	public void setUp() {
		todosusuarios = Mockito.mock(TodosUsuarios.class);
		controller = new LoginController(todosusuarios);
	}
	
	@Test
	public void LoginComSucesso() 
	{
		Credenciais c = new Credenciais("igual","igual");
		Mockito.when(todosusuarios.existeUsuario(c)).thenReturn(new Usuario("nome",40));
		ResponseEntity<String> resposta =  controller.fazerLogin(c);
		
		assertEquals(HttpStatus.OK,resposta.getStatusCode());
		assertEquals ("sucesso",resposta.getBody());
	}
	@Test
	public void LoginComFalha() {
		Credenciais c = new Credenciais("login", "senha");
		Mockito.when(todosusuarios.existeUsuario(c)).thenReturn(null);
		ResponseEntity<String> resposta = controller.fazerLogin(c);
		assertEquals(HttpStatus.UNAUTHORIZED,resposta.getStatusCode());
		assertEquals ("Login não encontrado",resposta.getBody());
	}
}
