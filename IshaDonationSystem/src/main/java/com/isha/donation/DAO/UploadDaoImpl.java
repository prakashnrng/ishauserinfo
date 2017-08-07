package com.isha.donation.DAO;

import java.io.Serializable;

import com.isha.donation.entity.UploadDonor;

public class UploadDaoImpl extends AbstractDao<Long, UploadDonor> implements UploadDAO{

	@Override
	public void saveUploadedDonor(UploadDonor uploadonor) {
		 
		persist(uploadonor);
		
	}
	

}
