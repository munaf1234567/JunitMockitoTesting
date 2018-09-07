package com.appsdeveloperblog.mongotemplatedemo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Document(collection = "person")
public class Person {
   @Id
   private String personId;
   private String name;
   private long age;
   private String sex;
   private String country;
   private String state;
   private String city;
   private List<String> favoriteBooks;
   private String dateOfBirth;
public String getPersonId() {
	return personId;
}
public void setPersonId(String personId) {
	this.personId = personId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getAge() {
	return age;
}
public void setAge(long age) {
	this.age = age;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public List<String> getFavoriteBooks() {
	return favoriteBooks;
}
public void setFavoriteBooks(List<String> favoriteBooks) {
	this.favoriteBooks = favoriteBooks;
}
public String getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public Person(String personId, String name, long age, String sex, String country, String state, String city,
		List<String> favoriteBooks, String dateOfBirth) {
	super();
	this.personId = personId;
	this.name = name;
	this.age = age;
	this.sex = sex;
	this.country = country;
	this.state = state;
	this.city = city;
	this.favoriteBooks = favoriteBooks;
	this.dateOfBirth = dateOfBirth;
}
public Person() {
	super();
}
   
  
}