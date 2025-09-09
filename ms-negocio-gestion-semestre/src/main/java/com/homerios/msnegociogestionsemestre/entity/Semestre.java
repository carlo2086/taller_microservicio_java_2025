package com.homerios.msnegociogestionsemestre.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "semestre", schema = "sys")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Semestre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_semestre")
	private Long id_semestre;
	@Column(name = "fecha_registro")
	private String fecha_registro;
	@Column(name = "fecha_inicio")
	private String fecha_inicio;
	@Column(name = "fecha_fin")
	private String fecha_fin;
	@Column(name = "semestre")
	private String semestre;

	// private Double totalHoras;
	@OneToMany(mappedBy = "idSemestre", cascade = CascadeType.ALL)
	private List<SemestreDetalle> semestreDetalles;

	public Long getId_semestre() {
		return id_semestre;
	}

	public void setId_semestre(Long id_semestre) {
		this.id_semestre = id_semestre;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public List<SemestreDetalle> getSemestreDetalles() {
		return semestreDetalles;
	}

	public void setSemestreDetalles(List<SemestreDetalle> semestreDetalles) {
		this.semestreDetalles = semestreDetalles;
	}

}
