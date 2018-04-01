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
public class StudentTableClass {
    final private String studentsFIO;
    final private String fatherFIO;
    final private String fatherSalary;
    final private String motherFIO;
    final private String motherSalary;
    final private String numberOfBrothers;
    final private String numberOfSisters;
    public StudentTableClass(
            String studentsFIO, 
            String fatherFIO, 
            String fatherSalary, 
            String motherFIO, 
            String motherSalary, 
            String numberOfBrothers, 
            String numberOfSisters
    ){
        this.studentsFIO = studentsFIO;
        this.fatherFIO = fatherFIO;
        this.fatherSalary = fatherSalary;
        this.motherFIO = motherFIO;
        this.motherSalary = motherSalary;
        this.numberOfBrothers = numberOfBrothers;
        this.numberOfSisters = numberOfSisters;
    }
}
