package com.oussema.jpa.models.embedded;


import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    private String city;
    private String state;
    private String zip;
}
