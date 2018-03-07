package edu.mum.group3.service;

import java.util.List;

import edu.mum.group3.model.Make;

public interface MakeService {

	public void addMake(Make make);

	public List<Make> listMakes();
	
	public Make getMake(int makeId);
	
	public void deleteMake(Make make);
}
