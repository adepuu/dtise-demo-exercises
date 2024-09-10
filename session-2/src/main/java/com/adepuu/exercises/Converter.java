package com.adepuu.exercises;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

public class Converter {
  // Use enum to represent the different types of conversions
  // Map holding conversion functions keyed by the enum
  private static final Map<ConversionType, Function<Double, Double>> conversionMap = new EnumMap<>(ConversionType.class);

  static {
    conversionMap.put(ConversionType.F_TO_C, fahrenheit -> (fahrenheit - 32) * 5 / 9);
    conversionMap.put(ConversionType.C_TO_F, celsius -> (celsius * 9 / 5) + 32);
    conversionMap.put(ConversionType.KM_TO_MILES, km -> km * 0.621371);
    conversionMap.put(ConversionType.MILES_TO_KM, miles -> miles / 0.621371);
    conversionMap.put(ConversionType.KM_TO_CM, km -> km * 100000);
    conversionMap.put(ConversionType.CM_TO_KM, cm -> cm / 100000);
  }

  // Method to perform the conversion based on the enum key
  public static double convert(ConversionType conversionType, double value) {
    Function<Double, Double> conversionFunction = conversionMap.get(conversionType);
    if (conversionFunction != null) {
      return conversionFunction.apply(value);
    } else {
      throw new IllegalArgumentException("Conversion type not supported: " + conversionType);
    }
  }
}
