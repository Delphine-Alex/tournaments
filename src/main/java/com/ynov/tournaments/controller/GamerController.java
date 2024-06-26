package com.ynov.tournaments.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Page<Gamer>> getGamers(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(required = false) String pseudo,
			@RequestParam(required = false) Integer ranking

		) {
			Pageable pageable = PageRequest.of(page, pageSize);
			Page<Gamer> gamersPage = gamerService.getGamers(pageable, pseudo, ranking);
		    
			if(gamersPage.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(gamersPage, HttpStatus.OK);
			}
		}
	
	@GetMapping("/gamer/{id}")
	public ResponseEntity<Gamer> getGamer(@PathVariable("id") Integer id) {
			Optional<Gamer> p = gamerService.getGamer(id);
			if(p.isPresent()) {
				return new ResponseEntity<Gamer>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Gamer>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/gamers")
	public ResponseEntity<Gamer> createGamer(@RequestBody Gamer gamer) {
		Gamer createGamer = gamerService.upsertGamer(gamer);
	    return ResponseEntity.status(HttpStatus.CREATED).body(createGamer);
	}
	
	@PutMapping("/gamer/{id}")
	public ResponseEntity<Gamer> updateGamer(@PathVariable("id") Integer id, @RequestBody Gamer gamer) {
		
	    Optional<Gamer> existingGamer = gamerService.getGamer(id);
	    if (existingGamer.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    gamer.setId_gamer(id);
	    Gamer updateGamer = gamerService.upsertGamer(gamer);
	    
	    return ResponseEntity.status(HttpStatus.OK).body(updateGamer);
	}
	
	@DeleteMapping("/gamer/{id}")
	public ResponseEntity<Gamer> deleteGamer(@PathVariable("id") Integer id) {
		gamerService.deleteGamer(id);
	    
	    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
