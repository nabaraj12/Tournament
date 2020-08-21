package com.letsstartcoding.springexample.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the TOURNAMENT database table.
 * 
 */
@Entity

public class PointsModel implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String TEAM_NAME;
	
	private String OWNER;
	
	private String TOURNAMENT_NAME;

	private String TOTAL_POINTS;

	
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

	public String getTOTAL_POINTS() {
		return TOTAL_POINTS;
	}

	public void setTOTAL_POINTS(String tOTAL_POINTS) {
		TOTAL_POINTS = tOTAL_POINTS;
	}

	
	
		

}