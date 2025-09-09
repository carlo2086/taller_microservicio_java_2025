package com.homerios.msnegociogestioncurso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.homerios.msnegociogestioncurso.model.Curso;
import com.homerios.msnegociogestioncurso.repository.CursoRepository;

@RestController
public class CursoController {
	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping("/cursos")
	public List<Curso> obtenerCursos() {
		return cursoRepository.findAll();
	}

	@GetMapping("/curso/{id}")
	public Optional<Curso> busCurso(@PathVariable("id") String id) {
		Long id_curso = Long.parseLong(id);
		return cursoRepository.findById(id_curso);
	}

	@PostMapping("/curso")
	public Curso crearDocente(@RequestBody Curso nCurso) {
		Curso tCurso = new Curso();
		tCurso.setNombre(nCurso.getNombre());
		tCurso.setCredito(nCurso.getCredito());
		tCurso.setId_docente(nCurso.getId_docente());

		return cursoRepository.save(nCurso);
	}

	@PutMapping("/curso/{id}")
	public ResponseEntity<Curso> actualizarCurso(@PathVariable("id") Long id, @RequestBody Curso aCurso) {

		return cursoRepository.findById(id).map(curso -> {
			curso.setNombre(aCurso.getNombre());
			curso.setCredito(aCurso.getCredito());
			curso.setId_docente(aCurso.getId_docente());
			Curso actualizado = cursoRepository.save(curso);
			return ResponseEntity.ok(actualizado);
		}).orElseGet(() -> ResponseEntity.notFound().build());

	}
	/*
	 * @PutMapping("/curso/{id}") public Optional<Curso>
	 * actualizarCurso(@PathVariable("id") String id, @RequestBody Curso aCurso) {
	 * Long id_curso = Long.parseLong(id); Optional<Curso> tCurso =
	 * cursoRepository.findById(id_curso); if (tCurso.isPresent()) { Curso t_curso =
	 * tCurso.get(); t_curso.setNombre(aCurso.getNombre());
	 * t_curso.setCredito(aCurso.getCredito());
	 * t_curso.setId_docente(aCurso.getId_docente()); cursoRepository.save(t_curso);
	 * } return tCurso; }
	 */

	@DeleteMapping("/curso/{id}")
	public boolean deleteCurso(@PathVariable("id") Long id) {
		Long id_curso = id; // Long.parseLong(id);
		cursoRepository.deleteById(id_curso);
		return true;
	}
}
