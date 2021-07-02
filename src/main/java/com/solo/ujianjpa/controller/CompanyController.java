package com.solo.ujianjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solo.ujianjpa.entity.Company;
import com.solo.ujianjpa.service.CompanyService;

@RestController
@RequestMapping("company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/addcompany")
	public Company addCompany(@RequestBody Company company) {
		return companyService.saveCompany(company);
	}
	
	@PostMapping("/addcompanys")
	public List<Company> addCompanys(@RequestBody List<Company> company) {
		return companyService.saveCompanys(company);
	}
	
	@GetMapping("/getbyaddress/{company_address}")
	public List<Company> getCompanyByAddress(@PathVariable String company_address) {
		return companyService.findCompanyByAddress(company_address);
	}
}
