package com.adepuu;

import com.adepuu.example.Character;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
//    Initialize the game chars
    Character characterA = new Character("hero1.jpg", "Character A", "SKILL_1");
    Character characterB = new Character("hero2.jpg", "Character B", "SKILL_3");
    Character characterC = new Character("hero12.jpg", "Character C", "SKILL_10");
    Character noobCharacter = new Character("Skill Issue");
    Character emptyCharacter = new Character();
    System.out.println(characterA.toString());
    System.out.println(noobCharacter.toString());
    System.out.println(emptyCharacter.toString());
  }
}