package com.homerios.msnegociogestionsemestre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homerios.msnegociogestionsemestre.entity.Semestre;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {

}