package com.adepuu.exercises;

import java.util.UUID;

/**
 * Represents a ticket for an event.
 */
class Ticket implements Ticketable {
  private final UUID ticketId;
  private final String tier;
  private final double price;
  private boolean isBooked;
  private String bookedBy;

  /**
   * Constructs a new Ticket with the specified tier and price.
   *
   * @param tier  The tier or zone of the ticket.
   * @param price The price of the ticket.
   */
  public Ticket(String tier, double price) {
    this.ticketId = UUID.randomUUID();
    this.tier = tier;
    this.price = price;
    this.isBooked = false;
  }

  /**
   * Attempts to book the ticket for the specified user.
   *
   * @param userName The name of the user booking the ticket.
   * @return true if the booking was successful, false otherwise.
   */
  public boolean book(String userName) {
    if (!isBooked) {
      isBooked = true;
      bookedBy = userName;
      return true;
    }
    return false;
  }

  /**
   * @return The price of the ticket.
   */
  public double getPrice() {
    return price;
  }

  /**
   * @return false if the ticket is booked, true otherwise.
   */
  public boolean isAvailable() {
    return !isBooked;
  }

  /**
   * Prints the details of the ticket.
   */
  @Override
  public void printTicketDetails() {
    System.out.println("Ticket ID: " + ticketId);
    System.out.println("Tier: " + tier);
    System.out.println("Price: " + String.format("%.2f", price));
    System.out.println("Status: " + (isBooked ? "Booked by " + bookedBy : "Available"));
  }
}
