package com.ynov.tournaments.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.tournaments.model.Gamer;
import com.ynov.tournaments.service.GamerService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Gamer", description = "Gamer Controller APIs")
public class GamerController {
	
	@Autowired
	private GamerService gamerService;
	
	@GetMapping("/gamers")
	public ResponseEntity<Iterable<Gamer>> getGamers() {
	    Iterable<Gamer> gamers = gamerService.getGamers();
	    
	    return ResponseEntity.status(HttpStatus.OK).body(gamers);
	}
	
	@GetMapping("/gamer/{id}")
	public ResponseEntity<Gamer> getGamer(@PathVariable("id") Integer id) {
			Optional<Gamer> p = gamerService.getGamer(id);
			if(p.isPresent()) {
				return new ResponseEntity<Gamer>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Gamer>(HttpStatus.NOT_FOUND);
	}

}
