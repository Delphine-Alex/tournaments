package com.ynov.tournaments.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ynov.tournaments.model.Winnerchart;

@Repository
public interface WinnerchartRepository extends JpaRepository<Winnerchart, Integer> {

	Page<Winnerchart> findAll(Pageable pageable);
}
