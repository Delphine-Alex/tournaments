package com.ynov.tournaments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.tournaments.model.Tournament;
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
	public ResponseEntity<Page<Winnerchart>> getWinnercharts(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int pageSize
		) {
			Pageable pageable = PageRequest.of(page, pageSize);
			Page<Winnerchart> winnerchartsPage = winnerchartService.getWinnercharts(pageable);
		    
			if(winnerchartsPage.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(winnerchartsPage, HttpStatus.OK);
			}
	}
	
	@PostMapping("/winnercharts")
	public ResponseEntity<Winnerchart> createWinnerchart(@RequestBody Winnerchart winnerchart) {
		Winnerchart createWinnerchart = winnerchartService.upsertWinnerchart(winnerchart);
	    return ResponseEntity.status(HttpStatus.CREATED).body(createWinnerchart);
	}

}
