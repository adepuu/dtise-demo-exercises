package com.adepuu.exercises;

import java.util.Arrays;

public class StringManipulator {
  /**
   * Reverses a string without using built-in reverse functions.
   * @param input The input string
   * @return The reversed string
   */
  public static String reverse(String input) {
    char[] chars = input.toCharArray();
    int left = 0, right = chars.length - 1;
    while (left < right) {
      char temp = chars[left];
      chars[left] = chars[right];
      chars[right] = temp;
      left++;
      right--;
    }
    return new String(chars);
  }

  /**
   * Counts the number of vowels in a string.
   * @param input The input string
   * @return The number of vowels in the string
   */
  public static Double countVowels(String input) {
    return (double) input.toLowerCase().replaceAll("[^aeiou]", "").length();
  }

  /**
   * Checks if two strings are anagrams using a two-pointer approach.
   * @param inputOne The first string
   * @param inputTwo The second string
   * @return true if the strings are anagrams, false otherwise
   */
  public static Boolean areAnagrams(String inputOne, String inputTwo) {
    if (inputOne.length() != inputTwo.length()) {
      return false;
    }
    char[] chars1 = inputOne.toLowerCase().toCharArray();
    char[] chars2 = inputTwo.toLowerCase().toCharArray();
    Arrays.sort(chars1);
    Arrays.sort(chars2);

    int left = 0, right = chars1.length - 1;
    while (left <= right) {
      if (chars1[left] != chars2[left] || chars1[right] != chars2[right]) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
