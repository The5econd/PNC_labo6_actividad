package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EstudianteDAO;
import com.example.demo.domain.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	EstudianteDAO estudianteDAO;
	
	@Override
	public List<Estudiante> findAll()throws DataAccessException{
		return estudianteDAO.findAll();
	}
	/*
	@Override
	public List<Computadora> findAllComputadora() throws DataAccessException{
		return estudianteDAO.findAllComputadorta();
	}
	*/
	@Override
	public Estudiante findOne(Integer code) throws DataAccessException{
		return estudianteDAO.findOne(code);
	}
	
	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException{
		estudianteDAO.save(estudiante);
	}

	@Override
	@Transactional
	public void delete(Integer codigoEstudiante) throws DataAccessException {
		estudianteDAO.delete(codigoEstudiante);
	}
}
