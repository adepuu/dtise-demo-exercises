package com.adepuu.exercises;

import java.util.*;

/**
 * Represents an event with multiple tiers of tickets.
 */
class Event {
  private final String name;
  private final Map<String, List<Ticket>> ticketsByTier;

  /**
   * Constructs a new Event with the specified name, tier quotas, and tier prices.
   *
   * @param name       The name of the event.
   * @param tierQuotas A map of tier names to their respective quotas.
   * @param tierPrices A map of tier names to their respective prices.
   */
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

  /**
   * @return The name of the event.
   */
  public String getName() {
    return name;
  }

  /**
   * @return A map of tier names to their respective lists of tickets.
   */
  public Map<String, List<Ticket>> getTicketsByTier() {
    return ticketsByTier;
  }

  /**
   * Returns the number of available tickets for a specific tier.
   *
   * @param tier The tier to check.
   * @return The number of available tickets in the specified tier.
   */
  public int getAvailableTickets(String tier) {
    return (int) ticketsByTier.get(tier).stream().filter(Ticket::isAvailable).count();
  }

  /**
   * Prints the details of the event, including information about each tier.
   */
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
