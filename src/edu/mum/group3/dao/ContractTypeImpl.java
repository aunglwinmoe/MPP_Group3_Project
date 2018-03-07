package edu.mum.group3.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.group3.model.ContractType;

@Repository("contractTypeDao")
public class ContractTypeImpl implements ContractTypeDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addContractType(ContractType contractType) {
		sessionFactory.getCurrentSession().saveOrUpdate(contractType);
	}

	@SuppressWarnings("unchecked")
	public List<ContractType> listContractTypes() {
		return (List<ContractType>) sessionFactory.getCurrentSession().createCriteria(ContractType.class).list();
	}

	public ContractType getContractType(int contractTypeId) {
		return (ContractType) sessionFactory.getCurrentSession().get(ContractType.class, contractTypeId);
	}

	public void deleteContractType(ContractType contractType) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM ContractType WHERE contracttypeid = " + contractType.getContractTypeId())
				.executeUpdate();
	}
}
