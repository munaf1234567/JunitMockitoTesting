package com.appsdeveloperblog.mongotemplatedemo.Dao;

import java.util.*;

import com.appsdeveloperblog.mongotemplatedemo.model.*;

public interface PersonDao {
	//----------------------insert-------------------------------------
	boolean savePerson(Person person);
	//-----------------------find-----------------------------------
    List<Person> getAllPerson();
    Person findOneById(String id);
    Person findOneByName(String name);
    List<Person> findByAgeRange(int lowerBound, int upperBound);
    List<Person> findByFavoriteBooks(String favoriteBook);
    List<Person> findBynameRegx(String regx);
    //-------------------update--------------------------------------------------
  
    Person updateORsaveOnePerson(Person person);
    Person updateOnePerson(String id,String fld,String value);
    List<Person> updateMultiplePersonStateByCity(String city, String value);
    //-------------------update--------------------------------------------------  
    Person deletePerson(String  id);
    String getNameById(String  id);

    
    
    
    
//	   List<Person> getAllPersonPaginated(
//	   int pageNumber, int pageSize);
//	   Person findOneByName(String name);
//	   List<Person> findByName(String name);
//	   List<Person> findByBirthDateAfter(Date date);
//	   List<Person> findByAgeRange(int lowerBound, int upperBound);
//	   List<Person> findByFavoriteBooks(String favoriteBook);
//	   void updateMultiplePersonAge();
//	   Person updateOnePerson(Person person);
//	   void deletePerson(Person person);

}
