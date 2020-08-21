package com.letsstartcoding.springexample.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the TOURNAMENT database table.
 * 
 */
@Entity

public class OwnerModel implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String TEAM_ID;
	
	private String TEAM_NAME;
	
	private String OWNER;
	
	private String LOCATION;

	public String getTEAM_ID() {
		return TEAM_ID;
	}

	public void setTEAM_ID(String tEAM_ID) {
		TEAM_ID = tEAM_ID;
	}

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

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	
		

}