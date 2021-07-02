package com.solo.ujianjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.solo.ujianjpa.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	@Query(value = "Select * FROM transaction WHERE transaction_type = ?1", nativeQuery = true)
	List<Transaction> findByTransactionType(char transaction_type);
	
	//Hard coded
	@Query(value = "Select * FROM transaction WHERE transaction_type = 'r'", nativeQuery = true)
	List<Transaction> findByTransactionTypeR();
	
	@Query(value = "Select * FROM transaction WHERE transaction_type = 's'", nativeQuery = true)
	List<Transaction> findByTransactionTypeS();
}
