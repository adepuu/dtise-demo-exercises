package com.adepuu.exercises;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class DateDifference {
  public static long getDaysBetween(LocalDate date1, LocalDate date2) {
    return date1.until(date2, ChronoUnit.DAYS);
  }
}