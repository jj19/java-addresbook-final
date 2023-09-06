package com.tts;

public class AddressBookEntry {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public AddressBookEntry(String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    // Getter and setter methods for firstName, lastName, phoneNumber, and emailAddress
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Email Address: " + emailAddress + "\n";
    }

    public String getName() {
      return firstName + " "  + lastName ;
    }

    public String getEmail() {
      return emailAddress;
    }
}

