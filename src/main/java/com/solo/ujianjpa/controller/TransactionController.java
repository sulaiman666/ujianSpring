package com.solo.ujianjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solo.ujianjpa.entity.Transaction;
import com.solo.ujianjpa.service.TransactionService;

@RestController
@RequestMapping("transaction")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/addtransaction")
	public Transaction addTransaction(@RequestBody Transaction transaction) {
		return transactionService.saveTransaction(transaction);
	}
	
	@PostMapping("/addtransactions")
	public List<Transaction> addTransactions(@RequestBody List<Transaction> transaction) {
		return transactionService.saveTransactions(transaction);
	}
	
	@GetMapping("/gettransactiontyper")
	public List<Transaction> getTransactionTypeR() {
		return transactionService.findByTransactionTypeR();
	}
	
	@GetMapping("/gettransactiontypes")
	public List<Transaction> getTransactionTypeS() {
		return transactionService.findByTransactionTypeS();
	}
	
	@GetMapping("/gettransactiontype/{type}")
	public List<Transaction> getTransactionType(@PathVariable char type) {
		return transactionService.findByTransactionType(type);
	}
}
