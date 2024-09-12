package com.adepuu.exercises;

import com.adepuu.exercises.utils.Input;

import java.util.*;

/**
 * Manages the ticketing system, including events and ticket bookings.
 */
public class TicketingSystem {
  private final List<Event> events;

  /**
   * Constructs a new TicketingSystem.
   */
  public TicketingSystem() {
    events = new ArrayList<>();
  }

  /**
   * Creates a new event with multiple tiers.
   */
  public void createEvent() {
    String eventName = Input.getStringInput("Enter event name: ");

    Map<String, Integer> tierQuotas = new HashMap<>();
    Map<String, Double> tierPrices = new HashMap<>();

    while (true) {
      String tier = Input.getStringInput("Enter tier name (or 'done' to finish): ");
      if (tier.equalsIgnoreCase("done")) break;

      int quota = Input.getIntInput("Enter ticket quota for " + tier + ": ");
      double price = Input.getDoubleInput("Enter ticket price for " + tier + ": ");

      tierQuotas.put(tier, quota);
      tierPrices.put(tier, price);
    }

    Event event = new Event(eventName, tierQuotas, tierPrices);
    events.add(event);
    System.out.println("Event created successfully.");
  }

  /**
   * Handles the ticket booking process.
   */
  public void bookTicket() {
    if (events.isEmpty()) {
      System.out.println("No events available.");
      return;
    }

    System.out.println("Available events:");
    for (int i = 0; i < events.size(); i++) {
      System.out.println((i + 1) + ". " + events.get(i).getName());
    }

    int eventChoice = Input.getIntInput("Select an event (enter number): ");

    if (eventChoice < 1 || eventChoice > events.size()) {
      System.out.println("Invalid event selection.");
      return;
    }

    Event selectedEvent = events.get(eventChoice - 1);
    selectedEvent.printEventDetails();

    String selectedTier = Input.getStringInput("Enter the tier you want to book: ");

    if (!selectedEvent.getTicketsByTier().containsKey(selectedTier)) {
      System.out.println("Invalid tier selection.");
      return;
    }

    if (selectedEvent.getAvailableTickets(selectedTier) == 0) {
      System.out.println("Sorry, this tier is sold out.");
      return;
    }

    String userName = Input.getStringInput("Enter your name: ");

    Ticket ticketToBook = selectedEvent.getTicketsByTier().get(selectedTier).stream()
            .filter(Ticket::isAvailable)
            .findFirst()
            .orElse(null);

    if (ticketToBook != null) {
      System.out.println("\nTicket Details:");
      ticketToBook.printTicketDetails();
      String confirmation = Input.getStringInput("Confirm booking? (yes/no): ");

      if (confirmation.equalsIgnoreCase("yes")) {
        if (ticketToBook.book(userName)) {
          System.out.println("Ticket booked successfully!");
          ticketToBook.printTicketDetails();
        } else {
          System.out.println("Failed to book the ticket. It may have been booked by someone else.");
        }
      } else {
        System.out.println("Booking cancelled.");
      }
    } else {
      System.out.println("Failed to find an available ticket.");
    }
  }

  /**
   * Displays details of all events.
   */
  public void displayAllEvents() {
    if (events.isEmpty()) {
      System.out.println("No events available.");
    } else {
      for (Event event : events) {
        event.printEventDetails();
        System.out.println("--------------------");
      }
    }
  }

  /**
   * Displays tickets for a selected event.
   */
  public void displayEventTickets() {
    if (events.isEmpty()) {
      System.out.println("No events available.");
      return;
    }

    System.out.println("Select an event to display tickets:");
    for (int i = 0; i < events.size(); i++) {
      System.out.println((i + 1) + ". " + events.get(i).getName());
    }

    System.out.print("Enter your choice: ");
    int eventChoice = Input.getIntInput("");

    if (eventChoice < 1 || eventChoice > events.size()) {
      System.out.println("Invalid event selection.");
      return;
    }

    Event selectedEvent = events.get(eventChoice - 1);
    System.out.println("Tickets for event: " + selectedEvent.getName());
    for (Map.Entry<String, List<Ticket>> entry : selectedEvent.getTicketsByTier().entrySet()) {
      System.out.println("Tier: " + entry.getKey());
      for (Ticket ticket : entry.getValue()) {
        ticket.printTicketDetails();
        System.out.println("--------------------");
      }
    }
  }

  /**
   * Runs the ticketing system, providing a menu for user interactions.
   */
  public void run() {
    while (true) {
      System.out.println("\n1. Create Event");
      System.out.println("2. Book Ticket");
      System.out.println("3. Display All Events");
      System.out.println("4. Display Event Tickets");
      System.out.println("5. Exit");
      System.out.print("Choose an option: ");

      int choice = Input.getIntInput("");

      switch (choice) {
        case 1:
          createEvent();
          break;
        case 2:
          bookTicket();
          break;
        case 3:
          displayAllEvents();
          break;
        case 4:
          displayEventTickets();
          break;
        case 5:
          System.out.println("Thank you for using the Ticketing System. Goodbye!");
          return;
        default:
          System.out.println("Invalid option. Please try again.");
      }
    }
  }
}