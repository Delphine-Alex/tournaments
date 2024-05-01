package com.ynov.tournaments.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ynov.tournaments.model.Tournament;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
	
	Page<Tournament> findAll(Pageable pageable);
	
	Page<Tournament> findAllByIdLangage(Pageable pageable, Integer idLangage);
	
	Page<Tournament> findAllByName(Pageable pageable, String name);

}
