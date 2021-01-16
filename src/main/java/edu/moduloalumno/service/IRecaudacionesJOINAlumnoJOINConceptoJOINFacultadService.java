package edu.moduloalumno.service;

import java.util.Date;
import java.util.List;

import edu.moduloalumno.entity.CodigosporNomApe;
import edu.moduloalumno.entity.RecaudacionesAlumnoConConcepto;
import edu.moduloalumno.entity.RecaudacionesJOINAlumnoJOINConceptoJOINFacultad;
import edu.moduloalumno.entity.RecaudacionesJoinAlumnoJoinConceptoJoinFacultadWithDescription;

public interface IRecaudacionesJOINAlumnoJOINConceptoJOINFacultadService {
	
	List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getAllRecaudacionesJOINAlumnoJOINConceptoJOINFacultads();
	
	List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadIdByNombresApellidosRestringido( String nombres, String apellidos);
	
	List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByStartDateBetween(Date fechaInicial,Date fechaFinal);

	List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNomApeStartDateBetween(String nomApe,Date fechaInicial,Date fechaFinal);

	List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNomApe(String nomApe);
	
	/*Met*/ 
	List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByCodigo(String codigo);

	/*Validados*/ 
	List<RecaudacionesAlumnoConConcepto> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByValidados(String codigo);

	/*new*/
	List<CodigosporNomApe> getCodigoByNombre(String nomApe);
	
	/*para login*/
	
	List<CodigosporNomApe> getCodigoByNombreCodAlumno(String nomApe, String codAlumno);	
	
	boolean updaterecaudacionesJOINAlumnoJOINConceptoJOINFacultad(Integer id_concepto,String moneda,Date fecha,String recibo,int ciclo,int idRec, Double importe, String ubicacion, String ctabanco, Boolean validado,String repitencia,Integer id_tipo_recaudacion);
	
	boolean insertObservacion(String observacion, Integer idrec);
	
	List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNomApeConcepto(String concepto, String nomApe);
	
	List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNomApeConceptoAll(String concepto, String nomApe);																																						 
	List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNomApeRecibo( String recibo, String nomApe);
	
	
	List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByPosgrado();

	List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNombresApellidosStartDateBetween(String nombres,String apellidos,Date fechaInicial, Date fechaFinal);

	List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNombresApellidos(String nombres, String apellidos);
	
	List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNombresApellidosConcepto(String concepto, String nombres, String apellidos);
	
	List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNombresApellidosRecibo( String recibo, String nombres, String apellidos);

	RecaudacionesJOINAlumnoJOINConceptoJOINFacultad getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadById(int idRec);

	int updateRecaudacionesJOINAlumnoJOINConceptoJOINFacultad(RecaudacionesJOINAlumnoJOINConceptoJOINFacultad reacaudaciones);
	
	int updateRecaudacionesJOINAlumnoJOINConceptoJOINFacultad(List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> reacaudacionesList);
	
	public int updateRecaudacionesCodAlumni(Integer id_rec,String cod_alumno);
	
	void deleteRecaudacionesJOINAlumnoJOINConceptoJOINFacultad(int idRec);

	int updateAlumnoEstadoCivil(String codigo, String estado_civil);
	
	int updateId_Programa(Integer idprograma,String codigo);
}