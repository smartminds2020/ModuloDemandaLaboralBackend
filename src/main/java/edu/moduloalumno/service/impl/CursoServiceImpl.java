package edu.moduloalumno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.ICursoDAO;
import edu.moduloalumno.entity.Curso;
import edu.moduloalumno.service.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService {
	@Autowired
	private ICursoDAO CursoDAO;

	@Override
	public Curso getCursoById(int idAlum) {
		Curso Curso = CursoDAO.getCursoById(idAlum);
		
		return Curso;
	}

	@Override
	public List<Curso> getCursosByIdPrograma(int idPrograma) {
		return CursoDAO.getCursosByIdPrograma(idPrograma);
	}

	@Override
	public List<Curso> getCursosByIdProgramaAndPlanEstudio(int idPrograma, String planEstudio) {
		return CursoDAO.getCursosByIdProgramaAndPlanEstudio(idPrograma, planEstudio);
	}

	@Override
	public List<Curso> getCursosByIdProgramaAndPlanEstudioAndAreaAndAreaAndNaturaleza(Integer idPrograma,
			String planestudio, Integer area, Integer naturaleza) {
		return CursoDAO.getCursosByIdProgramaAndPlanEstudioAndAreaAndAreaAndNaturaleza(idPrograma, planestudio, area, naturaleza);
	}

	@Override
	public List<Curso> getCursosByIdProgramaAndPlanEstudioAndArea(Integer idPrograma, String planestudio,
			Integer area) {
		return CursoDAO.getCursosByIdProgramaAndPlanEstudioAndArea(idPrograma, planestudio, area);
	}

	@Override
	public List<Curso> getCursosByIdProgramaAndPlanEstudioAndNaturaleza(Integer idPrograma, String planestudio,
			Integer naturaleza) {
		return CursoDAO.getCursosByIdProgramaAndPlanEstudioAndNaturaleza(idPrograma, planestudio, naturaleza);
	}
}