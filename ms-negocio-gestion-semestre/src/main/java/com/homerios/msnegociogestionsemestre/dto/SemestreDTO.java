package com.homerios.msnegociogestionsemestre.dto;

import java.util.List;

public class SemestreDTO {
	private Long id_semestre;
	private String fecha_registro;
	private String fecha_inicio;
	private String fecha_fin;
	private String semestre;
	private List<SemestreDetalleDTO> semestreDetalles;

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

	public List<SemestreDetalleDTO> getSemestreDetalles() {
		return semestreDetalles;
	}

	public void setSemestreDetalles(List<SemestreDetalleDTO> semestreDetalles) {
		this.semestreDetalles = semestreDetalles;
	}

}
