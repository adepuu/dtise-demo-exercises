package com.adepuu.exercises;

class Circle {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  public double calculateDiameter() {
    return 2 * radius;
  }

  public double calculateCircumference() {
    return 2 * Math.PI * radius;
  }

  public double calculateArea() {
    return Math.PI * radius * radius;
  }
}
