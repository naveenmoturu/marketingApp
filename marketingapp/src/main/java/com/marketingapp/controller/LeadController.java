package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeadData;
import com.marketingapp.entities.Lead;
import com.marketingapp.services.LeadServices;
import com.marketingapp.utilities.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private LeadServices leadServices;
	
	
	@RequestMapping("/viewleadpage")
	public String viewLeadsPage() {
		return "new_lead";
	}
	
	@RequestMapping("/savelead")
	public String saveLeadData(@ModelAttribute("lead") Lead lead, ModelMap model) {
		leadServices.saveLead(lead);
		emailService.sendSimpleMessage("naveennavy460@gmail.com", "Naveen@mech46", "Welcome Test Email");
		model.addAttribute("msg","location is saved");
	      return "new_lead";
	
	}
	
	@RequestMapping("/listall")
	public String listLeads(ModelMap modelMap) {
		List<Lead> allLeads = leadServices.getAllLeads();
		modelMap.addAttribute("leads", allLeads);
		return "search_result";
	}
	
	@RequestMapping("/delete")
	public String deleteLead(@RequestParam("id") long id, ModelMap modelMap) {
		leadServices.deleteOneLead(id);
		List<Lead> allLeads = leadServices.getAllLeads();
		modelMap.addAttribute("leads", allLeads);
		return "search_result";
	}
	
	@RequestMapping("/getLeadInfo")
	public String getLeadInfo(@RequestParam("id") long id, ModelMap modelMap) {
		Lead lead = leadServices.getOneLead(id);
		modelMap.addAttribute("lead", lead);
		return "update_lead";
		
	}
	
	@RequestMapping("/updatelead")
	public String updatelead(Lead lead,ModelMap modelMap ) {
		leadServices.saveLead(lead);
		List<Lead> allLeads = leadServices.getAllLeads();
		modelMap.addAttribute("leads", allLeads);
		return "search_result";
		
	}
	
	
//	@RequestMapping("savelead")
//	public String saveLeadData(LeadData data,ModelMap model) {
//		Lead l = new Lead();
//		l.setId(data.getId());
//		l.setFirstName(data.getFirstName());
//		l.setLastName(data.getLastName());
//		l.setEmail(data.getEmail());
//		l.setCity(data.getCity());
//		l.setMobile(data.getMobile());
//		leadServices.saveLead(l);
//		model.addAttribute("msg","location is saved");
//		return "new_lead";
//	
//	}
	
}
