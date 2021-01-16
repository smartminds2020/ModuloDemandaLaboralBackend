/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moduloalumno.rowmapper;

import edu.moduloalumno.entity.Curriculo;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author pc
 * curriculo_id, id_programa, estado_id, curriculo_desc, curriculo_ultimo, tcurriculo_id
 */
public class CurriculoRowMapper implements RowMapper<Curriculo>{
    @Override
	public Curriculo mapRow(ResultSet row, int rowNum) throws SQLException {
		Curriculo curriculo = new Curriculo();
		curriculo.setCurriculo_id(row.getInt("curriculo_id"));
		curriculo.setId_programa(row.getInt("id_programa"));
		curriculo.setEstado_id(row.getInt("estado_id"));
		curriculo.setCurriculo_desc(row.getString("curriculo_desc"));
		curriculo.setCurriculo_ultimo(row.getString("curriculo_ultimo"));
                curriculo.setTcurriculo_id(row.getInt("tcurriculo_id"));
		return curriculo;
	}
}
