package com.adepuu.exercises;

import java.util.*;

public class TicketingSystem {
  private final List<Event> events;
  private final Scanner scanner;

  public TicketingSystem() {
    events = new ArrayList<>();
    scanner = new Scanner(System.in);
  }

  public void createEvent() {
    System.out.print("Enter event name: ");
    String eventName = scanner.nextLine();

    Map<String, Integer> tierQuotas = new HashMap<>();
    Map<String, Double> tierPrices = new HashMap<>();

    while (true) {
      System.out.print("Enter tier name (or 'done' to finish): ");
      String tier = scanner.nextLine();
      if (tier.equalsIgnoreCase("done")) break;

      System.out.print("Enter ticket quota for " + tier + ": ");
      int quota = scanner.nextInt();
      System.out.print("Enter ticket price for " + tier + ": ");
      double price = scanner.nextDouble();
      scanner.nextLine(); // Consume newline

      tierQuotas.put(tier, quota);
      tierPrices.put(tier, price);
    }

    Event event = new Event(eventName, tierQuotas, tierPrices);
    events.add(event);
    System.out.println("Event created successfully.");
  }

  public void bookTicket() {
    if (events.isEmpty()) {
      System.out.println("No events available.");
      return;
    }

    System.out.println("Available events:");
    for (int i = 0; i < events.size(); i++) {
      System.out.println((i + 1) + ". " + events.get(i).getName());
    }

    System.out.print("Select an event (enter number): ");
    int eventChoice = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    if (eventChoice < 1 || eventChoice > events.size()) {
      System.out.println("Invalid event selection.");
      return;
    }

    Event selectedEvent = events.get(eventChoice - 1);
    selectedEvent.printEventDetails();

    System.out.print("Enter the tier you want to book: ");
    String selectedTier = scanner.nextLine();

    if (!selectedEvent.getTicketsByTier().containsKey(selectedTier)) {
      System.out.println("Invalid tier selection.");
      return;
    }

    if (selectedEvent.getAvailableTickets(selectedTier) == 0) {
      System.out.println("Sorry, this tier is sold out.");
      return;
    }

    System.out.print("Enter your name: ");
    String userName = scanner.nextLine();

    Ticket ticketToBook = selectedEvent.getTicketsByTier().get(selectedTier).stream()
            .filter(ticket -> !ticket.isBooked())
            .findFirst()
            .orElse(null);

    if (ticketToBook != null) {
      System.out.println("\nTicket Details:");
      ticketToBook.printTicketDetails();
      System.out.print("Confirm booking? (yes/no): ");
      String confirmation = scanner.nextLine();

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
    int eventChoice = scanner.nextInt();
    scanner.nextLine(); // Consume newline

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

  public void run() {
    while (true) {
      System.out.println("\n1. Create Event");
      System.out.println("2. Book Ticket");
      System.out.println("3. Display All Events");
      System.out.println("4. Display Event Tickets");
      System.out.println("5. Exit");
      System.out.print("Choose an option: ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline

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