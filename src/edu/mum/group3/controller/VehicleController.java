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
import edu.mum.group3.bean.VehicleBean;
import edu.mum.group3.model.Model;
import edu.mum.group3.model.Vehicle;
import edu.mum.group3.service.ModelService;
import edu.mum.group3.service.VehicleService;

/**
 * @author Lwin Moe Aung
 *
 */
@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private ModelService modelService;
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/saveVehicle", method = RequestMethod.POST)
	public ModelAndView saveVehicle(@ModelAttribute("command") VehicleBean vehicleBean, BindingResult result) {
		Vehicle vehicle = prepareModel(vehicleBean);
		vehicleService.addVehicle(vehicle);
		return new ModelAndView("redirect:/vehicles.html");
	}

	@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
	public ModelAndView listVehicles() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vehicles", prepareListofBean(vehicleService.listVehicles()));
		return new ModelAndView("vehiclesList", model);
	}

	@RequestMapping(value = "/addVehicle", method = RequestMethod.GET)
	public ModelAndView addVehicle(@ModelAttribute("command") VehicleBean vehicleBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vehicles", prepareListofBean(vehicleService.listVehicles()));
		model.put("models", prepareModelListofBean(modelService.listModels()));
		return new ModelAndView("addVehicle", model);
	}

	@RequestMapping(value = "/deleteVehicle", method = RequestMethod.GET)
	public ModelAndView deleteVehicle(@ModelAttribute("command") VehicleBean vehicleBean, BindingResult result) {
		vehicleService.deleteVehicle(prepareModel(vehicleBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vehicle", "null");
		model.put("vehicles", prepareListofBean(vehicleService.listVehicles()));
		return new ModelAndView("vehiclesList", model);
	}

	@RequestMapping(value = "/editVehicle", method = RequestMethod.GET)
	public ModelAndView editVehicle(@ModelAttribute("command") VehicleBean vehicleBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vehicle", prepareModelBean(vehicleService.getVehicle(vehicleBean.getId())));
		model.put("vehicles", prepareListofBean(vehicleService.listVehicles()));
		model.put("models", prepareModelListofBean(modelService.listModels()));
		return new ModelAndView("addVehicle", model);
	}

	private Vehicle prepareModel(VehicleBean vehicleBean) {
		Vehicle vehicle = new Vehicle();		

		String vehicleName = vehicleBean.getLicensePlate() +"/ " + vehicleBean.getChassisNumber();
		vehicle.setVehicleName(vehicleName);
		vehicle.setModelId(vehicleBean.getModelId());
		vehicle.setLicensePlate(vehicleBean.getLicensePlate());
		vehicle.setChassisNumber(vehicleBean.getChassisNumber());
		vehicle.setModelYear(vehicleBean.getModelYear());
		vehicle.setLastOdometer(vehicleBean.getLastOdometer());
		vehicle.setImmatriculationDate(vehicleBean.getImmatriculationDate());
		vehicle.setCatalogVal(vehicleBean.getCatalogVal());
		vehicle.setResidualVal(vehicleBean.getResidualVal());
		vehicle.setSeatsNum(vehicleBean.getSeatsNum());
		vehicle.setDoorsNum(vehicleBean.getDoorsNum());
		vehicle.setColor(vehicleBean.getColor());
		vehicle.setTransmission(vehicleBean.getTransmission());
		vehicle.setFuelType(vehicleBean.getFuelType());
		vehicle.setHorsePower(vehicleBean.getHorsePower());
		vehicle.setPower(vehicleBean.getPower());
		vehicle.setLimitedOdometer(vehicleBean.getLimitedOdometer());
		vehicle.setStatus(vehicleBean.getStatus());
		vehicle.setVehicleId(vehicleBean.getId());
		vehicleBean.setId(null);
		return vehicle;
	}

	private List<VehicleBean> prepareListofBean(List<Vehicle> vehicles) {
		List<VehicleBean> beans = null;
		if (vehicles != null && !vehicles.isEmpty()) {
			beans = new ArrayList<VehicleBean>();
			VehicleBean bean = null;
			for (Vehicle vehicle : vehicles) {
				bean = new VehicleBean();
				bean.setVehicleName(vehicle.getVehicleName());
				bean.setModelName(modelService.getModel(vehicle.getModelId()).getModelName());
				bean.setId(vehicle.getVehicleId());				
				bean.setLicensePlate(vehicle.getLicensePlate());
				bean.setChassisNumber(vehicle.getChassisNumber());
				bean.setModelYear(vehicle.getModelYear());
				bean.setLastOdometer(vehicle.getLastOdometer());
				bean.setImmatriculationDate(vehicle.getImmatriculationDate());
				bean.setCatalogVal(vehicle.getCatalogVal());
				bean.setResidualVal(vehicle.getResidualVal());
				bean.setSeatsNum(vehicle.getSeatsNum());
				bean.setDoorsNum(vehicle.getDoorsNum());
				bean.setColor(vehicle.getColor());
				bean.setTransmission(vehicle.getTransmission());
				bean.setFuelType(vehicle.getFuelType());
				bean.setHorsePower(vehicle.getHorsePower());
				bean.setPower(vehicle.getPower());
				bean.setLimitedOdometer(vehicle.getLimitedOdometer());
				bean.setStatus(vehicle.getStatus());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<ModelBean> prepareModelListofBean(List<Model> models) {
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

	private VehicleBean prepareModelBean(Vehicle vehicle) {
		VehicleBean bean = new VehicleBean();
		
		bean.setVehicleName(vehicle.getVehicleName());
		bean.setModelId(vehicle.getModelId());
		bean.setLicensePlate(vehicle.getLicensePlate());
		bean.setChassisNumber(vehicle.getChassisNumber());
		bean.setModelYear(vehicle.getModelYear());
		bean.setLastOdometer(vehicle.getLastOdometer());
		bean.setImmatriculationDate(vehicle.getImmatriculationDate());
		bean.setCatalogVal(vehicle.getCatalogVal());
		bean.setResidualVal(vehicle.getResidualVal());
		bean.setSeatsNum(vehicle.getSeatsNum());
		bean.setDoorsNum(vehicle.getDoorsNum());
		bean.setColor(vehicle.getColor());
		bean.setTransmission(vehicle.getTransmission());
		bean.setFuelType(vehicle.getFuelType());
		bean.setHorsePower(vehicle.getHorsePower());
		bean.setPower(vehicle.getPower());
		bean.setLimitedOdometer(vehicle.getLimitedOdometer());
		bean.setStatus(vehicle.getStatus());
		bean.setId(vehicle.getVehicleId());
		return bean;
	}
}
