package com.ynov.tournaments.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.tournaments.model.Tournament;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Integer> {

}
