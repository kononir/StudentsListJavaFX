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
public class PersonTableClass {
    final private String studentsFIO;
    final private String fatherFIO;
    final private double fatherSalary;
    final private String motherFIO;
    final private double motherSalary;
    final private int numberOfBrothers;
    final private int numberOfSisters;
    public PersonTableClass(
            String studentsFIO,
            String fatherFIO,
            double fatherSalary,
            String motherFIO,
            double motherSalary,
            int numberOfBrothers, 
            int numberOfSisters
            ){
        this.studentsFIO = studentsFIO; //пересмотреть копирование
        this.fatherFIO = fatherFIO;
        this.fatherSalary = fatherSalary;
        this.motherFIO = motherFIO;
        this.motherSalary = motherSalary;
        this.numberOfBrothers = numberOfBrothers;
        this.numberOfSisters = numberOfSisters;
    }
}
