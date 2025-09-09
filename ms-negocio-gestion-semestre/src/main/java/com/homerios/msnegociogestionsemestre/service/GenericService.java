package com.homerios.msnegociogestionsemestre.service;

import java.util.List;
import java.util.Optional;



public interface GenericService<T> {
	List<T> findByLikeObject(T t) throws ServiceException;

	Optional<T> findById(Long id) throws ServiceException;

	T save(T t) throws ServiceException;

	T update(T t) throws ServiceException;

	Boolean delete(T t) throws ServiceException;
}