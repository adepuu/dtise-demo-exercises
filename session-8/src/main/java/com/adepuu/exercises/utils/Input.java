package com.adepuu.exercises.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
  private static final Scanner scanner = new Scanner(System.in);

  /**
   * Safely gets an integer input from the user.
   *
   * @param prompt The prompt to display to the user.
   * @return The integer entered by the user.
   */
  public static int getIntInput(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return input;
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a valid number.");
        scanner.nextLine(); // Consume invalid input
      }
    }
  }

  /**
   * Safely gets a double input from the user.
   *
   * @param prompt The prompt to display to the user.
   * @return The double entered by the user.
   */
  public static double getDoubleInput(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        double input = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        return input;
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a valid number.");
        scanner.nextLine(); // Consume invalid input
      }
    }
  }

  /**
   * Safely gets a non-empty string input from the user.
   *
   * @param prompt The prompt to display to the user.
   * @return The non-empty string entered by the user.
   */
  public static String getStringInput(String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine();
      if (!input.trim().isEmpty()) {
        return input;
      } else {
        System.out.println("Input cannot be empty. Please enter a valid value.");
      }
    }
  }
}