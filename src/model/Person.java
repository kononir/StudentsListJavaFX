/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Vlad
 */
public class Person {
    final private String firstName;
    final private String surName;
    final private String lastName;
    public Person(
            String firstName,
            String surName,
            String lastName
    ){    
        this.firstName = firstName;
        this.lastName = surName;
        this.surName = lastName;
    }
}
