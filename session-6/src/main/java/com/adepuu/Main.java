package com.adepuu;

import com.adepuu.exercises.DailyTemperature;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    System.out.println("Get daily warmer days temperature");
    List<Integer> rawData = new ArrayList<>();

    // 73,74,75,71,69,72,76,73
    // [1,1,4,2,1,1,0,0]
    rawData.add(73);
    rawData.add(74);
    rawData.add(75);
    rawData.add(71);
    rawData.add(69);
    rawData.add(72);
    rawData.add(76);
    rawData.add(73);
    for (int eachDay : DailyTemperature.getWarmerdays(rawData)) {
      System.out.println(eachDay);
    }
  }
}