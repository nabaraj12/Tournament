package com.letsstartcoding.springexample.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

/**
 * The persistent class for the TOURNAMENT database table.
 * 
 */
@Entity
@NamedQuery(name="TOURNAMENT.findAll", query="SELECT s FROM TOURNAMENT s")
public class TournamentModel implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int TOURNAMENT_ID;
	
	@NotEmpty
	private String TOURNAMENT_NAME;
	
	@NumberFormat
	private int PRIZE_MONEY;

	public int getTOURNAMENT_ID() {
		return TOURNAMENT_ID;
	}

	public void setTOURNAMENT_ID(int tOURNAMENT_ID) {
		TOURNAMENT_ID = tOURNAMENT_ID;
	}

	public String getTOURNAMENT_NAME() {
		return TOURNAMENT_NAME;
	}

	public void setTOURNAMENT_NAME(String tOURNAMENT_NAME) {
		TOURNAMENT_NAME = tOURNAMENT_NAME;
	}

	public int getPRIZE_MONEY() {
		return PRIZE_MONEY;
	}

	public void setPRIZE_MONEY(int pRIZE_MONEY) {
		PRIZE_MONEY = pRIZE_MONEY;
	}

		

		

}