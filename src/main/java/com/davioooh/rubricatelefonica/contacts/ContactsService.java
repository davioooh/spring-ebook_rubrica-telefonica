package com.davioooh.rubricatelefonica.contacts;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
class ContactsService {
  private final ContactsRepository contactRepository;

  public ContactsService(ContactsRepository contactRepository) {
    this.contactRepository = contactRepository;
  }

  public Contact saveContact(ContactForm contactForm) {
    Contact c = mapContact(contactForm);
    return contactRepository.save(c);
  }

  private Contact mapContact(ContactForm contactForm) {
    Contact c = new Contact();
    c.setFirstName(contactForm.getFirstName());
    c.setLastName(contactForm.getLastName());
    c.setPhone(contactForm.getPhone());
    c.setEmail(contactForm.getEmail());
    return c;
  }

  public Optional<Contact> getContact(UUID contactId) {
    return contactRepository.findById(contactId);
  }

  public List<Contact> getAllContacts() {
    return contactRepository.findAll();
  }

}