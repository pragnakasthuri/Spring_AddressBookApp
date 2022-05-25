package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.ContactDTO;

public class Contact {
    
    private int contactId;
    private String firstName;
    private String lastName;

    public Contact(int contactId, ContactDTO contactDTO) {
        super();
        this.contactId =  contactId;
        this.firstName =  contactDTO.firstName;
        this.lastName = contactDTO.lastName;
    }

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

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
