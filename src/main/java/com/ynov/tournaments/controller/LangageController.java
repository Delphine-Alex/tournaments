package com.ynov.tournaments.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<Iterable<Langage>> getLangages() {
	    Iterable<Langage> langages = langageService.getLangages();
	    
	    return ResponseEntity.status(HttpStatus.OK).body(langages);
	}

	@GetMapping("/langage/{id}")
	public ResponseEntity<Langage> getLangage(@PathVariable("id") Integer id) {
			Optional<Langage> p = langageService.getLangage(id);
			if(p.isPresent()) {
				return new ResponseEntity<Langage>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Langage>(HttpStatus.NOT_FOUND);
	}
}
