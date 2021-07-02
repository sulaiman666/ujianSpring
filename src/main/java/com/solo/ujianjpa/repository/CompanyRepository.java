package com.solo.ujianjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.solo.ujianjpa.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{	
	@Query(value = "Select * FROM company WHERE company_address LIKE %?1%", nativeQuery = true)
	List<Company> findCompanyByAddress(String company_address);
}
