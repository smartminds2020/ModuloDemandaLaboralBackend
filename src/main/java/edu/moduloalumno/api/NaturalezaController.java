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

import edu.moduloalumno.entity.Naturaleza;
import edu.moduloalumno.service.INaturalezaService;

@RestController
@RequestMapping("/naturaleza")
public class NaturalezaController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private INaturalezaService service;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Naturaleza>> getAllNaturalezas() {
		logger.info("> getAllNaturalezas [List<Naturaleza>]");

		List<Naturaleza> list = null;

		try {
			list = service.getAllNaturalezas();
			
			if (list == null) {
				list = new ArrayList<Naturaleza>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Naturaleza>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		logger.info("< getAllNaturalezas [List<Naturaleza>]");
		return new ResponseEntity<List<Naturaleza>>(list, HttpStatus.OK);
	}

}
