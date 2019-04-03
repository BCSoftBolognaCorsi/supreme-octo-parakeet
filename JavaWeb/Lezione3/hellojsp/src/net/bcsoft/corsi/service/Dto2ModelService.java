package net.bcsoft.corsi.service;

import java.util.Arrays;
import java.util.List;

import net.bcsoft.corsi.models.Utente;

public class Dto2ModelService {
	
	public static Utente createModel (String id, String nome, String email, String eta, List<String> linguaggi) {
		Integer etaNumber = Integer.valueOf(eta);
		Long idNumber = null;
		try {
		 idNumber = Long.valueOf(id);
		} catch(Exception e) {
			
		}
		return new Utente( idNumber, nome, email, etaNumber, linguaggi);
	}
	
	public static Utente createModel (Integer id, String nome, String email, Integer eta,  String linguaggi) {
		return new Utente( Long.valueOf(id), nome, email, eta, Arrays.asList(linguaggi.split(",")));
	}

}
