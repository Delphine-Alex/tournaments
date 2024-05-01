package com.ynov.tournaments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.tournaments.model.Winnerchart;
import com.ynov.tournaments.repository.WinnerchartRepository;

@Service
public class WinnerchartService {

	@Autowired
	private WinnerchartRepository winnerchartRepository;
	
	public Iterable<Winnerchart> getWinnercharts(){
		return winnerchartRepository.findAll();
	}
	
}
