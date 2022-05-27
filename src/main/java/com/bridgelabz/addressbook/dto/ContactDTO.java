package com.bridgelabz.addressbook.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public @Data class ContactDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "First Name is Invalid")
    @NotEmpty(message = "first name cannot be null")
    public String firstName;

    @Pattern(regexp = "^[A-Z]{1,}[a-zA-z\\s]{2,}$", message = "Last Name is Invalid ")
    @NotEmpty(message = "last name cannot be null")
    public String lastName;

    @Pattern(regexp = "^[0-9]{2}?[\\s,-]{0,1}[6-9]{1}[0-9]{9}$", message = "Phone Number is Invalid ")
    @NotEmpty(message = "Phone Number cannot be null")
    public String phoneNumber;

    @Pattern(regexp = "^[#.0-9a-zA-Z\\s,-]+$", message = "Address is Invalid")
    @NotEmpty(message = "Address cannot be null")
    public String address;

    @Pattern(regexp = "^[A-Za-z]{3,}$", message = "City name is Invalid")
    @NotEmpty(message = "City cannot be null")
    public String city;

    @Pattern(regexp = "^[A-Za-z]{2,}$", message = "State Name is Invalid")
    @NotEmpty(message = "State cannot be null")
    public String state;

    @Pattern(regexp = "^[0-9]{3}\\s{0,1}[0-9]{3}$", message = "Zipcode is Invalid")
    @NotEmpty(message = "Zipcode cannot be null")
    public String zipcode;

    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "Email is Invalid")
    @NotEmpty(message = "Email cannot be null")
    public String email;

    public ContactDTO(String firstName, String lastName, String phoneNumber, String address, String city,
                      String state, String zipcode, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.email = email;
    }
}
