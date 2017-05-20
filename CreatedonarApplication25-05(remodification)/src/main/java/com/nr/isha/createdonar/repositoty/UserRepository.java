package com.nr.isha.createdonar.repositoty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nr.isha.createdonar.model.RegistrationUser;

 

 

@Repository
public interface UserRepository extends JpaRepository<RegistrationUser, Long> {
 //RegistrationUser findByName(String registrationFirstName);

	//RegistrationUser findById(Long mbl);
	 
	 
}
