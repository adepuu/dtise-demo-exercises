package com.adepuu.exercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// Create a csv file reader that calculates the summary of product
// based on the data inside the file. Make sure to handle the exceptions properly
//
// Example CSV file here
// Expected Output
//
// Total Sales: xx
// Total Product Sold: xx
// Most Bought Product:  product_xx
// Least Bought Product: product_xx
public class SalesReport {
  private static final String FILE_PATH = "D:\\projects\\dtise-demo-exercises\\session-7\\src\\main\\resources\\product_sales_data.csv";
  private static final String DELIMITER = ",";
  private static final String DATA_HEADER = "Product Name,Total Sold,Item Price";

  public static List<Product> readProductFromCsv() {
    List<Product> products = new ArrayList<>();

    try(BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
      String header = br.readLine();
      if (header == null || !header.equalsIgnoreCase(DATA_HEADER)) {
        throw new IllegalArgumentException("Invalid CSV file format");
      }

      String line;
      while ((line = br.readLine()) != null) {
        String[] data = line.split(DELIMITER);
        if (data.length != 3) {
          throw new IllegalArgumentException("Invalid CSV file format, expected 3 columns but got " + data.length);
        }
        products.add(createProduct(data));
      }
    } catch (Exception e) {
      System.out.println("Something went wrong: " + e.getMessage());
    }

    return products;
  }

  private static Product createProduct(String[] values) {
    Product product = new Product();

    product.setName(values[0].trim());
    try {
      product.setPrice(Double.parseDouble(values[2]));
      product.setSold(Integer.parseInt(values[1]));
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid product price or sold value (it should be a number): " + values[1].trim());
    }

    return product;
  }

  private static void printSummary(List<Product> products) {
    int totalSold = 0;
    BigDecimal totalSales = BigDecimal.ZERO;

    Product mostBought = null;
    Product leastBought = null;

    for (Product product : products) {
      totalSales = totalSales.add(product.getSales());
      totalSold += product.getSold();

      if (mostBought == null || product.getSold() > mostBought.getSold()) {
        mostBought = product;
      }

      if (leastBought == null || product.getSold() < leastBought.getSold()) {
        leastBought = product;
      }
    }

    System.out.println("Total Sold: " + totalSold);
    System.out.println("Total Sales: " + totalSales);
    System.out.println("Most Bought Product: " + mostBought);
    System.out.println("Least Bought Product: " + leastBought);
  }

  public static void main(String[] args) {
    List<Product>  products = readProductFromCsv();
    printSummary(products);
  }
}
