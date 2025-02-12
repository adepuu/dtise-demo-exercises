package com.adepuu.examples;

import com.adepuu.examples.exceptions.InsufficientFundException;
import com.adepuu.examples.exceptions.NegativeAmountException;

public interface BankAccount {
  public String getAccountNumber();
  public double getBalance();
  public void deposit(double amount) throws NegativeAmountException;
  public void withdraw(double amount) throws InsufficientFundException, NegativeAmountException;
}
