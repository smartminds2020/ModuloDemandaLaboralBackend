/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moduloalumno.rowmapper;

import edu.moduloalumno.entity.PerfilEgreso;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author pc
 */
public class perfilEgresoRowMapper implements RowMapper<PerfilEgreso>{
     @Override
	public PerfilEgreso mapRow(ResultSet row, int rowNum) throws SQLException {
		PerfilEgreso perfilEgreso = new PerfilEgreso();
		perfilEgreso.setPerfilegreso_id(row.getInt("perfilegreso_id"));
		perfilEgreso.setEstado_id(row.getInt("estado_id"));
		perfilEgreso.setCurriculo_id(row.getInt("curriculo_id"));
		perfilEgreso.setPerfilegreso_desc(row.getString("perfilegreso_desc"));
                perfilEgreso.setPerfilegreso_norden(row.getInt("perfilegreso_norden"));
		return perfilEgreso;
	}
}
