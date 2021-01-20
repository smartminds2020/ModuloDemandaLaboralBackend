package edu.moduloalumno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.INaturalezaDAO;
import edu.moduloalumno.entity.Naturaleza;
import edu.moduloalumno.service.INaturalezaService;

@Service
public class NaturalezaServiceImpl implements INaturalezaService {
	@Autowired
	private INaturalezaDAO naturalezaDAO;

	@Override
	public List<Naturaleza> getAllNaturalezas() {
		
		List<Naturaleza> alumnoList = naturalezaDAO.getAllNaturalezas();
		
		return alumnoList;
	}
}