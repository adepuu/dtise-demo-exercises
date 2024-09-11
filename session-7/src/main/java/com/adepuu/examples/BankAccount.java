package com.adepuu.examples;

public interface BankAccount {
  public String getAccountNumber();
  public double getBalance();
  public void deposit(double amount);
  public void withdraw(double amount);
}
