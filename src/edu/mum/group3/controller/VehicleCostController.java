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
import org.springframework.web.servlet.ModelAndView;

import edu.mum.group3.bean.ModelBean;
import edu.mum.group3.bean.ServiceTypeBean;
import edu.mum.group3.bean.VehicleBean;
import edu.mum.group3.bean.VehicleCostBean;
import edu.mum.group3.bean.VendorBean;
import edu.mum.group3.model.Model;
import edu.mum.group3.model.ServiceType;
import edu.mum.group3.model.Vehicle;
import edu.mum.group3.model.VehicleCost;
import edu.mum.group3.model.Vendor;
import edu.mum.group3.service.ServiceTypeService;
import edu.mum.group3.service.VehicleCostService;
import edu.mum.group3.service.VehicleService;

/**
 * @author Lwin Moe Aung
 *
 */
@Controller
public class VehicleCostController {

	@Autowired
	private VehicleCostService vehicleCostService;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private ServiceTypeService serviceTypeService;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/saveVehicleCost", method = RequestMethod.POST)
	public ModelAndView saveVehicleCost(@ModelAttribute("command") VehicleCostBean vehicleCostBean,
			BindingResult result) {
		VehicleCost vehicleCost = prepareModel(vehicleCostBean);
		vehicleCostService.addVehicleCost(vehicleCost);
		return new ModelAndView("redirect:/vehiclecosts.html");
	}

	@RequestMapping(value = "/vehiclecosts", method = RequestMethod.GET)
	public ModelAndView listVehicleCosts() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vehiclecosts", prepareListofBean(vehicleCostService.listVehicleCosts()));
		return new ModelAndView("vehicleCostsList", model);
	}

	@RequestMapping(value = "/addVehicleCost", method = RequestMethod.GET)
	public ModelAndView addVehicleCost(@ModelAttribute("command") VehicleCostBean vehicleCostBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vehiclecosts", prepareListofBean(vehicleCostService.listVehicleCosts()));
		model.put("vehicles", prepareVehicleListofBean(vehicleService.listVehicles()));
		model.put("servicetypes", prepareServiceTypeListofBean(serviceTypeService.listServiceTypes()));
		model.put("vehiclecosts", prepareListofBean(vehicleCostService.listVehicleCosts()));
		return new ModelAndView("addVehicleCost", model);
	}

	@RequestMapping(value = "/deleteVehicleCost", method = RequestMethod.GET)
	public ModelAndView deleteVehicleCost(@ModelAttribute("command") VehicleCostBean vehicleCostBean,
			BindingResult result) {
		vehicleCostService.deleteVehicleCost(prepareModel(vehicleCostBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vehiclecost", "null");
		model.put("vehiclecosts", prepareListofBean(vehicleCostService.listVehicleCosts()));
		return new ModelAndView("vehicleCostsList", model);
	}

	@RequestMapping(value = "/editVehicleCost", method = RequestMethod.GET)
	public ModelAndView editVehicleCost(@ModelAttribute("command") VehicleCostBean vehicleCostBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vehiclecost", prepareModelBean(vehicleCostService.getVehicleCost(vehicleCostBean.getId())));
		model.put("vehiclecosts", prepareListofBean(vehicleCostService.listVehicleCosts()));
		model.put("servicetypes", prepareServiceTypeListofBean(serviceTypeService.listServiceTypes()));
		model.put("vehicles", prepareVehicleListofBean(vehicleService.listVehicles()));
		return new ModelAndView("addVehicleCost", model);
	}

	private VehicleCost prepareModel(VehicleCostBean vehicleCostBean) {
		VehicleCost vehicleCost = new VehicleCost();

		vehicleCost.setCostDesc(vehicleCostBean.getCostDesc());
		vehicleCost.setDate(vehicleCostBean.getDate());
		vehicleCost.setTotalPrice(vehicleCostBean.getTotalPrice());
		vehicleCost.setVehicleId(vehicleCostBean.getVehicleId());
		vehicleCost.setServiceTypeId(vehicleCostBean.getServiceTypeId());
		vehicleCost.setVehicleCostId(vehicleCostBean.getId());
		vehicleCostBean.setId(null);
		return vehicleCost;
	}

	private List<VehicleCostBean> prepareListofBean(List<VehicleCost> vehiclecosts) {
		List<VehicleCostBean> beans = null;
		if (vehiclecosts != null && !vehiclecosts.isEmpty()) {
			beans = new ArrayList<VehicleCostBean>();
			VehicleCostBean bean = null;
			for (VehicleCost vehicleCost : vehiclecosts) {
				bean = new VehicleCostBean();
				bean.setId(vehicleCost.getVehicleCostId());
				bean.setCostDesc(vehicleCost.getCostDesc());
				bean.setDate(vehicleCost.getDate());
				bean.setTotalPrice(vehicleCost.getTotalPrice());
				bean.setVehicleName(vehicleService.getVehicle(vehicleCost.getVehicleId()).getVehicleName());
				bean.setServiceTypeName(
						serviceTypeService.getServiceType(vehicleCost.getServiceTypeId()).getServiceTypeName());

				beans.add(bean);
			}
		}
		return beans;
	}

	private List<VehicleBean> prepareVehicleListofBean(List<Vehicle> vehicles) {
		List<VehicleBean> beans = null;
		if (vehicles != null && !vehicles.isEmpty()) {
			beans = new ArrayList<VehicleBean>();
			VehicleBean bean = null;
			for (Vehicle vehicle : vehicles) {
				bean = new VehicleBean();
				bean.setId(vehicle.getVehicleId());
				bean.setVehicleName(vehicle.getVehicleName());
				beans.add(bean);
			}
		}
		return beans;
	}

	private List<ServiceTypeBean> prepareServiceTypeListofBean(List<ServiceType> serviceTypes) {
		List<ServiceTypeBean> beans = null;
		if (serviceTypes != null && !serviceTypes.isEmpty()) {
			beans = new ArrayList<ServiceTypeBean>();
			ServiceTypeBean bean = null;
			for (ServiceType serviceType : serviceTypes) {
				bean = new ServiceTypeBean();
				bean.setId(serviceType.getServiceTypeId());
				bean.setServiceTypeName(serviceType.getServiceTypeName());
				beans.add(bean);
			}
		}
		return beans;
	}

	private VehicleCostBean prepareModelBean(VehicleCost vehicleCost) {
		VehicleCostBean bean = new VehicleCostBean();

		bean.setDate(vehicleCost.getDate());
		bean.setTotalPrice(vehicleCost.getTotalPrice());
		bean.setVehicleId(vehicleCost.getVehicleId());
		bean.setServiceTypeId(vehicleCost.getServiceTypeId());
		bean.setId(vehicleCost.getVehicleCostId());
		bean.setCostDesc(vehicleCost.getCostDesc());
		return bean;
	}
}
