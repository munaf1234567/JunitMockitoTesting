package com.appsdeveloperblog.mongotemplatedemo.Dao;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.coyote.UpgradeToken;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.springframework.data.mongodb.core.query.Criteria.where;


import org.springframework.stereotype.Repository;

import com.appsdeveloperblog.mongotemplatedemo.model.Person;

@Repository
public class PersonDaoImpl  implements PersonDao{
 @Autowired
 MongoTemplate mongoTemplate;

	
	public PersonDaoImpl() {
		System.out.println("PersonDaoImpl--d.c");
		System.out.println(mongoTemplate);
	}
	
	@Override
	public boolean savePerson(Person person) {
		try
		{
			System.out.println(mongoTemplate);
			mongoTemplate.save(person);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public List<Person> getAllPerson() {
		
		return mongoTemplate.findAll(Person.class);
	}

	@Override
	public Person findOneById(String id) {
		Person p=mongoTemplate.findById(id, Person.class);
		System.out.println(p);
		return p;
	}

	@Override
	public Person findOneByName(String name) {
		Query query= new Query(where("name").is(name));
		 return mongoTemplate.findOne(query, Person.class);
	}

	@Override
	public List<Person> findByAgeRange(int lowerBound, int upperBound) {
		Query query=new Query(where("age").gte(lowerBound).lte(upperBound));		
		return mongoTemplate.find(query, Person.class);
		
	}

	@Override
	public List<Person> findByFavoriteBooks(String favoriteBook) {
		
		Query query=new Query(where("favoriteBooks").regex(favoriteBook));
		return mongoTemplate.find(query, Person.class);
	}

	@Override
	public List<Person> findBynameRegx(String regx) {
		System.out.println(regx);
      String reg="^"+regx;
      System.out.println(reg);
	//	Query query=new Query(where("name").regex("^m","i"));
  	Query query=new Query(where("name").regex(reg,"i"));
		List<Person> list=mongoTemplate.find(query, Person.class);
		System.out.println(list);
		return list;
	}

	@Override
	public Person updateORsaveOnePerson(Person person) {
	
		mongoTemplate.save(person);

	
		Person p=mongoTemplate.findById(person.getPersonId(), Person.class);
		System.out.println(p);
		return p;
		
		
	}

	@Override
	public Person updateOnePerson(String id,String fld,String value) {
		Query query=new Query(where("_id").is(id));
		Update u=Update.update(fld, value);
		mongoTemplate.upsert(query, u, Person.class);
		Person p=mongoTemplate.findById(id, Person.class);
		System.out.println(p);
		return p;
	}

	@Override
	public List<Person> updateMultiplePersonStateByCity(String city, String value) {
		Query query=new Query(where("city").is(city));
		Update u=Update.update("state", value);
		mongoTemplate.updateMulti(query, u, Person.class);
		return mongoTemplate.find(query, Person.class);
	}

	@Override
	public Person deletePerson(String id) {
		
		Query query=new Query(where("_id").is(id));
		Person p=this.findOneById(id);
		if(p!=null)
		mongoTemplate.remove(query, Person.class);
		
		return p;
	}

	@Override
	public String getNameById(String id) {
		Query query=new Query(where("_id").is(id));
		query.fields().include("name");
		
		
		return mongoTemplate.findOne(query, Person.class).getName();
	}

}
