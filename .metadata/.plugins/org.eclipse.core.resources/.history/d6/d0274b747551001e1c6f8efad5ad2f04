package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Account;
import com.entities.BankTransaction;
import com.exception.InvalidBankTransactionException;
import com.repository.AccountRepository;
import com.repository.TransactionRepository;

@Component
public class TransactionDAOImpl implements ITransactionDAO {
	
	//Provide code to Inject TransactionRepository and AccountRepository
	//Provide code to Inject AccountRepository, if needed
	@Autowired
	private AccountRepository arepo;
	@Autowired
	private TransactionRepository trepo;
	@Override
	public BankTransaction insertTransaction(BankTransaction transactionObj,String accountNumber) throws InvalidBankTransactionException{
		
		//fill code
//		Account account = arepo.findById(accountNumber).orElse(null);
//		if(account==null) {
//			throw new InvalidBankTransactionException("Account not found");
//		}
		Account account = arepo.findById(accountNumber).orElseThrow(()->new InvalidBankTransactionException("Account not found"));
		double d = transactionObj.getAmount();
		if(transactionObj.getTransactionType().equalsIgnoreCase("Deposit")) {
			account.setBalanceAmount(account.getBalanceAmount()+d);
		}else if(transactionObj.getTransactionType().equalsIgnoreCase("withdraw")) {
			account.setBalanceAmount(account.getBalanceAmount()-d);
		}
		transactionObj.setAccountObj(account);
		BankTransaction save = trepo.save(transactionObj);
		return save;
	}
	
	@Override
	public List<BankTransaction> viewTransactionByAccountNumber(String accountNumber) throws InvalidBankTransactionException
	{
		//fill code
		Account account = arepo.findById(accountNumber).orElse(null);
		if(account==null) {
			throw new InvalidBankTransactionException("Account not found");
		}
		List<BankTransaction> list = trepo.findByAccountObj_AccountNumber(accountNumber);
		
		return list;	
	}
	
	@Override
	public List<BankTransaction> viewTransactionByTransactionType(String transactionType)
	{
		//fill code
		
		return trepo.findByTransactionType(transactionType);	
	}
	
	@Override
	public List<BankTransaction> viewTransactionByTransactionTypeAndAmount(String transactionType,double amount)
	{
		//fill code
		
		return trepo.findByTransactionTypeAndAmountGreaterThanEqual(transactionType, amount);	
	}

}
