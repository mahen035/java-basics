package com.training.accountsvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.accountsvc.entity.Account;
import com.training.accountsvc.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account addAccount(Account account) {
		long accountNumber = generateAccountNumber();
		account.setAccountNumber(accountNumber);
		accountRepository.save(account);
		return account;
	}
	
	private long generateAccountNumber() {
		long min = 1000000000L; // Minimum 10-digit number
		long max = 9999999999L; // Maximum 10-digit number
		return (long) (Math.random() * (max - min + 1) + min);
	}

}
