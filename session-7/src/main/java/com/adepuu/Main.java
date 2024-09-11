package com.adepuu;

import com.adepuu.examples.Bank;
import com.adepuu.examples.FileReader;
import com.adepuu.examples.exceptions.InsufficientFundException;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
//    FileReader.parseContents("D:\\projects\\dtise-demo-exercises\\session-7\\src\\main\\resources\\testfile.txt");
//    Make a new bank object based on a Bank class
    Bank bank = new Bank();

    Scanner scanner = new Scanner(System.in);

    bank.createAccount("1234567890", 100000);
    System.out.println(bank.getBalance("1234567890"));

    try {
      bank.withdraw("1234567890", 20000);
    } catch (InsufficientFundException e) {
      System.out.println(e.getMessage());
    } finally {
      System.out.println("Final Balance: " + bank.getBalance("1234567890"));
    }

    scanner.close();
  }
}