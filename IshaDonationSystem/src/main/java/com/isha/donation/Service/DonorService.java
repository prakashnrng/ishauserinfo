package com.isha.donation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.isha.donation.DAO.IshaDonorDao;
import com.isha.donation.entity.Donor;
import com.isha.donation.repository.IDonorRepository;

@Service
public class DonorService {

	 
    @Autowired
    private IDonorRepository mDonorRepository;

    @Autowired
    private IshaDonorDao donorRepository;
    
    public Object findAll() {
        return mDonorRepository.findAll();
    }
    
    
   /* public List<Donor> findAllDonor(){
    	return donorRepository.findAllDonor();
    }*/
    

    public Donor findById(Long id) {
        return mDonorRepository.findOne(id);
    }

    public Donor save(Donor donor) {
        return mDonorRepository.save(donor);
    }

    public void delete(Donor donor) {
        mDonorRepository.delete(donor);
        return;
    }

    public Donor findByMobileNumber(String mobileNumber) {
        return mDonorRepository.findByMobileNumber(mobileNumber);
    }
    
    
    public Donor findByid(String TPPSConsumerCode){
    	return mDonorRepository.findById(TPPSConsumerCode);
    }
}