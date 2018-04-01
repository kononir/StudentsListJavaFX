/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysearchjavafx;

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
        this.father = father; //пересмотреть копирование
        this.mother = mother;
        this.numberOfBrothers = numberOfBrothers;
        this.numberOfSisters = numberOfSisters;
    }
}
