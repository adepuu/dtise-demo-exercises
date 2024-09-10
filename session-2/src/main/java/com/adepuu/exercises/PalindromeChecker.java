package com.adepuu.exercises;

public class PalindromeChecker {
  public static boolean isPalindrome(String str) {
    if (str.isEmpty() || str.length() == 1 || str.isBlank()) {
      return false;  // If the string is empty, it's not a palindrome
    }

    // Remove non-alphanumeric characters and convert to lowercase
    String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    int left = 0;
    int right = cleanedStr.length() - 1;

    while (left < right) {
      if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
        return false;  // If characters don't match, it's not a palindrome
      }
      left++;
      right--;
    }
    return true;  // If all characters match, it's a palindrome
  }
}
