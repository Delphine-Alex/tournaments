package com.ynov.tournaments.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tournaments")
public class Tournament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tournament")
	private Integer id_tournament;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "id_game")
	private Integer id_game;
	
	@Column(name = "id_langage")
	private Integer id_langage;
	
	
	// Getters and setters

	
	public Integer getId_tournament() {
		return id_tournament;
	}

	public void setId_tournament(Integer id_tournament) {
		this.id_tournament = id_tournament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId_game() {
		return id_game;
	}

	public void setId_game(Integer id_game) {
		this.id_game = id_game;
	}

	public Integer getId_langage() {
		return id_langage;
	}

	public void setId_langage(Integer id_langage) {
		this.id_langage = id_langage;
	}

	

}
