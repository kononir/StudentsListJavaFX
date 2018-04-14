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
public class Student extends Person {
    final private Parent father;
    final private Parent mother;
    final private int numberOfBrothers;
    final private int numberOfSisters;
    public Student(
            String firstName,
            String surName,
            String lastName,
            Parent father,
            Parent mother,
            int numberOfBrothers,
            int numberOfSisters
    ){
        super(firstName, surName, lastName);
        this.father = father;
        this.mother = mother;
        this.numberOfBrothers = numberOfBrothers;
        this.numberOfSisters = numberOfSisters;
    }
    
    public Parent getFather(){
        return father;
    }
    public Parent getMother(){
        return mother;
    }
    public int getNumberOfBrothers(){
        return numberOfBrothers;
    }
    public int getNumberOfSisters(){
        return numberOfSisters;
    }
}
