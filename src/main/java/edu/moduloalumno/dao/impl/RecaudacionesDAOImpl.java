package edu.moduloalumno.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.IRecaudacionesDAO;
import edu.moduloalumno.entity.CuentasPorCobrar;
import edu.moduloalumno.entity.CuentasPorCobrar2;
import edu.moduloalumno.entity.DeudoresPosgradoMasInfo;
import edu.moduloalumno.entity.Recaudaciones;
import edu.moduloalumno.rowmapper.CuentasPorCobrarRowMapper;
import edu.moduloalumno.rowmapper.CuentasPorCobrarRowMapper2;
import edu.moduloalumno.rowmapper.CuentasPorCobrarV3RowMapper;
import edu.moduloalumno.rowmapper.RecaudacionesRowMapper;

@Transactional
@Repository
public class RecaudacionesDAOImpl implements IRecaudacionesDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addRecaudaciones(Recaudaciones reacaudaciones) { }

	@Override
	public int updateRecaudaciones(Recaudaciones reacaudaciones) {return 0;}

	@Override
	public void updateRecaudaciones(int idRec, String codAlum, Integer idProg) {
		
		String sql = "UPDATE recaudaciones SET cod_alumno = ?, id_programa = ? WHERE id_rec = ?";
		String sql2 = "UPDATE recaudaciones SET cod_alumno = "+codAlum+", id_programa = "+idProg+" WHERE id_rec = "+idRec;
		System.out.println(sql2);
		int i =jdbcTemplate.update(sql, codAlum, idProg, idRec);
		System.out.println("Se modificaron " + i + " filas");
	}

	@Override
	public void deleteRecaudaciones(int idRec) { }

	@Override
	public List<Recaudaciones> getAllRecaudaciones() {
		
		String sql = "SELECT id_rec, moneda, numero, importe, carnet, autoseguro, ave, devol_tran, observacion, fecha, validado, id_alum, id_concepto, id_registro, cod_alumno, id_programa, id_ubicacion, id_tipo , repitencia FROM recaudaciones";		
		RowMapper<Recaudaciones> rowMapper = new RecaudacionesRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public Recaudaciones getRecaudacionesById(int idRecaudaciones) {
		String sql = "SELECT id_rec, moneda, numero, importe, carnet, autoseguro, ave, devol_tran, observacion, fecha, validado, id_alum, id_concepto, id_registro, cod_alumno, id_programa, id_ubicacion, id_tipo FROM recaudaciones WHERE id_rec = ?";
		RowMapper<Recaudaciones> rowMapper = new BeanPropertyRowMapper<Recaudaciones>(Recaudaciones.class);
		Recaudaciones recaudaciones = jdbcTemplate.queryForObject(sql, rowMapper, idRecaudaciones);
		return recaudaciones;
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByStartDateBetween(Date fechaInicial, Date fechaFinal) {
		String sql = "select r.id_rec, r.moneda, r.numero, r.importe, r.carnet, r.autoseguro, r.ave, r.devol_tran, r.observacion, r.fecha, r.validado, r.id_alum, r.id_concepto, r.id_registro,  r.cod_alumno, r.id_programa, r.id_ubicacion, r.id_tipo from Recaudaciones r where (r.fecha between ? and ?) and (r.id_concepto = some ( select tc.id_concepto from Concepto tc where tc.id_clase_pagos = 2)) order by r.id_concepto, r.fecha";
		RowMapper<Recaudaciones> rowMapper = new RecaudacionesRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, fechaInicial, fechaFinal);
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByNomApeStartDateBetween(String nomApe, Date fechaInicial,
			Date fechaFinal) {
		String sql = "select r.id_rec, r.moneda, r.numero, r.importe, r.carnet, r.autoseguro, r.ave, r.devol_tran, r.observacion, r.fecha, r.validado, r.id_alum, r.id_concepto, r.id_registro,  r.cod_alumno, r.id_programa, r.id_ubicacion, r.id_tipo from Recaudaciones r, alumno a where ((r.fecha between ? and ?) or r.fecha = null) and (r.id_alum = a.id_alum) and (a.ape_nom = ?) and (r.id_concepto = some ( select tc.id_concepto from Concepto tc where tc.id_clase_pagos = 2)) order by r.id_concepto, r.fecha";
		RowMapper<Recaudaciones> rowMapper = new RecaudacionesRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, fechaFinal, fechaInicial, nomApe);
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByNomApe(String nomApe) {
		String sql = "select r.id_rec, r.moneda, r.numero, r.importe, r.carnet, r.autoseguro, r.ave, r.devol_tran, r.observacion, r.fecha, r.validado, r.id_alum, r.id_concepto, r.id_registro,  r.cod_alumno, r.id_programa, r.id_ubicacion, r.id_tipo from Recaudaciones r, alumno a where (r.id_alum = a.id_alum) and (a.ape_nom = ?) and (r.id_concepto = some ( select tc.id_concepto from Concepto tc where tc.id_clase_pagos = 2)) order by r.id_concepto, r.fecha";
		RowMapper<Recaudaciones> rowMapper = new RecaudacionesRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, nomApe);
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByNomApeConcepto(String concepto, String nomApe) {
		String sql = "select r.id_rec, r.moneda, r.numero, r.importe, r.carnet, r.autoseguro, r.ave, r.devol_tran, r.observacion, r.fecha, r.validado, r.id_alum, r.id_concepto, r.id_registro,  r.cod_alumno, r.id_programa, r.id_ubicacion, r.id_tipo from Recaudaciones r, concepto co, alumno a where (r.id_concepto = co.id_concepto) and (co.concepto = ?) and (r.id_alum = a.id_alum) and (a.ape_nom = ?) order by r.id_concepto, r.fecha";
		RowMapper<Recaudaciones> rowMapper = new RecaudacionesRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, concepto, nomApe);
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByNomApeRecibo(String recibo, String nomApe) {
		String sql = "select r.id_rec, r.moneda, r.numero, r.importe, r.carnet, r.autoseguro, r.ave, r.devol_tran, r.observacion, r.fecha, r.validado, r.id_alum, r.id_concepto, r.id_registro,  r.cod_alumno, r.id_programa, r.id_ubicacion, r.id_tipo from Recaudaciones r, alumno a where (r.numero = ?) and (r.id_alum = a.id_alum) and (a.ape_nom = ?) order by r.id_concepto, r.fecha";
		RowMapper<Recaudaciones> rowMapper = new RecaudacionesRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, recibo, nomApe);
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByPosgrado() {
		String sql = "select r.id_rec, r.moneda, r.numero, r.importe, r.carnet, r.autoseguro, r.ave, r.devol_tran, r.observacion, r.fecha, r.validado, r.id_alum, r.id_concepto, r.id_registro,  r.cod_alumno, r.id_programa, r.id_ubicacion, r.id_tipo from Recaudaciones r  where (r.id_concepto = some ( select tc.id_concepto from Concepto tc where tc.id_clase_pagos = 2))  order by r.id_concepto, r.fecha";
		RowMapper<Recaudaciones> rowMapper = new RecaudacionesRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByNombresApellidosStartDateBetween(String nombres, String apellidos,
			Date fechaInicial, Date fechaFinal) {
		String sql = "select r.id_rec, r.moneda, r.numero, r.importe, r.carnet, r.autoseguro, r.ave, r.devol_tran, r.observacion, r.fecha, r.validado, r.id_alum, r.id_concepto, r.id_registro,  r.cod_alumno, r.id_programa, r.id_ubicacion, r.id_tipo from Recaudaciones r, alumno a where (r.id_alum = a.id_alum) and ((a.ape_nom like '%'|| ? ||'%') and (a.ape_nom like '%'|| ? ||'%')) and ((r.fecha between ? and ? ) or r.fecha = null) and (r.id_concepto = some ( select tc.id_concepto  from Concepto tc where tc.id_clase_pagos = 2)) order by r.id_concepto, r.fecha";
		RowMapper<Recaudaciones> rowMapper = new RecaudacionesRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, nombres, apellidos, fechaInicial, fechaFinal);
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByNombresApellidos(String nombres, String apellidos) {
		String sql = "select r.id_rec, r.moneda, r.numero, r.importe, r.carnet, r.autoseguro, r.ave, r.devol_tran, r.observacion, r.fecha, r.validado, r.id_alum, r.id_concepto, r.id_registro,  r.cod_alumno, r.id_programa, r.id_ubicacion, r.id_tipo from Recaudaciones r, alumno a where (a.id_alum = r.id_alum ) and ((a.ape_nom like '%'|| ? ||'%') and (a.ape_nom like '%'||?||'%')) and (r.id_concepto = some ( select tc.id_concepto from Concepto tc where tc.id_clase_pagos = 2)) order by r.id_concepto, r.fecha";
		RowMapper<Recaudaciones> rowMapper = new RecaudacionesRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, nombres, apellidos);
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByNombresApellidosConcepto(String concepto, String nombres,
			String apellidos) {
		String sql = "select r.id_rec, r.moneda, r.numero, r.importe, r.carnet, r.autoseguro, r.ave, r.devol_tran, r.observacion, r.fecha, r.validado, r.id_alum, r.id_concepto, r.id_registro, r.cod_alumno, r.id_programa, r.id_ubicacion, r.id_tipo from Recaudaciones r, alumno a, concepto co where (r.id_concepto = co.id_concepto) and (co.concepto = ?) and (r.id_alum = a.id_alum) and ((a.ape_nom like '%'|| ? ||'%') and (a.ape_nom like '%'|| ? ||'%')) order by r.id_concepto, r.fecha";
		RowMapper<Recaudaciones> rowMapper = new RecaudacionesRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, concepto, nombres, apellidos);
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByNombresApellidosRecibo(String recibo, String nombres,
			String apellidos) {
		String sql = "select r.id_rec, r.moneda, r.numero, r.importe, r.carnet, r.autoseguro, r.ave, r.devol_tran, r.observacion, r.fecha, r.validado, r.id_alum, r.id_concepto, r.id_registro, r.cod_alumno, r.id_ubicacion, r.id_programa, r.id_tipo from Recaudaciones r, alumno a where (r.numero = ?) and (r.id_alum = a.id_alum ) and ((a.ape_nom like '%'|| ? ||'%') and (a.ape_nom like '%'|| ? ||'%')) order by r.id_concepto, r.fecha";
		RowMapper<Recaudaciones> rowMapper = new RecaudacionesRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, recibo, nombres, apellidos);
	}
	
	

	@Override
	public List<Recaudaciones> getRecaudacionReci(String recibo) {
		String sql = "select " + 
				"r.id_rec,  " + 
				"r.id_alum,  " + 
				"a.ape_nom,  " + 
				"c.concepto, " + 
				"a.dni,  " + 
				"r.numero,  " + 
				"f.nombre,  " + 
				"r.moneda, " + 
				"r.importe,  " + 
				"r.observacion, " +
				"r.fecha,  " + 
				"r.cod_alumno as codAlum, " + 
				"p.id_programa as idProg,   " + 
				"p.sigla_programa as siglaProg "+
				"from recaudaciones r " + 
				"join alumno a on (r.id_alum = a.id_alum) " + 
				"join concepto c on (r.id_concepto = c.id_concepto) " + 
				"join facultad f on (a.id_facultad = f.id_facultad) " + 
				"left join programa p on (p.id_programa = r.id_programa) " + 
				"where  (r.numero = (?))  " + 
				"order by r.id_concepto, r.fecha";
		
//		String sql = "select " +
//		"r.id_rec,  " +
//		"r.id_alum,  " +
//		"a.ape_nom,  " +
//		"c.concepto, " +
//		"a.dni,  " +
//		"r.numero,  " +
//		"f.nombre,  " +
//		"r.moneda, " +
//		"r.importe,  " +
//		"r.fecha,  " +
//		"r.cod_alumno as codAlum, " +
//		"r.id_programa as idProg   " +
//		"from recaudaciones r,  " +
//		"alumno a,  " +
//		"concepto c,  " +
//		"facultad f  " +
//		"where  (r.numero = (?))  " +
//		"and (r.id_alum = a.id_alum)  " +
//		"and (r.id_concepto = c.id_concepto)  " +
//		"and (a.id_facultad = f.id_facultad) "+
//		"order by r.id_concepto, r.fecha";  
		
		RowMapper<Recaudaciones> rowMapper = new RecaudacionesRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, recibo);
	}	
	
	@Override
	public List<Recaudaciones> getRecaudacionesPendiengesEntreFechas(Date fechaInicial, Date fechaFinal) {
		
		String sql = "select " +
				"r.id_rec,  " +
				"r.id_alum,  " +
				"a.ape_nom,  " +
				"c.concepto, " +
				"a.dni,  " +
				"r.numero,  " +
				"f.nombre,  " +
				"r.moneda, " +
				"r.importe,  " +
				"r.observacion, " +
				"r.fecha,  " +
				"r.cod_alumno as codAlum, " +
				"r.id_programa as idProg,  " +
				"p.sigla_programa as siglaProg "+
				"from recaudaciones r  " +
				"join alumno a on (r.id_alum = a.id_alum) " + 
				"join concepto c on (r.id_concepto = c.id_concepto) " + 
				"join facultad f on (a.id_facultad = f.id_facultad) " + 
				"left join programa p on (p.id_programa = r.id_programa) " + 
				"where (r.fecha between ? and ?) " +
				"and r.cod_alumno is null " +
				"order by r.id_concepto, r.fecha";
		RowMapper<Recaudaciones> rowMapper = new RecaudacionesRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, fechaInicial, fechaFinal);
	}
	
	@Override
	public List<Recaudaciones> getRecaudacionesPorNombre(String nombresApellido) {
		String sql = "select " + 
				"r.id_rec,  " + 
				"r.id_alum,  " + 
				"a.ape_nom,  " + 
				"c.concepto, " + 
				"a.dni,  " + 
				"r.numero,  " + 
				"f.nombre,  " + 
				"r.moneda, " + 
				"r.importe,  " + 
				"r.observacion, " +
				"r.fecha,  " + 
				"r.cod_alumno as codAlum," + 
				"r.id_programa as idProg,   " +
				"p.sigla_programa as siglaProg "+ 
				"from recaudaciones r  " +
				"join alumno a on (r.id_alum = a.id_alum) " + 
				"join concepto c on (r.id_concepto = c.id_concepto) " + 
				"join facultad f on (a.id_facultad = f.id_facultad) " + 
				"left join programa p on (p.id_programa = r.id_programa) " + 
				"where (a.ape_nom like '%'|| ? ||'%') " + 
				"order by r.id_concepto, r.fecha";
		RowMapper<Recaudaciones> rowMapper = new RecaudacionesRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, nombresApellido);
	}

	@Override
	public List<Recaudaciones> getObservacionesEntreFechas(Date fechaInicial, Date fechaFinal){
	String sql = "select " +
				"r.id_rec,  " +
				"r.id_alum,  " +
				"a.ape_nom,  " +
				"c.concepto, " +
				"a.dni,  " +
				"r.numero,  " +
				"f.nombre,  " +
				"r.moneda, " +
				"r.importe,  " +
				"r.observacion, " +
				"r.fecha,  " +
				"r.cod_alumno as codAlum, " +
				"r.id_programa as idProg,  " +
				"p.sigla_programa as siglaProg "+
				"from recaudaciones r  " +
				"join alumno a on (r.id_alum = a.id_alum) " + 
				"join concepto c on (r.id_concepto = c.id_concepto) " + 
				"join facultad f on (a.id_facultad = f.id_facultad) " + 
				"left join programa p on (p.id_programa = r.id_programa) " + 
				"where (r.fecha between ? and ?) " +
				"and length(trim(r.observacion))>10 " +
				"order by r.fecha";

		RowMapper<Recaudaciones> rowMapper = new RecaudacionesRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, fechaInicial, fechaFinal);
	}
	
	@Override
	public List<CuentasPorCobrar> getCuentasPorCobrar(String fechaInicial,String fechaFinal){
		String sql="select a.cod_alumno,a.ape_paterno,a.ape_materno,a.nom_alumno,d.sigla_programa, " + 
				"a.cod_perm, coalesce(a.max_anio_estudio,0) as max_anio_estudio,f.beneficio_otorgado,f.autorizacion, " + 
				"CASE WHEN c.moneda='108' THEN 'SOLES' " + 
				"            WHEN c.moneda='113' THEN 'DOLARES' " + 
				"            ELSE '?'  " + 
				"       END as moneda,e.n_prioridad,e.concepto,e.descripcion_min, " + 
				"			i.importe as importe_xpagar,c.importe_pagado,(i.importe - c.importe_pagado) as deuda, " + 
				"			'RECIBO VERIFICADO' as estado " + 
				"from importe_alumno i " + 
				"inner join alumno_programa a  " + 
				"on (a.cod_alumno=CAST(i.cod_alumno as varchar) and a.id_programa=i.cod_programa) " + 
				"inner join programa d " + 
				"on (a.id_programa=d.id_programa) " + 
				"left outer join alumno_programa_beneficio f " + 
				"on (a.cod_alumno=f.cod_alumno) " + 
				"inner join (select  " + 
				"c.cod_alumno,c.id_programa,c.moneda,c.id_concepto,sum(c.importe) as importe_pagado " + 
				"from recaudaciones c " + 
				"where  " + 
				"	  c.validado is true " + 
				"and c.id_concepto in (9,117,21,62) " + 
				"group by c.cod_alumno,c.id_programa,c.moneda,c.id_concepto) as c " + 
				"on (a.cod_alumno=c.cod_alumno) " + 
				"inner join concepto e " + 
				"on (i.cod_concepto=e.id_concepto and i.cod_concepto=c.id_concepto) " + 
				"where " + 
				"	a.cna is null " + 
				"and substring(a.anio_ingreso,1,4) between '"+fechaInicial+"' and '"+fechaFinal+"' " + 
				"and CAST(substring(a.cod_alumno,1,2) as integer)>=16 " + 
				"and c.moneda='108' " + 
				"and i.importe>0.0 and (i.importe - c.importe_pagado) > 5 " + 
				"UNION " + 
				"select a.cod_alumno,a.ape_paterno,a.ape_materno,a.nom_alumno,d.sigla_programa,	" + 
				"a.cod_perm, coalesce(a.max_anio_estudio,0) as max_anio_estudio,f.beneficio_otorgado,f.autorizacion, " + 
				"'SOLES' as moneda,e.n_prioridad,e.concepto,e.descripcion_min, " + 
				"			i.importe as importe_xpagar,0,(i.importe - 0) as deuda, 'RECIBO NO UBICADO' " + 
				"from importe_alumno i " + 
				"inner join alumno_programa a  " + 
				"on (a.cod_alumno=CAST(i.cod_alumno as varchar) and a.id_programa=i.cod_programa) " + 
				"inner join programa d " + 
				"on (a.id_programa=d.id_programa) " + 
				"left outer join alumno_programa_beneficio f " + 
				"on (a.cod_alumno=f.cod_alumno) " + 
				"inner join concepto e " + 
				"on (i.cod_concepto=e.id_concepto ) " + 
				"where " + 
				"	a.cna is null " + 
				"and substring(a.anio_ingreso,1,4) between '"+fechaInicial+"'  and '"+fechaFinal+"'"+ 
				"and CAST(substring(a.cod_alumno,1,2) as integer)>=16 " + 
				"and not exists (select 1 " + 
				"from recaudaciones c " + 
				"where c.cod_alumno=a.cod_alumno " + 
				"and c.id_concepto=i.cod_concepto " + 
				"and c.validado is true) " + 
				"order by 1,2,3,n_prioridad;";
		
		System.out.println("El sql es "+ sql);
		
		RowMapper<CuentasPorCobrar> rowMapper=new CuentasPorCobrarRowMapper();
		System.out.println("llego hasta el rowMapper");
		List<CuentasPorCobrar> list=this.jdbcTemplate.query(sql, rowMapper);
		System.out.println("Paso a ejecutar el query");
		return list;
	}

	@Override
	public List<DeudoresPosgradoMasInfo> getCuentasPorCobrar2(String fechaInicial, String fechaFinal) {
		String sql="select a.cod_alumno,a.id_programa,a.ape_paterno,a.ape_materno,a.nom_alumno,d.n_prioridad,d.sigla_programa,	" + 
				"				  substring(a.anio_ingreso,1,4) as anio_ingreso,a.cod_perm, coalesce(a.max_anio_estudio,0) as max_anio_estudio,f.beneficio_otorgado,f.autorizacion,      " + 
				"				  CASE WHEN c.moneda='108' THEN 'SOLES'      " + 
				"				              WHEN c.moneda='113' THEN 'DOLARES'       " + 
				"				              ELSE '?'        " + 
				"				         END as moneda,c.moneda as id_moneda, e.n_prioridad as prioridad,e.id_concepto,e.concepto,e.descripcion_min,       " + 
				"				  			i.importe as importe_xpagar,c.importe_pagado,(i.importe - c.importe_pagado) as deuda,a.notificacion_deuda,nd.deuda_estado,       " + 
				"				  			'RECIBO VERIFICADO' as estado,       " + 
				"				  dp.coe_alumno,dp.coe_alu_personal,dp.tel_alu_movil,dp.tel_alumno,dp.des_doc_identidad,dp.did_alumno,       " + 
				"				  dp.dir_tip_via,dp.dir_tip_via_nom,dp.dir_num_puerta,dp.dir_num_piso,dp.dir_num_dpto,       " + 
				"				  dp.dir_num_mz,dp.dir_num_lote,dp.dir_num_km,dp.dir_tip_loc,       " + 
				"				  dp.dir_tip_loc_nom,u.departamento,u.provincia,u.distrito       " + 
				"				  from importe_alumno i       " + 
				"				  inner join alumno_programa a        " + 
				"				  on (a.cod_alumno=CAST(i.cod_alumno as varchar) and a.id_programa=i.cod_programa)       " + 
				"				  inner join programa d       " + 
				"				  on (a.id_programa=d.id_programa)       " + 
				"				  left outer join alumno_programa_beneficio f       " + 
				"				  on (a.cod_alumno=f.cod_alumno)       " + 
				"				  inner join (select        " + 
				"				  c.cod_alumno,c.id_programa,c.moneda,c.id_concepto,sum(c.importe) as importe_pagado       " + 
				"				  from recaudaciones c       " + 
				"				  where        " + 
				"				    c.id_concepto in (9,117,21,62)       " + 
				"				  group by c.cod_alumno,c.id_programa,c.moneda,c.id_concepto) as c       " + 
				"				  on (a.cod_alumno=c.cod_alumno)       " + 
				"				  inner join concepto e       " + 
				"				  on (i.cod_concepto=e.id_concepto and i.cod_concepto=c.id_concepto)       " + 
				"				  left outer join sum_dpersonales dp       " + 
				"				  on (a.cod_alumno=dp.cod_alumno       " + 
				"				  and dp.semestre=(select max(dp1.semestre)        " + 
				"				  								from sum_dpersonales dp1        " + 
				"				  								where dp1.cod_alumno=dp.cod_alumno))       " + 
				"				  left outer join ubigeo u       " + 
				"				  on (u.idubigeo=CONCAT(dp.dir_ubi_depa, dp.dir_ubi_prov,dp.dir_ubi_dist))       " + 
				"				  left outer join notificacion_deudas nd       " + 
				"				  on(a.cod_alumno=nd.cod_alumno and nd.l_ultimo='S')       " + 
				"				  where        " + 
				"				  	a.cna is null       " + 
				"				  and substring(a.anio_ingreso,1,4) between '"+fechaInicial+"' and '"+fechaFinal+"' " + 
				"				  and c.moneda='108'       " + 
				"				  and i.importe>0.0 and (i.importe - c.importe_pagado) > 10       " + 
				"				  and ((select sum(importe) from importe_alumno where cod_alumno=a.cod_alumno)-       " + 
				"				  		(select sum(importe) from recaudaciones where cod_alumno=a.cod_alumno and id_concepto in (9,117,21,62)))>0       " + 
				"				  UNION       " + 
				"				  select a.cod_alumno,a.id_programa,a.ape_paterno,a.ape_materno,a.nom_alumno,d.n_prioridad,d.sigla_programa,			       " + 
				"				  substring(a.anio_ingreso,1,4) as anio_ingreso,a.cod_perm, coalesce(a.max_anio_estudio,0) as max_anio_estudio,f.beneficio_otorgado,f.autorizacion,       " + 
				"				  'SOLES' as moneda,'108' as id_moneda,e.n_prioridad,e.id_concepto,e.concepto,e.descripcion_min,       " + 
				"                  i.importe as importe_xpagar,0,(i.importe - 0) as deuda, a.notificacion_deuda,null,'RECIBO NO UBICADO' as estado,       " + 
				"				  dp.coe_alumno,dp.coe_alu_personal,dp.tel_alu_movil,dp.tel_alumno,dp.des_doc_identidad,dp.did_alumno,       " + 
				"				  dp.dir_tip_via,dp.dir_tip_via_nom,dp.dir_num_puerta,dp.dir_num_piso,dp.dir_num_dpto,       " + 
				"				  dp.dir_num_mz,dp.dir_num_lote,dp.dir_num_km,dp.dir_tip_loc,       " + 
				"				  dp.dir_tip_loc_nom,u.departamento,u.provincia,u.distrito       " + 
				"				  from importe_alumno i       " + 
				"				  inner join alumno_programa a        " + 
				"				  on (a.cod_alumno=CAST(i.cod_alumno as varchar) and a.id_programa=i.cod_programa)       " + 
				"				  inner join programa d       " + 
				"				  on (a.id_programa=d.id_programa)       " + 
				"				  left outer join alumno_programa_beneficio f       " + 
				"				  on (a.cod_alumno=f.cod_alumno)       " + 
				"				  inner join concepto e       " + 
				"				  on (i.cod_concepto=e.id_concepto )       " + 
				"				  left outer join sum_dpersonales dp       " + 
				"				  on (a.cod_alumno=dp.cod_alumno       " + 
				"				  and dp.semestre=(select max(dp1.semestre)        " + 
				"				  								from sum_dpersonales dp1        " + 
				"				  								where dp1.cod_alumno=dp.cod_alumno))       " + 
				"				  left outer join ubigeo u       " + 
				"				  on (u.idubigeo=CONCAT(dp.dir_ubi_depa, dp.dir_ubi_prov,dp.dir_ubi_dist))       " + 
				"				  where        " + 
				"				  	a.cna is null       " + 
				"				  and substring(a.anio_ingreso,1,4) between '"+fechaInicial+"' and '"+fechaFinal+"'       " + 
				"				  and i.importe>0.0        " + 
				"				  and not exists (select 1       " + 
				"				  from recaudaciones c       " + 
				"				  where c.cod_alumno=a.cod_alumno       " + 
				"				  and c.id_concepto=i.cod_concepto)        " + 
				"				  order by 8 desc,6,3,4,14 " ;
		
		System.out.println("El sql es "+ sql);
		
		RowMapper<DeudoresPosgradoMasInfo> rowMapper=new CuentasPorCobrarV3RowMapper();
		System.out.println("llego hasta el rowMapper cuentas por cobrar");
		List<DeudoresPosgradoMasInfo> list=this.jdbcTemplate.query(sql, rowMapper);
		System.out.println("Paso a ejecutar el query");
		return list;
	}
}