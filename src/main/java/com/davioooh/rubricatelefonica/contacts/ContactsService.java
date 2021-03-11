package com.davioooh.rubricatelefonica.contacts;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
class ContactsService {
  private final Map<String, Contact> db = new HashMap<>();

  public Contact saveContact(ContactForm contactForm) {
    Contact c = new Contact();
    c.setId(UUID.randomUUID().toString());
    c.setFirstName(contactForm.getFirstName());
    c.setLastName(contactForm.getLastName());
    c.setPhone(contactForm.getPhone());
    c.setEmail(contactForm.getEmail());
    db.put(c.getId(), c);
    return c;
  }

  public Optional<Contact> getContact(String contactId) {
    return Optional.ofNullable(db.get(contactId));
  }

}