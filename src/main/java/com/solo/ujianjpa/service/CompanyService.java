package com.solo.ujianjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solo.ujianjpa.entity.Company;
import com.solo.ujianjpa.repository.CompanyRepository;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository companyRepository;
	
	public Company saveCompany(Company company) {
		return companyRepository.save(company);
	}
	
	public List<Company> saveCompanys(List<Company> company) {
		return companyRepository.saveAll(company);
	}
	
	public List<Company> findCompanyByAddress(String company_address) {
		return companyRepository.findCompanyByAddress(company_address);
	}
}
