package com.adepuu.examples;

import com.adepuu.examples.exceptions.InsufficientFundException;
import com.adepuu.examples.exceptions.NegativeAmountException;

public class BankAccount {
  private String accountNumber;
  private double balance;

  public BankAccount(String accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public void deposit(double amount) {
    if (amount < 0) {
      throw new NegativeAmountException("Deposit amount cannot be negative");
    }
    this.balance += amount;
  }

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
