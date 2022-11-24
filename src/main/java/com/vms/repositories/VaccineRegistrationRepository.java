package com.vms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.entity.VaccineRegistration;

@Repository
public interface VaccineRegistrationRepository extends JpaRepository< VaccineRegistration,Integer>{ 
	VaccineRegistration findByMobileNo(long mobile);
}
