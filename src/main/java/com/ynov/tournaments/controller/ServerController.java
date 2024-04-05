package com.ynov.tournaments.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ServerController {
	
	@GetMapping("/")
	public String getServer() {
		return "Server works!";
	}

}
