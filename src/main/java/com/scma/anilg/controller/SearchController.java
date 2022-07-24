package com.scma.anilg.controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.scma.anilg.dao.ContactRepository;
import com.scma.anilg.entities.Contact;

@RestController
public class SearchController {
  @Autowired
  private ContactRepository contactRepository;


  @GetMapping(value="/search/{query}")
  public ResponseEntity<?> search(@PathVariable("query") String query) {
    System.out.println(query);
    List<Contact> contacts = this.contactRepository.findByNameContaining(query);
    return ResponseEntity.ok(contacts);
  }
  

}
