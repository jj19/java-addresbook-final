package com.tts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookApp {
    
    private static List<AddressBookEntry> addressBook = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("Address Book Menu:");
            System.out.println();
            System.out.println("1) Add an Entry");
            System.out.println();
            System.out.println("2) Remove an Entry");
            System.out.println();
            System.out.println("3) Search for Specific Entry");
            System.out.println();
            System.out.println("4) Print the Address Book");
            System.out.println();
            System.out.println("5) Delete the Address Book");
            System.out.println();
            System.out.println("6) Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEntry();
                    break;
                case 2:
                    removeEntry();
                    break;
                case 3:
                    searchEntry();
                    break;
                case 4:
                    printAddressBook();
                    break;
                case 5:
                    deleteAddressBook();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEntry() {
      System.out.print("Enter first name: ");
      String firstName = scanner.nextLine();
      System.out.print("Enter last name: ");
      String lastName = scanner.nextLine();
      System.out.print("Enter phone number: ");
      String phoneNumber = scanner.nextLine();
      System.out.print("Enter email address: ");
      String emailAddress = scanner.nextLine();
  
      AddressBookEntry entry = new AddressBookEntry(firstName, lastName, phoneNumber, emailAddress);
      addressBook.add(entry);
      System.out.println();
      System.out.println("Added new entry!");
      System.out.println();
  }
  

  private static void removeEntry() {
    System.out.print("Enter an entry's email to remove: ");
    
    String emailToRemove = scanner.nextLine();

    AddressBookEntry entryToRemove = null;
    for (AddressBookEntry entry : addressBook) {
        if (entry.getEmailAddress().equalsIgnoreCase(emailToRemove)) {
            entryToRemove = entry;
            break;
        }
    }

    if (entryToRemove != null) {
        addressBook.remove(entryToRemove);
        System.out.println("Deleted the following entry:");
        System.out.println("*******************");
        System.out.println("First Name: " + entryToRemove.getFirstName());
        System.out.println("Last Name: " + entryToRemove.getLastName());
        System.out.println("Phone Number: " + entryToRemove.getPhoneNumber());
        System.out.println("Email: " + entryToRemove.getEmailAddress());
        System.out.println("*******************");
    } else {
        System.out.println("Entry with email '" + emailToRemove + "' not found.");
    }
}



private static void searchEntry() {
  System.out.println("Please choose what you'd like to do with the database:");
  System.out.println("1) First Name");
  System.out.println("2) Last Name");
  System.out.println("3) Phone Number");
  System.out.println("4) Email Address");

  int searchOption;
  do {
      System.out.print("Choose a search type: ");
      searchOption = scanner.nextInt();
      scanner.nextLine(); // Consume the newline character

      if (searchOption < 1 || searchOption > 4) {
          System.out.println("Invalid search option. Please choose a number between 1 and 4.");
      }
  } while (searchOption < 1 || searchOption > 4);

  System.out.print("Enter your search: ");
  String searchTerm = scanner.nextLine().toLowerCase(); // Convert search term to lowercase

  // Perform the search based on the selected searchOption
  List<AddressBookEntry> matchingEntries = new ArrayList<>();

  switch (searchOption) {
      case 1: // First Name
          for (AddressBookEntry entry : addressBook) {
              if (entry.getFirstName().toLowerCase().contains(searchTerm)) {
                  matchingEntries.add(entry);
              }
          }
          break;
      case 2: // Last Name
          for (AddressBookEntry entry : addressBook) {
              if (entry.getLastName().toLowerCase().contains(searchTerm)) {
                  matchingEntries.add(entry);
              }
          }
          break;
      case 3: // Phone Number
          for (AddressBookEntry entry : addressBook) {
              if (entry.getPhoneNumber().toLowerCase().contains(searchTerm)) {
                  matchingEntries.add(entry);
              }
          }
          break;
      case 4: // Email Address
          for (AddressBookEntry entry : addressBook) {
              if (entry.getEmailAddress().toLowerCase().contains(searchTerm)) {
                  matchingEntries.add(entry);
              }
          }
          break;
  }

  if (!matchingEntries.isEmpty()) {
      System.out.println("Matching entries found:");
      System.out.println();
      for (AddressBookEntry entry : matchingEntries) {
          System.out.println("*******************");
          System.out.println(entry);
          System.out.println("*******************");
          System.out.println();
          System.out.println();
      }
  } else {
      System.out.println("No matching entries found.");
  }
}

    private static void printAddressBook() {
        for (AddressBookEntry entry : addressBook) {
            System.out.println("*******************");
            System.out.println();
            System.out.println("Name: " + entry.getName());
            System.out.println("Phone Number: " + entry.getPhoneNumber());
            System.out.println("Email: " + entry.getEmail());
            System.out.println("*******************");
            System.out.println();
        }
    }

    private static void deleteAddressBook() {
        addressBook.clear();
        System.out.println("Address book cleared!.");
    }

  

}
