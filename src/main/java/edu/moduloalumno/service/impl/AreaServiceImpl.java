package edu.moduloalumno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.IAreaDAO;
import edu.moduloalumno.entity.Area;
import edu.moduloalumno.service.IAreaService;

@Service
public class AreaServiceImpl implements IAreaService {
	@Autowired
	private IAreaDAO areaDAO;

	@Override
	public List<Area> getAllAreas() {
		
		List<Area> alumnoList = areaDAO.getAllAreas();
		
		return alumnoList;
	}
}