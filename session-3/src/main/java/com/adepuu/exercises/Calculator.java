package com.adepuu.exercises;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Calculator {
  /**
   * Implements a simple calculator for basic arithmetic operations using switch expression.
   * Handles invalid input and provides more precise calculations.
   * @param input A string representing the calculation (e.g., "5 + 3")
   * @return The result of the calculation
   * @throws IllegalArgumentException if the input is invalid
   */
  public static Double calculate(String input) {
    String[] parts = input.split(" "); // [5, +, 3]
    if (parts.length != 3) {
      throw new IllegalArgumentException("Invalid input format. Use 'number operator number'");
    }

    try {
      BigInteger a = new BigInteger(parts[0]);
      BigInteger b = new BigInteger(parts[2]);
      String operator = parts[1];

      return switch (operator) {
        case "+" -> a.add(b).doubleValue();
        case "-" -> a.subtract(b).doubleValue();
        case "*" -> a.multiply(b).doubleValue();
        case "/" -> {
          if (b.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Division by zero");
          }
          yield new BigDecimal(a).divide(new BigDecimal(b), 10, RoundingMode.HALF_UP).doubleValue();
        }
        default -> throw new IllegalArgumentException("Invalid operator: " + operator);
      };
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid number format", e);
    }
  }
}
