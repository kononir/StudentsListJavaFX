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
public class Person {
    final private String firstName;
    final private String surname;
    final private String lastName;
    final private MoneyBr earnMoney;
    final private Person father;
    final private Person mother;
    final private Person[] Brothers;
    final private Person[] Sisters;
    public Person(
            String firstName,
            String surName,
            String lastName,
            MoneyBr earnMoney,
            Person father,
            Person mother,
            Person[] Brothers,
            Person[] Sisters
            ){
        this.firstName = firstName; //пересмотреть копирование
        this.surname = surName;
        this.lastName = lastName;
        this.earnMoney = earnMoney;
        this.Brothers = Brothers;
        this.Sisters = Sisters;
        this.father = father;
        this.mother = mother;
    }
}
