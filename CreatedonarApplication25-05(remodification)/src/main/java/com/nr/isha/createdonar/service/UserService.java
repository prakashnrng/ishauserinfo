package com.nr.isha.createdonar.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.nr.isha.createdonar.model.RegistrationUser;
import com.nr.isha.createdonar.repositoty.UserRepository;
 

@Service
public class UserService {
	
	@Autowired
	 JdbcTemplate jtemp;
	 
	@Autowired
		UserRepository userRepository;
	 
	 
	public List<RegistrationUser> getAlltopic(){
		 return (List<RegistrationUser>) userRepository.findAll();
	 }
	
	public RegistrationUser getUserById(Long id){
		
		return  userRepository.getOne(id);
	//List<User>list=(List<User>)userRepository.findById(id);
 
		  
	}
	
	public void add(RegistrationUser u){
		System.out.println("userService->"+u);
		userRepository.save(u);
	}

	public void update(RegistrationUser user) {
		System.out.println("UserSErvice->id"+user);
		  
		userRepository.save(user);
		 
		  /*int count=0;
		 for(User u:l){
			 if(u.getId()==id){
				 l.set(count,user);
				 
			 }count++;
		 }*/
		 
		
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
		 
		 
	}
	/*public RegistrationUser findByName(String name) {
		return userRepository.findByName(name);
	}
*/
	 
	 
	public RegistrationUser findUser(RegistrationUser user) {
		 
Long mobile=user.getRegistrationMobile();

		RegistrationUser registrationUser=jtemp.queryForObject("select * from registrationUser where registrationmobile=?",
        new Object[]{mobile}, new UserRowMappe());

 
if(user!=null){
		return user;
}
		return null;
	}

 
	public RegistrationUser getByMobileNumber(Long mobileno){
		String query="select * from registrationuser where registrationmobile=?";
		List<RegistrationUser> listofRegistrationuser=jtemp.query(query, new Object[]{mobileno},new UserRowMappe());
		RegistrationUser registrationUsertemp=null;
		for(RegistrationUser registrationUseriterate:listofRegistrationuser){
			 
			registrationUsertemp=new RegistrationUser(registrationUseriterate.getRegistrationUserid(), registrationUseriterate.getRegistrationFirstName(), registrationUseriterate.getRegistrationLastName(),registrationUseriterate.getRegistrationEmail(), registrationUseriterate.getRegistrationMobile(), registrationUseriterate.getRegistrationPasscode(), registrationUseriterate.getRegistrationConfirmPasscode(), registrationUseriterate.getRegistrationStatus());
	System.out.println(registrationUsertemp);
		}
		
		
		if(registrationUsertemp!=null){
			
		 
			return registrationUsertemp;
		}
		 
		return null; 
		
	}
	
 
	 
	
	
	public boolean isUserExist(Long mbl) {
		 
		 
		 System.out.println(mbl+"==========================================");
	 
		 
		 
		 String query="select * from registrationuser where registrationmobile=?";
		 
		 
		
		 List<RegistrationUser> registrationUser= jtemp.query(query,new Object[]{mbl},new UserRowMappe());
		 for(RegistrationUser r:registrationUser){
			 System.out.println(r);
		 }
		 if(registrationUser!=null){
			 System.out.println("===============================================================================================");
			 for(RegistrationUser r:registrationUser){
				 System.out.println("------------------------------------------------------------------------------------------------------");
				 System.out.println(r);
				 System.out.println("------------------------------------------------------------------------------------------------------");
				 Long mboile=r.getRegistrationMobile();
				 System.out.println(mboile+"################################################################"+mbl);
				 if(mboile.equals(mbl)){
					 System.out.println("***************************************************************");
					 return true;
				 } 
			 }
			  
			  }
			   
			 
		  return false;
		
	}
 
	public RegistrationUser verifyUser(Long registrationmobile,String registrationPasscode){
		System.out.println("UserService->verifyUser"+"\t"+registrationmobile+"\t"+registrationPasscode);
		
		
		String query="select * from RegistrationUser where registrationPasscode=? and registrationMobile=?";
		List<RegistrationUser> registrationUserfetch=jtemp.query(query, new Object[]{registrationPasscode,registrationmobile},new UserRowMappe());
		 
		for(RegistrationUser reg:registrationUserfetch){
			System.out.println(reg);
		}
		RegistrationUser registrationUser=null;
		if(registrationUserfetch!=null){
			for(RegistrationUser registrationiterate:registrationUserfetch){
				registrationUser=new RegistrationUser(registrationiterate.getRegistrationUserid(), registrationiterate.getRegistrationFirstName(), registrationiterate.getRegistrationLastName(),registrationiterate.getRegistrationEmail(), registrationiterate.getRegistrationMobile(),registrationiterate.getRegistrationPasscode(), registrationiterate.getRegistrationConfirmPasscode(), registrationiterate.getRegistrationStatus());
				return registrationUser;
			}
		 	
	}

		return null;
}
	
	public RegistrationUser verifyUser(String registrationEmail,String registrationPasscode){
		System.out.println("UserService->verifyUser"+"\t"+registrationEmail+"\t"+registrationPasscode);
		
		String query="select * from RegistrationUser where registrationEmail=? and registrationPasscode=?";
		List<RegistrationUser> registrationUserfetch=jtemp.query(query, new Object[]{registrationEmail,registrationPasscode},new UserRowMappe());
		for(RegistrationUser reg:registrationUserfetch){
			System.out.println(reg);
		} 
		
		RegistrationUser registrationUser=null;
		if(registrationUserfetch!=null){
			for(RegistrationUser registrationiterate:registrationUserfetch){
				registrationUser=new RegistrationUser(registrationiterate.getRegistrationUserid(), registrationiterate.getRegistrationFirstName(), registrationiterate.getRegistrationLastName(),registrationiterate.getRegistrationEmail(), registrationiterate.getRegistrationMobile(),registrationiterate.getRegistrationPasscode(), registrationiterate.getRegistrationConfirmPasscode(), registrationiterate.getRegistrationStatus());
				return registrationUser;
			}
		 	
	}

		return null;
}	
	
}
class UserRowMappe implements RowMapper<RegistrationUser>
{
    @Override
    public RegistrationUser mapRow(ResultSet rs, int rowNum) throws SQLException {
    	RegistrationUser user = new RegistrationUser();
       user.setRegistrationUserid(rs.getLong("registrationUserid"));
         user.setRegistrationFirstName(rs.getString("registrationfirstname"));
         user.setRegistrationLastName(rs.getString("registrationlastname"));
         
         user.setRegistrationEmail(rs.getString("registrationemail"));
         user.setRegistrationMobile(rs.getLong("registrationmobile"));
        user.setRegistrationPasscode(rs.getString("registrationpasscode"));
         user.setRegistrationConfirmPasscode(rs.getString("registrationconfirmpasscode"));
         user.setRegistrationStatus(rs.getString("registrationstatus"));
          
               
        return user;
    }

	 
}

