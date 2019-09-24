package br.com.bandtec.AgendaDeObjetivos.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.bandtec.AgendaDeObjetivos.domain.Credenciais;
import br.com.bandtec.AgendaDeObjetivos.domain.Objetivo;
import br.com.bandtec.AgendaDeObjetivos.domain.Usuario;


@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, Long> {
	
	@Query("select u from Usuario u where u.credenciais = :credenciais")
	Usuario existeUsuario(@Param("credenciais") Credenciais credenciais);
	
}
