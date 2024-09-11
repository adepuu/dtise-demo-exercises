package com.adepuu.example.cc.features;

import java.util.List;

public interface CardLess {
  boolean isEnabled();
  void setEnabled(boolean enabled);
  List<String> getAcceptedVendors();
}
