package com.adepuu.example.cc.features;

import java.util.List;

public interface Rewards {
  void setPoints(int points);
  int getPoints();
  List<String> getBenefits();
  void setBenefits(List<String> benefits);
  void setIssuer(String issuer);
}
