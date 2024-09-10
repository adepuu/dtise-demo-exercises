package com.adepuu.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FibonacciGenerator {
  /**
   * Generates the Fibonacci sequence up to n terms.
   * @param input The number of terms to generate
   * @return A string representation of the Fibonacci sequence
   */
  public static String generate(Double input) {
    int n = input.intValue();
    List<Integer> fib = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (i <= 1) {
        fib.add(i);
      } else {
        fib.add(fib.get(i-1) + fib.get(i-2));
      }
    }
    return fib.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }

  /**
   * Generates the Fibonacci sequence up to n terms using memoization.
   * @param input The number of terms to generate
   * @return A string representation of the Fibonacci sequence
   */
  public static String generateMemoized(Double input) {
    int n = input.intValue();
    Map<Integer, Integer> memo = new HashMap<>();
    List<Integer> fib = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      fib.add(fibMemo(i, memo));
    }
    return fib.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }

  private static int fibMemo(int n, Map<Integer, Integer> memo) {
    if (n <= 1) return n;
    if (memo.containsKey(n)) return memo.get(n);
    int result = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
    memo.put(n, result);
    return result;
  }
}
