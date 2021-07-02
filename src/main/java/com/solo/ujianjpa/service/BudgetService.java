package com.solo.ujianjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solo.ujianjpa.entity.Budget;
import com.solo.ujianjpa.repository.BudgetRepository;

@Service
public class BudgetService {
	
	@Autowired
	private BudgetRepository budgetRepository;
	
	public Budget saveBudget(Budget budgets) {
		return budgetRepository.save(budgets);
	}
	
	public List<Budget> saveBudgets(List<Budget> budgets) {
		return budgetRepository.saveAll(budgets);
	}
	
	public List<Budget> findCompanyAbove() {
		return budgetRepository.findCompanyAboveValue(5000000);
	}
	
	public List<Budget> findCompanyAboveValue(int budget_amount) {
		return budgetRepository.findCompanyAboveValue(budget_amount);
	}
	
	public List<Budget> findInDebtCompany() {
		return budgetRepository.findInDebtCompany();
	}

}
