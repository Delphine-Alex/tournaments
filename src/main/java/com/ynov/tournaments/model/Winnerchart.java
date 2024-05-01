package com.ynov.tournaments.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "winnerchart")
public class Winnerchart {
	
	@EmbeddedId
    private WinnerchartId id_winnerchart;
	
	@Column(name = "ranking")
	private Integer ranking;
	
	@Column(name = "years")
	private Date years;
	
	

	public WinnerchartId getId_winnerchart() {
		return id_winnerchart;
	}

	public void setId_winnerchart(WinnerchartId id_winnerchart) {
		this.id_winnerchart = id_winnerchart;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public Date getYears() {
		return years;
	}

	public void setYears(Date years) {
		this.years = years;
	}
	
	

}
