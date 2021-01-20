package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.Area;

public class AreaRowMapper implements RowMapper<Area> {
	@Override
	public Area mapRow(ResultSet row, int rowNum) throws SQLException {
		Area area = new Area();
		area.setArea_id(row.getInt("area_id"));
		area.setArea_desc(row.getString("area_desc"));
		area.setArea_desc_min(row.getString("area_desc_min"));
		return area;
	}
}