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
//		try {
//			String sql = "SELECT id_curso, nom_curso, id_programa, numciclo, numcreditaje, tipocurso, planestudios, cod_asignatura FROM curso WHERE id_programa = ? AND planestudio = ?";
//			RowMapper<Curso> rowMapper = new CursoRowMapper();
//			List<Curso> cursos = jdbcTemplate.query(sql, rowMapper, idPrograma, planEstudio);
//			return cursos;
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
		String sql = "SELECT id_curso, nom_curso, id_programa, numciclo, numcreditaje, tipocurso, planestudios, cod_asignatura FROM curso WHERE id_programa = ? AND planestudios = ?";
		RowMapper<Curso> rowMapper = new CursoRowMapper();
		List<Curso> cursos = jdbcTemplate.query(sql, rowMapper, idPrograma, planEstudio);
		return cursos;
	}

}