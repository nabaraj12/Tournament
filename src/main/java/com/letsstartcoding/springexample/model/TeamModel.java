package com.letsstartcoding.springexample.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.lang.NonNull;

/**
 * The persistent class for the TOURNAMENT database table.
 * 
 */
@Entity
@NamedQuery(name="teams.findAll", query="SELECT t FROM teams t")
public class TeamModel implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String TEAM_NAME;
	
	@NotEmpty
	private String OWNER;
	
	@NotEmpty
	private String TOURNAMENT_NAME;
	
	@NotEmpty
	private String TOURNAMENT_TEAM;

	public String getTEAM_NAME() {
		return TEAM_NAME;
	}

	public void setTEAM_NAME(String tEAM_NAME) {
		TEAM_NAME = tEAM_NAME;
	}

	public String getOWNER() {
		return OWNER;
	}

	public void setOWNER(String oWNER) {
		OWNER = oWNER;
	}

	public String getTOURNAMENT_NAME() {
		return TOURNAMENT_NAME;
	}

	public void setTOURNAMENT_NAME(String tOURNAMENT_NAME) {
		TOURNAMENT_NAME = tOURNAMENT_NAME;
	}

	public String getTOURNAMENT_TEAM() {
		return TOURNAMENT_TEAM;
	}

	public void setTOURNAMENT_TEAM(String tOURNAMENT_TEAM) {
		TOURNAMENT_TEAM = tOURNAMENT_TEAM;
	}
			

		

}