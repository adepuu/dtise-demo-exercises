package com.adepuu.exercises;

import java.util.List;

public class ArrayOperations {
  /**
   * Finds the largest element in an array.
   * @param input List of numbers
   * @return The largest number in the list
   */
  public static Double findLargest(List<Double> input) {
    return input.stream().max(Double::compare).orElseThrow();
  }

  /**
   * Sorts an array of integers using bubble sort.
   * @param input List of numbers to sort
   * @return Sorted list of numbers
   */
  public static List<Double> bubbleSort(List<Double> input) {
    Double[] arr = input.toArray(new Double[0]);
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          Double temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    return List.of(arr);
  }

  /**
   * Finds the second smallest element in an array.
   * @param input List of numbers
   * @return The second smallest number in the list
   */
  public static Double findSecondSmallest(List<Double> input) {
    Double smallest = Double.POSITIVE_INFINITY;
    double secondSmallest = Double.POSITIVE_INFINITY;
    for (Double num : input) {
      if (num < smallest) {
        secondSmallest = smallest;
        smallest = num;
      } else if (num < secondSmallest && !num.equals(smallest)) {
        secondSmallest = num;
      }
    }
    return secondSmallest;
  }
}
