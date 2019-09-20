package com.ge.exercise3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Bank {

	private static final Logger LOGGER = LogManager.getLogger(Bank.class);
	private Map<String, Account> accountMap ;

	public Bank() {
		accountMap = new HashMap<>();
	}
 
	public Map<String, Account> getAccountMap(){
		return accountMap;
	}

	public Account getAccount(String accountNumber) {
		LOGGER.info("Account: {}", accountMap.get(accountNumber));
		return accountMap.get(accountNumber);
	}

	public void addAccount(Account account) {
		LOGGER.info("Adding Account: "+ account);
		accountMap.put(account.getAccountNumber(), account);
	}

	public void depositToAccount(String accountNumber, float amount) {
		LOGGER.info("Depositing amt to Account: "+accountMap.get(accountNumber)+" is: "+ amount);
		getAccount(accountNumber).deposit(amount);
	}

	public void withdrawFromAccount(String accountNumber, float amount) {
		LOGGER.info("Withdraw amt from Account: "+accountMap.get(accountNumber)+" is: "+ amount);
		getAccount(accountNumber).withdraw(amount);

	} 

	public float calNexMonthValue(String accountNumber) {
		LOGGER.info("Calculated amt of Account: "+accountMap.get(accountNumber)+" for next Month is: "+ getAccount(accountNumber).calNextMonthValue());
		return getAccount(accountNumber).calNextMonthValue();
	}

	public String calProfitOrLoss(){
		float interestAmt = 0.0f;
		float monthlyFee = 0.0f;
		Account account = null;
		for(Entry<String, Account> eachAcc: accountMap.entrySet()){
			account = accountMap.get(eachAcc.getKey());
			if(account != null){
				interestAmt += (account.getBalance()*account.getMonthlyInterestRate()/100);
				monthlyFee += account.getMonthlyFee();
			}
		}
		if(monthlyFee - interestAmt > 0){
			return  "PROFIT";
		}else if(monthlyFee - interestAmt == 0){
			return "NEUTRAL";
		}else{
			return "LOSS";
		}
	}
	

	public float currentHolding(){
		float currentHoldings = 0.0f;
		for(Entry<String, Account> eachAcc: accountMap.entrySet()){
			currentHoldings += accountMap.get(eachAcc.getKey()).getBalance();
		}
		return currentHoldings;
	}

	public int numAccounts() {
		return accountMap.size();
	}
}
