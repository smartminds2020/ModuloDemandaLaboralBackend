package edu.moduloalumno.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.Curso;
import edu.moduloalumno.service.ICursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICursoService service;
	
	@RequestMapping(value = "{idAlum}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Curso> getCursoById(@PathVariable("idAlum") Integer idAlum) {
		logger.info("> getCursoById [Curso]");

		Curso alu = null;
		try {
			alu = service.getCursoById(idAlum);

			if (alu == null) {
				alu = new Curso();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Curso>(alu, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getCursoById [Curso]");
		return new ResponseEntity<Curso>(alu, HttpStatus.OK);
	}
	
	@RequestMapping(value = "programa/{idPrograma}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curso>> getCursosByIdPrograma(@PathVariable("idPrograma") Integer idPrograma) {
		logger.info("> getCursosByIdPrograma [Cursos]");

		List<Curso> list = null;

		try {
			list = service.getCursosByIdPrograma(idPrograma);
			
			if (list == null) {
				list = new ArrayList<Curso>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Curso>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		logger.info("< getCursoIdByNombresApellidos [Curso]");
		return new ResponseEntity<List<Curso>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "programa/{idPrograma}/planestudio/{planestudio}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curso>> getCursosByIdProgramaAndPlanEstudio(@PathVariable("idPrograma") Integer idPrograma, @PathVariable("planestudio") String planestudio) {
		logger.info("> getCursosByIdProgramaAndPlanEstudio [Cursos]");

		List<Curso> list = null;

		try {
			list = service.getCursosByIdProgramaAndPlanEstudio(idPrograma, planestudio);
			
			if (list == null) {
				list = new ArrayList<Curso>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Curso>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		logger.info("< getCursoIdByNombresApellidos [Curso]");
		return new ResponseEntity<List<Curso>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "programa/{idPrograma}/planestudio/{planestudio}/area/{area}/naturaleza/{naturaleza}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curso>> getCursosByIdProgramaAndPlanEstudioAndAreaAndAreaAndNaturaleza(@PathVariable("idPrograma") Integer idPrograma, @PathVariable("planestudio") String planestudio, @PathVariable("area") Integer area, @PathVariable("naturaleza") Integer naturaleza) {
		logger.info("> getCursosByIdProgramaAndPlanEstudioAndAreaAndAreaAndNaturaleza [Cursos]");

		List<Curso> list = null;

		try {
			list = service.getCursosByIdProgramaAndPlanEstudioAndAreaAndAreaAndNaturaleza(idPrograma, planestudio, area, naturaleza);
			
			if (list == null) {
				list = new ArrayList<Curso>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Curso>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		logger.info("< getCursosByIdProgramaAndPlanEstudioAndAreaAndAreaAndNaturaleza [Cursos]");
		return new ResponseEntity<List<Curso>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "programa/{idPrograma}/planestudio/{planestudio}/area/{area}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curso>> getCursosByIdProgramaAndPlanEstudioAndArea(@PathVariable("idPrograma") Integer idPrograma, @PathVariable("planestudio") String planestudio, @PathVariable("area") Integer area) {
		logger.info("> getCursosByIdProgramaAndPlanEstudioAndArea [Cursos]");

		List<Curso> list = null;

		try {
			list = service.getCursosByIdProgramaAndPlanEstudioAndArea(idPrograma, planestudio, area);
			
			if (list == null) {
				list = new ArrayList<Curso>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Curso>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		logger.info("< getCursosByIdProgramaAndPlanEstudioAndArea [Curso]");
		return new ResponseEntity<List<Curso>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "programa/{idPrograma}/planestudio/{planestudio}/naturaleza/{naturaleza}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curso>> getCursosByIdProgramaAndPlanEstudioAndNaturaleza(@PathVariable("idPrograma") Integer idPrograma, @PathVariable("planestudio") String planestudio, @PathVariable("naturaleza") Integer naturaleza) {
		logger.info("> getCursosByIdProgramaAndPlanEstudioAndNaturaleza [Cursos]");

		List<Curso> list = null;

		try {
			list = service.getCursosByIdProgramaAndPlanEstudioAndNaturaleza(idPrograma, planestudio, naturaleza);
			
			if (list == null) {
				list = new ArrayList<Curso>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Curso>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		logger.info("< getCursosByIdProgramaAndPlanEstudioAndNaturaleza [Curso]");
		return new ResponseEntity<List<Curso>>(list, HttpStatus.OK);
	}
}
