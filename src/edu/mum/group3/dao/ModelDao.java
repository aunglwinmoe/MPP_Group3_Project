package edu.mum.group3.dao;

import java.util.List;

import edu.mum.group3.model.Model;

public interface ModelDao {
	
	public void addModel(Model model);

	public List<Model> listModels();
	
	public Model getModel(int modelId);
	
	public void deleteModel(Model model);
}
