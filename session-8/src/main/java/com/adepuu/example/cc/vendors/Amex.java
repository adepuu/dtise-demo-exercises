package com.adepuu.example.cc.vendors;

import com.adepuu.example.cc.entity.CreditCard;
import com.adepuu.example.cc.features.CardLess;

import java.util.List;

public class Amex extends CreditCard implements CardLess {
  public Amex(String number, String expiryDate, String cvv, String holderName) {
    super(number, expiryDate, cvv, holderName);
  }

  @Override
  public boolean proccessPayment(double amount) {
    System.out.println("Payment by american express. Amount: " + amount);
    return true;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }

  @Override
  public void setEnabled(boolean enabled) {

  }

  @Override
  public List<String> getAcceptedVendors() {
    return List.of();
  }
}
