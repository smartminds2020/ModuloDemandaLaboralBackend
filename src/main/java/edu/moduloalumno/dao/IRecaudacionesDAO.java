package edu.moduloalumno.dao;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

import edu.moduloalumno.entity.CuentasPorCobrar;
import edu.moduloalumno.entity.CuentasPorCobrar2;
import edu.moduloalumno.entity.DeudoresPosgradoMasInfo;
import edu.moduloalumno.entity.Recaudaciones;

public interface IRecaudacionesDAO {

	List<Recaudaciones> getAllRecaudaciones();

	List<Recaudaciones> getRecaudacionesByStartDateBetween(Date fechaInicial,Date fechaFinal);

	List<Recaudaciones> getRecaudacionesByNomApeStartDateBetween(String nomApe,Date fechaInicial,Date fechaFinal);

	List<Recaudaciones> getRecaudacionesByNomApe(String nomApe);
	
	List<Recaudaciones> getRecaudacionesByNomApeConcepto(String concepto, String nomApe);
	
	List<Recaudaciones> getRecaudacionesByNomApeRecibo( String recibo, String nomApe);
	
	List<Recaudaciones> getRecaudacionReci(String recibo);
	
	List<Recaudaciones> getRecaudacionesByPosgrado();

	List<Recaudaciones> getRecaudacionesByNombresApellidosStartDateBetween(String nombres,String apellidos,Date fechaInicial, Date fechaFinal);

	List<Recaudaciones> getRecaudacionesByNombresApellidos(String nombres, String apellidos);
	
	List<Recaudaciones> getRecaudacionesByNombresApellidosConcepto(String concepto, String nombres, String apellidos);
	
	List<Recaudaciones> getRecaudacionesByNombresApellidosRecibo( String recibo, String nombres, String apellidos);

	Recaudaciones getRecaudacionesById(int idRec);

	void addRecaudaciones(Recaudaciones reacaudaciones);

	int updateRecaudaciones(Recaudaciones reacaudaciones);

	void updateRecaudaciones(int idRec, String codAlum, Integer idProg);
	
	void deleteRecaudaciones(int idRec);

	//agregado por miguel
	public List<Recaudaciones> getRecaudacionesPendiengesEntreFechas(Date fechaInicial, Date fechaFinal);
	public List<Recaudaciones> getRecaudacionesPorNombre(String nombresApellido);
	public List<Recaudaciones> getObservacionesEntreFechas(Date fechaInicial, Date fechaFinal);
	
	//agregado por rolando
	public List<CuentasPorCobrar> getCuentasPorCobrar(String fechaInicial,String fechaFinal);
	
	public List<DeudoresPosgradoMasInfo> getCuentasPorCobrar2(String fechaInicial,String fechaFinal);
}