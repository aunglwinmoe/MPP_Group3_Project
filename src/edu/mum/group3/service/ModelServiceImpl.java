package edu.mum.group3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.group3.dao.ModelDao;
import edu.mum.group3.model.Model;

@Service("modelService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ModelServiceImpl implements ModelService{
	
	@Autowired
	private ModelDao modelDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addModel(Model model) {
		modelDao.addModel(model);
	}
	
	public List<Model> listModels() {
		return modelDao.listModels();
	}

	public Model getModel(int modelId) {
		return modelDao.getModel(modelId);
	}
	
	public void deleteModel(Model model) {
		modelDao.deleteModel(model);
	}
}
