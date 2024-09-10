package com.adepuu.exercises;

public class DigitSum {
  /**
   * Calculates the sum of digits in a given number.
   * @param input The input number
   * @return The sum of its digits
   */
  public static Double calculate(Double input) {
    int number = input.intValue();
    int sum = 0;
    while (number > 0) {
      sum += number % 10;
      number /= 10;
    }
    return (double) sum;
  }
}
