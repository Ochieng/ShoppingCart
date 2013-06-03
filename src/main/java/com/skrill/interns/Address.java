package com.skrill.interns;

/**
 * 
 * @author boykoarsov This is a class that represents a person's address.
 */
public class Address {
    private String country;
    private String city;
    private String addressLine1;
    private String addressLine2;
    private String zip;

    public Address() {
        country = "";
        city = "";
        addressLine1 = "";
        addressLine2 = "";
        zip = "";
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String toString() {
        return String.format(
                " \"Address\" : [{\"country\": \"%s\"},{\"city\":\"%s\"},{\"street\":\"%s\"},{\"zip\":\"%s\"}]",
                country, city, addressLine1, zip);
    }

}
