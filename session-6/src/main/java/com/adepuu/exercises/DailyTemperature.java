package com.adepuu.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DailyTemperature {
  public static int[] getWarmerdays(List<Integer> temperatures) {
    int[] result = new int[temperatures.size()];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < temperatures.size(); i++) {
      while (!stack.isEmpty() && temperatures.get(i) > temperatures.get(stack.peek())) {
        int tempIndex = stack.pop();
        result[tempIndex] = i-tempIndex;
      }
      stack.push(i);
    }
    return result;
  }
}
