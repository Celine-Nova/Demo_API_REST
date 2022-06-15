/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poe.demoapi.api;


import com.poe.demoapi.entity.Person;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//url
@Path("/persons")
public class PersonApi {
    //HTTP Verb
    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Person> getPersons(){
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Celine", "Dion"));
        persons.add(new Person("JC", "Dom"));
        return persons;
    }
}
