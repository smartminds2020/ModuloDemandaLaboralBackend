package edu.moduloalumno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.IAlumnoProgramaJOINProgramaJOINAlumnoDAO;
import edu.moduloalumno.entity.AlumnoProgramaJOINProgramaJOINAlumno;
import edu.moduloalumno.entity.AlumnoSemestre;
import edu.moduloalumno.entity.Curriculo;
import edu.moduloalumno.entity.PerfilEgreso;
import edu.moduloalumno.entity.Presupuesto;
import edu.moduloalumno.entity.Programa;
import edu.moduloalumno.entity.Semestre;
import edu.moduloalumno.service.IAlumnoProgramaJOINProgramaJOINAlumnoService;

@Service
public class AlumnoProgramaJOINProgramaJOINAlumnoServiceImpl implements IAlumnoProgramaJOINProgramaJOINAlumnoService {
	@Autowired
	private IAlumnoProgramaJOINProgramaJOINAlumnoDAO alumnoAlumnoProgramaDAO;

	@Override
	public List<AlumnoProgramaJOINProgramaJOINAlumno> getAllAlumnoProgramaJOINProgramaJOINAlumnos() {
		return alumnoAlumnoProgramaDAO.getAllAlumnoProgramaJOINProgramaJOINAlumnos();
	}
	
	@Override
	public List<AlumnoProgramaJOINProgramaJOINAlumno> getAlumnoProgramaJOINProgramaJOINAlumnoIdByNombresApellidosRestringido(String nombresApellidos) {
		
		List<AlumnoProgramaJOINProgramaJOINAlumno> alumnoProgramaList = alumnoAlumnoProgramaDAO.getAlumnoProgramaJOINProgramaJOINAlumnoIdByNombresApellidosRestringido(nombresApellidos);
		
		return alumnoProgramaList;
	}

	@Override
	public Programa getProgramabyId(Integer id_programa) {
		Programa programa = alumnoAlumnoProgramaDAO.getProgramabyId(id_programa);
		return programa;
	}
	
	@Override
	public List<Programa> getPrograma() {
		List<Programa> programa = alumnoAlumnoProgramaDAO.getPrograma();
		return programa;
	}
	
	@Override
	public List<Presupuesto> getPresupuesto(Integer id_programa) {
		List<Presupuesto> presupuesto = alumnoAlumnoProgramaDAO.getPresupuesto(id_programa);
		return presupuesto;
	}
	
	@Override
	public List<Semestre> getSemestre(){
		List<Semestre> semestre = alumnoAlumnoProgramaDAO.getSemestre();
		return semestre;
	}
	
	@Override
	public List<AlumnoSemestre> getAlumnoSemestre(Integer semestre,String periodoinicial,String periodofinal){
		List<AlumnoSemestre> alumnosemestre = alumnoAlumnoProgramaDAO.getAlumnoSemestre(semestre,periodoinicial,periodofinal);
		return alumnosemestre;
	}
        
        @Override
	public List<Curriculo> getCurriculos(){
		List<Curriculo> curriculo = alumnoAlumnoProgramaDAO.getCurriculos();
		return curriculo;
	}

    @Override
    public List<Curriculo> getCurriculosPrograma(Integer id_programa) {
       List<Curriculo> curriculo = alumnoAlumnoProgramaDAO.getCurriculosPrograma(id_programa);
		return curriculo;
    }

    @Override
    public List<PerfilEgreso> getPerfilEgreso(Integer id_programa) {
       List<PerfilEgreso> perfilEgreso = alumnoAlumnoProgramaDAO.getPerfilEgreso(id_programa);
		return perfilEgreso;
    }
	
}
