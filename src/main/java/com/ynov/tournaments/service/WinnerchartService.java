package com.ynov.tournaments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ynov.tournaments.model.Winnerchart;
import com.ynov.tournaments.repository.WinnerchartRepository;

@Service
public class WinnerchartService {

	@Autowired
	private WinnerchartRepository winnerchartRepository;
	
	public Page<Winnerchart> getWinnercharts(Pageable pageable){
		return winnerchartRepository.findAll(pageable);
	}
	
	public Winnerchart upsertWinnerchart(Winnerchart winnerchart) {
		return winnerchartRepository.save(winnerchart);
	}

	
}
