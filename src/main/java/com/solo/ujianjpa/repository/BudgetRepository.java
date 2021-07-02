package com.solo.ujianjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.solo.ujianjpa.entity.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer>{
	@Query(value = "Select * \n"
			+ "FROM budget \n"
			+ "WHERE budget_amount > ?1", nativeQuery = true)
	List<Budget> findCompanyAboveValue(int budget_amount);
	
	@Query(value = "Select * \n"
			+ "FROM budget \n"
			+ "WHERE budget_amount < 0", nativeQuery = true)
	List<Budget> findInDebtCompany();
}
