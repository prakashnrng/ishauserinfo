package com.nr.isha.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nr.isha.User;
import com.nr.isha.repository.UserRepository;

@Service
public class UserService {

	@Autowired
		UserRepository userRepository;
	 
	 
	public List<User> getAlltopic(){
		 return (List<User>) userRepository.findAll();
	 }
	
	public Optional<User> gettopic(Long id){
		
		return userRepository.findById(id);
	//List<User>list=(List<User>)userRepository.findById(id);
 
		  
	}
	
	public void add(User u){
		System.out.println("userService->"+u);
		userRepository.save(u);
	}

	public void update(User user) {
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
		/*int count=0;
		  for(int i=0;i<l.size();i++){
			  
		  }*/
		 
	}
	public User findByName(String name) {
		return userRepository.findByName(name);
	}

	public boolean isUserExistName(String name) {
		
		User usertempuser=userRepository.findByName(name);
		//User usertemppasword=userRepository.findByName(user.getPassword());
		if(usertempuser!=null){
			System.out.println("userService->isUserExistName->exist"+name);
			return true;
		}else return false;
		 
		
	}
public boolean isUserExistPassword(String password) {
		
		   
		User usertemppasword=userRepository.findByName(password);
		if(usertemppasword!=null){
			System.out.println("userService->isUserExistPassword->exist"+password);
			return true;
		}else return false;
		 
		
	}
}
