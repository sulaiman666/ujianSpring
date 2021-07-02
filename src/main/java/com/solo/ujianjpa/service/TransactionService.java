package com.solo.ujianjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solo.ujianjpa.entity.Transaction;
import com.solo.ujianjpa.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	public Transaction saveTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	public List<Transaction> saveTransactions(List<Transaction> transaction) {
		return transactionRepository.saveAll(transaction);
	}
	
	public List<Transaction> findByTransactionType(char transaction_type) {
		return transactionRepository.findByTransactionType(transaction_type);
	}
	
	public List<Transaction> findByTransactionTypeR() {
		return transactionRepository.findByTransactionTypeR();
	}
	
	public List<Transaction> findByTransactionTypeS() {
		return transactionRepository.findByTransactionTypeS();
	}
}
