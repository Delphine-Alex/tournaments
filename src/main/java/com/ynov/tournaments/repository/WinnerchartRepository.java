package com.ynov.tournaments.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.tournaments.model.Winnerchart;

@Repository
public interface WinnerchartRepository extends CrudRepository<Winnerchart, Integer> {

}
