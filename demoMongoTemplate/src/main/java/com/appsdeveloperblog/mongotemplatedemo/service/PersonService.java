package com.appsdeveloperblog.mongotemplatedemo.service;

import java.util.List;

import com.appsdeveloperblog.mongotemplatedemo.model.Person;

public interface PersonService {
	boolean savePerson(Person person);
	 List<Person> getAllPerson();
	 Person findOneById(String id);
	 Person findOneByName(String name);
	  List<Person> findByAgeRange(int lowerBound, int upperBound);
	  List<Person> findByFavoriteBooks(String favoriteBook);
	  List<Person> findBynameRegx(String regx);
	  String getNameById(String  id);
	  //-----------------------------------------------------------------------
	    Person updateORsaveOnePerson(Person person);
	    Person updateOnePerson(String id,String fld,String value);
	    List<Person> updateMultiplePersonStateByCity(String city, String value);
	    
	    //-------------------------------------------------------------------------------
	    Person deletePerson(String  id);

}