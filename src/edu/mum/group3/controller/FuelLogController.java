package edu.mum.group3.controller;

import java.time.LocalDate;
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

import edu.mum.group3.bean.FuelLogBean;
import edu.mum.group3.model.FuelLog;
import edu.mum.group3.service.FuelLogService;

/**
 * @author Lwin Moe Aung
 *
 */
@Controller
public class FuelLogController {

	@Autowired
	private FuelLogService fuelLogService;

	@RequestMapping(value = "/saveFuelLog", method = RequestMethod.POST)
	public ModelAndView saveFuelLog(@ModelAttribute("command") FuelLogBean fuelLogBean, BindingResult result) {
		FuelLog fuelLog = prepareModel(fuelLogBean);
		fuelLogService.addFuelLog(fuelLog);
		return new ModelAndView("redirect:/fuelLogs.html");
	}

	@RequestMapping(value = "/fuelLogs", method = RequestMethod.GET)
	public ModelAndView listFuelLogs() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("fuelLogs", prepareListofBean(fuelLogService.listFuelLogs()));
		return new ModelAndView("fuelLogsList", model);
	}

	@RequestMapping(value = "/addFuelLog", method = RequestMethod.GET)
	public ModelAndView addFuelLog(@ModelAttribute("command") FuelLogBean fuelLogBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("fuelLogs", prepareListofBean(fuelLogService.listFuelLogs()));
		return new ModelAndView("addFuelLog", model);
	}

	@RequestMapping(value = "/deleteFuelLog", method = RequestMethod.GET)
	public ModelAndView deleteFuelLog(@ModelAttribute("command") FuelLogBean fuelLogBean, BindingResult result) {
		fuelLogService.deleteFuelLog(prepareModel(fuelLogBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("fuelLog", "null");
		model.put("fuelLogs", prepareListofBean(fuelLogService.listFuelLogs()));
		return new ModelAndView("fuelLogsList", model);
	}

	@RequestMapping(value = "/editFuelLog", method = RequestMethod.GET)
	public ModelAndView editFuelLog(@ModelAttribute("command") FuelLogBean fuelLogBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("fuelLog", prepareModelBean(fuelLogService.getFuelLog(fuelLogBean.getId())));
		model.put("fuelLogs", prepareListofBean(fuelLogService.listFuelLogs()));
		return new ModelAndView("addFuelLog", model);
	}

	private FuelLog prepareModel(FuelLogBean fuelLogBean) {
		FuelLog fuelLog = new FuelLog();

		fuelLog.setDate(fuelLogBean.getDate());
		fuelLog.setInvoiceReference(fuelLogBean.getInvoiceReference());
		fuelLog.setLiter(fuelLogBean.getLiter());
		fuelLog.setOtherInfo(fuelLogBean.getOtherInfo());
		fuelLog.setPricePerLiter(fuelLogBean.getPricePerLiter());
		fuelLog.setPurchaserId(fuelLogBean.getPurchaserId());
		fuelLog.setTotalPrice(fuelLogBean.getTotalPrice());
		fuelLog.setVehicleId(fuelLogBean.getVehicleId());
		fuelLog.setVendorId(fuelLogBean.getVendorId());

		fuelLog.setFuelLogId(fuelLogBean.getId());
		fuelLogBean.setId(null);
		return fuelLog;
	}

	private List<FuelLogBean> prepareListofBean(List<FuelLog> fuelLogs) {
		List<FuelLogBean> beans = null;
		if (fuelLogs != null && !fuelLogs.isEmpty()) {
			beans = new ArrayList<FuelLogBean>();
			FuelLogBean bean = null;
			for (FuelLog fuelLog : fuelLogs) {
				bean = new FuelLogBean();

				bean.setId(fuelLog.getFuelLogId());

				bean.setDate(fuelLog.getDate());
				bean.setInvoiceReference(fuelLog.getInvoiceReference());
				bean.setLiter(fuelLog.getLiter());
				bean.setOtherInfo(fuelLog.getOtherInfo());
				bean.setPricePerLiter(fuelLog.getPricePerLiter());
				bean.setPurchaserId(fuelLog.getPurchaserId());
				bean.setTotalPrice(fuelLog.getTotalPrice());
				bean.setVehicleId(fuelLog.getVehicleId());
				bean.setVendorId(fuelLog.getVendorId());
				beans.add(bean);
			}
		}
		return beans;
	}

	private FuelLogBean prepareModelBean(FuelLog fuelLog) {
		FuelLogBean bean = new FuelLogBean();

		bean.setDate(fuelLog.getDate());
		bean.setInvoiceReference(fuelLog.getInvoiceReference());
		bean.setLiter(fuelLog.getLiter());
		bean.setOtherInfo(fuelLog.getOtherInfo());
		bean.setPricePerLiter(fuelLog.getPricePerLiter());
		bean.setPurchaserId(fuelLog.getPurchaserId());
		bean.setTotalPrice(fuelLog.getTotalPrice());
		bean.setVehicleId(fuelLog.getVehicleId());
		bean.setVendorId(fuelLog.getVendorId());
		bean.setId(fuelLog.getFuelLogId());
		return bean;
	}
}
