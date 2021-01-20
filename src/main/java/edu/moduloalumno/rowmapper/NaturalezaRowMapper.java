package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.Naturaleza;

public class NaturalezaRowMapper implements RowMapper<Naturaleza> {
	@Override
	public Naturaleza mapRow(ResultSet row, int rowNum) throws SQLException {
		Naturaleza naturaleza = new Naturaleza();
		naturaleza.setId_naturaleza(row.getInt("id_naturaleza"));
		naturaleza.setNaturaleza_desc(row.getString("naturaleza_desc"));
		naturaleza.setNaturaleza_desc_min(row.getString("naturaleza_desc_min"));
		return naturaleza;
	}
}