package com.ynov.tournaments.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ynov.tournaments.model.Gamer;

@Repository
public interface GamerRepository extends CrudRepository<Gamer, Integer>{
	
	Page<Gamer> findAll(Pageable pageable);
	
	Page<Gamer> findAllByPseudo(Pageable pageable, String pseudo);
	
    @Query("SELECT g FROM Gamer g JOIN Winnerchart w ON g.id_gamer = w.id_winnerchart.id_gamer WHERE w.ranking = :ranking")
    Page<Gamer> findByRanking(@Param("ranking") Integer ranking, Pageable pageable);
	
}

