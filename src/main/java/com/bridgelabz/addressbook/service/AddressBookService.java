package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{

    @Autowired
    private AddressBookRepository addressBookRepository;


    @Override
    public List<Contact> getContact() {
        return addressBookRepository.findAll();
    }

    @Override
    public Contact getContactById(int contactId) {
        return addressBookRepository.findById(contactId)
                .orElseThrow(() -> new AddressBookException("Address Book with ContactId" + contactId + " does not exists"));
    }

    @Override
    public Contact createContact(ContactDTO contactDTO) {
        Contact contactData = new Contact(contactDTO);
        log.debug("Address book data ", contactData);
        return addressBookRepository.save(contactData);
    }

    @Override
    public Contact updateContact(int contactId, ContactDTO contactDTO) {
        Contact contactData = this.getContactById(contactId);
        contactData.updateContact(contactDTO);
        return addressBookRepository.save(contactData);
    }

    @Override
    public void deleteContact(int contactId) {
        Contact contactData = this.getContactById(contactId);
        addressBookRepository.delete(contactData);
    }

    @Override
    public List<Contact> getContactByCity(String city) {
        return addressBookRepository.findContactListByCity(city);
    }

    @Override
    public List<Contact> getContactByState(String state) {
        return addressBookRepository.findContactListByState(state);
    }
}
