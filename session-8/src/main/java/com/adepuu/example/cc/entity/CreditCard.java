package com.adepuu.example.cc.entity;

import com.adepuu.example.cc.features.CardLess;

public abstract class CreditCard implements CardLess {
  String number;
  String expiryDate;
  String cvv;
  String holderName;

  public CreditCard(String number, String expiryDate, String cvv, String holderName) {
    this.number = number;
    this.expiryDate = expiryDate;
    this.cvv = cvv;
    this.holderName = holderName;
  }

  public abstract boolean proccessPayment(double amount);
}
