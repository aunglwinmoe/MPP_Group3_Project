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

import edu.mum.group3.bean.VendorBean;
import edu.mum.group3.model.Vendor;
import edu.mum.group3.service.VendorService;

/**
 * @author Lwin Moe Aung
 *
 */
@Controller
public class VendorController {

	@Autowired
	private VendorService vendorService;

	@RequestMapping(value = "/saveVendor", method = RequestMethod.POST)
	public ModelAndView saveVendor(@ModelAttribute("command") VendorBean vendorBean, BindingResult result) {
		Vendor vendor = prepareModel(vendorBean);
		vendorService.addVendor(vendor);
		return new ModelAndView("redirect:/vendors.html");
	}

	@RequestMapping(value = "/vendors", method = RequestMethod.GET)
	public ModelAndView listVendors() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendors", prepareListofBean(vendorService.listVendors()));
		return new ModelAndView("vendorsList", model);
	}

	@RequestMapping(value = "/addVendor", method = RequestMethod.GET)
	public ModelAndView addVendor(@ModelAttribute("command") VendorBean vendorBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendors", prepareListofBean(vendorService.listVendors()));
		return new ModelAndView("addVendor", model);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/menu", method = RequestMethod.POST)
	public ModelAndView menu() {
		return new ModelAndView("menu");
	}
	
	@RequestMapping(value = "/deleteVendor", method = RequestMethod.GET)
	public ModelAndView deleteVendor(@ModelAttribute("command") VendorBean vendorBean, BindingResult result) {
		vendorService.deleteVendor(prepareModel(vendorBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendor", null);
		model.put("vendors", prepareListofBean(vendorService.listVendors()));
		return new ModelAndView("vendorsList", model);
	}

	@RequestMapping(value = "/editVendor", method = RequestMethod.GET)
	public ModelAndView editVendor(@ModelAttribute("command") VendorBean vendorBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendor", prepareVendorBean(vendorService.getVendor(vendorBean.getId())));
		model.put("vendors", prepareListofBean(vendorService.listVendors()));
		return new ModelAndView("addVendor", model);
	}

	private Vendor prepareModel(VendorBean vendorBean) {
		Vendor vendor = new Vendor();
		vendor.setVendorAddress(vendorBean.getAddress());
		vendor.setTitle(vendorBean.getTitle());
		vendor.setPhone(vendorBean.getPhone());
		vendor.setEmail(vendorBean.getEmail());
		vendor.setVendorName(vendorBean.getVendorName());
		vendor.setSsn(vendorBean.getSsn());
		vendor.setVendorId(vendorBean.getId());
		vendorBean.setId(null);
		return vendor;
	}

	private List<VendorBean> prepareListofBean(List<Vendor> vendors) {
		List<VendorBean> beans = null;
		if (vendors != null && !vendors.isEmpty()) {
			beans = new ArrayList<VendorBean>();
			VendorBean bean = null;
			for (Vendor vendor : vendors) {
				bean = new VendorBean();
				bean.setVendorName(vendor.getVendorName());
				bean.setId(vendor.getVendorId());
				bean.setTitle(vendor.getTitle());
				bean.setSsn(vendor.getSsn());
				bean.setPhone(vendor.getPhone());
				bean.setEmail(vendor.getEmail());
				bean.setAddress(vendor.getVendorAddress());
				beans.add(bean);
			}
		}
		return beans;
	}

	private VendorBean prepareVendorBean(Vendor vendor) {
		VendorBean bean = new VendorBean();
		bean.setAddress(vendor.getVendorAddress());
		bean.setEmail(vendor.getEmail());
		bean.setPhone(vendor.getPhone());
		bean.setTitle(vendor.getTitle());
		bean.setVendorName(vendor.getVendorName());
		bean.setSsn(vendor.getSsn());
		bean.setId(vendor.getVendorId());
		return bean;
	}
}
