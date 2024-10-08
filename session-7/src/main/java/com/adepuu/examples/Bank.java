package com.adepuu.examples;

import com.adepuu.examples.exceptions.BankAccountExistException;
import com.adepuu.examples.exceptions.BankAccountNotFoundException;
import com.adepuu.examples.exceptions.NegativeAmountException;
import com.adepuu.examples.impl.BankAccountImpl;

import java.util.HashMap;
import java.util.Map;

public class Bank {
  private Map<String, BankAccount> account;

  //  Constructor
  public Bank() {
    System.out.println("Creating a new bank with empty bank account");
    account = new HashMap<String, BankAccount>();
  }

  public void createAccount(String accountNumber, double initialBalance) {
    if (initialBalance < 0) {
      throw new NegativeAmountException("Initial balance cannot be negative");
    }
    if (account.containsKey(accountNumber)) {
      throw new BankAccountExistException();
    }
    account.put(accountNumber, new BankAccountImpl(accountNumber, initialBalance));
  }

  public void deposit(String accountNumber, double amount) {
    if (!account.containsKey(accountNumber)) {
      throw new BankAccountNotFoundException();
    }

    BankAccount currentAccount = account.get(accountNumber);
    currentAccount.deposit(amount);
  }

  public void withdraw(String accountNumber, double amount) {
    if (!account.containsKey(accountNumber)) {
      throw new BankAccountNotFoundException();
    }
    if (amount < 0) {
      throw new NegativeAmountException("Withdraw amount cannot be negative");
    }
    BankAccount currentAccount = account.get(accountNumber);
    currentAccount.withdraw(amount);
  }

  public double getBalance(String accountNumber) {
    if (!account.containsKey(accountNumber)) {
      throw new BankAccountNotFoundException();
    }
    return account.get(accountNumber).getBalance();
  }
}
