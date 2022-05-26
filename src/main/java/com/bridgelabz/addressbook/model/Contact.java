package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.ContactDTO;
import lombok.Data;

@Data
public class Contact {
    
    private int contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String email;

    public Contact(int contactId, ContactDTO contactDTO) {
        super();
        this.contactId =  contactId;
        this.firstName =  contactDTO.firstName;
        this.lastName = contactDTO.lastName;
        this.phoneNumber = contactDTO.phoneNumber;
        this.address = contactDTO.address;
        this.city = contactDTO.city;
        this.state = contactDTO.state;
        this.zipcode = contactDTO.zipcode;
        this.email = contactDTO.email;
    }
}
