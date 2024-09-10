package com.adepuu.examples.exceptions;

public class BankAccountNotFoundException extends RuntimeException {
  public BankAccountNotFoundException() {
    super("Bank account not found");
  }
}
