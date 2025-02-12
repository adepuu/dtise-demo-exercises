package com.adepuu.examples.exceptions;

public class NegativeAmountException extends GenericBankException {
  public NegativeAmountException(String msg) {
    super(msg);
  }
}
