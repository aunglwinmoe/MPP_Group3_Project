package edu.mum.group3.service;

import java.util.List;

import edu.mum.group3.model.Vendor;

/**
 * @author Lwin Moe Aung
 *
 */
public interface VendorService {

	public void addVendor(Vendor vendor);

	public List<Vendor> listVendors();

	public Vendor getVendor(int vendorid);

	public void deleteVendor(Vendor vendor);
}
