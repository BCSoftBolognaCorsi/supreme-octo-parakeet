package net.bcsoft.corsi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import net.bcsoft.corsi.db.config.Connection;
import net.bcsoft.corsi.models.Utente;
import net.bcsoft.corsi.service.Dto2ModelService;

public class UtenteDao {
	
	public UtenteDao() {};

	public static void insertUtente(Utente utente) throws SQLException {
		String queryInsert = "INSERT INTO utenti (nome, email, eta, linguaggi) VALUES(?, ?, ?, ?);";
		Integer id = -1;
		ArrayList<Object> parameterList = new ArrayList<>();
		parameterList.add(utente.getNome());
		parameterList.add(utente.getEmail());
		parameterList.add(utente.getEta());
		parameterList.add(utente.getLinguaggi().stream().collect(Collectors.joining(",")));

		Connection con = new Connection("root", "root", "help_desk");
		con.connect();
		con.preparedStatement(queryInsert, parameterList);
		try(ResultSet rs = con.query("SELECT MAX(id) FROM utenti;")) {
			if(rs.next())
				id = rs.getInt(1);
		} 
		
		
		utente.setId(Long.valueOf(id));
		con.disconnect();
		
		
		
	}
	
	public static void updateUtente(Utente utente) throws SQLException {
		String queryUpdate = "UPDATE utenti SET nome=?, email=?, eta=?, linguaggi=? WHERE id=?";
		ArrayList<Object> parameterList = new ArrayList<>();
		parameterList.add(utente.getNome());
		parameterList.add(utente.getEmail());
		parameterList.add(utente.getEta());
		parameterList.add(utente.getLinguaggi().stream().collect(Collectors.joining(",")));
		parameterList.add(utente.getId());

		Connection con = new Connection("root", "root", "help_desk");
		con.connect();
		con.preparedStatement(queryUpdate, parameterList);
		con.disconnect();
		
		
		
	}
	
	
	public List<Utente>  getUtenti() throws SQLException {
		String querySelect = "SELECT * FROM utenti ORDER BY nome;";
		List<Utente> result = new ArrayList<>();

		Connection con = new Connection("root", "root", "help_desk");
		con.connect();
		try(ResultSet rs = con.query(querySelect)) {
			while(rs.next()) {
				Integer id = rs.getInt(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				Integer eta = rs.getInt(4);
				String linguaggi = rs.getString(5);
				result.add(Dto2ModelService.createModel(id, nome, email, eta, linguaggi));
			}
				
		} 
		con.disconnect();
		
		return result;
		
		
	}
	

}
