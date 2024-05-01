package com.ynov.tournaments.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gamers")
public class Gamer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gamer")
	private Integer id_gamer;
	
	@Column(name = "pseudo")
	private String pseudo;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "id_langage")
	private Integer id_langage;
	
	
	// Getters and setters

	
	public Integer getId_gamer() {
		return id_gamer;
	}

	public void setId_gamer(Integer id_gamer) {
		this.id_gamer = id_gamer;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getId_langage() {
		return id_langage;
	}

	public void setId_langage(Integer id_langage) {
		this.id_langage = id_langage;
	}	

}
