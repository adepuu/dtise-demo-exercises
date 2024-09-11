package com.adepuu.example;

public class Character {
  private String avatar;
  private String name;
  private String skill;

  public Character(String avatar, String name, String skill) {
    this.avatar = avatar;
    this.name = name;
    this.skill = skill;
  }

  public Character(String name) {
    this.avatar = "default.jpg";
    this.name = name;
    this.skill = "DEFAULT_SKILL";
  }

  public Character() {
    this.avatar = "default.jpg";
    this.name = "no_name";
    this.skill = "DEFAULT_SKILL";
  }

  public String toString() {
    return name + " " + skill;
  }
}
