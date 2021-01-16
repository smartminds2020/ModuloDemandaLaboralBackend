package edu.moduloalumno.dao.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.IRecaudacionesJOINAlumnoJOINConceptoJOINFacultadDAO;
import edu.moduloalumno.entity.CodigosporNomApe;
import edu.moduloalumno.entity.RecaudacionesAlumnoConConcepto;
import edu.moduloalumno.entity.RecaudacionesJOINAlumnoJOINConceptoJOINFacultad;
import edu.moduloalumno.entity.RecaudacionesJoinAlumnoJoinConceptoJoinFacultadWithDescription;
import edu.moduloalumno.rowmapper.CodigosporNomApeRowMapper;
import edu.moduloalumno.rowmapper.RecaudacionesAlumnoConConceptoRowMapper;
import edu.moduloalumno.rowmapper.RecaudacionesJOINAlumnoJOINConceptoJOINFacultadRowMapper;
import edu.moduloalumno.rowmapper.RecaudacionesJOINAlumnoJOINConceptoJOINFacultad_idTipoRecaudacionRowMapper;
import edu.moduloalumno.rowmapper.RecaudacionesJoinAlumnoJoinConceptoJoinFacultadWithDescriptionRowMapper;

@Transactional
@Repository
public class RecaudacionesJOINAlumnoJOINConceptoJOINFacultadDAOImpl
		implements IRecaudacionesJOINAlumnoJOINConceptoJOINFacultadDAO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private int estado_id;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override // aqui
	public List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getAllRecaudacionesJOINAlumnoJOINConceptoJOINFacultads() {
		String sql = "select r.repitencia, r.id_rec,r.id_alum,rc.estado,a.ape_nom,r.ciclo,c.concepto,c.id_concepto,ap.dni_m as dni,r.numero,f.nombre,m.id_moneda,m.moneda, "
				+ "r.importe, r.fecha,ap.anio_ingreso,p.nom_programa, "
				+ "p.id_programa, r.cod_alumno, r.observacion, r.validado, ec.ecivil_desc as estado_civil " + "from "
				+ "recaudaciones r inner join alumno a " + "on (r.id_alum = a.id_alum) "
				+ "inner join registro_carga rc " + "on (rc.id_registro = r.id_registro) " + "inner join facultad f "
				+ "on (a.id_facultad = f.id_facultad) " + "inner join concepto c "
				+ "on (r.id_concepto = c.id_concepto) " + "inner join alumno_programa ap "
				+ "on  (ap.cod_alumno = r.cod_alumno) " + "inner join programa p "
				+ "on (ap.id_programa = p.id_programa) "
				+ "inner join estado_civil ec on (ap.ecivil_id = ec.ecivil_id) " + "left outer join moneda m "
				+ "on (m.id_moneda = r.moneda) " + "order by c.concepto, r.fecha";

		RowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> rowMapper = new RecaudacionesJOINAlumnoJOINConceptoJOINFacultadRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadIdByNombresApellidosRestringido(
			String nombres, String apellidos) {
		String sql = "select r.repitencia, r.id_rec, r.id_alum, a.ape_nom, c.concepto, "
				+ "r.numero, f.nombre, r.moneda, r.importe, r.fecha, r.id_programa, "
				+ "r.cod_alumno, r.observacion, r.validado " + "from recaudaciones r, alumno a, facultad f, concepto c "
				+ "where (r.id_alum = a.id_alum) " + "and (a.id_facultad = f.id_facultad) "
				+ "and ((a.ape_nom like '%'|| ? ||'%') " + "and (a.ape_nom like '%'|| ? ||'%')) "
				+ "and (r.id_concepto = c.id_concepto) " + "order by c.concepto, r.fecha";
		RowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> rowMapper = new RecaudacionesJOINAlumnoJOINConceptoJOINFacultadRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, nombres, apellidos);
	}

	@Override
	public RecaudacionesJOINAlumnoJOINConceptoJOINFacultad getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadById(
			int idRecaudaciones) {
		logger.info("Facultadupdate id" + idRecaudaciones);

		String sql = "select r.repitencia, r.id_rec, r.id_alum, rc.estado, a.ape_nom, "
				+ "c.concepto,r.ciclo,c.id_concepto,ap.dni_m as dni, r.numero, f.nombre, "
				+ "r.moneda, r.importe, r.fecha,p.nom_programa ,p.id_programa, "
				+ "p.sigla_programa, r.cod_alumno, r.observacion, r.validado, ec.ecivil_desc as estado_civil " + "from "
				+ "recaudaciones r inner join registro_carga rc " + "on (rc.id_registro = r.id_registro) "
				+ "inner join alumno a " + "on (r.id_alum = a.id_alum) " + "inner join facultad f "
				+ "on (a.id_facultad = f.id_facultad) " + "inner join concepto c "
				+ "on (r.id_concepto = c.id_concepto) " + "inner join alumno_programa ap "
				+ "on (ap.cod_alumno = r.cod_alumno) " + "inner join programa p "
				+ "on (ap.id_programa = p.id_programa) "
				+ "inner join estado_civil ec on (ap.ecivil_id = ec.ecivil_id) " + "where (r.id_rec = ? ) "
				+ "order by c.concepto,r.fecha";

		RowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> rowMapper = new BeanPropertyRowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad>(
				RecaudacionesJOINAlumnoJOINConceptoJOINFacultad.class);
		RecaudacionesJOINAlumnoJOINConceptoJOINFacultad recaudaciones = jdbcTemplate.queryForObject(sql, rowMapper,
				idRecaudaciones);
		logger.info("Facultadupdate idREC" + recaudaciones);

		return recaudaciones;
	}

	@Override
	public List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByStartDateBetween(
			Date fechaInicial, Date fechaFinal) {
		String sql = "select r.repitencia, r.id_rec, r.id_alum, rc.estado ,a.ape_nom, "
				+ "c.concepto, r.numero, f.nombre, r.moneda, r.importe, r.fecha, "
				+ "p.id_programa, r.cod_alumno, r.observacion, r.validado "
				+ "from recaudaciones r, registro_carga rc, alumno a, " + "facultad f, concepto c "
				+ "where (r.fecha between ? and ?) " + "and (r.id_alum = a.id_alum) "
				+ "and (rc.id_registro = r.id_registro) " + "and (a.id_facultad = f.id_facultad) "
				+ "and (r.id_concepto = c.id_concepto) " + "order by c.concepto, r.fecha";
		RowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> rowMapper = new RecaudacionesJOINAlumnoJOINConceptoJOINFacultadRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, fechaInicial, fechaFinal);
	}

	@Override // aqui
	public List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNomApeStartDateBetween(
			String nomApe, Date fechaInicial, Date fechaFinal) {

		String sql = "select r.repitencia, r.id_rec, r.id_alum, rc.estado, "
				+ "ap.nom_alumno || ' ' || ap.ape_paterno || ' ' || ap.ape_materno as ape_nom, "
				+ "r.ciclo ,c.concepto,c.id_concepto,r.id_tipo_recaudacion,ap.dni_m as dni, r.numero, f.nombre, m.id_moneda, "
				+ "m.moneda, r.importe, r.fecha,ap.anio_ingreso,p.nom_programa, "
				+ "p.id_programa,p.sigla_programa, r.cod_alumno, r.observacion, "
				+ "u.descripcion as descripcion_ubi, t.descripcion as descripcion_tipo, r.validado, ec.ecivil_desc as estado_civil "
				+ "from " + "recaudaciones r inner join registro_carga rc " + "on (rc.id_registro = r.id_registro) "
				+ "inner join alumno a " + "on (a.id_alum = r.id_alum) " + "inner join facultad f "
				+ "on (a.id_facultad = f.id_facultad) " + "inner join concepto c "
				+ "on (r.id_concepto = c.id_concepto ) "
				+ "left outer join ubicacion u on (r.id_ubicacion = u.id_ubicacion) "
				+ "left outer join tipo t on (r.id_tipo = t.id_tipo) " + "inner join alumno_programa ap "
				+ "on (ap.cod_alumno = r.cod_alumno) " + "inner join programa p "
				+ "on (ap.id_programa = p.id_programa) " + "left outer join moneda m " + "on (m.id_moneda = r.moneda) "
				+ "left outer join estado_civil ec on (ap.ecivil_id = ec.ecivil_id) "
				+ "where to_tsquery( ? ) @@ to_tsvector(coalesce(ap.cod_alumno,'') ) "
				+ "and ((r.fecha between ? and ?) or r.fecha = null) " + "order by c.concepto, r.fecha";

		RowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> rowMapper = new RecaudacionesJOINAlumnoJOINConceptoJOINFacultad_idTipoRecaudacionRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, nomApe, fechaInicial, fechaFinal);
	}

	@Override
	public List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNomApe(
			String nomApe) {

		String sql = "select r.repitencia,r.id_rec, r.id_alum, "
				+ "ap.nom_alumno || ' ' || ap.ape_paterno || ' ' || ap.ape_materno as ape_nom, "
				+ "c.concepto, r.numero, f.nombre, r.moneda, r.importe, "
				+ "r.fecha, r.id_programa, ap.cod_alumno, r.observacion, r.validado " + "from "
				+ "recaudaciones r inner join alumno a " + "on (a.id_alum = r.id_alum) " + "inner join facultad f "
				+ "on (a.id_facultad = f.id_facultad) " + "inner join concepto c "
				+ "on (r.id_concepto = c.id_concepto ) " + "inner join alumno_programa ap "
				+ "on (ap.cod_alumno = r.cod_alumno) "
				+ "where to_tsquery( ? ) @@ to_tsvector(coalesce(ap.nom_alumno,'') || ' ' ||coalesce(ap.ape_paterno,'') || ' ' ||coalesce(ap.ape_materno,'')) "
				+ "order by c.concepto, r.fecha";

		RowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> rowMapper = new RecaudacionesJOINAlumnoJOINConceptoJOINFacultadRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, nomApe);
	}// under claass

	@Override
	public List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByCodigo(
			String codigo) {

		String sql = "select r.id_tipo_recaudacion as r_id_tipo_recaudacion,c.id_tipo_recaudacion as c_id_tipo_recaudacion, "
				+ "CASE " + "WHEN r.id_tipo_recaudacion=4 THEN 'REPIT' "
				+ "WHEN c.id_tipo_recaudacion=5 THEN coalesce(c.descripcion_min,c.concepto) "
				+ "WHEN r.id_tipo_recaudacion IS NULL OR r.id_tipo_recaudacion=0 THEN dconcepto.desc_tipo_recaudacion "
				+ "ELSE rconcepto.desc_tipo_recaudacion " + "END as descripcion_recaudacion,"
				+ "r.repitencia, r.id_rec, r.id_alum, rc.estado,  "
				+ "ap.nom_alumno || ' ' || ap.ape_paterno || ' ' || ap.ape_materno as ape_nom, "
				+ "r.ciclo,r.id_tipo_recaudacion,c.concepto,c.id_concepto, ap.dni_m as dni, "
				+ "r.numero, f.nombre,  m.id_moneda, m.moneda, r.importe, "
				+ "COALESCE( s.fecha_equiv,r.fecha) as fecha,ap.anio_ingreso, "
				+ "p.nom_programa, p.id_programa,p.sigla_programa, "
				+ "r.cod_alumno, ec.ecivil_desc as estado_civil, r.observacion, r.observacion_upg , "
				+ "u.descripcion as descripcion_ubi, t.descripcion as descripcion_tipo, r.validado "
				+ "from recaudaciones r " + "inner join registro_carga rc on (rc.id_registro = r.id_registro) "
				+ "inner join alumno_programa ap on (ap.cod_alumno = r.cod_alumno) "
				+ "inner join estado_civil ec on (ap.ecivil_id = ec.ecivil_id) "
				+ "inner join programa p on (ap.id_programa = p.id_programa) "
				+ "inner join alumno a on (r.id_alum = a.id_alum) "
				+ "inner join facultad f on (a.id_facultad = f.id_facultad) "
				+ "inner join concepto c on (r.id_concepto = c.id_concepto) "
				+ "left outer join tipo_recaudacion dconcepto on (c.id_tipo_recaudacion=dconcepto.id_tipo_recaudacion)"
				+ "left outer join tipo_recaudacion rconcepto on (r.id_tipo_recaudacion=rconcepto.id_tipo_recaudacion)"
				+ "left outer join ubicacion u on (r.id_ubicacion = u.id_ubicacion) "
				+ "left outer join tipo t on (r.id_tipo = t.id_tipo) "
				+ "left outer join moneda m on (r.moneda = m.id_moneda) "
				+ "left outer join sunat_sintipocambio s on (r.fecha = s.fecha) "
				+ "where to_tsquery(?) @@ to_tsvector(coalesce(ap.cod_alumno,'') || ' ') "
				+ "order by c.concepto, r.fecha";

		RowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> rowMapper = new RecaudacionesJoinAlumnoJoinConceptoJoinFacultadWithDescriptionRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, codigo);
	}

	@Override
	public List<RecaudacionesAlumnoConConcepto> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByValidados(
			String codigo) {

		String sql = "select r.repitencia, r.id_rec, r.id_alum, rc.estado, "
				+ "ap.nom_alumno || ' ' || ap.ape_paterno || ' ' || ap.ape_materno as ape_nom, "
				+ "r.ciclo,c.concepto,c.id_concepto, ap.dni_m as dni, "
				+ "r.numero, f.nombre,  m.id_moneda, m.moneda, r.importe, "
				+ "COALESCE( s.fecha_equiv,r.fecha) as fecha,ap.anio_ingreso, "
				+ "p.nom_programa, p.id_programa,p.sigla_programa,p.id_tip_grado, "
				+ "r.cod_alumno, ec.ecivil_desc as estado_civil, r.observacion, "
				+ "u.descripcion as descripcion_ubi, t.descripcion as descripcion_tipo, r.validado "
				+ "from recaudaciones r " + "inner join registro_carga rc on (rc.id_registro = r.id_registro) "
				+ "inner join alumno_programa ap on (ap.cod_alumno = r.cod_alumno) "
				+ "inner join estado_civil ec on (ap.ecivil_id = ec.ecivil_id) "
				+ "inner join programa p on (ap.id_programa = p.id_programa) "
				+ "inner join alumno a on (r.id_alum = a.id_alum) "
				+ "inner join facultad f on (a.id_facultad = f.id_facultad) "
				+ "inner join concepto c on (r.id_concepto = c.id_concepto) "
				+ "left outer join ubicacion u on (r.id_ubicacion = u.id_ubicacion) "
				+ "left outer join tipo t on (r.id_tipo = t.id_tipo) "
				+ "left outer join moneda m on (r.moneda = m.id_moneda) "
				+ "left outer join sunat_sintipocambio s on (r.fecha = s.fecha) "
				+ "where to_tsquery(?) @@ to_tsvector(coalesce(ap.cod_alumno,'') || ' ') "
				+ "order by c.concepto, r.fecha";
		System.out.println("llego hasta aqui");

		RowMapper<RecaudacionesAlumnoConConcepto> rowMapper = new RecaudacionesAlumnoConConceptoRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, codigo);
	}

	/* new */@Override
	public List<CodigosporNomApe> getCodigoByNombre(String nomApe) {
		String sql = "select ap.cod_alumno, "
				+ "ap.nom_alumno || ' ' || ap.ape_paterno || ' ' || ap.ape_materno as nombre_alumno, "
				+ "ec.ecivil_desc as estado_civil, " + "p.nom_programa as nombre_programa "
				+ "from alumno_programa as ap, " + "programa as p, " + "estado_civil as ec "
				+ "where to_tsquery( ? ) @@ to_tsvector(coalesce(ap.nom_alumno,'') || ' ' ||coalesce(ap.ape_paterno,'') || ' ' ||coalesce(ap.ape_materno,'')) and (ap.id_programa = p.id_programa) and (ap.ecivil_id = ec.ecivil_id)";

		RowMapper<CodigosporNomApe> rowMapper = new CodigosporNomApeRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, nomApe);
	}

	// para login

	@Override
	public List<CodigosporNomApe> getCodigoByNombreCodAlumno(String nomApe, String codAlumno) {
		System.out.println("llego aqui");
		System.out.println(nomApe);
		System.out.println(codAlumno);
		String sql = " SELECT ap.cod_alumno,"
				+ " ap.nom_alumno || ' ' ||  ap.ape_paterno || ' ' || ap.ape_materno as nombre_alumno,"
				+ " ec.ecivil_desc as estado_civil, " + " p.nom_programa as nombre_programa"
				+ " FROM alumno_programa  as ap" + " INNER JOIN programa as p on (p.id_programa = ap.id_programa)"
				+ " INNER JOIN estado_civil  as ec  on (ec.ecivil_id = ap.ecivil_id)" + " WHERE ((ap.ape_paterno = '"
				+ nomApe + "') OR (ap.ape_materno = '" + nomApe + "') OR (ap.nom_alumno = '" + nomApe
				+ "')) AND (ap.cod_alumno = '" + codAlumno + "');";

		System.out.println(sql);
		RowMapper<CodigosporNomApe> rowMapper = new CodigosporNomApeRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	// login

	@Override // aqui
	public List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNomApeConcepto(
			String concepto, String nomApe) {

		String sql = "select r.repitencia,r.id_rec, r.id_alum, rc.estado,  "
				+ "ap.nom_alumno || ' ' || ap.ape_paterno || ' ' || ap.ape_materno as ape_nom, "
				+ "r.ciclo,c.concepto,c.id_concepto,c.id_tipo_recaudacion,ap.dni_m as dni, r.numero, f.nombre, m.id_moneda,  "
				+ "m.moneda, r.importe, r.fecha,ap.anio_ingreso,p.nom_programa,  "
				+ "p.id_programa,p.sigla_programa, r.cod_alumno, r.observacion,  "
				+ "u.descripcion as descripcion_ubi, t.descripcion as descripcion_tipo, r.validado, ec.ecivil_desc as estado_civil "
				+ "from recaudaciones r inner join registro_carga rc " + "on (rc.id_registro = r.id_registro) "
				+ "inner join alumno a " + "on (a.id_alum = r.id_alum) " + "inner join facultad f "
				+ "on (a.id_facultad = f.id_facultad) " + "inner join concepto c "
				+ "on (r.id_concepto = c.id_concepto ) "
				+ "left outer join ubicacion u on (r.id_ubicacion = u.id_ubicacion) "
				+ "left outer join tipo t on (r.id_tipo = t.id_tipo) " + "inner join alumno_programa ap "
				+ "on (ap.cod_alumno = r.cod_alumno) " + "inner join programa p "
				+ "on (ap.id_programa = p.id_programa)" + "left outer join moneda m  " + "on (m.id_moneda = r.moneda) "
				+ "left outer join estado_civil ec on (ap.ecivil_id = ec.ecivil_id) "
				+ "where (c.concepto = ?) and to_tsquery( ? ) @@ to_tsvector(coalesce(ap.cod_alumno,'')) "
				+ "order by c.concepto, r.fecha";

		RowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> rowMapper = new RecaudacionesJOINAlumnoJOINConceptoJOINFacultad_idTipoRecaudacionRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, concepto, nomApe);
	}

	@Override // filtro de conceptos- Importe-Pagos
	public List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNomApeConceptoAll(
			String concepto, String nomApe) {

		String sql = "select r.repitencia,r.id_rec, r.id_alum, rc.estado,  "
				+ "ap.nom_alumno || ' ' || ap.ape_paterno || ' ' || ap.ape_materno as ape_nom, "
				+ "r.ciclo,c.concepto,c.id_concepto,c.id_tipo_recaudacion,ap.dni_m as dni, r.numero, f.nombre, m.id_moneda,  "
				+ "m.moneda, r.importe, r.fecha,ap.anio_ingreso,p.nom_programa,  "
				+ "p.id_programa,p.sigla_programa, r.cod_alumno, r.observacion,  "
				+ "u.descripcion as descripcion_ubi, t.descripcion as descripcion_tipo, r.validado, ec.ecivil_desc as estado_civil "
				+ "from recaudaciones r inner join registro_carga rc " + "on (rc.id_registro = r.id_registro) "
				+ "inner join alumno a " + "on (a.id_alum = r.id_alum) " + "inner join facultad f "
				+ "on (a.id_facultad = f.id_facultad) " + "inner join concepto c "
				+ "on (r.id_concepto = c.id_concepto ) "
				+ "left outer join ubicacion u on (r.id_ubicacion = u.id_ubicacion) "
				+ "left outer join tipo t on (r.id_tipo = t.id_tipo) " + "inner join alumno_programa ap "
				+ "on (ap.cod_alumno = r.cod_alumno) " + "inner join programa p "
				+ "on (ap.id_programa = p.id_programa)" + "left outer join moneda m  " + "on (m.id_moneda = r.moneda) "
				+ "left outer join estado_civil ec on (ap.ecivil_id = ec.ecivil_id) "
				+ "where (c.concepto = ?) and to_tsquery( ? ) @@ to_tsvector(coalesce(ap.cod_alumno,'')) "
				+ "order by c.concepto, r.fecha";

		RowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> rowMapper = new RecaudacionesJOINAlumnoJOINConceptoJOINFacultad_idTipoRecaudacionRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, concepto, nomApe);
	}

	@Override // aqui
	public List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNomApeRecibo(
			String recibo, String nomApe) {

		String sql = "select r.repitencia,  r.id_rec, r.id_alum,rc.estado,  "
				+ "ap.nom_alumno || ' ' || ap.ape_paterno || ' ' || ap.ape_materno as ape_nom, "
				+ "r.ciclo ,c.concepto,c.id_concepto,c.id_tipo_recaudacion,ap.dni_m as dni,r.numero,  "
				+ "f.nombre, m.id_moneda,m.moneda, r.importe, r.fecha, "
				+ "ap.anio_ingreso,p.nom_programa, p.id_programa, " + "p.sigla_programa, r.cod_alumno, r.observacion,  "
				+ "u.descripcion as descripcion_ubi, t.descripcion as descripcion_tipo, r.validado, ec.ecivil_desc as estado_civil "
				+ "from recaudaciones r " + "inner join registro_carga rc " + "on (rc.id_registro = r.id_registro) "
				+ "inner join alumno a  " + "on (a.id_alum = r.id_alum) " + "inner join facultad f "
				+ "on (a.id_facultad = f.id_facultad) " + "inner join concepto c  "
				+ "on (r.id_concepto = c.id_concepto ) "
				+ "left outer join ubicacion u on (r.id_ubicacion = u.id_ubicacion) "
				+ "left outer join tipo t on (r.id_tipo = t.id_tipo) " + "inner join alumno_programa ap "
				+ "on (ap.cod_alumno = r.cod_alumno) " + "inner join programa p "
				+ "on (ap.id_programa = p.id_programa) " + "left outer join moneda m " + "on (m.id_moneda = r.moneda) "
				+ "left outer join estado_civil ec on (ap.ecivil_id = ec.ecivil_id) "
				+ "where (r.numero = ?) and to_tsquery( ? ) @@ to_tsvector(coalesce(ap.cod_alumno,'')) "
				+ "order by c.concepto, r.fecha";

		RowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> rowMapper = new RecaudacionesJOINAlumnoJOINConceptoJOINFacultad_idTipoRecaudacionRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, recibo, nomApe);
	}

	@Override
	public List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByPosgrado() {
		String sql = "select r.repitencia,r.id_rec, r.id_alum, a.ape_nom, "
				+ "c.concepto, r.numero, f.nombre, r.moneda, r.importe, "
				+ "r.fecha, r.id_programa, r.cod_alumno, r.observacion "
				+ "from recaudaciones r, alumno a, facultad f, concepto c " + "where (r.id_alum = a.id_alum) "
				+ "and (r.id_alum = a.id_alum) " + "and (a.id_facultad = f.id_facultad)  "
				+ "and (r.id_concepto = c.id_concepto)  " + "order by c.concepto, r.fecha";

		RowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> rowMapper = new RecaudacionesJOINAlumnoJOINConceptoJOINFacultadRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNombresApellidosStartDateBetween(
			String nombres, String apellidos, Date fechaInicial, Date fechaFinal) {
		String sql = "select r.repitencia,r.id_rec, r.id_alum, a.ape_nom, c.concepto,  "
				+ "r.numero, f.nombre, r.moneda, r.importe, r.fecha, r.id_programa,  " + "r.cod_alumno, r.observacion  "
				+ "from recaudaciones r, alumno a, facultad f, concepto c  " + "where (r.id_alum = a.id_alum)   "
				+ "and (a.id_facultad = f.id_facultad)   " + "and ((a.ape_nom like '%'|| ? ||'%')   "
				+ "and (a.ape_nom like '%'|| ? ||'%'))   " + "and ((r.fecha between ? and ? ) or r.fecha = null)   "
				+ "and (r.id_concepto = c.id_concepto)   " + "order by c.concepto, r.fecha";

		RowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> rowMapper = new RecaudacionesJOINAlumnoJOINConceptoJOINFacultadRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, nombres, apellidos, fechaInicial, fechaFinal);
	}

	@Override
	public List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNombresApellidos(
			String nombres, String apellidos) {
		String sql = "select r.repitencia,r.id_rec, r.id_alum, a.ape_nom, c.concepto,  "
				+ "r.numero, f.nombre, r.moneda, r.importe, r.fecha, r.id_programa,   "
				+ "r.cod_alumno, r.observacion   " + "from recaudaciones r,   " + "alumno a,   " + "facultad f,   "
				+ "concepto c   " + "where (r.id_alum = a.id_alum)   " + "and (a.id_facultad = f.id_facultad)   "
				+ "and ((a.ape_nom like '%'|| ? ||'%')   " + "and (a.ape_nom like '%'|| ? ||'%'))   "
				+ "and (r.id_concepto = c.id_concepto)   " + "order by c.concepto, r.fecha";

		RowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> rowMapper = new RecaudacionesJOINAlumnoJOINConceptoJOINFacultadRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, nombres, apellidos);
	}

	@Override
	public List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNombresApellidosConcepto(
			String concepto, String nombres, String apellidos) {
		String sql = "select r.repitencia,r.id_rec, r.id_alum, a.ape_nom, c.concepto, r.numero,   "
				+ "f.nombre, r.moneda, r.importe, r.fecha, r.id_programa,   " + "r.cod_alumno, r.observacion   "
				+ "from recaudaciones r,   " + "alumno a,   " + "facultad f,   " + "concepto c   "
				+ "where (r.id_alum = a.id_alum)   " + "and (a.id_facultad = f.id_facultad)    "
				+ "and (c.concepto = ? )    " + "and ((a.ape_nom like '%'|| ? ||'%')    "
				+ "and (a.ape_nom like '%'|| ? ||'%'))   " + "and (r.id_concepto = c.id_concepto)   "
				+ "order by c.concepto, r.fecha";

		RowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> rowMapper = new RecaudacionesJOINAlumnoJOINConceptoJOINFacultadRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, concepto, nombres, apellidos);
	}

	@Override
	public List<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> getRecaudacionesJOINAlumnoJOINConceptoJOINFacultadByNombresApellidosRecibo(
			String recibo, String nombres, String apellidos) {
		String sql = "select r.repitencia, r.id_rec, r.id_alum, a.ape_nom, c.concepto,    "
				+ "r.numero, f.nombre, r.moneda, r.importe, r.fecha, r.id_programa,    "
				+ "r.cod_alumno, r.observacion    " + "from recaudaciones r,    " + "alumno a,    " + "facultad f,    "
				+ "concepto c    " + "where (r.id_alum = a.id_alum)    " + "and (a.id_facultad = f.id_facultad)    "
				+ "and (r.numero = ? )    " + "and ((a.ape_nom like '%'|| ? ||'%')    "
				+ "and (a.ape_nom like '%'|| ? ||'%'))    " + "and (r.id_concepto = c.id_concepto)    "
				+ "order by c.concepto, r.fecha";

		RowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> rowMapper = new RecaudacionesJOINAlumnoJOINConceptoJOINFacultadRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, recibo, nombres, apellidos);
	}

	@Override
	public int updateRecaudacionesJOINAlumnoJOINConceptoJOINFacultad(
			RecaudacionesJOINAlumnoJOINConceptoJOINFacultad recaudaciones) {
		String sql = "UPDATE recaudaciones SET id_programa = ?, cod_alumno = ? WHERE id_rec = ?";
		return jdbcTemplate.update(sql, recaudaciones.getIdPrograma(), recaudaciones.getCodAlumno(),
				recaudaciones.getIdRec());
	}

	@Override
	public int updateRecaudacionesCodAlumno(Integer id_rec, String cod_alumno) {
		String sql = "UPDATE recaudaciones SET cod_alumno = ? WHERE id_rec = ?";
		return jdbcTemplate.update(sql, cod_alumno, id_rec);
	}

	@Override
	public void deleteRecaudacionesJOINAlumnoJOINConceptoJOINFacultad(int idRecaudaciones) {
		String sql = "DELETE FROM recaudaciones WHERE id_rec = ?";
		jdbcTemplate.update(sql, idRecaudaciones);
	}

	@Override
	public boolean updateRecaudacionesJOINAlumnoJOINConceptoJOINFacultad(Integer id_concepto, String moneda, Date fecha,
			String numero, int ciclo, int idRec, Double importe, String ubicacion, String ctabanco, Boolean validado,
			String repitencia, Integer id_tipo_recaudacion) {
		boolean validar = false;
		logger.info("Facultad DAO validado " + validado);
		if (validado)
			validar = true;
		else
			validar = false;

		logger.info("Facultad DAO " + fecha + " " + " " + numero + " " + idRec);
		String sql = "UPDATE recaudaciones SET id_concepto=?,moneda=?,fecha = ?, numero = ?,ciclo=?, importe=?, id_ubicacion = (select id_ubicacion from ubicacion where descripcion = ?), id_tipo = (select id_tipo from tipo where descripcion = ?), validado = ? , repitencia = ?, id_tipo_recaudacion=? WHERE id_rec = ?";
		logger.info("Facultad DAO " + sql);
		Integer resp = jdbcTemplate.update(sql, id_concepto, moneda, fecha, numero, ciclo, importe, ubicacion, ctabanco,
				validar, repitencia, id_tipo_recaudacion, idRec);

		if (resp.equals(1)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean insertObservacion(String observacion, Integer idrec) {
		String sql = "update recaudaciones set observacion_upg = ? where id_rec = ?";
		Integer resp = jdbcTemplate.update(sql, observacion, idrec);
		logger.info("resp :" + resp);
		if (resp.equals(1)) {
			return true;
		} else {
			return false;
		}
	}

	public int updateAlumnoEstadoCivil(String codigo, String estado_civil) {
		/*
		 * "Casado              " "Soltero             " "Divorciado          "
		 * "Viudo               " "Separado            " "Conviviente         "
		 * "Fallecido           "
		 */

		String estado = estado_civil;
		if (estado == "casado") {
			estado_id = 1;
		}
		switch (estado) {
		case "casado":
			estado_id = 1;
			break;
		case "soltero":
			estado_id = 2;
			break;
		case "divorsiado":
			estado_id = 3;
			break;
		case "viudo":
			estado_id = 4;
			break;
		case "separado":
			estado_id = 5;
			break;
		case "conviviente":
			estado_id = 6;
			break;
		case "fallecido":
			estado_id = 7;
			break;
		case "ninguno":
			estado_id = 0;
			break;
		}

		String sql = "update alumno_programa " + "set ecivil_id = ? where cod_alumno= ?";

		return this.jdbcTemplate.update(sql, estado_id, codigo);

	}

	public int updateId_Programa(Integer idprograma, String codigo) {
		if (idprograma == 0)
			idprograma = null;
		String sql = "update alumno_programa set id_programa_presupuesto = ? where cod_alumno= ?";

		return this.jdbcTemplate.update(sql, idprograma, codigo);
	}

}
