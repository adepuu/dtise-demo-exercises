package com.adepuu.examples.impl;

import com.adepuu.examples.BankAccount;
import com.adepuu.examples.exceptions.InsufficientFundException;
import com.adepuu.examples.exceptions.NegativeAmountException;

public class BankAccountImpl implements BankAccount {
  private String accountNumber;
  private double balance;

  public BankAccountImpl(String accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  @Override
  public String getAccountNumber() {
    return accountNumber;
  }

  @Override
  public double getBalance() {
    return balance;
  }
  
  @Override
  public void deposit(double amount) {
    if (amount < 0) {
      throw new NegativeAmountException("Deposit amount cannot be negative");
    }
    this.balance += amount;
  }

  @Override
  public void withdraw(double amount) {
    if (amount < 0) {
      throw new NegativeAmountException("Deposit amount cannot be negative");
    }
    if (balance < amount) {
      throw new InsufficientFundException();
    }
    this.balance -= amount;
  }
}
