package com.nr.isha.createdonar.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

 
import com.nr.isha.createdonar.model.CreateDonor;
import com.nr.isha.createdonar.model.RegistrationUser;
import com.nr.isha.createdonar.service.DonorService;
import com.nr.isha.createdonar.service.UserService;
 
 
 
 
@Controller
public class DonorController {
	
@Autowired
DonorService donarService;

@Autowired
UserService userService;

	@RequestMapping(method=RequestMethod.POST, value="/donar1/")
	 public ResponseEntity<?>  addUser(@RequestBody @Valid CreateDonor createDonar, UriComponentsBuilder ucBuilder){
		 System.out.println("HomeController->addUse->"+createDonar);
		
		 
		  
			  Long mobile=createDonar.getDonormobile();
			
			System.out.println("DOnarController->Mobile"+mobile);
			 
		 
		 boolean verify=donarService.isUserExist(mobile);
		 if(verify){
			 return new ResponseEntity("Unable to create. A User with name " + 
					 createDonar.getDonorlastname() + " already exist.",HttpStatus.CONFLICT);
		 }else{
			 donarService.saveDonar(createDonar);
		 }    
		 HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/donar1/{id}").buildAndExpand(createDonar.getConsumerCode()).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		  
		  
	 }
	 
	@RequestMapping(method=RequestMethod.GET,value="/donar1/{donarmobile}")
	public ResponseEntity<?> searchUser(@PathVariable("donarmobile")Long donarmobile){
		
		System.out.println("DOnarController->searchUser");
		if(donarmobile!=0){
			CreateDonor createdonarcatch=donarService.searchDonar(donarmobile);
			if(createdonarcatch==null){
				return new ResponseEntity("enter the mobile no " + 
						donarmobile	  + " not exist.",HttpStatus.CONFLICT);
			}else{
				return new ResponseEntity<CreateDonor>(createdonarcatch,HttpStatus.OK);
			}
		}else{
			return new ResponseEntity("enter the mobile no " + 
					donarmobile	  + "  .",HttpStatus.NOT_FOUND);
		}
		
	}
	
