package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.entities.Account;
import com.exception.InvalidAccountException;
import com.repository.AccountRepository;

@Component
public class AccountDAOImpl implements IAccountDAO{
	
	//Provide code to Inject AccountRepository
	@Autowired
	private AccountRepository arepo;
	
	@Override
	public Account openAccount(Account account) {
		
		//fill code
		
		//acrepo.save(account);
		Account save = arepo.save(account);
		return save;
	}
	
	@Override
	public Account updateAccountHolderPhoneNumber(String accountNumber,String phoneNumber) throws InvalidAccountException {
		
		//fill code
//		Optional<Account> optional = arepo.findById(accountNumber);
//		if(optional.isPresent()) {
//			Account account = optional.get();
//			account.setPhoneNumber(phoneNumber);
//			return arepo.save(account);
//		}else {
//			throw new InvalidAccountException("Account not found");
//		}
		Account account = arepo.findById(accountNumber).orElseThrow(()->new InvalidAccountException("Account not found") );
		if(account!=null) {
			account.setPhoneNumber(phoneNumber);
			Account save = arepo.save(account);
			
		}
		return account;
	}
	
	@Override
	public Account viewAccountByAccountNumber(String accountNumber) throws InvalidAccountException {
		
		//fill code
//		Optional<Account> optional = arepo.findById(accountNumber);
//		if(optional.isPresent()) {
//			Account account = optional.get();
//			return arepo.save(account);
//		}
//		else {
//			throw new InvalidAccountException("Account not found");
//		}
		Account account2 = arepo.findByAccountNumber(accountNumber);
		if(account2==null) {
			throw new InvalidAccountException("Account not found");
		}
		return account2;
//		Account account = arepo.findById(accountNumber).orElseThrow(()->new InvalidAccountException("Account not found") );
//		return account;
	}

	@Override
	public List<Account> viewAccountByBalance(double balance) {
		
		//fill code
		List<Account> list = arepo.findByBalanceAmountGreaterThanEqual(balance);
		
		return list;
	}

}
