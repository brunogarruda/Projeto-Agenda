package br.com.bandtec.AgendaDeObjetivos.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.AgendaDeObjetivos.domain.Objetivo;
import br.com.bandtec.AgendaDeObjetivos.repository.TodosObjetivos;

@RestController
public class ObjetivoController {
	
	private TodosObjetivos todosobjetivos;
	
	@Autowired
	public ObjetivoController(TodosObjetivos todosobjetivos) {
		this.todosobjetivos = todosobjetivos;
	}

	@PostMapping("/objetivos")
	public ResponseEntity<String> cadastrarObjetivos(@RequestBody Objetivo objetivo){
		todosobjetivos.save(objetivo);
		return ResponseEntity.ok("Sucesso");
	}
	
	@GetMapping("/objetivos/data/{data}")
	public ResponseEntity<List<Objetivo>> GetPorData(@PathVariable("data") String data){
		List<Objetivo> objetivoPorData = new ArrayList<Objetivo>();
		objetivoPorData = todosobjetivos.ate(LocalDate.parse(data));
		
		if(objetivoPorData.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(objetivoPorData);
	}
	
	@GetMapping("/objetivos")
	public ResponseEntity<List<Objetivo>> buscarTodosObjetivos(){
		return ResponseEntity.ok(todosobjetivos.findAll());
	}
}
