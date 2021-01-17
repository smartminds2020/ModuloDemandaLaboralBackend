package edu.moduloalumno.dao;

import edu.moduloalumno.entity.Curso;
import java.util.List;

public interface ICursoDAO {

	Curso getCursoById(int idCurso);
	
	List<Curso> getCursosByIdPrograma(int idPrograma);

	List<Curso> getCursosByIdProgramaAndPlanEstudio(int idPrograma, String planEstudio);
}