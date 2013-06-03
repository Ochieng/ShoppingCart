package com.skrill.interns;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author boykoarsov This is a class that models a person's contact details
 *         such as names, email, telephone, etc.
 */
public class PersonalInformation {
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String phoneNumber;
    private Date dateOfBirth;

    public PersonalInformation() {
        firstName = "";
        lastName = "";
        email = "";
        address = new Address();
        phoneNumber = "";
        dateOfBirth = new Date();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String toString() {
        return String
                .format(" \"Personal Information\" : [{\"First name\": \"%s\"},{\"Last name\":\"%s\"},{\"Email\":\"%s\"},{\"Phone number\":\"%s\"}, {\"Date of birth\":\"%s\"}], %s}",
                        firstName, lastName, email, phoneNumber,
                        new SimpleDateFormat("yyyy/MM/dd").format(dateOfBirth), address.toString());
    }
}
