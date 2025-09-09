package com.homerios.msnegociogestionsemestre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "semestre_detalle", schema = "sys")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SemestreDetalle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_semestre_det")
	private Long id_semestre_det;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_semestre", nullable = false)
	private Semestre idSemestre;

	@Column(name = "id_docente")
	private Long id_docente;
	@Column(name = "id_curso")
	private Long id_curso;
	@Column(name = "horas_lteoricas")
	private int horas_lteoricas;
	@Column(name = "horas_practicas")
	private int horas_practicas;

	public Semestre getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(Semestre idSemestre) {
		this.idSemestre = idSemestre;
	}

	public Long getId_semestre_det() {
		return id_semestre_det;
	}

	public void setId_semestre_det(Long id_semestre_det) {
		this.id_semestre_det = id_semestre_det;
	}

	public Long getId_docente() {
		return id_docente;
	}

	public void setId_docente(Long id_docente) {
		this.id_docente = id_docente;
	}

	public Long getId_curso() {
		return id_curso;
	}

	public void setId_curso(Long id_curso) {
		this.id_curso = id_curso;
	}

	public int getHoras_lteoricas() {
		return horas_lteoricas;
	}

	public void setHoras_lteoricas(int horas_lteoricas) {
		this.horas_lteoricas = horas_lteoricas;
	}

	public int getHoras_practicas() {
		return horas_practicas;
	}

	public void setHoras_practicas(int horas_practicas) {
		this.horas_practicas = horas_practicas;
	}

}
