package com.isha.donation.DAO;

import java.util.List;

import com.isha.donation.entity.Donor;
import com.isha.donation.entity.UploadDonor;

public interface IshaDonorDao {

	
	public List<Donor> findAllDonor(String status);
	
	
	 
	
}
