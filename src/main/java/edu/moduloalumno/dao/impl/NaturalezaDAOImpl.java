package edu.moduloalumno.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.INaturalezaDAO;
import edu.moduloalumno.entity.Naturaleza;
import edu.moduloalumno.rowmapper.NaturalezaRowMapper;

@Transactional
@Repository
public class NaturalezaDAOImpl implements INaturalezaDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Naturaleza> getAllNaturalezas() {
		String sql = "SELECT id_naturaleza, naturaleza_desc, naturaleza_desc_min FROM public.naturaleza";
		
		RowMapper<Naturaleza> rowMapper = new NaturalezaRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

}