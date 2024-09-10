package com.adepuu.examples.exceptions;

public class InsufficientFundException extends RuntimeException {
  public InsufficientFundException() {
    super("Insufficient Fund");
  }
}
