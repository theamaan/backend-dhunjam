package com.dhunjam.backend.controller;

import com.dhunjam.backend.Exception.ResourceNotFoundException;
import com.dhunjam.backend.entity.Person;
import com.dhunjam.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/account")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/admin")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @PostMapping("/admin")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Integer id) throws ResourceNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + id));
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    @PutMapping("/admin/{id}")
    public ResponseEntity<Person> updatePersonById(@PathVariable Integer id, @RequestBody Person personDetails) throws ResourceNotFoundException{
        Person existingPerson = personRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Person not exists with id:"+id));
        existingPerson.setFullName(personDetails.getFullName());
        existingPerson.setLocation(personDetails.getLocation());
        existingPerson.setEmail(personDetails.getEmail());
        Person updatedPerson = personRepository.save(existingPerson);
        return new ResponseEntity<>(updatedPerson,HttpStatus.OK);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable Integer id) {
        personRepository.deleteById(id);
        return new ResponseEntity<>("Person record deleted with id: " + id, HttpStatus.NO_CONTENT);
    }
}