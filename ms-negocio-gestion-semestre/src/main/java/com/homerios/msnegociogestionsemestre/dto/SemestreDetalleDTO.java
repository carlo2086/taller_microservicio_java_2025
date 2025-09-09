package com.homerios.msnegociogestionsemestre.dto;

import com.homerios.msnegociogestionsemestre.entity.Semestre;

public class SemestreDetalleDTO {
	private Semestre idSemestre;
	private DocenteDTO docente;
	private CursoDTO curso;
	private int horas_lteoricas;
	private int horas_practicas;

	public Semestre getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(Semestre idSemestre) {
		this.idSemestre = idSemestre;
	}

	public DocenteDTO getDocente() {
		return docente;
	}

	public void setDocente(DocenteDTO docente) {
		this.docente = docente;
	}

	public CursoDTO getCurso() {
		return curso;
	}

	public void setCurso(CursoDTO curso) {
		this.curso = curso;
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
