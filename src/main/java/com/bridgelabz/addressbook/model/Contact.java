package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.ContactDTO;
import lombok.Data;

@Data
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
}
