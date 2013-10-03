package org.springframework.social.google.api.contacts.impl;


import org.springframework.social.google.api.contacts.Contact;
import org.springframework.social.google.api.contacts.ContactList;
import org.springframework.social.google.api.contacts.ContactsOperations;
import org.springframework.social.google.api.impl.AbstractGoogleApiOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ContactsTemplate  extends AbstractGoogleApiOperations implements ContactsOperations{
           private static final String CONTACTS_URL = "https://www.google.com/m8/feeds/";
           private static final String CONTACTS_LIST_URL  = CONTACTS_URL + "contacts/default/full?alt=json&max-results=9999";

    public ContactsTemplate(RestTemplate restTemplate,boolean isAuthorized) {
        super(restTemplate,isAuthorized);
    }

    @Override
    public Contact getContacts(){
        return restTemplate.getForObject(CONTACTS_LIST_URL, Contact.class);
    }

}
