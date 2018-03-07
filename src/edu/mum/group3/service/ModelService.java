package edu.mum.group3.service;

import java.util.List;

import edu.mum.group3.model.Model;

public interface ModelService {
	
	public void addModel(Model model);

	public List<Model> listModels();
	
	public Model getModel(int modelId);
	
	public void deleteModel(Model model);
}
