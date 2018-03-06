package edu.mum.group3.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.group3.model.Vendor;

/**
 * @author Lwin Moe Aung
 *
 */
@Repository("vendorDao")
public class VendorDaoImpl implements VendorDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addVendor(Vendor vendor) {
		sessionFactory.getCurrentSession().saveOrUpdate(vendor);
	}

	@SuppressWarnings("unchecked")
	public List<Vendor> listVendors() {
		return (List<Vendor>) sessionFactory.getCurrentSession().createCriteria(Vendor.class).list();
	}

	public Vendor getVendor(int empid) {
		return (Vendor) sessionFactory.getCurrentSession().get(Vendor.class, empid);
	}

	public void deleteVendor(Vendor vendor) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Vendor WHERE vendorid = " + vendor.getVendorId())
				.executeUpdate();
	}

}
