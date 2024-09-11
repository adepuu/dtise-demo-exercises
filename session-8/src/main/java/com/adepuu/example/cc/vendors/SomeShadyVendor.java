package com.adepuu.example.cc.vendors;

import com.adepuu.example.cc.entity.CreditCard;

import java.util.List;

public class SomeShadyVendor extends CreditCard {
  public SomeShadyVendor(String number, String expiryDate, String cvv, String holderName) {
    super(number, expiryDate, cvv, holderName);
  }

  @Override
  public boolean proccessPayment(double amount) {
    return false;
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
