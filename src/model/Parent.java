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
public class Parent extends Person {
    final private MoneyBr earnMoney;
    public Parent(
        String firstName,
        String surName,
        String lastName,
        MoneyBr earnMoney
    ){
        super(firstName, surName, lastName);
        this.earnMoney = earnMoney;
    }
    
    public MoneyBr getEarnMoney(){
        return earnMoney;
    }
}
