package edu.mum.group3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.group3.dao.VendorDao;
import edu.mum.group3.model.Vendor;

/**
 * @author Lwin Moe Aung
 *
 */
@Service("vendorService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorDao vendorDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addVendor(Vendor vendor) {
		vendorDao.addVendor(vendor);
	}
	
	public List<Vendor> listVendors() {
		return vendorDao.listVendors();
	}

	public Vendor getVendor(int vendorid) {
		return vendorDao.getVendor(vendorid);
	}
	
	public void deleteVendor(Vendor vendor) {
		vendorDao.deleteVendor(vendor);
	}

}
