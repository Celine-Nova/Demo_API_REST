/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poe.demoapi.api;

import com.poe.demoapi.entity.Person;
import com.poe.demoapi.entity.PersonDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

//url
@Path("/persons")
public class PersonApi {

    //HTTP Verb
    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Person> getPersons(@Context HttpServletRequest request) {
        PersonDAO personList = (PersonDAO) request.getSession().getAttribute("personList");
        if (personList == null) {
            personList = new PersonDAO();
        }
        /*ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Celine", "Dion"));
        persons.add(new Person("JC", "Dom"));*/
        return personList.getPersons();
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person postPerson(Person newPerson, @Context HttpServletRequest request) {
        PersonDAO personList = (PersonDAO) request.getSession().getAttribute("personList");
        if (personList == null) {
            personList = new PersonDAO();
        }
        Person person = personList.addPerson(newPerson);
        request.getSession().setAttribute("personList", personList);
        return person;
    }
}
