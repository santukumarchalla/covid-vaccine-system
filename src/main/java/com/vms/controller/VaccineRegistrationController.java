package com.vms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vms.entity.VaccineRegistration;
import com.vms.exception.RecordNotFound;
import com.vms.service.VaccineRegistrationService;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;

import com.vms.entity.Vaccine;
import com.vms.exception.RecordNotFound;
import com.vms.service.VaccineService;

import org.springframework.beans.factory.annotation.Autowired;

import com.vms.entity.Member;
import com.vms.exception.RecordNotFound;
import com.vms.service.MemberService;
import com.vms.service.VaccineCenterService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vms.dto.LoginDTO;
import com.vms.entity.Appointment;
import com.vms.entity.IdCard;
import com.vms.exception.RecordNotFound;
import com.vms.service.AppointmentService;
import com.vms.service.IdCardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/vms-vaccineRegistration")
public class VaccineRegistrationController {
	
	
	@Autowired
	VaccineRegistrationService vaccineRegistrationService;
	
	@PostMapping
	public VaccineRegistration addVaccineRegistration(@RequestBody VaccineRegistration vaccineRegistration) throws RecordNotFound{
		return vaccineRegistrationService.addVaccineRegistration(vaccineRegistration);
	}
	
	@PostMapping("/validate")
	public VaccineRegistration validate(@RequestBody LoginDTO dto) throws RecordNotFound{
		return vaccineRegistrationService.validate(dto);
	}
	
	@PutMapping("/updateVaccineRegistration")
	public VaccineRegistration updateVaccineRegistration(@RequestBody VaccineRegistration vaccineRegistration) throws RecordNotFound{
		return vaccineRegistrationService.updateVaccineRegistration(vaccineRegistration);
	}
	
	@DeleteMapping("/deleteVaccineRegistration")
	public VaccineRegistration deleteVaccineRegistration(@RequestBody VaccineRegistration vaccineRegistration) throws RecordNotFound{
		return vaccineRegistrationService.deleteVaccineRegistration(vaccineRegistration);
	}
	
	@GetMapping("/getAllVaccineRegistrations")
	public List<VaccineRegistration> getAllVaccineRegistrations() throws RecordNotFound{
		return vaccineRegistrationService.getAllVaccineRegistrations();
	}
	
	@GetMapping("/getAllMembers/{mobileNo}")
	public VaccineRegistration getAllMembers(@PathVariable long mobileNo) throws RecordNotFound{
		return vaccineRegistrationService.getAllMembers(mobileNo);
	}

	@GetMapping("{regId}")
	public VaccineRegistration getDetails(@PathVariable int regId) throws RecordNotFound{
		return vaccineRegistrationService.getDetails(regId);
	}

}


















