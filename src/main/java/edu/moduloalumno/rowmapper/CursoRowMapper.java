package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.Curso;
import edu.moduloalumno.entity.Programa;

public class CursoRowMapper implements RowMapper<Curso> {

	@Override
	public Curso mapRow(ResultSet row, int rowNum) throws SQLException {
		Curso curso = new Curso();
		curso.setIdCurso(row.getInt("id_curso"));
		curso.setNomCurso(row.getString("nom_curso"));
		curso.setIdPrograma(new Programa(row.getInt("id_programa")));
		curso.setNumciclo(row.getString("numciclo"));
		curso.setNumcreditaje(row.getString("numcreditaje"));
		curso.setTipocurso(row.getString("tipocurso").charAt(0));
		curso.setPlanestudios(row.getString("planestudios"));
		curso.setCodAsignatura(row.getString("cod_asignatura"));
		return curso;
	}
	
}