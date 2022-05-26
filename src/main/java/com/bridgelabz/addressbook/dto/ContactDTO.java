package com.bridgelabz.addressbook.dto;

import lombok.Data;

public @Data class ContactDTO {

    public String firstName;
    public String lastName;

    public ContactDTO(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
