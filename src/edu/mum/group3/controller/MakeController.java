/*package edu.mum.group3.controller;

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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveVendor(@ModelAttribute("command") MakeBean makeBean, BindingResult result) {
		Make make = prepareModel(makeBean);
		makeService.addMake(make);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value = "/makes", method = RequestMethod.GET)
	public ModelAndView listMakes() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("makes", prepareListofBean(makeService.listMakes()));
		return new ModelAndView("makesList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addMake(@ModelAttribute("command") MakeBean makeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("makes", prepareListofBean(makeService.listMakes()));
		return new ModelAndView("addMakes", model);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editMake(@ModelAttribute("command") MakeBean makeBean, BindingResult result) {
		makeService.deleteMake(prepareModel(makeBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("make", null);
		model.put("makes", prepareListofBean(makeService.listMakes()));
		return new ModelAndView("addMakes", model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteVendor(@ModelAttribute("command") MakeBean makeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("make", prepareMakeBean(makeService.getMake(makeBean.getMakeId())));
		model.put("makes", prepareListofBean(makeService.listMakes()));
		return new ModelAndView("addMakes", model);
	}

	private Make prepareModel(MakeBean makeBean) {
		Make make = new Make();
		make.setMakeName(makeBean.getMakeName());
		make.setMakeId(makeBean.getMakeId());
		makeBean.setMakeId(null);
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
				bean.setMakeId(make.getMakeId());
				beans.add(bean);
			}
		}
		return beans;
	}

	private MakeBean prepareMakeBean(Make make) {
		MakeBean bean = new MakeBean();
		bean.setMakeName(make.getMakeName());
		bean.setMakeId(make.getMakeId());
		return bean;
	}
}
*/