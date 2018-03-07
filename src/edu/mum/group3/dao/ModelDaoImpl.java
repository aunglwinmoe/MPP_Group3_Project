package edu.mum.group3.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.group3.model.Model;

@Repository("modelDao")
public class ModelDaoImpl implements ModelDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void addModel(Model model) {
		sessionFactory.getCurrentSession().saveOrUpdate(model);
	}

	@SuppressWarnings("unchecked")
	public List<Model> listModels() {
		return (List<Model>) sessionFactory.getCurrentSession().createCriteria(Model.class).list();
	}

	public Model getModel(int modelId) {
		return (Model) sessionFactory.getCurrentSession().get(Model.class, modelId);
	}

	public void deleteModel(Model model) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Model WHERE modelid = " + model.getModelId())
				.executeUpdate();
	}
}
