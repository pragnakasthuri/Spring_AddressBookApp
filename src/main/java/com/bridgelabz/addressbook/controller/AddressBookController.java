package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService iAddressBookService;

    @GetMapping(value = { "", "/", "/get" })
    public ResponseEntity<ResponseDTO> getContactData() {
    List<Contact> contactList = iAddressBookService.getContact();
    ResponseDTO responseDTO = new ResponseDTO("Get call Success", contactList);
    return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDTO> getContactDataById(@PathVariable("contactId") int contactId) {
        Contact contact = iAddressBookService.getContactById(contactId);
        ResponseDTO responseDTO = new ResponseDTO("Get call Success for id", contact);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addContactData(@Valid @RequestBody ContactDTO contactDTO) {
        Contact contact = iAddressBookService.createContact(contactDTO);
        ResponseDTO responseDTO = new ResponseDTO("Contact Added Successfully", contact);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updateContactData(@PathVariable("contactId") int contactId, @Valid @RequestBody ContactDTO contactDTO) {
        Contact contact = iAddressBookService.updateContact(contactId, contactDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Contact data Successfully", contact);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deleteContactData(@PathVariable("contactId") int contactId) {
        iAddressBookService.deleteContact(contactId);
        ResponseDTO responseDTO = new ResponseDTO("Delete Contact Data for Id ", + contactId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<ResponseDTO> getContactByCity(@PathVariable String city) {
        List<Contact> contactList = null;
        contactList = iAddressBookService.getContactByCity(city);
        ResponseDTO response = new ResponseDTO("Get Call for search by city is successful", contactList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<ResponseDTO> getContactByState(@PathVariable String state) {
        List<Contact> contactList = null;
        contactList = iAddressBookService.getContactByState(state);
        ResponseDTO response = new ResponseDTO("Get Call for search by state is successful", contactList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
}
