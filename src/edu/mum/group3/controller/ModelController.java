package edu.mum.group3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.group3.bean.ModelBean;
import edu.mum.group3.model.Model;
import edu.mum.group3.service.ModelService;

@Controller
public class ModelController {

	@Autowired
	private ModelService modelService;

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
		return new ModelAndView("addModel", model);
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
		return new ModelAndView("addModel", model);
	}

	private Model prepareModel(ModelBean modelBean) {
		Model model = new Model();
		model.setModelId(modelBean.getId());
		model.setModelName(modelBean.getModelName());
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
				bean.setModelName(model.getModelName());
				bean.setId(model.getModelId());
				beans.add(bean);
			}
		}
		return beans;
	}

	private ModelBean prepareModelBean(Model model) {
		ModelBean bean = new ModelBean();
		bean.setModelName(model.getModelName());
		bean.setId(model.getModelId());
		return bean;
	}
}
