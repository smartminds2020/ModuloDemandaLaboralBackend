package edu.moduloalumno.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.IAreaDAO;
import edu.moduloalumno.entity.Area;
import edu.moduloalumno.rowmapper.AreaRowMapper;

@Transactional
@Repository
public class AreaDAOImpl implements IAreaDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Area> getAllAreas() {
		String sql = "SELECT area_id, area_desc, area_desc_min FROM public.area";
		
		RowMapper<Area> rowMapper = new AreaRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

}