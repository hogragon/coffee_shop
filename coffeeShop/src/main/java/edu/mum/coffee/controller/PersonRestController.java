/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.coffee.controller;


import edu.mum.coffee.domain.Person;
import java.util.List;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Son Vu
 */
@RestController
public class PersonRestController {
    
    @Autowired
    private PersonService personService;
    
    @GetMapping(RestURIConstant.PERSON_LIST)
    public ResponseEntity getPersonList(){
        List<Person> list = personService.getAll();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping(RestURIConstant.PERSON_CREATE)
    public ResponseEntity createPerson(@ModelAttribute Person p){
        personService.savePerson(p);
        return new ResponseEntity(p,HttpStatus.OK);
    }
}
