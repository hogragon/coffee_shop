package edu.mum.coffee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.repository.PersonRepository;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Transactional
	public void savePerson(Person person) {
		personRepository.save(person);
	}
	@Transactional
	public Person findByEmail(String email){
		return personRepository.findByEmail(email);
	}
	@Transactional
	public Person findById(Long id){
		return personRepository.findOne(id);
	}
	@Transactional
	public List<Person> getAll(){
                return personRepository.findAll();
	}
}
