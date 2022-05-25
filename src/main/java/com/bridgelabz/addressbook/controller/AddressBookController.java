package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @RequestMapping("/get")
    public ResponseEntity<String> getContactData(){
        Contact contact = null;
        contact = new Contact(1, new ContactDTO("Pragna", "Kasthuri"));
        return new ResponseEntity<String>("Get Call Success" +contact, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getContactDataById(@PathVariable("id") int id) {
        Contact contact = null;
        contact = new Contact(1, new ContactDTO("Pragna", "Kasthuri"));
        return new ResponseEntity<String>("Get Call Success For Id " +id  +contact, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createContact(@RequestBody Contact contact) {
        return new ResponseEntity<String>("Contact Added Successfully" +contact, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateContact(@PathVariable("id") int id,@RequestBody Contact contact) {
        return new ResponseEntity<String>("Updated Contact Data Successfully" +contact, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") int id) {
        return new ResponseEntity<String>("Deleted contact for Id " + id, HttpStatus.OK);
    }
}
