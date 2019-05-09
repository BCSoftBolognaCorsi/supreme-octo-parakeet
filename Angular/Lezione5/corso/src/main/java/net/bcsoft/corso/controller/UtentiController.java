package net.bcsoft.corso.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.bcsoft.corso.entity.Utente;
import net.bcsoft.corso.service.UtentiService;

@RestController()
public class UtentiController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	UtentiService service;
	
	@GetMapping("/utenti")
	public ResponseEntity<List<Utente>> getUtenti() {
		logger.info("getUtenti: IN");
		try {
			List<Utente> result = service.getUtentiList();
			return new ResponseEntity<List<Utente>>(result, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("getUtenti {}", e.getLocalizedMessage());
			return new ResponseEntity<List<Utente>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/utente")
	public ResponseEntity<Utente> postUtente(@RequestBody() Utente request) {
		try {
			Utente result = service.insertUtente(request);
			
			return new ResponseEntity<Utente>(result, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("getUtenti {}", e.getLocalizedMessage());
			return new ResponseEntity<Utente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/utente/{id}")
	public ResponseEntity<Utente> postUtente(@RequestBody() Utente request, @PathParam("id") Long id) {
		try {
			Utente result = service.updateUtente(id, request);
			
			return new ResponseEntity<Utente>(result, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("getUtenti {}", e.getLocalizedMessage());
			return new ResponseEntity<Utente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/utente/{id}")
	public ResponseEntity<Utente> postUtente(@PathParam("id") Long id) {
		try {
			Utente result = service.deleteUtente(id);
			
			return new ResponseEntity<Utente>(result, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("getUtenti {}", e.getLocalizedMessage());
			return new ResponseEntity<Utente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
