package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.BankTransaction;

//Provide necessary Annotation
@Repository
public interface TransactionRepository extends JpaRepository<BankTransaction,String> {

	//Provide necessary method to view transactions based on Account number,
	List<BankTransaction> findByAccountObj_AccountNumber(String accountNumber);
	// view transactions based on transaction type and
	List<BankTransaction> findByTransactionType(String transactionType);
	// view transactions based on transaction type and transaction amount greater than or equal to a value
	List<BankTransaction> findByTransactionTypeAndAmountGreaterThanEqual(String transactionType,double amount);
	
}