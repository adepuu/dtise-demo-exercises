package com.adepuu;

import com.adepuu.examples.Bank;
import com.adepuu.examples.FileReader;
import com.adepuu.examples.exceptions.BankAccountNotFoundException;
import com.adepuu.examples.exceptions.GenericBankException;
import com.adepuu.examples.exceptions.InsufficientFundException;
import com.adepuu.examples.exceptions.NegativeAmountException;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
//    FileReader.parseContents("D:\\projects\\dtise-demo-exercises\\session-7\\src\\main\\resources\\testfile.txt");
//    Make a new bank object based on a Bank class
    Bank bank = new Bank();

    try {
      bank.createAccount("1234567890", 1000000);
    } catch (NegativeAmountException e) {
      System.out.println("Create new account failed. Reason: " + e.getMessage());
      return;
    }

    System.out.println(bank.getBalance("1234567890"));

    try {
      bank.withdraw("12345167890", 200000000);
    } catch(GenericBankException e) {
      System.out.println("Something wrong with bank account: " + e.getMessage());
    } catch(BankAccountNotFoundException e) {
      System.out.println("Withdraw failed. Reason: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Failed with unknown cause. Reason: " + e.getMessage());
    } finally {
      System.out.println("Final Balance: " + bank.getBalance("1234567890"));
    }
  }
}