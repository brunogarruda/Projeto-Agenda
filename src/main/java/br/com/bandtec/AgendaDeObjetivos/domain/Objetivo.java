package br.com.bandtec.AgendaDeObjetivos.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="objetivos")
public class Objetivo {

	@Id
	@GeneratedValue
	private Long IdObjetivo;
	
	@JsonProperty
	private String titulo;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@JsonProperty
	private String descricao;
	
	@JsonProperty
	@Column(name = "data_maxima_para_execucao")
	private LocalDate dataMaximaParaExecucao;
	
	@Embedded
	@JsonProperty
	private Prioridade prioridade;
	
	
	
	
	public Objetivo() {}
	
	public Objetivo(Long idObjetivo, String titulo, String descricao, LocalDate dataMaximaParaExecucao,
			Prioridade prioridade) {
		IdObjetivo = idObjetivo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataMaximaParaExecucao = dataMaximaParaExecucao;
		this.prioridade = prioridade;
	}


	@Override
	public String toString() {
		return "Objetivo [titulo=" + titulo + ", descricao=" + descricao + ", dataMaximaParaExecucao="
				+ dataMaximaParaExecucao + "]";
	}

	public boolean ate(LocalDate data) {
		return dataMaximaParaExecucao.isBefore(data) || dataMaximaParaExecucao.isEqual(data);
	}

}