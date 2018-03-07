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

import edu.mum.group3.bean.ContractTypeBean;
import edu.mum.group3.model.ContractType;
import edu.mum.group3.service.ContractTypeService;

@Controller
public class ContractTypeController {

	@Autowired
	private ContractTypeService contractTypeService;

	@RequestMapping(value = "/saveContractType", method = RequestMethod.POST)
	public ModelAndView saveContractType(@ModelAttribute("command") ContractTypeBean contractTypeBean, BindingResult result) {
		ContractType contractType = prepareModel(contractTypeBean);
		contractTypeService.addContractType(contractType);
		return new ModelAndView("redirect:/contractTypes.html");
	}

	@RequestMapping(value = "/contractTypes", method = RequestMethod.GET)
	public ModelAndView listContractTypes() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("contractTypes", prepareListofBean(contractTypeService.listContractTypes()));
		return new ModelAndView("contractTypesList", model);
	}

	@RequestMapping(value = "/addContractType", method = RequestMethod.GET)
	public ModelAndView addContractType(@ModelAttribute("command") ContractTypeBean contractTypeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("contractTypes", prepareListofBean(contractTypeService.listContractTypes()));
		return new ModelAndView("addContractType", model);
	}

	@RequestMapping(value = "/deleteContractType", method = RequestMethod.GET)
	public ModelAndView deleteContractType(@ModelAttribute("command") ContractTypeBean contractTypeBean, BindingResult result) {
		contractTypeService.deleteContractType(prepareModel(contractTypeBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("contractType", "null");
		model.put("contractTypes", prepareListofBean(contractTypeService.listContractTypes()));
		return new ModelAndView("contractTypesList", model);
	}

	@RequestMapping(value = "/editContractType", method = RequestMethod.GET)
	public ModelAndView editContractType(@ModelAttribute("command") ContractTypeBean contractTypeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("contractType", prepareContractTypeBean(contractTypeService.getContractType(contractTypeBean.getId())));
		model.put("contractTypes", prepareListofBean(contractTypeService.listContractTypes()));
		return new ModelAndView("addContractType", model);
	}

	private ContractType prepareModel(ContractTypeBean contractTypeBean) {
		ContractType contractType = new ContractType();
		contractType.setContractTypeId(contractTypeBean.getId());
		contractType.setContractTypeName(contractTypeBean.getContractTypeName());
		contractTypeBean.setId(null);
		return contractType;
	}

	private List<ContractTypeBean> prepareListofBean(List<ContractType> contractTypes) {
		List<ContractTypeBean> beans = null;
		if (contractTypes != null && !contractTypes.isEmpty()) {
			beans = new ArrayList<ContractTypeBean>();
			ContractTypeBean bean = null;
			for (ContractType contractType : contractTypes) {
				bean = new ContractTypeBean();
				bean.setContractTypeName(contractType.getContractTypeName());
				bean.setId(contractType.getContractTypeId());
				beans.add(bean);
			}
		}
		return beans;
	}

	private ContractTypeBean prepareContractTypeBean(ContractType contractType) {
		ContractTypeBean bean = new ContractTypeBean();
		bean.setContractTypeName(contractType.getContractTypeName());
		bean.setId(contractType.getContractTypeId());
		return bean;
	}
}
