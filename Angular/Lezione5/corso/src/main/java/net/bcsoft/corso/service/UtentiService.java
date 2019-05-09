package net.bcsoft.corso.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bcsoft.corso.entity.Utente;
import net.bcsoft.corso.repository.UtenteRepository;

@Service
@Transactional
public class UtentiService {
	
	@Autowired
	UtenteRepository utenteRepository;
	
	public List<Utente> getUtentiList() {
		List<Utente> result =  StreamSupport.stream(utenteRepository.findAll().spliterator(), false).collect(Collectors.toList());
		return result;
	}
	
	public Utente insertUtente(Utente utente) {
		return utenteRepository.save(utente);
	}
	
	public Utente updateUtente(Long id, Utente target) {
		Utente utente = utenteRepository.findById(id).orElse(null);
		if(utente != null)
			throw new NoSuchElementException("Utente non trovato");
		
		return utenteRepository.save(target);
	}
	
	public Utente deleteUtente (Long id) {
		Utente utente = utenteRepository.findById(id).orElse(null);
		if(utente != null)
			throw new NoSuchElementException("Utente non trovato");
		
		utenteRepository.delete(utente);
		return utente;
	}

}
