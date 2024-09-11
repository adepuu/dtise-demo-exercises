package com.adepuu.example.cc;

import com.adepuu.example.cc.entity.CreditCard;
import com.adepuu.example.cc.vendors.Amex;
import com.adepuu.example.cc.vendors.Visa;

public class PaymentGateway {
  public static void main(String[] args) {
    var visaCard = new Visa("1234123412341234", "12/24", "999", "Mr Vincent");
    CreditCard amexCard = new Amex("1234123412341234", "11/24", "999", "Mr Budiono");
    visaCard.proccessPayment(11000);
  }
}
