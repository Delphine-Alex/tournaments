package com.ynov.tournaments.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.tournaments.model.Gamer;

@Repository
public interface GamerRepository extends CrudRepository<Gamer, Integer>{
	
	Page<Gamer> findAll(Pageable pageable);
	
	Page<Gamer> findAllByPseudo(Pageable pageable, String pseudo);

}
