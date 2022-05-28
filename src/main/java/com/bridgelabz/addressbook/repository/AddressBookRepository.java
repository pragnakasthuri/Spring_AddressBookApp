package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<Contact, Integer> {
    @Query(value = "select * from addressbook_db where city= :city", nativeQuery = true)
    List<Contact> findContactListByCity(String city);

    @Query(value = "select * from addressbook_db where state= :state", nativeQuery = true)
    List<Contact> findContactListByState(String state);

    @Query(value = "select * from addressbook_db order by city", nativeQuery = true)
    List<Contact> sortByCity();

    @Query(value="select * from addressbook_db order by state",nativeQuery = true)
    List<Contact> sortByState();
}






