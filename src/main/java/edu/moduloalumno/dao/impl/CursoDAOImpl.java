package edu.moduloalumno.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.ICursoDAO;
import edu.moduloalumno.entity.Curso;
import edu.moduloalumno.rowmapper.CursoRowMapper;

@Transactional
@Repository
public class CursoDAOImpl implements ICursoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Curso getCursoById(int idCurso) {
		try {
			String sql = "SELECT id_curso, nom_curso, id_programa, numciclo, numcreditaje, tipocurso, planestudios, cod_asignatura FROM curso WHERE id_curso = ?";
			RowMapper<Curso> rowMapper = new BeanPropertyRowMapper<Curso>(Curso.class);
			Curso curso = jdbcTemplate.queryForObject(sql, rowMapper, idCurso);
			return curso;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Curso> getCursosByIdPrograma(int idPrograma) {
		try {
			String sql = "SELECT id_curso, nom_curso, id_programa, numciclo, numcreditaje, tipocurso, planestudios, cod_asignatura FROM curso WHERE id_programa = ?";
			RowMapper<Curso> rowMapper = new CursoRowMapper();
			List<Curso> cursos = jdbcTemplate.query(sql, rowMapper, idPrograma);
			return cursos;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Curso> getCursosByIdProgramaAndPlanEstudio(int idPrograma, String planEstudio) {
		try {
			String sql = "SELECT id_curso, nom_curso, id_programa, numciclo, numcreditaje, tipocurso, planestudios, cod_asignatura FROM curso WHERE id_programa = ? AND planestudios = ?";
			RowMapper<Curso> rowMapper = new CursoRowMapper();
			List<Curso> cursos = jdbcTemplate.query(sql, rowMapper, idPrograma, planEstudio);
			return cursos;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Curso> getCursosByIdProgramaAndPlanEstudioAndAreaAndAreaAndNaturaleza(Integer idPrograma,
			String planestudio, Integer area, Integer naturaleza) {
		try {
			String sql = "SELECT c.id_curso, c.nom_curso, c.id_programa, c.numciclo, c.numcreditaje, c.tipocurso, c.planestudios,\n" + 
					"c.cod_asignatura\n" + 
					"	FROM curso c, area_curso ac, area a, naturaleza n, naturaleza_curso nc\n" + 
					"	WHERE\n" + 
					"		c.id_curso = ac.id_curso and\n" + 
					"		ac.area_id = a.area_id and\n" + 
					"		c.id_curso = nc.id_curso and\n" + 
					"		nc.id_naturaleza = n.id_naturaleza and\n" + 
					"		a.area_id = ? and\n" + 
					"		n.id_naturaleza = ? and\n" + 
					"		c.id_programa = ? and\n" + 
					"		c.planestudios = ?;";
			RowMapper<Curso> rowMapper = new CursoRowMapper();
			List<Curso> cursos = jdbcTemplate.query(sql, rowMapper, area, naturaleza,idPrograma, planestudio);
			return cursos;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Curso> getCursosByIdProgramaAndPlanEstudioAndArea(Integer idPrograma, String planestudio,
			Integer area) {
		try {
			String sql = "SELECT c.id_curso, c.nom_curso, c.id_programa, c.numciclo, c.numcreditaje, c.tipocurso, c.planestudios,\n" + 
					"c.cod_asignatura\n" + 
					"	FROM curso c, area_curso ac, area a\n" + 
					"	WHERE\n" + 
					"		c.id_curso = ac.id_curso and\n" + 
					"		ac.area_id = a.area_id and\n" + 
					"		a.area_id = ? and\n" + 
					"		c.id_programa = ? and\n" + 
					"		c.planestudios = ?;";
			RowMapper<Curso> rowMapper = new CursoRowMapper();
			List<Curso> cursos = jdbcTemplate.query(sql, rowMapper, area, idPrograma, planestudio);
			return cursos;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Curso> getCursosByIdProgramaAndPlanEstudioAndNaturaleza(Integer idPrograma, String planestudio,
			Integer naturaleza) {
		try {
			String sql = "SELECT c.id_curso, c.nom_curso, c.id_programa, c.numciclo, c.numcreditaje, c.tipocurso, c.planestudios,\n" + 
					"c.cod_asignatura\n" + 
					"	FROM curso c, naturaleza n, naturaleza_curso nc\n" + 
					"	WHERE\n" + 
					"		c.id_curso = nc.id_curso and\n" + 
					"		nc.id_naturaleza = n.id_naturaleza and\n" + 
					"		n.id_naturaleza = ? and\n" + 
					"		c.id_programa = ? and\n" + 
					"		c.planestudios = ?;";
			RowMapper<Curso> rowMapper = new CursoRowMapper();
			List<Curso> cursos = jdbcTemplate.query(sql, rowMapper, naturaleza, idPrograma, planestudio);
			return cursos;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}