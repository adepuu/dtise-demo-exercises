package com.adepuu.exercises;

class NameInitials {
  public static String getInitials(String fullName) {
    String[] names = fullName.split(" ");
    StringBuilder initials = new StringBuilder();
    for (String name : names) {
      if (!name.isEmpty()) {
        initials.append(Character.toUpperCase(name.charAt(0)));
      }
    }
    return initials.toString();
  }
}
