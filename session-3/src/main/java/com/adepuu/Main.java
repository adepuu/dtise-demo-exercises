package com.adepuu;

import com.adepuu.exercises.*;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    try {
      // DigitSum
      Double digitSumResult = DigitSum.calculate(1234.0);
      System.out.println("DigitSum: " + digitSumResult);
      assert digitSumResult == 10.0 : "DigitSum assertion failed";

      // PrimeChecker
      Boolean isPrime17 = PrimeChecker.isPrime(17.0);
      System.out.println("PrimeChecker (17): " + isPrime17);
      assert isPrime17 : "PrimeChecker assertion failed for 17";

      Boolean isPrime4 = PrimeChecker.isPrime(4.0);
      System.out.println("PrimeChecker (4): " + isPrime4);
      assert !isPrime4 : "PrimeChecker assertion failed for 4";

      // ArrayOperations (largest)
      Double largest = ArrayOperations.findLargest(List.of(3.0, 7.0, 2.0, 8.0, 1.0));
      System.out.println("ArrayOperations (largest): " + largest);
      assert largest == 8.0 : "ArrayOperations (largest) assertion failed";

      // Calculator
      Double calcResult1 = Calculator.calculate("5 + 3");
      System.out.println("Calculator (5 + 3): " + calcResult1);
      assert calcResult1 == 8.0 : "Calculator assertion failed for 5 + 3";

      Double calcResult2 = Calculator.calculate("10 / 2");
      System.out.println("Calculator (10 / 2): " + calcResult2);
      assert calcResult2 == 5.0 : "Calculator assertion failed for 10 / 2";

      // StringManipulator (reverse)
      String reversed = StringManipulator.reverse("hello");
      System.out.println("StringManipulator (reverse): " + reversed);
      assert reversed.equals("olleh") : "StringManipulator (reverse) assertion failed";

      // FibonacciGenerator
      String fibSequence = FibonacciGenerator.generate(6.0);
      System.out.println("FibonacciGenerator: " + fibSequence);
      assert fibSequence.equals("0 1 1 2 3 5") : "FibonacciGenerator assertion failed";

      // ArrayOperations (bubble sort)
      List<Double> sorted = ArrayOperations.bubbleSort(List.of(64.0, 34.0, 25.0, 12.0, 22.0, 11.0, 90.0));
      System.out.println("ArrayOperations (bubble sort): " + sorted);
      assert sorted.equals(List.of(11.0, 12.0, 22.0, 25.0, 34.0, 64.0, 90.0)) : "ArrayOperations (bubble sort) assertion failed";

      // StringManipulator (anagram)
      Boolean areAnagrams1 = StringManipulator.areAnagrams("listen", "silent");
      System.out.println("StringManipulator (anagram 'listen', 'silent'): " + areAnagrams1);
      assert areAnagrams1 : "StringManipulator (anagram) assertion failed for 'listen' and 'silent'";

      Boolean areAnagrams2 = StringManipulator.areAnagrams("hello", "world");
      System.out.println("StringManipulator (anagram 'hello', 'world'): " + areAnagrams2);
      assert !areAnagrams2 : "StringManipulator (anagram) assertion failed for 'hello' and 'world'";

      // ArrayOperations (second smallest)
      Double secondSmallest = ArrayOperations.findSecondSmallest(List.of(5.0, 3.0, 8.0, 1.0, 2.0, 9.0));
      System.out.println("ArrayOperations (second smallest): " + secondSmallest);
      assert secondSmallest == 2.0 : "ArrayOperations (second smallest) assertion failed";

      // StringManipulator (count vowels)
      Double vowelCount = StringManipulator.countVowels("programming");
      System.out.println("StringManipulator (count vowels in 'programming'): " + vowelCount);
      assert vowelCount == 3.0 : "StringManipulator (count vowels) assertion failed";

      // Test exception handling for Calculator
      try {
        Calculator.calculate("10 / 0");
      } catch (ArithmeticException e) {
        System.out.println("Caught expected exception in Calculator: " + e.getMessage());
      }

    } catch (RuntimeException e) {
      System.err.println("Caught unexpected runtime exception: " + e.getMessage());
      e.printStackTrace();
    } catch (AssertionError e) {
      System.err.println("Assertion failed: " + e.getMessage());
      e.printStackTrace();
    }
  }
}