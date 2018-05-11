/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysearchjavafx;

import java.util.ArrayList;
import java.util.List;
import model.MoneyBr;
import model.Parent;
import model.Person;
import model.Student;

/**
 *
 * @author vlad
 */
public class SearchingAlgorithms {
    
    private final List<Student> currentStudentsList;
    private final String searchArgType;
    
    public SearchingAlgorithms(List<Student> currentStudentsList, String searchArgType){
        this.currentStudentsList = currentStudentsList;
        this.searchArgType = searchArgType;
    }
    
    public List<Student> findInformation(String searchArg){                     
        List<Student> listOfFidingStudents = new ArrayList();

        if(currentStudentsList.isEmpty()){
            System.out.println("NoElements");            
            return listOfFidingStudents;
        }
        
        switch(searchArgType){
            case "Students FIO":
                currentStudentsList.forEach(student -> {                   
                    String studentFullName = getFullName(student);
                    
                    if(studentFullName.equals(searchArg)){
                        listOfFidingStudents.add(student);
                    }
                });                    
                
                break;
                
            case "Father FIO":
                currentStudentsList.forEach(student -> {
                    Parent father = student.getFather();
                    String fatherFullName = getFullName(father);
                    
                    if(fatherFullName.equals(searchArg)){
                        listOfFidingStudents.add(student);
                    }                   
                });                    
                
                break;
                
            case "Mother FIO":
                currentStudentsList.forEach(student -> {
                    Parent mother = student.getMother();
                    String motherFullName = getFullName(mother);
                    
                    if(motherFullName.equals(searchArg)){
                        listOfFidingStudents.add(student);
                    }                   
                });                    
                
                break;
                
            case "Number of brothers":
                currentStudentsList.forEach(student -> {                   
                    int numberOfBrothers = student.getNumberOfBrothers();
                    int searchArgInteger = Integer.parseInt(searchArg);
                    
                    if(numberOfBrothers == searchArgInteger){
                        listOfFidingStudents.add(student);
                    }
                });                    
                
                break;
                
            case "Number of sisters":
                currentStudentsList.forEach(student -> {
                    int numberOfSisters = student.getNumberOfSisters();
                    int searchArgInteger = Integer.parseInt(searchArg);
                    
                    if(numberOfSisters == searchArgInteger){
                        listOfFidingStudents.add(student);
                    }                 
                });                    
                
                break;
                
            case "Father salary by lower limit":
                currentStudentsList.forEach(student -> {
                    Parent father = student.getFather();
                    MoneyBr salary = father.getEarnMoney();
                    int salaryRubles = salary.getRubles();
                    int salaryPenny = salary.getPenny();
                    double salaryDouble = (double)salaryRubles + (double)salaryPenny;
                    
                    double searchArgDouble = Double.parseDouble(searchArg);
                    
                    if(salaryDouble > searchArgDouble){
                        listOfFidingStudents.add(student);
                    }                 
                });                    
                
                break;
                
            case "Father salary by upper limit":
                currentStudentsList.forEach(student -> {
                    Parent father = student.getFather();
                    MoneyBr salary = father.getEarnMoney();
                    int salaryRubles = salary.getRubles();
                    int salaryPenny = salary.getPenny();
                    double salaryDouble = (double)salaryRubles + (double)salaryPenny;
                    
                    double searchArgDouble = Double.parseDouble(searchArg);

                    if(salaryDouble < searchArgDouble){
                        listOfFidingStudents.add(student);
                    }                 
                });                    

                break; 
                
            case "Father salary by both limits":
                currentStudentsList.forEach(student -> {
                    Parent father = student.getFather();
                    MoneyBr salary = father.getEarnMoney();
                    int salaryRubles = salary.getRubles();
                    int salaryPenny = salary.getPenny();
                    double salaryDouble = (double)salaryRubles + (double)salaryPenny;
                    
                    String[] searchArgMas = searchArg.split(",");
                    String lowerSalaryString = searchArgMas[0];
                    String upperSalaryString = searchArgMas[1];
                    double lowerSalaryDouble = Double.parseDouble(lowerSalaryString);
                    double upperSalaryDouble = Double.parseDouble(upperSalaryString);

                    if(lowerSalaryDouble < salaryDouble 
                            && salaryDouble < upperSalaryDouble){
                        listOfFidingStudents.add(student);
                    }                 
                });                    
                
            case "Mother salary by lower limit":
                currentStudentsList.forEach(student -> {
                    Parent mother = student.getMother();
                    MoneyBr salary = mother.getEarnMoney();
                    int salaryRubles = salary.getRubles();
                    int salaryPenny = salary.getPenny();
                    double salaryDouble = (double)salaryRubles + (double)salaryPenny;

                    double searchArgDouble = Double.parseDouble(searchArg);

                    if(salaryDouble > searchArgDouble){
                        listOfFidingStudents.add(student);
                    }                 
                });                    

                break;

            case "Mother salary by upper limit":
                currentStudentsList.forEach(student -> {
                    Parent mother = student.getMother();
                    MoneyBr salary = mother.getEarnMoney();
                    int salaryRubles = salary.getRubles();
                    int salaryPenny = salary.getPenny();
                    double salaryDouble = (double)salaryRubles + (double)salaryPenny;

                    double searchArgDouble = Double.parseDouble(searchArg);

                    if(salaryDouble < searchArgDouble){
                        listOfFidingStudents.add(student);
                    }                 
                });                    

                break; 

            case "Mother salary by both limits":
                currentStudentsList.forEach(student -> {
                    Parent mother = student.getFather();
                    MoneyBr salary = mother.getEarnMoney();
                    int salaryRubles = salary.getRubles();
                    int salaryPenny = salary.getPenny();
                    double salaryDouble = (double)salaryRubles + (double)salaryPenny;

                    String[] searchArgMas = searchArg.split(",");
                    String lowerSalaryString = searchArgMas[0];
                    String upperSalaryString = searchArgMas[1];
                    double lowerSalaryDouble = Double.parseDouble(lowerSalaryString);
                    double upperSalaryDouble = Double.parseDouble(upperSalaryString);

                    if(lowerSalaryDouble < salaryDouble 
                            && salaryDouble < upperSalaryDouble){
                        listOfFidingStudents.add(student);
                    }                 
                });   

                break; 
        }
        
        return listOfFidingStudents;
    }
    
    private String getFullName(Person person){
        String studentFirstName = person.getFirstName();
        String studentSurname = person.getSurName();
        String studentLastName = person.getLastName();
        String studentFullName = studentFirstName + " " + studentSurname
                               + " " + studentLastName;
        return studentFullName;
    }
 
}
