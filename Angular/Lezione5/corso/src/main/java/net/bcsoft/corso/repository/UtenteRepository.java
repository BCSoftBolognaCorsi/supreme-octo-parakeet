package net.bcsoft.corso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.bcsoft.corso.entity.Utente;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Long>{

}
