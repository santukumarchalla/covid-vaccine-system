package com.vms.service;

import java.util.List;

import com.vms.dto.LoginDTO;
import com.vms.entity.VaccineCenter;
import com.vms.entity.VaccineRegistration;
import com.vms.exception.RecordNotFound;

public interface VaccineRegistrationService {
	
	public VaccineRegistration addVaccineRegistration(VaccineRegistration vaccineRegistration) throws RecordNotFound;
	public VaccineRegistration updateVaccineRegistration(VaccineRegistration vaccineRegistration) throws RecordNotFound;
	public VaccineRegistration deleteVaccineRegistration(VaccineRegistration vaccineRegistration) throws RecordNotFound;
	public List<VaccineRegistration> getAllVaccineRegistrations() throws RecordNotFound;
	public VaccineRegistration getAllMembers(long mobileNo) throws RecordNotFound;
	public VaccineRegistration validate(LoginDTO dto);
	public VaccineRegistration getDetails(int regId);
}
