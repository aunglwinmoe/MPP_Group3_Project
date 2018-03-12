package edu.mum.group3.dao;

import java.util.List;

import edu.mum.group3.model.Contract;

/**
 * @author Lwin Moe Aung
 *
 */
public interface ContractDao {

	public void addContract(Contract contract);

	public List<Contract> listContracts();

	public Contract getContract(int contractId);

	public void deleteContract(Contract contract);
}
