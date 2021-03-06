package com.isha.donation.DAO;

 

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.isha.donation.DAO.AbstractDao;
import com.isha.donation.entity.Donor;
import com.isha.donation.entity.UploadDonor;

@Repository("ishaDonor")
public class IshaDonorImpl extends AbstractDao<Long,Donor>  implements IshaDonorDao{
	
	
	 @SuppressWarnings("unchecked")
	@Override
	public List<Donor> findAllDonor(String status) {
		 Criteria criteria= createEntityCriteria();
		 criteria.add(Restrictions.eq("status",status));
		 //criteria.addOrder(Order.asc("type"));
		 
		return (List<Donor>)criteria.list();
	}
	 
	 
	 
	 

}
