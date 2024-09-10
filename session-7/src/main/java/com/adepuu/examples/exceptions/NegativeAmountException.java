package com.adepuu.examples.exceptions;

public class NegativeAmountException extends RuntimeException {
  public NegativeAmountException(String msg) {
    super(msg);
  }
}
