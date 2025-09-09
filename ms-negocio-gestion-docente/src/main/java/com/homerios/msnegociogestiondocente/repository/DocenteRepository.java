package com.homerios.msnegociogestiondocente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homerios.msnegociogestiondocente.model.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

}
