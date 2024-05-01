package com.ynov.tournaments.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class WinnerchartId implements Serializable {

    @Column(name = "id_tournament", insertable = false, updatable = false)
    private Integer id_tournament;

    @Column(name = "id_gamer", insertable = false, updatable = false)
    private Integer id_gamer;
    
    
    // Getters and setters

    
	public Integer getId_tournament() {
		return id_tournament;
	}

	public void setId_tournament(Integer id_tournament) {
		this.id_tournament = id_tournament;
	}

	public Integer getId_gamer() {
		return id_gamer;
	}

	public void setId_gamer(Integer id_gamer) {
		this.id_gamer = id_gamer;
	}

    
}
