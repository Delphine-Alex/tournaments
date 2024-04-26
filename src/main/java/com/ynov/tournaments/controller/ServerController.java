package com.ynov.tournaments.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Server", description = "Server APIs")
public class ServerController {
	
	@GetMapping("/")
	public String getServer() {
		return "Server works for Tournaments API!";
	}

}
