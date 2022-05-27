package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.Contact;

import java.util.List;

public interface IAddressBookService {

    List<Contact> getContact();

    Contact getContactById(int contactId);

    Contact createContact(ContactDTO contactDTO);

    Contact updateContact(int contactId, ContactDTO contactDTO);

    void deleteContact(int contactId);

    List<Contact> getContactByCity(String city);

    List<Contact> getContactByState(String city);

    List<Contact> sortByCity();

    List<Contact> sortByState();
}
