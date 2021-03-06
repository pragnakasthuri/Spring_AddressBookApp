package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.ContactDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="addressbook_db")
public @Data class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_id")
    private int contactId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zip")
    private String zipcode;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;

    public Contact() {
    }

    public Contact(ContactDTO contactDTO) {
        this.updateContact(contactDTO);
    }

    public void updateContact(ContactDTO contactDTO) {
        this.firstName = contactDTO.firstName;
        this.lastName = contactDTO.lastName;
        this.address = contactDTO.address;
        this.city = contactDTO.city;
        this.state = contactDTO.state;
        this.zipcode = contactDTO.zipcode;
        this.phoneNumber = contactDTO.phoneNumber;
        this.email=contactDTO.email;
    }
}
