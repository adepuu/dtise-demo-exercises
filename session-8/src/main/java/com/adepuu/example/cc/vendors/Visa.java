package com.adepuu.example.cc.vendors;

import com.adepuu.example.cc.entity.CreditCard;
import com.adepuu.example.cc.features.CardLess;
import com.adepuu.example.cc.features.Rewards;

import java.util.List;

public class Visa extends CreditCard implements Rewards, CardLess {

  public Visa(String number, String expiryDate, String cvv, String holderName) {
    super(number, expiryDate, cvv, holderName);
  }

//Inherited from CreditCard abstract class
  @Override
  public boolean proccessPayment(double amount) {
    System.out.println("Payment by visa. Amount: " + amount);
    return true;
  }

//Inherited from Rewards interface
  @Override
  public void setPoints(int points) {

  }

  //Inherited from Rewards interface
  @Override
  public int getPoints() {
    return 0;
  }

  //Inherited from Rewards interface
  @Override
  public List<String> getBenefits() {
    return List.of();
  }

  //Inherited from Rewards interface
  @Override
  public void setBenefits(List<String> benefits) {

  }

  //Inherited from Rewards interface
  @Override
  public void setIssuer(String issuer) {

  }

  //Inherited from CardLess interface
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
