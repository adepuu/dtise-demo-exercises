package com.adepuu.examples.exceptions;

public class BankAccountExistException extends RuntimeException {
  public BankAccountExistException() {
    super("Bank account already exists");
  }
}
