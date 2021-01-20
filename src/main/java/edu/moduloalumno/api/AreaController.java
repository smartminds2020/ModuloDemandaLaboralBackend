package edu.moduloalumno.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.Area;
import edu.moduloalumno.service.IAreaService;

@RestController
@RequestMapping("/area")
public class AreaController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IAreaService service;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Area>> getAllAreas() {
		logger.info("> getAllAreas [List<Area>]");

		List<Area> list = null;

		try {
			list = service.getAllAreas();
			
			if (list == null) {
				list = new ArrayList<Area>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Area>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		logger.info("< getAllAreas [List<Area>]");
		return new ResponseEntity<List<Area>>(list, HttpStatus.OK);
	}

}
