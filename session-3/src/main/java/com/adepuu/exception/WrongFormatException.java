package com.adepuu.exception;

public class WrongFormatException extends Exception{
  public WrongFormatException() {
    super("Invalid input format. Use 'number operator number'");
  }
}
