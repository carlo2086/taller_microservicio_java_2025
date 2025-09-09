package com.homerios.msnegociogestionsemestre.rest;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.homerios.msnegociogestionsemestre.dto.CursoDTO;
import com.homerios.msnegociogestionsemestre.dto.DocenteDTO;
import com.homerios.msnegociogestionsemestre.dto.SemestreDTO;
import com.homerios.msnegociogestionsemestre.dto.SemestreDetalleDTO;
import com.homerios.msnegociogestionsemestre.entity.Semestre;
import com.homerios.msnegociogestionsemestre.entity.SemestreDetalle;
import com.homerios.msnegociogestionsemestre.repository.SemestreRepository;
import com.homerios.msnegociogestionsemestre.service.CursoService;
import com.homerios.msnegociogestionsemestre.service.DocententeService;

@RestController
public class SemestreRest {

	@Autowired
	private SemestreRepository semestrerepository;

	@Autowired
	private DocententeService docententeService;

	@Autowired
	private CursoService cursoService;

	@GetMapping("/semestres")
	public List<Semestre> obtenerDocentes() {
		return semestrerepository.findAll();
	}

	@GetMapping("/semestre/{id}")
	public SemestreDTO busSemestre(@PathVariable String id) {
		Long id_semestre = Long.parseLong(id);
		Optional<Semestre> tSemestre = semestrerepository.findById(id_semestre);
		SemestreDTO semestreDTO = new SemestreDTO();

		if (tSemestre.isPresent()) {
			Semestre t_Semestre = tSemestre.get();

			// se transfiere la informacion de semestre a semestre dto
			semestreDTO.setId_semestre(t_Semestre.getId_semestre());
			semestreDTO.setSemestre(t_Semestre.getSemestre());
			semestreDTO.setFecha_inicio(t_Semestre.getFecha_inicio());
			semestreDTO.setFecha_fin(t_Semestre.getFecha_fin());
			semestreDTO.setFecha_registro(t_Semestre.getFecha_registro());
			// se declara una lista para la carga del detalle de persona
			List<SemestreDetalleDTO> semestreDetallesDTO = new ArrayList<>();

			SemestreDetalleDTO semestreDetalleDTO = new SemestreDetalleDTO();

			if (t_Semestre.getSemestreDetalles().size() > 0) {
				for (SemestreDetalle sd : t_Semestre.getSemestreDetalles()) {
					DocenteDTO docenteDTO = new DocenteDTO();
					CursoDTO cursoDTO = new CursoDTO();

					semestreDetalleDTO = new SemestreDetalleDTO();
					//semestreDetalleDTO.setIdSemestre(t_Semestre);
					semestreDetalleDTO.setHoras_lteoricas(sd.getHoras_lteoricas());
					semestreDetalleDTO.setHoras_practicas(sd.getHoras_practicas());

					if (sd.getId_docente() != null) {
						System.out.println("sd.getId_docente()::::::::::" + sd.getId_docente());
						docenteDTO = docententeService.findById(sd.getId_docente());
						semestreDetalleDTO.setDocente(docenteDTO);
						System.out.println(docenteDTO.getNombre());
					}
					if (sd.getId_curso() != null) {
						System.out.println("sd.getId_curso()::::::::::" + sd.getId_curso());
						cursoDTO = cursoService.findById(sd.getId_curso());
						semestreDetalleDTO.setCurso(cursoDTO);
						System.out.println(cursoDTO.getNombre());
					}
					semestreDetallesDTO.add(semestreDetalleDTO);
				}
			}

			semestreDTO.setSemestreDetalles(semestreDetallesDTO);
		}
		return semestreDTO;
	}

}
