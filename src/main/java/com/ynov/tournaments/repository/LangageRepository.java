package com.ynov.tournaments.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.tournaments.model.Langage;

@Repository
public interface LangageRepository extends CrudRepository<Langage, Integer> {

}
