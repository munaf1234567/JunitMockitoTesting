package com.appsdeveloperblog.mongotemplatedemo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.appsdeveloperblog.mongotemplatedemo.model.Person;
import com.appsdeveloperblog.mongotemplatedemo.service.PersonService;
import com.exilant.mongotemplate.demoMongoTemplate.DemoMongoTemplateApplication;


@RunWith(SpringRunner.class)
@WebMvcTest(value = PersonColtroller.class, secure = false)
@ContextConfiguration(classes={DemoMongoTemplateApplication.class})
public class PersonControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonService personService;

	@Test
	public void createStudentCourse() throws Exception {
	String presonjosn="{\n" + 
			"	\"personId\" : \"711\",\n" + "	\"name\" : \"samas229\",\n" + "	\"age\" : \"30\",\n" + "	\"sex\" : \"male\",\n" + "	\"country\" : \"ind\",\n" + "	\"state\" : \"KA\",\n" + 
			"	\"city\" : \"btm\",\n" + "	\"favoriteBooks\" : [\n" + "		\"java\",\n" + "		\"spring\",\n" + "		\"hibernate\"\n" + "	],\n" + "	\"dateOfBirth\" : \"21-12-1999\"\n" + "	}";
		// studentService.addCourse to respond back with mockCourse
		Mockito.when(personService.savePerson(Mockito.any(Person.class))).thenReturn(true);
		// Send course as body to /students/Student1/courses
		 RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/savepersion").accept(MediaType.APPLICATION_JSON).content(presonjosn).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals("persion	711	is Saved",result.getResponse().getContentAsString());
		

	}
	@Test
	public void getPersonBYIDFound() throws Exception {
		Person mockPersion = new Person("711", "samas229", 30, "male", "ind", "KA", "btm", Arrays.asList("java","spring","hibernate"), "21-12-1999");	
		Mockito.when(personService.findOneById(Mockito.anyString())).thenReturn(mockPersion);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getPersonById/711").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		//String expected = "{id:Course1,name:Spring,description:10 Steps}";
		String expected ="{\n" + 
				"	\"personId\" : \"711\",\n" + "	\"name\" : \"samas229\",\n" + "	\"age\" : 30,\n" + "	\"sex\" : \"male\",\n" + "	\"country\" : \"ind\",\n" + "	\"state\" : \"KA\",\n" + 
				"	\"city\" : \"btm\",\n" + "	\"favoriteBooks\" : [\n" + "		\"java\",\n" + "		\"spring\",\n" + "		\"hibernate\"\n" + "	],\n" + "	\"dateOfBirth\" : \"21-12-1999\"\n" + "	}";;
		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}
		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		 mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(jsonPath("$.personId", is(mockPersion.getPersonId())));
		 
		
	}
	
	@Test
   public void getPersonBYIDNotFound() throws Exception {
	  
		
		Mockito.when(personService.findOneById(Mockito.anyString())).thenThrow(new PersionNotFoundException());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getPersonById/101").accept(MediaType.APPLICATION_JSON);

		//MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 mockMvc.perform(requestBuilder).andExpect(status().isNotFound());

	//	System.out.println(result.getResponse());
		

		
	}
	
	
}
	
	

