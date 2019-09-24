package br.com.bandtec.AgendaDeObjetivos.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.bandtec.AgendaDeObjetivos.domain.Objetivo;

@Repository
public interface TodosObjetivos extends JpaRepository<Objetivo, Long> {

//	public void save(Objetivo objetivo);
	@Query("select o from Objetivo o where o.dataMaximaParaExecucao <= :data")
	public List<Objetivo> ate(@Param("data")LocalDate data);
	
	
//	private final List<Objetivo> objetivos;
	
//	public TodosObjetivos() {
//		this.objetivos = new ArrayList<>();
//	}
	
//	{
//		this.objetivos.add(objetivo);
//		System.out.println("Objetivo " +objetivo+ " cadastrado com sucesso");
//	}

	
//	{
//		return objetivos.stream()
//				.filter(o -> o.ate(data))
//				.collect(toList());
//	}

}
