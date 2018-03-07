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

import edu.mum.group3.bean.ServiceTypeBean;
import edu.mum.group3.model.ServiceType;
import edu.mum.group3.service.ServiceTypeService;

@Controller
public class ServiceTypeController {

	@Autowired
	private ServiceTypeService serviceTypeService;

	@RequestMapping(value = "/saveServiceType", method = RequestMethod.POST)
	public ModelAndView saveServiceType(@ModelAttribute("command") ServiceTypeBean serviceTypeBean, BindingResult result) {
		ServiceType serviceType = prepareModel(serviceTypeBean);
		serviceTypeService.addServiceType(serviceType);
		return new ModelAndView("redirect:/serviceTypes.html");
	}

	@RequestMapping(value = "/serviceTypes", method = RequestMethod.GET)
	public ModelAndView listServiceTypes() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("serviceTypes", prepareListofBean(serviceTypeService.listServiceTypes()));
		return new ModelAndView("serviceTypesList", model);
	}

	@RequestMapping(value = "/addServiceType", method = RequestMethod.GET)
	public ModelAndView addServiceType(@ModelAttribute("command") ServiceTypeBean serviceTypeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("serviceTypes", prepareListofBean(serviceTypeService.listServiceTypes()));
		return new ModelAndView("addServiceType", model);
	}

	@RequestMapping(value = "/deleteServiceType", method = RequestMethod.GET)
	public ModelAndView deleteServiceType(@ModelAttribute("command") ServiceTypeBean serviceTypeBean, BindingResult result) {
		serviceTypeService.deleteServiceType(prepareModel(serviceTypeBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("serviceType", "null");
		model.put("serviceTypes", prepareListofBean(serviceTypeService.listServiceTypes()));
		return new ModelAndView("serviceTypesList", model);
	}

	@RequestMapping(value = "/editServiceType", method = RequestMethod.GET)
	public ModelAndView editServiceType(@ModelAttribute("command") ServiceTypeBean serviceTypeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("serviceType", prepareServiceTypeBean(serviceTypeService.getServiceType(serviceTypeBean.getId())));
		model.put("serviceTypes", prepareListofBean(serviceTypeService.listServiceTypes()));
		return new ModelAndView("addServiceType", model);
	}

	private ServiceType prepareModel(ServiceTypeBean serviceTypeBean) {
		ServiceType serviceType = new ServiceType();
		serviceType.setServiceTypeId(serviceTypeBean.getId());
		serviceType.setServiceTypeName(serviceTypeBean.getServiceTypeName());
		serviceTypeBean.setId(null);
		return serviceType;
	}

	private List<ServiceTypeBean> prepareListofBean(List<ServiceType> serviceTypes) {
		List<ServiceTypeBean> beans = null;
		if (serviceTypes != null && !serviceTypes.isEmpty()) {
			beans = new ArrayList<ServiceTypeBean>();
			ServiceTypeBean bean = null;
			for (ServiceType serviceType : serviceTypes) {
				bean = new ServiceTypeBean();
				bean.setServiceTypeName(serviceType.getServiceTypeName());
				bean.setId(serviceType.getServiceTypeId());
				beans.add(bean);
			}
		}
		return beans;
	}

	private ServiceTypeBean prepareServiceTypeBean(ServiceType serviceType) {
		ServiceTypeBean bean = new ServiceTypeBean();
		bean.setServiceTypeName(serviceType.getServiceTypeName());
		bean.setId(serviceType.getServiceTypeId());
		return bean;
	}
}
