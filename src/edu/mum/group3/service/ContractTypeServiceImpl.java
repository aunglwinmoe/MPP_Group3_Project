package edu.mum.group3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.group3.dao.ContractTypeDao;
import edu.mum.group3.model.ContractType;

@Service("contractTypeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ContractTypeServiceImpl implements ContractTypeService{

	@Autowired
	private ContractTypeDao contractTypeDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addContractType(ContractType contractType) {
		contractTypeDao.addContractType(contractType);
	}
	
	public List<ContractType> listContractTypes() {
		return contractTypeDao.listContractTypes();
	}

	public ContractType getContractType(int contractTypeId) {
		return contractTypeDao.getContractType(contractTypeId);
	}
	
	public void deleteContractType(ContractType contractType) {
		contractTypeDao.deleteContractType(contractType);
	}
}
