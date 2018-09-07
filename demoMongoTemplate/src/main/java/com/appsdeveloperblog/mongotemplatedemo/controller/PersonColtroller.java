package com.appsdeveloperblog.mongotemplatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.mongotemplatedemo.model.Person;
import com.appsdeveloperblog.mongotemplatedemo.service.PersonService;

@RestController
public class PersonColtroller {
	public PersonColtroller() {
		System.out.println("PersonColtroller--d.c");
	}

	@Autowired
	PersonService ps;
	
	@PostMapping("/savepersion")
	String savePerson(@RequestBody Person person)
	{
	
		String msg="";
		boolean b=ps.savePerson(person);
		if(b)
		{
			msg="persion"+ "\t"+ person.getPersonId() +"\t"+"is Saved";
		}
		else
		{
			msg="persion"+person.getPersonId()+"is not Saved";
			
		}
		return msg;
	}
	
	@GetMapping("/getAllPerson")
	public List<Person> getAllPerson()
	{
		return ps.getAllPerson();
		
	}
	
	@GetMapping("/getPersonById/{id}")
	public Person findOneById(@PathVariable String id) {
		Person p=ps.findOneById(id);
	
		if(p!=null)
		{
			//ResponseEntity e= new ResponseEntity<>(HttpStatus.FOUND);
		
			return p;
			
		}else
		{
			throw new PersionNotFoundException(id);
		}
	}

	
	
	@GetMapping("/getPersonByName/{name}")
	public Person findOneByName(@PathVariable String name) {
		
		Person p=ps.findOneByName(name);
		String msg="";
		if(p!=null)
		{
			return p;
		}else
		{
			throw new PersionNotFoundException("name "+name );
		}
			
	}
	
	@GetMapping("/getPersonByAgeRange/{lowerBound}/{upperBound}")
	List<Person> findByAgeRange(@PathVariable int lowerBound,@PathVariable int upperBound)
	{
		return ps.findByAgeRange(lowerBound, upperBound);
	}
	
	
	@GetMapping("/getPersonByFavoriteBooks/{favoriteBook}")
	public List<Person> findByFavoriteBooks(@PathVariable String favoriteBook) {
		
		
		return ps.findByFavoriteBooks(favoriteBook);
	}
	@GetMapping("/getPersonBynameRegx/{regx}")
	public List<Person> findBynameRegx(@PathVariable String regx) {
		
		List<Person> list=	ps.findBynameRegx(regx);
		
		String msg="";
		if(!list.isEmpty())
		{
			return list;
		}else
		{
			throw new PersionNotFoundException(regx +"not matche with any Person name");
		}
	}
	
	
	@PostMapping("/updateORsaveOnePerson")
	public Person updateORsaveOnePerson(@RequestBody Person person)
	{
		return ps.updateORsaveOnePerson(person);
	}
	@GetMapping("/updateOnePerson/{id}/{fld}/{value}")
	public Person updateOnePerson(@PathVariable String id,@PathVariable String fld, @PathVariable String value) {
		return ps.updateOnePerson(id, fld, value);
	}
	
	@GetMapping("/updateMultiplePersonStateByCity/{city}/{value}")
	public List<Person> updateMultiplePersonStateByCity(@PathVariable String city, @PathVariable String value) {
		return ps.updateMultiplePersonStateByCity(city, value);
	}
	
	
	
	@GetMapping("/deletePerson/{id}")
   public Person deletePerson(@PathVariable String id) {
		
		
		Person p=ps.deletePerson(id);
		
		if(p!=null)
		{
			return p;
		}else
		{
			throw new PersionNotFoundException("person with "+id +"does not exist");
		}
	}
	
	@GetMapping("/getNameById/{id}")
	public String getNameById(@PathVariable String id) {
		// TODO Auto-generated method stub
		return ps.getNameById(id);
	}
	
	
	
	
	
	
	
	
	
	}

