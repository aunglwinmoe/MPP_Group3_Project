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

import edu.mum.group3.bean.MakeBean;
import edu.mum.group3.model.Make;
import edu.mum.group3.service.MakeService;

@Controller
public class MakeController {

	@Autowired
	private MakeService makeService;

	@RequestMapping(value = "/saveMake", method = RequestMethod.POST)
	public ModelAndView saveMake(@ModelAttribute("command") MakeBean makeBean, BindingResult result) {
		Make make = prepareModel(makeBean);
		makeService.addMake(make);
		return new ModelAndView("redirect:/makes.html");
	}

	@RequestMapping(value = "/makes", method = RequestMethod.GET)
	public ModelAndView listModels() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("makes", prepareListofBean(makeService.listMakes()));
		return new ModelAndView("makesList", model);
	}

	@RequestMapping(value = "/addMake", method = RequestMethod.GET)
	public ModelAndView addMake(@ModelAttribute("command") MakeBean makeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("makes", prepareListofBean(makeService.listMakes()));
		return new ModelAndView("addMake", model);
	}

	@RequestMapping(value = "/deleteMake", method = RequestMethod.GET)
	public ModelAndView deleteMake(@ModelAttribute("command") MakeBean makeBean, BindingResult result) {
		makeService.deleteMake(prepareModel(makeBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("make", "null");
		model.put("makes", prepareListofBean(makeService.listMakes()));
		return new ModelAndView("makesList", model);
	}

	@RequestMapping(value = "/editMake", method = RequestMethod.GET)
	public ModelAndView editMake(@ModelAttribute("command") MakeBean makeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("make", prepareMakeBean(makeService.getMake(makeBean.getId())));
		model.put("makes", prepareListofBean(makeService.listMakes()));
		return new ModelAndView("addMake", model);
	}

	private Make prepareModel(MakeBean makeBean) {
		Make make = new Make();
		make.setMakeId(makeBean.getId());
		make.setMakeName(makeBean.getMakeName());
		makeBean.setId(null);
		return make;
	}

	private List<MakeBean> prepareListofBean(List<Make> makes) {
		List<MakeBean> beans = null;
		if (makes != null && !makes.isEmpty()) {
			beans = new ArrayList<MakeBean>();
			MakeBean bean = null;
			for (Make make : makes) {
				bean = new MakeBean();
				bean.setMakeName(make.getMakeName());
				bean.setId(make.getMakeId());
				beans.add(bean);
			}
		}
		return beans;
	}

	private MakeBean prepareMakeBean(Make make) {
		MakeBean bean = new MakeBean();
		bean.setMakeName(make.getMakeName());
		bean.setId(make.getMakeId());
		return bean;
	}
}
