package com.nr.isha.createdonar.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 
import com.nr.isha.createdonar.model.CreateDonor;
 
import com.nr.isha.createdonar.repositoty.DonorRepository;
 

 

 

@Service
@Transactional
public class DonorService {

	@Autowired
	DonorRepository donarRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	 
	
	public boolean isUserExist(Long donarmobile) {
		
		
		
		System.out.println("DOnarService->Mobile"+donarmobile);
		 String query="select * from createdonor where  donormobile=?";
		// Long createDonarmobile=createDonar.getDonarmobile();
		List<CreateDonor> createDonarTemp=jdbcTemplate.query(query,new Object[]{donarmobile} ,new DonarRowMapper());
		 if(createDonarTemp!=null){
			for(CreateDonor createDonariterate:createDonarTemp){
				 if(donarmobile.equals(createDonariterate.getDonormobile())){
					 System.out.println("DonarService=------------------------->true");
					 return true;
				 }
			}
			 
		}
		return false;
	}
	
	
	public CreateDonor getDonorById(Long consumerCode){
		System.out.println("DonorService->getDonorById");
		
		return donarRepository.getOne(consumerCode);
	}
	
	public CreateDonor updateDonor(CreateDonor createDonor){
		System.out.println("DonorService->updateDonor");
		return donarRepository.save(createDonor);
	}
	
	public CreateDonor searchDonar(Long donarmobile){
		System.out.println("DOnarService->Mobile"+donarmobile);
		
		 
		 
		 String query="select * from createDonor  where  donormobile=?";
		// Long createDonarmobile=createDonar.getDonarmobile();
		List<CreateDonor> createDonarTemp=jdbcTemplate.query(query,new Object[]{donarmobile} ,new DonarRowMapper());
		
		 if(createDonarTemp!=null){
			 System.out.println("=================================not nulll======================");
			for(CreateDonor createDonariterate:createDonarTemp){
				 
				 if(donarmobile.equals(createDonariterate.getDonormobile())){
					 System.out.println("DonarService=------------------------->true");
					  
					 return createDonariterate;
				 }
			}
			 
		}
		return null; 
	}
	

	public void saveDonar(CreateDonor createDonar) {
		 
		  donarRepository.save(createDonar);		 
		
	}

	public List<CreateDonor> getAllDonor(){
		System.out.println("DonarService->getAllDonor");
		return (List<CreateDonor>)donarRepository.findAll();		
	}
 
	
	
	 
}
class DonarRowMapper implements RowMapper<CreateDonor>
{
    @Override
    public CreateDonor mapRow(ResultSet rs, int rowNum) throws SQLException {
    	CreateDonor createDonor = new CreateDonor();
    	 
    	createDonor.setConsumerCode(rs.getLong("consumerCode"));
    	createDonor.setDonorfirstname(rs.getString("donorfirstname"));
    	 
    	createDonor.setDonorlastname(rs.getString("donorlastname"));
    	
    	createDonor.setDonormobile(rs.getLong("donormobile"));
    	createDonor.setDonoremail(rs.getString("donoremail"));
    	createDonor.setDonorAddress(rs.getString("donoraddress"));
    	createDonor.setDonorRegion(rs.getString("donorregion"));
    	createDonor.setDonorCity(rs.getString("donorcity"));
    	createDonor.setDonorState(rs.getString("donorstate"));
    	createDonor.setDonorCenter(rs.getString("donorcenter"));
    	createDonor.setBankDetailsAccountHolderName(rs.getString("bankDetailsAccountHolderName"));
    	createDonor.setBankDetailsBankName(rs.getString("bankDetailsBankName"));
    	createDonor.setBankDetailsBranch(rs.getString("bankDetailsBranch"));
    	   
    	createDonor.setBankDetailsIFSCCode(rs.getString("bankDetailsIFSCCode")); 
    	  
    	createDonor.setBankDetailsAccountType(rs.getString("bankDetailsAccountType"));
		  
    	createDonor.setPaymentDetailsStartDate(rs.getDate("paymentDetailsStartDate"));
		  
    	createDonor.setPaymentDetailsEndDate(rs.getDate("paymentDetailsEndDate"));
	  
		 
    	createDonor.setPaymentDetailsAmountInRs(rs.getDouble("paymentDetailsAmountInRs"));
   
    	createDonor.setPaymentDetailsFrequency(rs.getString("paymentDetailsFrequency"));
	  createDonor.setMicr(rs.getDouble("Micr"));
	  createDonor.setBankDetailsAccountNo(rs.getString("bankDetailsAccountNo"));
			createDonor.setComments(rs.getString("Comments"));	 
    	  
  	 System.out.println(createDonor);
  	 
    
    
        return createDonor;
    }

	 
}
 
