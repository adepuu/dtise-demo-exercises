package com.adepuu.examples.exceptions;

public class InsufficientFundException extends GenericBankException {
  public InsufficientFundException() {
    super("Insufficient Fund");
  }
}
