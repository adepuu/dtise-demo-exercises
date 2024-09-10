package com.adepuu.exercises;

public class PrimeChecker {
  /**
   * Checks if a number is prime.
   * @param input The number to check
   * @return true if the number is prime, false otherwise
   */
  public static Boolean isPrime(Double input) {
    int number = input.intValue();
    if (number <= 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
