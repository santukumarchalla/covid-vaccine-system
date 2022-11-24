package com.vms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.dto.LoginDTO;
import com.vms.entity.VaccineRegistration;
import com.vms.exception.RecordNotFound;
import com.vms.repositories.VaccineRegistrationRepository;

@Service("VaccineRegistrationService")
public class VaccineRegistrationServiceImpl implements VaccineRegistrationService{

	@Autowired
	VaccineRegistrationRepository vaccineRegistrationRepository;
	
	@Override
	public VaccineRegistration addVaccineRegistration(VaccineRegistration vaccineRegistration) throws RecordNotFound {
		vaccineRegistrationRepository.saveAndFlush(vaccineRegistration);
		return vaccineRegistration ;
	}

	@Override
	public VaccineRegistration updateVaccineRegistration(VaccineRegistration vaccineRegistration)
			throws RecordNotFound {
		VaccineRegistration  bean = null;
		try {
			bean = vaccineRegistrationRepository.findById(vaccineRegistration.getRegId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Vaccine Registration details not found!");
		}
		vaccineRegistrationRepository.saveAndFlush(vaccineRegistration);
		return vaccineRegistration;
	}

	@Override
	public VaccineRegistration deleteVaccineRegistration(VaccineRegistration vaccineRegistration)
			throws RecordNotFound {
		VaccineRegistration  bean = null;
		try {
			bean = vaccineRegistrationRepository.findById(vaccineRegistration.getRegId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Vaccine Registration details not found!");
		}
		vaccineRegistrationRepository.deleteById(vaccineRegistration.getRegId());
		return vaccineRegistration;
	}

	@Override
	public List<VaccineRegistration> getAllVaccineRegistrations() throws RecordNotFound {
		return vaccineRegistrationRepository.findAll();
	}

	@Override
	public VaccineRegistration getAllMembers(long mobileNo) throws RecordNotFound {
		VaccineRegistration  bean = null;
		try {
			for(VaccineRegistration i : vaccineRegistrationRepository.findAll()) {
				if(i.getMobileNo()==mobileNo) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new RecordNotFound("Vaccine Registration details not found!");
		}
		return bean;
	}

	@Override
	public VaccineRegistration validate(LoginDTO dto) {
		VaccineRegistration  bean = null;
		bean = vaccineRegistrationRepository.findByMobileNo(Long.parseLong(dto.getUserid()));
		if(bean!=null && bean.getPwd().equals(dto.getPwd()))
			return bean;
		return null;
	}

	@Override
	public VaccineRegistration getDetails(int regId) {
		VaccineRegistration  bean = null;
		bean = vaccineRegistrationRepository.findById(regId).get();
		return bean;
	}
	
	

}


/*
 
  
  CRUD - Create Update Delete Get
  
  
  
 */






















