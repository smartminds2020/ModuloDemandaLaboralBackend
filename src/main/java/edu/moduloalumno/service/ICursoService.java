package edu.moduloalumno.service;

import java.util.List;

import edu.moduloalumno.entity.Curso;

public interface ICursoService {
	
    Curso getCursoById(int idCurso);
	
	List<Curso> getCursosByIdPrograma(int idPrograma);
	
	List<Curso> getCursosByIdProgramaAndPlanEstudio(int idPrograma, String planEstudio);
}