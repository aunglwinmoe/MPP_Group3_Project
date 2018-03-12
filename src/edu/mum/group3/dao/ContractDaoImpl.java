package edu.mum.group3.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.group3.model.Contract;

/**
 * @author Lwin Moe Aung
 *
 */
@Repository("contractDao")
public class ContractDaoImpl implements ContractDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addContract(Contract contract) {
		sessionFactory.getCurrentSession().saveOrUpdate(contract);
	}

	@SuppressWarnings("unchecked")
	public List<Contract> listContracts() {
		return (List<Contract>) sessionFactory.getCurrentSession().createCriteria(Contract.class).list();
	}

	public Contract getContract(int contractId) {
		return (Contract) sessionFactory.getCurrentSession().get(Contract.class, contractId);
	}

	public void deleteContract(Contract contract) {
		sessionFactory.getCurrentSession()
				.createQuery("DELETE FROM Contract WHERE contractid = " + contract.getContractId()).executeUpdate();
	}

}
