package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO{
	
	@PersistenceContext(unitName="demo")
	private EntityManager eManager;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.estudiante");
		Query query = eManager.createNativeQuery(sb.toString(), Estudiante.class);
		List<Estudiante> res = query.getResultList();
		return res;
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		Estudiante estudiante = eManager.find(Estudiante.class, code);
		return estudiante;
	}
	
	@Override
	@Transactional
	public void insert(Estudiante estudiante) throws DataAccessException{
		eManager.persist(estudiante);
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException {
		try {
			if(estudiante.getCodigoEstudiante() == null) {
				eManager.persist(estudiante);
			}else {
				eManager.merge(estudiante);
				eManager.flush();
			}
		}catch(Throwable e){
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void delete(Integer codigoEstudiante) throws DataAccessException {
		Estudiante estudiante = eManager.find(Estudiante.class, codigoEstudiante);
		eManager.remove(estudiante);
	}
}