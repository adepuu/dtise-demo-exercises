package com.adepuu.exercises;

import java.time.LocalDate;
import java.util.Scanner;

public class GeometryAndUtilsDemo {
  public static void run() {
    // Rectangle area
    Rectangle rectangle = new Rectangle(5, 3);
    System.out.println("Rectangle area: " + rectangle.calculateArea());

    // Circle calculations
    Circle circle = new Circle(5);
    System.out.printf("Circle - Diameter: %.2f, Circumference: %.4f, Area: %.3f%n",
            circle.calculateDiameter(),
            circle.calculateCircumference(),
            circle.calculateArea());

    // Triangle third angle
    System.out.println("Triangle third angle: " + Triangle.calculateThirdAngle(80, 65));

    // Date difference
    LocalDate date1 = LocalDate.of(2024, 3, 19);
    LocalDate date2 = LocalDate.of(2024, 3, 21);
    System.out.println("Days between dates: " + DateDifference.getDaysBetween(date1, date2));

    // Name initials
    System.out.println("Name initials: " + NameInitials.getInitials("John Doe"));
  }
}
