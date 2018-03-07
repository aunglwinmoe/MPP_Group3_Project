package edu.mum.group3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Make implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8419315052947907998L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "makeid")
	private Integer makeId;

	@Column(name = "makename")
	private String makeName;

	public Integer getMakeId() {
		return makeId;
	}

	public void setMakeId(Integer makeId) {
		this.makeId = makeId;
	}

	public String getMakeName() {
		return makeName;
	}

	public void setMakeName(String makeName) {
		this.makeName = makeName;
	}
	
	
}
