package com.adepuu.exercises;

import static com.adepuu.exercises.Converter.convert;
import static com.adepuu.exercises.PalindromeChecker.isPalindrome;

public class StringAndConverterDemo {
  public static void run() {
    double fahrenheit = 98.6;
    double celsius = convert(ConversionType.F_TO_C, fahrenheit);
    System.out.println(fahrenheit + " F is " + celsius + " C");

    double kilometers = 5.0;
    double centimeters = convert(ConversionType.KM_TO_CM, kilometers);
    System.out.println(kilometers + " km is " + centimeters + " cm");

    double centimetersBack = 500000.0;
    double kilometersBack = convert(ConversionType.CM_TO_KM, centimetersBack);
    System.out.println(centimetersBack + " cm is " + kilometersBack + " km");

    String str1 = "A man, a plan, a canal, Panama!";
    String str2 = "Hello, World!";

    System.out.println(str1 + " is a palindrome? " + isPalindrome(str1));
    System.out.println(str2 + " is a palindrome? " + isPalindrome(str2));
  }
}
