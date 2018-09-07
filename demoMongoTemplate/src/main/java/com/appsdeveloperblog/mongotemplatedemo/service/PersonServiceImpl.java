package com.appsdeveloperblog.mongotemplatedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.mongotemplatedemo.Dao.PersonDao;
import com.appsdeveloperblog.mongotemplatedemo.Dao.PersonDaoImpl;
import com.appsdeveloperblog.mongotemplatedemo.model.Person;
@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	PersonDao pdao;
	public PersonServiceImpl() {
		System.out.println("PersonServiceImpl--d.c");
	}
	@Override
	public boolean savePerson(Person person) {
		
		return pdao.savePerson(person);
	}
	@Override
	public List<Person> getAllPerson() {
		
		return pdao.getAllPerson();
	}
	@Override
	public Person findOneById(String id) {
		// TODO Auto-generated method stub
		return pdao.findOneById(id);
	}
	@Override
	public Person findOneByName(String name) {
		// TODO Auto-generated method stub
		return pdao.findOneByName(name);
	}
	@Override
	public List<Person> findByAgeRange(int lowerBound, int upperBound) {
		// TODO Auto-generated method stub
		return pdao.findByAgeRange(lowerBound, upperBound);
	}
	@Override
	public List<Person> findByFavoriteBooks(String favoriteBook) {
		
		return pdao.findByFavoriteBooks(favoriteBook);
	}
	@Override
	public List<Person> findBynameRegx(String regx) {
		
		return pdao.findBynameRegx(regx);
	}
	@Override
	public Person updateORsaveOnePerson(Person person) {
		
		return pdao.updateORsaveOnePerson(person);
	}
	@Override
	public Person updateOnePerson(String id,String fld,String value) {
		// TODO Auto-generated method stub
		return pdao.updateOnePerson(id, fld, value);
	}
	@Override
	public List<Person> updateMultiplePersonStateByCity(String city, String value) {
		// TODO Auto-generated method stub
		return pdao.updateMultiplePersonStateByCity(city, value);
	}
	@Override
	public Person deletePerson(String id) {
		
		return pdao.deletePerson(id);
	}
	@Override
	public String getNameById(String id) {
		// TODO Auto-generated method stub
		return pdao.getNameById(id);
	}

}
