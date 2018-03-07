package edu.mum.group3.bean;

public class ModelBean {
	private Integer id;
	private String modelName;
	//private Integer makeId;
	//private List<Vendor> vendors;
	
	
	public String getModelName() {
		return modelName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	
}
