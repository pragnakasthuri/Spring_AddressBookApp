package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{

    @Autowired
    private AddressBookRepository addressBookRepository;


    List<Contact> contactList = new ArrayList<>();

    @Override
    public List<Contact> getContact() {
        return contactList;
    }

    public Contact getContactById(int contactId) {

        return contactList.stream().filter(contact -> contact.getContactId() == contactId).findFirst()
                .orElseThrow(() -> new AddressBookException("Contact not found"));
    }

    @Override
    public Contact createContact(ContactDTO contactDTO) {
        Contact contactData = new Contact(contactList.size()+1, contactDTO);
        contactList.add(contactData);
        return addressBookRepository.save(contactData);
    }

    @Override
    public Contact updateContact(int contactId, ContactDTO contactDTO) {
        Contact contact = this.getContactById(contactId);
        contact.setFirstName(contactDTO.getFirstName());
        contact.setLastName(contactDTO.getLastName());
        contact.setPhoneNumber(contactDTO.getPhoneNumber());
        contact.setAddress(contactDTO.getAddress());
        contact.setCity(contactDTO.getCity());
        contact.setState(contactDTO.getState());
        contact.setZipcode(contactDTO.getZipcode());
        contact.setEmail(contactDTO.getEmail());
        contactList.set(contactId - 1, contact);
        return contact;
    }

    @Override
    public void deleteContact(int contactId) {
        contactList.remove(contactId-1);
    }
}
