package com.training.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AccountTest {
	
	@Test
	void testDeposit() {
		Account acct = new Account(1000);
		acct.deposit(500);
		assertEquals(1500, acct.displayBalance());
		//assertNotEquals(1300,acct.displayBalance());
		//asertTrue -> the argument should be a boolean value
		//assertFalse
		//assertThrows
	}
	
	@Test
	void testWithdraw() {
		Account acct = new Account(1000);
		
		assertThrows(IllegalArgumentException.class, ()->acct.withdraw(1000));
	}

}

// CREATE WITHDRAW METHOD IN ACCOUNT CLASS AND TEST IT
