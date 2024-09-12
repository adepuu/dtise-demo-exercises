package com.adepuu.exercises;

import java.util.*;

class Event {
  private final String name;
  private final Map<String, List<Ticket>> ticketsByTier;

  public Event(String name, Map<String, Integer> tierQuotas, Map<String, Double> tierPrices) {
    this.name = name;
    this.ticketsByTier = new HashMap<>();
    for (Map.Entry<String, Integer> entry : tierQuotas.entrySet()) {
      String tier = entry.getKey();
      int quota = entry.getValue();
      double price = tierPrices.get(tier);
      List<Ticket> tickets = new ArrayList<>();
      for (int i = 0; i < quota; i++) {
        tickets.add(new Ticket(tier, price));
      }
      ticketsByTier.put(tier, tickets);
    }
  }

  public String getName() {
    return name;
  }

  public Map<String, List<Ticket>> getTicketsByTier() {
    return ticketsByTier;
  }

  public int getAvailableTickets(String tier) {
    return (int) ticketsByTier.get(tier).stream().filter(ticket -> !ticket.isBooked()).count();
  }

  public void printEventDetails() {
    System.out.println("Event: " + name);
    for (Map.Entry<String, List<Ticket>> entry : ticketsByTier.entrySet()) {
      String tier = entry.getKey();
      List<Ticket> tickets = entry.getValue();
      System.out.println("Tier: " + tier);
      System.out.println("  Total tickets: " + tickets.size());
      System.out.println("  Available tickets: " + getAvailableTickets(tier));
      System.out.println("  Ticket price: " + String.format("%.2f", tickets.get(0).getPrice()));
    }
  }
}
