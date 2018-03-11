package edu.mum.group3.service;

import java.util.List;

import edu.mum.group3.model.ContractType;

public interface ContractTypeService {
	
	public void addContractType(ContractType contractType);

	public List<ContractType> listContractTypes();
	
	public ContractType getContractType(int contractTypeId);
	
	public void deleteContractType(ContractType contractType);
}
