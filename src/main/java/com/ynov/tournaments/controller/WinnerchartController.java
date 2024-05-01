package com.ynov.tournaments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.tournaments.model.Winnerchart;
import com.ynov.tournaments.service.WinnerchartService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Winnerchart", description = "Winnerchart Controller APIs")
public class WinnerchartController {

	@Autowired
	private WinnerchartService winnerchartService;
	
	@GetMapping("/winnercharts")
	public ResponseEntity<Iterable<Winnerchart>> getWinnercharts() {
	    Iterable<Winnerchart> winnercharts = winnerchartService.getWinnercharts();
	    
	    return ResponseEntity.status(HttpStatus.OK).body(winnercharts);
	}

}
