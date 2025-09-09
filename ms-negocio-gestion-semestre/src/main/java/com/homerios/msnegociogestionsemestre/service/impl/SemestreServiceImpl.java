package com.homerios.msnegociogestionsemestre.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.homerios.msnegociogestionsemestre.entity.Semestre;
import com.homerios.msnegociogestionsemestre.repository.SemestreRepository;
import com.homerios.msnegociogestionsemestre.service.SemestreService;
import com.homerios.msnegociogestionsemestre.service.ServiceException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class SemestreServiceImpl implements SemestreService {

	private SemestreRepository semestreRepository;

	@Override
	public List<Semestre> findByLikeObject(Semestre t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Semestre> findById(Long id) throws ServiceException {
		try {
			return semestreRepository.findById(id);
		} catch (Exception e) {
			// log.error(e.getMessage(), e);
			throw new ServiceException();
		}
	}

	@Override
	public Semestre save(Semestre t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Semestre update(Semestre t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Semestre t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
