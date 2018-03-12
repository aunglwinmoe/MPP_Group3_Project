package edu.mum.group3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.group3.bean.ContractBean;
import edu.mum.group3.model.Contract;
import edu.mum.group3.service.ContractService;

/**
 * @author Lwin Moe Aung
 *
 */
@Controller
public class ContractController {

	@Autowired
	private ContractService contractService;

	@RequestMapping(value = "/saveContract", method = RequestMethod.POST)
	public ModelAndView saveContract(@ModelAttribute("command") ContractBean contractBean, BindingResult result) {
		Contract contract = prepareModel(contractBean);
		contractService.addContract(contract);
		return new ModelAndView("redirect:/contracts.html");
	}

	@RequestMapping(value = "/contracts", method = RequestMethod.GET)
	public ModelAndView listContracts() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("contracts", prepareListofBean(contractService.listContracts()));
		return new ModelAndView("contractsList", model);
	}

	@RequestMapping(value = "/addContract", method = RequestMethod.GET)
	public ModelAndView addContract(@ModelAttribute("command") ContractBean contractBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("contracts", prepareListofBean(contractService.listContracts()));
		return new ModelAndView("addContract", model);
	}

	@RequestMapping(value = "/deleteContract", method = RequestMethod.GET)
	public ModelAndView deleteContract(@ModelAttribute("command") ContractBean contractBean, BindingResult result) {
		contractService.deleteContract(prepareModel(contractBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("contract", "null");
		model.put("contracts", prepareListofBean(contractService.listContracts()));
		return new ModelAndView("contractsList", model);
	}

	@RequestMapping(value = "/editContract", method = RequestMethod.GET)
	public ModelAndView editContract(@ModelAttribute("command") ContractBean contractBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("contract", prepareModelBean(contractService.getContract(contractBean.getId())));
		model.put("contracts", prepareListofBean(contractService.listContracts()));
		return new ModelAndView("addContract", model);
	}

	private Contract prepareModel(ContractBean contractBean) {
		Contract contract = new Contract();
		contract.setContractExpDate(contractBean.getContractExpDate());
		contract.setContractorId(contractBean.getContractorId());
		contract.setVehicleId(contractBean.getVehicleId());
		contract.setVendorId(contractBean.getVendorId());
		contract.setContractStartDate(contractBean.getContractStartDate());
		contract.setInvoiceDate(contractBean.getInvoiceDate());
		contract.setOdometerAtCreation(contractBean.getOdometerAtCreation());
		contract.setRentalCost(contractBean.getRentalCost());
		contract.setTermsAndConditions(contractBean.getTermsAndConditions());
		contract.setContractTypeId(contractBean.getContractTypeId());
		contract.setContractId(contractBean.getId());
		contractBean.setId(null);
		return contract;
	}

	private List<ContractBean> prepareListofBean(List<Contract> contracts) {
		List<ContractBean> beans = null;
		if (contracts != null && !contracts.isEmpty()) {
			beans = new ArrayList<ContractBean>();
			ContractBean bean = null;
			for (Contract contract : contracts) {
				bean = new ContractBean();

				bean.setContractExpDate(contract.getContractExpDate());
				bean.setContractorId(contract.getContractorId());
				bean.setVendorId(contract.getVendorId());
				bean.setVehicleId(contract.getVehicleId());
				bean.setContractStartDate(contract.getContractStartDate());
				bean.setInvoiceDate(contract.getInvoiceDate());
				bean.setOdometerAtCreation(contract.getOdometerAtCreation());
				bean.setRentalCost(contract.getRentalCost());
				bean.setTermsAndConditions(contract.getTermsAndConditions());
				bean.setContractTypeId(contract.getContractTypeId());
				bean.setId(contract.getContractId());

				beans.add(bean);
			}
		}
		return beans;
	}

	private ContractBean prepareModelBean(Contract contract) {
		ContractBean bean = new ContractBean();

		bean.setContractExpDate(contract.getContractExpDate());
		bean.setContractorId(contract.getContractorId());
		bean.setVehicleId(contract.getVehicleId());
		bean.setVendorId(contract.getVendorId());
		bean.setContractStartDate(contract.getContractStartDate());
		bean.setInvoiceDate(contract.getInvoiceDate());
		bean.setOdometerAtCreation(contract.getOdometerAtCreation());
		bean.setRentalCost(contract.getRentalCost());
		bean.setTermsAndConditions(contract.getTermsAndConditions());
		bean.setContractTypeId(contract.getContractTypeId());
		bean.setId(contract.getContractId());
		return bean;
	}
}
