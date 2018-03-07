package edu.mum.group3.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.group3.model.Make;

@Repository("makeDao")
public class MakeDaoImpl implements MakeDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addMake(Make make) {
		sessionFactory.getCurrentSession().saveOrUpdate(make);
	}

	@SuppressWarnings("unchecked")
	public List<Make> listMakes() {
		return (List<Make>) sessionFactory.getCurrentSession().createCriteria(Make.class).list();
	}

	public Make getMake(int makeId) {
		return (Make) sessionFactory.getCurrentSession().get(Make.class, makeId);
	}

	public void deleteMake(Make make) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Make WHERE makeid = " + make.getMakeId())
				.executeUpdate();
	}

}
