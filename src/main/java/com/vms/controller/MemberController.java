package com.vms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vms.entity.Member;
import com.vms.exception.RecordNotFound;
import com.vms.service.MemberService;
import com.vms.service.VaccineRegistrationService;

@CrossOrigin
@RestController
@RequestMapping("/vms-member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	@Autowired VaccineRegistrationService vservice;
	
	@PostMapping
	public Member addMember(@RequestBody Member member){
		member.setVaccineRegistration(vservice.getDetails(member.getRegId()));
		System.out.println(member);
		return memberService.addMember(member);
	}
	
	@PutMapping("{id}")
	public Member updateMember(@PathVariable("id") int id,@RequestBody Member member) throws RecordNotFound{
		return memberService.updateMember(id,member);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteMember(@PathVariable("id") int id) throws RecordNotFound{
		memberService.deleteMember(id);
		return ResponseEntity.ok("Member deleted successfully");
	}
	
	@GetMapping("/getMemberById/{cardId}")
	public Member getMemberById(@PathVariable String cardId) throws RecordNotFound{
		return memberService.getMemberById(cardId);
	}
	
	@GetMapping("/getMemberByAadhar/{aadharNo}")
	public Member getMemberByAadhar(@PathVariable String aadharNo) throws RecordNotFound{
		return memberService.getMemberByAadhar(aadharNo);
	}
	
	@GetMapping("/getMemberByPan/{panNo}")
	public Member getMemberByPan(@PathVariable String panNo) throws RecordNotFound{
		return memberService.getMemberByPan(panNo);
	}

}
