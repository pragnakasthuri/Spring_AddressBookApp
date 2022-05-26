package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{

    @Override
    public List<Contact> getContact() {
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact(1, new ContactDTO("Pragna", "Kasthuri")));
        return contactList;
    }

    @Override
    public Contact getContactById(int contactId) {
        Contact contact = new Contact(1, new ContactDTO("Pragna", "Kasthuri"));
        return contact;
    }

    @Override
    public Contact createContact(ContactDTO contactDTO) {
        Contact contact = new Contact(1, contactDTO);
        return contact;
    }

    @Override
    public Contact updateContact(int contactId, ContactDTO contactDTO) {
        Contact contact = new Contact(1, contactDTO);
        return contact;
    }

    @Override
    public void deleteContact(int contactId) {

    }
}
