package edu.moduloalumno.service;

import java.util.List;

import edu.moduloalumno.entity.AlumnoProgramaJOINProgramaJOINAlumno;
import edu.moduloalumno.entity.AlumnoSemestre;
import edu.moduloalumno.entity.Curriculo;
import edu.moduloalumno.entity.PerfilEgreso;
import edu.moduloalumno.entity.Presupuesto;
import edu.moduloalumno.entity.Programa;
import edu.moduloalumno.entity.Semestre;

public interface IAlumnoProgramaJOINProgramaJOINAlumnoService {
	
	List<AlumnoProgramaJOINProgramaJOINAlumno> getAllAlumnoProgramaJOINProgramaJOINAlumnos();
	
	List<AlumnoProgramaJOINProgramaJOINAlumno> getAlumnoProgramaJOINProgramaJOINAlumnoIdByNombresApellidosRestringido( String nombresApellidos);
	
	Programa getProgramabyId(Integer id_programa);
	
	List<Programa> getPrograma();
	List<Presupuesto> getPresupuesto(Integer id_programa);
	public List<Semestre> getSemestre();
	public List<AlumnoSemestre> getAlumnoSemestre(Integer semestre,String periodoinicial,String periodofinal);
        public List<Curriculo> getCurriculos();
        public List<Curriculo> getCurriculosPrograma(Integer id_programa);

    public List<PerfilEgreso> getPerfilEgreso(Integer id_programa);

}