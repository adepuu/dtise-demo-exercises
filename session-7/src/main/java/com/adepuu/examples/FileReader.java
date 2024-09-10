package com.adepuu.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
  public static List<Integer> parseContents(String filePath) {
    List<Integer> result = new ArrayList<>();

    try {
      Scanner scanner = new Scanner(new File(filePath));

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        System.out.println("Content: " + line);
        Integer number = Integer.parseInt(line);
        result.add(number);
      }
    } catch (FileNotFoundException e) {
      System.out.println("file not found");
    } catch (NumberFormatException e) {
      System.out.println("file content is not a number");
    }  catch (Exception e) {
      System.out.println("Global Exception");
    } finally {
      System.out.println("file reading done!");
    }

    return result;
  }
}
