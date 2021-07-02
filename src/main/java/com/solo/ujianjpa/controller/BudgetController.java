package com.solo.ujianjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solo.ujianjpa.entity.Budget;
import com.solo.ujianjpa.service.BudgetService;

@RestController
@RequestMapping("budget")
public class BudgetController {
	@Autowired
	private BudgetService budgetService;
	
	@PostMapping("/addbudget")
	public Budget addBudget(@RequestBody Budget budget) {
		return budgetService.saveBudget(budget);
	}
	
	@PostMapping("/addbudgets")
	public List<Budget> addBudgets(@RequestBody List<Budget> budget) {
		return budgetService.saveBudgets(budget);
	}
	
	@GetMapping("/getabove")
	public List<Budget> getCompanyAbove() {
		return budgetService.findCompanyAbove();
	}
	
	@GetMapping("/getabovevalue/{amount}")
	public List<Budget> getCompanyAboveValue(@PathVariable int amount) {
		return budgetService.findCompanyAboveValue(amount);
	}
	
	@GetMapping("/getindebt")
	public List<Budget> getCompanyAboveValue() {
		return budgetService.findInDebtCompany();
	}
}
