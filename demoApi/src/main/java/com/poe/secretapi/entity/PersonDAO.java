/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poe.secretapi.entity;

import java.util.ArrayList;
import java.util.Optional;

public class PersonDAO {
    private ArrayList<Person> persons = new ArrayList<>();
    private long nextId = 1;
    

    public void addPerson(Person newPerson){
        newPerson.setId(nextId);
        nextId++;
        persons.add(newPerson);
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public Optional<Person> getPerson(long id){
        for(Person p : persons){
            if(p.getId().equals(id))
                return Optional.of(p);
        }
        return Optional.empty();
    }
    
    public void updatePerson(Person person){
        for(Person p : persons){
            if(p.getId().equals(person.getId())){
                persons.remove(p);
                persons.add(person);
                // autre solution
                //int index = personnes.indexOf(personne)
                //personnes.set(index, personne);
            }
        }
    }
    
    public void deletePerson(long id){
        for(Person p : persons){
            if(p.getId().equals(id)){
                persons.remove(p);
            }
        }
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public long getxtId() {
        return nextId;
    }

    public void setxtId(long nextId) {
        this.nextId = nextId;
    } 
}
