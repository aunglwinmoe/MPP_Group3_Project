package edu.mum.group3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.group3.dao.ContractDao;
import edu.mum.group3.model.Contract;

/**
 * @author Lwin Moe Aung
 *
 */
@Service("contractService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractDao ContractDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addContract(Contract contract) {
		ContractDao.addContract(contract);
	}

	public List<Contract> listContracts() {
		return ContractDao.listContracts();
	}

	public Contract getContract(int contractId) {
		return ContractDao.getContract(contractId);
	}

	public void deleteContract(Contract contract) {
		ContractDao.deleteContract(contract);
	}

}
