package com.adepuu.exercises;

import java.util.UUID;

class Ticket implements Ticketable {
  private final UUID ticketId;
  private final String tier;
  private final double price;
  private boolean isBooked;
  private String bookedBy;

  public Ticket(String tier, double price) {
    this.ticketId = UUID.randomUUID();
    this.tier = tier;
    this.price = price;
    this.isBooked = false;
  }

  public boolean book(String userName) {
    if (!isBooked) {
      isBooked = true;
      bookedBy = userName;
      return true;
    }
    return false;
  }

  public UUID getTicketId() {
    return ticketId;
  }

  public String getTier() {
    return tier;
  }

  public double getPrice() {
    return price;
  }

  public boolean isBooked() {
    return isBooked;
  }

  @Override
  public void printTicketDetails() {
    System.out.println("Ticket ID: " + ticketId);
    System.out.println("Tier: " + tier);
    System.out.println("Price: " + String.format("%.2f", price));
    System.out.println("Status: " + (isBooked ? "Booked by " + bookedBy : "Available"));
  }
}