	 @RequestMapping(method=RequestMethod.GET,value="/donar1")
		public ResponseEntity<?> searchAllUser(){
			System.out.println("DOnarController->SearchAllUser");
			List<CreateDonor> listofdonor=donarService.getAllDonor();
			
			if(listofdonor==null){
				 return new ResponseEntity("no data availabe in a database "  
						   ,HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<List<CreateDonor>>(listofdonor,HttpStatus.OK);
			}
			
		}
	 
	 @RequestMapping(value = "/hello1")  
 	 public ResponseEntity<List<RegistrationUser>> getTopic(){
	 
	  List<RegistrationUser> listofuser=userService.getAlltopic();
	  if(listofuser==null){
		  return new ResponseEntity("Unable to get data from. User  not found.",
					HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<List<RegistrationUser>>(listofuser,HttpStatus.OK);
	  }
	  
 }
	 
	 @RequestMapping(method=RequestMethod.PUT, value="/donar1/{consumerCode}")
	 public ResponseEntity<?> updateUser(@PathVariable("consumerCode")Long consumerCode,@RequestBody CreateDonor createDonor){
		 System.out.println("HomeController->"+consumerCode);
		 CreateDonor createDonorfetch =donarService.getDonorById(consumerCode);
		 
		
		if(createDonorfetch==null){
			return new ResponseEntity("Unable to fin createdonor  with id " + createDonorfetch.getConsumerCode()  + " not found.",
					HttpStatus.NOT_FOUND);
			//return new ResponseEntity("Unable to upate. User with id " + user.getId() + " not found.",HttpStatus.NOT_FOUND);
		}
			CreateDonor createDonorupdateresult=donarService.updateDonor(createDonor);
		
		
		
		return new ResponseEntity<CreateDonor>(createDonorupdateresult, HttpStatus.OK);
	 }  
	 
 
 
 @RequestMapping(method=RequestMethod.POST, value="/hello1/")
 public ResponseEntity<?>  addUser(@RequestBody RegistrationUser user, UriComponentsBuilder ucBuilder){
	 System.out.println("HomeController->addUse->"+user);
	 userService.add(user);
	 
/* boolean verify=userService.isUserExist(user.getRegistrationMobile());
	 if(verify){
		 return new ResponseEntity("Unable to create. A User with name " + 
					user.getRegistrationFirstName() + " already exist.",HttpStatus.CONFLICT);
	 }else{
		 userService.add(user);
	 } */
	 HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/hello1/{id}").buildAndExpand(user.getRegistrationUserid()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	 
	  
 }
 
 
 
 
  @RequestMapping(method=RequestMethod.GET, value="/hello1/{registrationMobile}")
 public ResponseEntity<?> isUserExist(@PathVariable("registrationMobile")Long registrationMobile){
	 System.out.println("HomeController->"+registrationMobile);
	RegistrationUser registrationuser=userService.getByMobileNumber(registrationMobile);
	
	if(registrationuser==null){
		return new ResponseEntity("Unable to fin RegistrationUser with id " +registrationMobile  + " not found.",
				HttpStatus.NOT_FOUND);
	 
	}
	
	return new ResponseEntity<RegistrationUser>(registrationuser, HttpStatus.OK);
 }
  
  
  @RequestMapping(method=RequestMethod.PUT, value="/hello1/{registrationuserid}")
	 public ResponseEntity<?> updateUser(@PathVariable("registrationuserid")Long registrationuserid,@RequestBody RegistrationUser registrationUser){
		 System.out.println("HomeController->"+registrationuserid);
		RegistrationUser registrationuserfetch=userService.getUserById(registrationuserid);
		
		if(registrationuserfetch==null){
			return new ResponseEntity("Unable to fin RegistrationUser with id " + registrationuserid  + " not found.",
					HttpStatus.NOT_FOUND);
			//return new ResponseEntity("Unable to upate. User with id " + user.getId() + " not found.",HttpStatus.NOT_FOUND);
		}else{
			userService.update(registrationUser);
		}
		
		
		return new ResponseEntity<RegistrationUser>(registrationUser, HttpStatus.OK);
	 }  
  
  
 
  @RequestMapping(method=RequestMethod.GET, value="/hello2/{registrationmobile}/{registratinpassword}")
	 public ResponseEntity<?> verifyRegistrationUser(@PathVariable("registrationmobile")String registrationmobile,@PathVariable("registratinpassword")String registratinpassword){
	  
	  
		 System.out.println("HomeController->verifyRegistrationUser" );
		 
		 String tempemail=null;
		 long mobileno=0;
		 
		 String password=registratinpassword;
		 String registrationemail=registrationmobile;
		 if(registrationemail.matches("[a-zA-Z]+")&&registrationemail!=null){
			 tempemail=registrationemail;			 
			 System.out.println("DOnorController->verifyUser->"+"\t"+tempemail);
		 }else if(registrationemail.matches("[0-9]+")){
			mobileno=Long.parseLong(registrationemail);
			System.out.println("DOnorController->verifyUser->"+"\t"+mobileno);
		 }
	 	 
		  
			 if(mobileno!=0&registratinpassword!=null){
				 RegistrationUser registrationUsertemp=userService.verifyUser(mobileno,registratinpassword);
			 					if(registrationUsertemp!=null){
			 						return new ResponseEntity<RegistrationUser>(registrationUsertemp, HttpStatus.OK);
			 					} 
			 }
			 
		 else  if(registrationemail!=null&registratinpassword!=null){
			 RegistrationUser registrationUsertemp=userService.verifyUser(registrationemail,registratinpassword);
			 if(registrationUsertemp!=null){
					return new ResponseEntity<RegistrationUser>(registrationUsertemp, HttpStatus.OK);
				} 
					
				
		 }
		 return new ResponseEntity(" please enter correct username and mobile no",
					HttpStatus.NOT_FOUND);
		 
	 
	 } 
   
  
  
 
 @RequestMapping(method=RequestMethod.DELETE,value="/hello1/{id}")
 public ResponseEntity<?>  delete(@PathVariable("id")Long id){
	 
 
	  
	 RegistrationUser user = userService.getUserById(id);
		if (user == null) {
		//	logger.error("Unable to delete. User with id {} not found.", id);
			return new ResponseEntity("Unable to delete. User with id " + id + " not found.",
					HttpStatus.NOT_FOUND);
		}
		if(user!=null){
		userService.delete(id);
		}
		return new ResponseEntity<RegistrationUser>(HttpStatus.NO_CONTENT);
	  
 }
	 
	 
	}
	 
 
