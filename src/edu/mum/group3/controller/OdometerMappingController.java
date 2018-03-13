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

import edu.mum.group3.bean.OdometerMappingBean;
import edu.mum.group3.model.OdometerMapping;
import edu.mum.group3.service.OdometerMappingService;

@Controller
public class OdometerMappingController {

	@Autowired
	private OdometerMappingService odometerMappingService;

	@RequestMapping(value = "/saveOdometerMapping", method = RequestMethod.POST)
	public ModelAndView saveOdometerMapping(@ModelAttribute("command") OdometerMappingBean odometerMappingBean,
			BindingResult result) {
		OdometerMapping odometerMapping = prepareModel(odometerMappingBean);
		odometerMappingService.addOdometerMapping(odometerMapping);
		return new ModelAndView("redirect:/odometerMappings.html");
	}

	@RequestMapping(value = "/odometerMappings", method = RequestMethod.GET)
	public ModelAndView listOdometerMappings() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("odometerMappings", prepareListofBean(odometerMappingService.listOdometerMappings()));
		return new ModelAndView("odometerMappingsList", model);
	}

	@RequestMapping(value = "/addOdometerMapping", method = RequestMethod.GET)
	public ModelAndView addOdometerMapping(@ModelAttribute("command") OdometerMappingBean odometerMappingBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("odometerMappings", prepareListofBean(odometerMappingService.listOdometerMappings()));
		return new ModelAndView("addOdometerMapping", model);
	}

	@RequestMapping(value = "/deleteOdometerMapping", method = RequestMethod.GET)
	public ModelAndView deleteOdometerMapping(@ModelAttribute("command") OdometerMappingBean odometerMappingBean,
			BindingResult result) {
		odometerMappingService.deleteOdometerMapping(prepareModel(odometerMappingBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("odometerMapping", "null");
		model.put("odometerMappings", prepareListofBean(odometerMappingService.listOdometerMappings()));
		return new ModelAndView("odometerMappingsList", model);
	}

	@RequestMapping(value = "/editOdometerMapping", method = RequestMethod.GET)
	public ModelAndView editOdometerMapping(@ModelAttribute("command") OdometerMappingBean odometerMappingBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("odometerMapping",
				prepareOdometerMappingBean(odometerMappingService.getOdometerMapping(odometerMappingBean.getId())));
		model.put("odometerMappings", prepareListofBean(odometerMappingService.listOdometerMappings()));
		return new ModelAndView("addOdometerMapping", model);
	}

	private OdometerMapping prepareModel(OdometerMappingBean odometerMappingBean) {
		OdometerMapping odometerMapping = new OdometerMapping();
		odometerMapping.setOdometerMappingId(odometerMappingBean.getId());
		odometerMapping.setMaxOdometer(odometerMappingBean.getMaxOdometer());
		odometerMappingBean.setId(null);
		return odometerMapping;
	}

	private List<OdometerMappingBean> prepareListofBean(List<OdometerMapping> odometerMappings) {
		List<OdometerMappingBean> beans = null;
		if (odometerMappings != null && !odometerMappings.isEmpty()) {
			beans = new ArrayList<OdometerMappingBean>();
			OdometerMappingBean bean = null;
			for (OdometerMapping odometerMapping : odometerMappings) {
				bean = new OdometerMappingBean();
				bean.setMaxOdometer(odometerMapping.getMaxOdometer());
				bean.setId(odometerMapping.getOdometerMappingId());
				beans.add(bean);
			}
		}
		return beans;
	}

	private OdometerMappingBean prepareOdometerMappingBean(OdometerMapping odometerMapping) {
		OdometerMappingBean bean = new OdometerMappingBean();
		bean.setMaxOdometer(odometerMapping.getMaxOdometer());
		bean.setId(odometerMapping.getOdometerMappingId());
		return bean;
	}
}
