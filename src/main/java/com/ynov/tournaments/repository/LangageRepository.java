package com.ynov.tournaments.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ynov.tournaments.model.Langage;

@Repository
public interface LangageRepository extends JpaRepository<Langage, Integer> {
	
	Page<Langage> findAll(Pageable pageable);
	
	Page<Langage> findAllByName(Pageable pageable, String name);

}
