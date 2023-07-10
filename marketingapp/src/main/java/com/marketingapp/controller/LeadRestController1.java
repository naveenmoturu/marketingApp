package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp.entities.Lead;
import com.marketingapp.repositories.LeadRepository;

@RestController
@RequestMapping("/leads")
public class LeadRestController1 {
	
	@Autowired
	private LeadRepository leadRepo;
	
	@GetMapping
	public List<Lead> listAll() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
			
	}

	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
		
	}
	
	@PutMapping
	public void updateOneLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteOneLead(@PathVariable long id) {
		leadRepo.deleteById(id);
		
	}
}
