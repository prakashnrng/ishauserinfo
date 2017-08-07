package com.isha.donation.Service;

import java.util.List;

import com.isha.donation.entity.Donor;
import com.isha.donation.entity.UploadDonor;

public interface IshaDonorService {

	public List<Donor> findAllDonor(String status);
	
	public void saveUploadedDonor(UploadDonor uploadonor);
	
}
