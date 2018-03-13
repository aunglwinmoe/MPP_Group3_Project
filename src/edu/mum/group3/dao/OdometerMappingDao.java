package edu.mum.group3.dao;

import java.util.List;

import edu.mum.group3.model.OdometerMapping;

public interface OdometerMappingDao {

	public void addOdometerMapping(OdometerMapping odometerMapping);

	public List<OdometerMapping> listOdometerMappings();
	
	public OdometerMapping getOdometerMapping(int odometerMappingId);
	
	public void deleteOdometerMapping(OdometerMapping odometerMapping);
}
