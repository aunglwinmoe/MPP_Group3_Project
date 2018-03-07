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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveVendor(@ModelAttribute("command") VendorBean vendorBean, BindingResult result) {
		Vendor vendor = prepareModel(vendorBean);
		vendorService.addVendor(vendor);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value = "/vendors", method = RequestMethod.GET)
	public ModelAndView listVendors() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendors", prepareListofBean(vendorService.listVendors()));
		return new ModelAndView("vendorsList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addVendor(@ModelAttribute("command") VendorBean vendorBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendors", prepareListofBean(vendorService.listVendors()));
		return new ModelAndView("addVendors", model);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editVendor(@ModelAttribute("command") VendorBean vendorBean, BindingResult result) {
		vendorService.deleteVendor(prepareModel(vendorBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendor", null);
		model.put("vendors", prepareListofBean(vendorService.listVendors()));
		return new ModelAndView("addVendors", model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteVendor(@ModelAttribute("command") VendorBean vendorBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendor", prepareVendorBean(vendorService.getVendor(vendorBean.getVendorId())));
		model.put("vendors", prepareListofBean(vendorService.listVendors()));
		return new ModelAndView("addVendors", model);
	}

	// =========================================================================================================================

	@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
	public ModelAndView listVehicles() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vehicles", prepareListofBean(vendorService.listVendors()));
		return new ModelAndView("vehiclesList", model);
	}

	@RequestMapping(value = "/odometers", method = RequestMethod.GET)
	public ModelAndView listVehiclesOdometer() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("odometers", prepareListofBean(vendorService.listVendors()));
		return new ModelAndView("vehiclesodometerList", model);
	}

	// =========================================================================================================================

	private Vendor prepareModel(VendorBean vendorBean) {
		Vendor vendor = new Vendor();
		vendor.setVendorAddress(vendorBean.getAddress());
		vendor.setVendorName(vendorBean.getVendorName());
		vendor.setSsn(vendorBean.getSsn());
		vendor.setVendorId(vendorBean.getVendorId());
		vendorBean.setVendorId(null);
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
				bean.setVendorId(vendor.getVendorId());
				bean.setAddress(vendor.getVendorAddress());
				bean.setSsn(vendor.getSsn());
				beans.add(bean);
			}
		}
		return beans;
	}

	private VendorBean prepareVendorBean(Vendor vendor) {
		VendorBean bean = new VendorBean();
		bean.setAddress(vendor.getVendorAddress());
		bean.setVendorName(vendor.getVendorName());
		bean.setSsn(vendor.getSsn());
		bean.setVendorId(vendor.getVendorId());
		return bean;
	}
}
