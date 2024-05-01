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

import com.ynov.tournaments.model.Langage;
import com.ynov.tournaments.service.LangageService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Langage", description = "Langage Controller APIs")
public class LangageController {

	@Autowired
	private LangageService langageService;
	
	@GetMapping("/langages")
	public ResponseEntity<Page<Langage>> getLangages(
		@RequestParam(defaultValue = "0") int page,
		@RequestParam(defaultValue = "10") int pageSize,
		@RequestParam(required = false) String name
	) {
		Pageable pageable = PageRequest.of(page, pageSize);
		Page<Langage> langagesPage = langageService.getLangages(pageable, name);
	    
		if(langagesPage.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(langagesPage, HttpStatus.OK);
		}
	}

	@GetMapping("/langage/{id}")
	public ResponseEntity<Langage> getLangage(@PathVariable("id") Integer id) {
			Optional<Langage> p = langageService.getLangage(id);
			if(p.isPresent()) {
				return new ResponseEntity<Langage>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Langage>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/langages")
	public ResponseEntity<Langage> createLangage(@RequestBody Langage langage) {
		Langage createLangage = langageService.upsertLangage(langage);
	    return ResponseEntity.status(HttpStatus.CREATED).body(createLangage);
	}
	
	@PutMapping("/langage/{id}")
	public ResponseEntity<Langage> updateLangage(@PathVariable("id") Integer id, @RequestBody Langage langage) {
		
	    Optional<Langage> existingLangage = langageService.getLangage(id);
	    if (existingLangage.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    langage.setId_langage(id);
	    Langage updateLangage = langageService.upsertLangage(langage);
	    
	    return ResponseEntity.status(HttpStatus.OK).body(updateLangage);
	}
	
	@DeleteMapping("/langage/{id}")
	public ResponseEntity<Langage> deleteLangage(@PathVariable("id") Integer id) {
		langageService.deleteLangage(id);
	    
	    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
