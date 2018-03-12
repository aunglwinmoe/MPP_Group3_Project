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

import edu.mum.group3.bean.ServiceLogBean;
import edu.mum.group3.bean.ServiceTypeBean;
import edu.mum.group3.bean.VehicleBean;
import edu.mum.group3.bean.VendorBean;
import edu.mum.group3.model.ServiceLog;
import edu.mum.group3.model.ServiceType;
import edu.mum.group3.model.Vehicle;
import edu.mum.group3.model.Vendor;
import edu.mum.group3.service.ServiceLogService;
import edu.mum.group3.service.ServiceTypeService;
import edu.mum.group3.service.VehicleService;
import edu.mum.group3.service.VendorService;

@Controller
public class ServiceLogController {

	@Autowired
	private ServiceLogService serviceLogService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private ServiceTypeService serviceTypeService;
	
	@Autowired
	private VendorService vendorService;

	@RequestMapping(value = "/saveServiceLog", method = RequestMethod.POST)
	public ModelAndView saveServiceLog(@ModelAttribute("command") ServiceLogBean serviceLogBean, BindingResult result) {
		ServiceLog serviceLog = prepareModel(serviceLogBean);
		serviceLogService.addServiceLog(serviceLog);
		return new ModelAndView("redirect:/serviceLogs.html");
	}

	@RequestMapping(value = "/serviceLogs", method = RequestMethod.GET)
	public ModelAndView listServiceLogs() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("serviceLogs", prepareListofBean(serviceLogService.listServiceLogs()));
		return new ModelAndView("serviceLogsList", model);
	}

	@RequestMapping(value = "/addServiceLog", method = RequestMethod.GET)
	public ModelAndView addServiceLog(@ModelAttribute("command") ServiceLogBean serviceLogBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("serviceLogs", prepareListofBean(serviceLogService.listServiceLogs()));
		model.put("vehicles", prepareVehicleListofBean(vehicleService.listVehicles()));
		model.put("serviceTypes", prepareServiceTypeListofBean(serviceTypeService.listServiceTypes()));
		model.put("vendors", prepareVendorListofBean(vendorService.listVendors()));
		return new ModelAndView("addServiceLog", model);
	}

	@RequestMapping(value = "/deleteServiceLog", method = RequestMethod.GET)
	public ModelAndView deleteServiceLog(@ModelAttribute("command") ServiceLogBean serviceLogBean, BindingResult result) {
		serviceLogService.deleteServiceLog(prepareModel(serviceLogBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("serviceLog", "null");
		model.put("serviceLogs", prepareListofBean(serviceLogService.listServiceLogs()));
		return new ModelAndView("serviceLogsList", model);
	}

	@RequestMapping(value = "/editServiceLog", method = RequestMethod.GET)
	public ModelAndView editServiceLog(@ModelAttribute("command") ServiceLogBean serviceLogBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("serviceLog", prepareServiceLogBean(serviceLogService.getServiceLog(serviceLogBean.getId())));
		model.put("serviceLogs", prepareListofBean(serviceLogService.listServiceLogs()));
		return new ModelAndView("addServiceLog", model);
	}

	private ServiceLog prepareModel(ServiceLogBean serviceLogBean) {
		ServiceLog serviceLog = new ServiceLog();
		serviceLog.setLogId(serviceLogBean.getId());
		serviceLog.setVehicleId(serviceLogBean.getVehicleId());
		serviceLog.setServiceTypeId(serviceLogBean.getServiceTypeId());
		serviceLog.setTotalPrice(serviceLogBean.getTotalPrice());
		serviceLog.setOdometerVal(serviceLogBean.getOdometerVal());
		serviceLog.setDate(serviceLogBean.getDate());
		serviceLog.setVendorId(serviceLogBean.getVendorId());
		serviceLog.setInvoiceRef(serviceLogBean.getInvoiceRef());
		serviceLogBean.setId(null);
		return serviceLog;
	}

	private List<ServiceLogBean> prepareListofBean(List<ServiceLog> serviceLogs) {
		List<ServiceLogBean> beans = null;
		if (serviceLogs != null && !serviceLogs.isEmpty()) {
			beans = new ArrayList<ServiceLogBean>();
			ServiceLogBean bean = null;
			for (ServiceLog serviceLog : serviceLogs) {
				bean = new ServiceLogBean();
				bean.setId(serviceLog.getLogId());
				bean.setVehicleName(vehicleService.getVehicle(serviceLog.getVehicleId()).getVehicleName());
				bean.setServiceTypeName(serviceTypeService.getServiceType(serviceLog.getServiceTypeId()).getServiceTypeName());
				bean.setTotalPrice(serviceLog.getTotalPrice());
				bean.setOdometerVal(serviceLog.getOdometerVal());
				bean.setDate(serviceLog.getDate());
				bean.setVendorName(vendorService.getVendor(serviceLog.getVendorId()).getVendorName());
				bean.setInvoiceRef(serviceLog.getInvoiceRef());
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
	
	private List<VendorBean> prepareVendorListofBean(List<Vendor> vendors) {
		List<VendorBean> beans = null;
		if (vendors != null && !vendors.isEmpty()) {
			beans = new ArrayList<VendorBean>();
			VendorBean bean = null;
			for (Vendor vendor : vendors) {
				bean = new VendorBean();
				bean.setId(vendor.getVendorId());
				bean.setVendorName(vendor.getVendorName());
				beans.add(bean);
			}
		}
		return beans;
	}

	private ServiceLogBean prepareServiceLogBean(ServiceLog serviceLog) {
		ServiceLogBean bean = new ServiceLogBean();
		bean.setId(serviceLog.getLogId());
		bean.setVehicleId(serviceLog.getVehicleId());
		bean.setServiceTypeId(serviceLog.getServiceTypeId());
		bean.setTotalPrice(serviceLog.getTotalPrice());
		bean.setOdometerVal(serviceLog.getOdometerVal());
		bean.setDate(serviceLog.getDate());
		bean.setVendorId(serviceLog.getVendorId());
		bean.setInvoiceRef(serviceLog.getInvoiceRef());
		return bean;
	}
}
