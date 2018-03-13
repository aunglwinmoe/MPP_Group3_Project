package edu.mum.group3.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.group3.bean.UserBean;
import edu.mum.group3.model.User;
import edu.mum.group3.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("command") UserBean userBean, BindingResult result) {
		User user = prepareModel(userBean);
		userService.addUser(user);
		return new ModelAndView("redirect:/users.html");
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView listUsers() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("users", prepareListofBean(userService.listUsers()));
		return new ModelAndView("usersList", model);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addUser(@ModelAttribute("command") UserBean userBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("users", prepareListofBean(userService.listUsers()));
		return new ModelAndView("addUser", model);
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUser(@ModelAttribute("command") UserBean userBean, BindingResult result) {
		userService.deleteUser(prepareModel(userBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", null);
		model.put("users", prepareListofBean(userService.listUsers()));
		return new ModelAndView("usersList", model);
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editUser(@ModelAttribute("command") UserBean userBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", prepareUserBean(userService.getUser(userBean.getId())));
		model.put("users", prepareListofBean(userService.listUsers()));
		return new ModelAndView("addUser", model);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST	)
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET	)
	public ModelAndView logout() {
		return new ModelAndView("logout");
	}
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public ModelAndView menu() {
		return new ModelAndView("menu");		
	}

	private User prepareModel(UserBean userBean) {
		User user = new User();
		user.setUserId(userBean.getId());
		user.setPassword(userBean.getPassword());
		user.setUserName(userBean.getUserName());
		user.setLastName(userBean.getLastName());
		user.setFirstName(userBean.getFirstName());
		userBean.setId(null);
		return user;
	}

	private List<UserBean> prepareListofBean(List<User> users) {
		List<UserBean> beans = null;
		if (users != null && !users.isEmpty()) {
			beans = new ArrayList<UserBean>();
			UserBean bean = null;
			for (User user : users) {
				bean = new UserBean();
				bean.setUserName(user.getUserName());
				bean.setLastName(user.getLastName());
				bean.setFirstName(user.getFirstName());
				bean.setId(user.getUserId());

				beans.add(bean);
			}
		}
		return beans;
	}

	private UserBean prepareUserBean(User user) {
		UserBean bean = new UserBean();
		bean.setPassword(user.getPassword());
		bean.setUserName(user.getUserName());
		bean.setLastName(user.getLastName());
		bean.setFirstName(user.getFirstName());
		bean.setId(user.getUserId());
		return bean;
	}
}
