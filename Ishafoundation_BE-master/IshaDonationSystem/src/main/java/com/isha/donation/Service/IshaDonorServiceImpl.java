package com.isha.donation.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isha.donation.DAO.IshaDonorDao;
import com.isha.donation.entity.Donor;


@Service("ishaDonorService")
@Transactional
public class IshaDonorServiceImpl implements IshaDonorService{
	
	 @Autowired
	 private IshaDonorDao ishaDonorDao;
	
	@Override
	public List<Donor> findAllDonor() {
	 
		return ishaDonorDao.findAllDonor();
	}

}
