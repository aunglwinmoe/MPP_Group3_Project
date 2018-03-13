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
import edu.mum.group3.bean.ModelBean;
import edu.mum.group3.model.Make;
import edu.mum.group3.model.Model;
import edu.mum.group3.service.MakeService;
import edu.mum.group3.service.ModelService;

@Controller
public class ModelController {

	@Autowired
	private ModelService modelService;
	
	@Autowired
	private MakeService makeService;

	@RequestMapping(value = "/saveModel", method = RequestMethod.POST)
	public ModelAndView saveModel(@ModelAttribute("command") ModelBean modelBean, BindingResult result) {
		Model model = prepareModel(modelBean);
		modelService.addModel(model);
		return new ModelAndView("redirect:/models.html");
	}

	@RequestMapping(value = "/models", method = RequestMethod.GET)
	public ModelAndView listModels() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("models", prepareListofBean(modelService.listModels()));
		return new ModelAndView("modelsList", model);
	}

	@RequestMapping(value = "/addModel", method = RequestMethod.GET)
	public ModelAndView addModel(@ModelAttribute("command") ModelBean modelBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("models", prepareListofBean(modelService.listModels()));
		model.put("makes", prepareListofBean1(makeService.listMakes()));
		return new ModelAndView("addModel", model);
	}
	
	@ModelAttribute("webFrameworkList")
	   public List<String> getWebFrameworkList() {
	      List<String> webFrameworkList = new ArrayList<String>();
	      webFrameworkList.add("Spring MVC");
	      webFrameworkList.add("Struts 1");
	      webFrameworkList.add("Struts 2");
	      webFrameworkList.add("Apache Wicket");
	      return webFrameworkList;
	   }


	@RequestMapping(value = "/deleteModel", method = RequestMethod.GET)
	public ModelAndView deleteModel(@ModelAttribute("command") ModelBean modelBean, BindingResult result) {
		modelService.deleteModel(prepareModel(modelBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("model", "null");
		model.put("models", prepareListofBean(modelService.listModels()));
		return new ModelAndView("modelsList", model);
	}

	@RequestMapping(value = "/editModel", method = RequestMethod.GET)
	public ModelAndView editModel(@ModelAttribute("command") ModelBean modelBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("model", prepareModelBean(modelService.getModel(modelBean.getId())));
		model.put("models", prepareListofBean(modelService.listModels()));
		model.put("makes", prepareListofBean1(makeService.listMakes()));
		return new ModelAndView("addModel", model);
	}

	private Model prepareModel(ModelBean modelBean) {
		Model model = new Model();
		model.setModelId(modelBean.getId());
		model.setModelName(modelBean.getModelName());
		model.setMakeId(modelBean.getMakeId());
		modelBean.setId(null);
		return model;
	}

	private List<ModelBean> prepareListofBean(List<Model> models) {
		List<ModelBean> beans = null;
		if (models != null && !models.isEmpty()) {
			beans = new ArrayList<ModelBean>();
			ModelBean bean = null;
			for (Model model : models) {
				bean = new ModelBean();
				bean.setMakeName(makeService.getMake(model.getMakeId()).getMakeName());
				bean.setModelName(model.getModelName());
				bean.setId(model.getModelId());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<MakeBean> prepareListofBean1(List<Make> makes) {
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
	

	private ModelBean prepareModelBean(Model model) {
		ModelBean bean = new ModelBean();
		bean.setMakeId(model.getMakeId());
		bean.setModelName(model.getModelName());
		bean.setId(model.getModelId());
		return bean;
	}
}
