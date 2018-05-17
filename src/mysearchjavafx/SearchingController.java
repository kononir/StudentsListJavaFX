/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysearchjavafx;

import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Student;

/**
 *
 * @author vlad
 */
public class SearchingController {
    final private Button curentDialogOk;
    
    public SearchingController(
            Button curentDialogOk    
    ){
        this.curentDialogOk = curentDialogOk;        
    }
    
    public final List<Student> controlSearchFullNameButton(
            List<TextField> nameTextFields,
            List<Student> studentsList,
            String searchArgType
    ){
        
            TextField firstNameTextField = nameTextFields.get(0);
            TextField surNameTextField = nameTextFields.get(1);
            TextField lastNameTextField = nameTextFields.get(2);
            
            String firstName = firstNameTextField.getText();
            String surName = surNameTextField.getText();
            String lastName = lastNameTextField.getText();

            String fullName  = firstName + " " + surName 
                             + " " + lastName;

            String searchArg = fullName;

            SearchingAlgorithms searching = new SearchingAlgorithms(
                    studentsList,
                    searchArgType
            );

            List<Student> listOfFidingStudents 
                    = searching.findInformation(searchArg);

            return listOfFidingStudents;
    }

    public final List<Student> controlSearchNumberOfRelativesButton(
            TextField numberTextField,
            List<Student> studentsList,
            String searchArgType
    ){      
        String relativesNumber = numberTextField.getText();
        String searchArg = relativesNumber;

        SearchingAlgorithms searching = new SearchingAlgorithms(
                studentsList,
                searchArgType
        );

        List<Student> listOfFidingStudents 
                = searching.findInformation(searchArg);

        return listOfFidingStudents;       
    }
    
    public final List<Student> controlSearchSalaryLowerLimitButton(
            List<TextField> salaryTextFields,
            List<Student> studentsList,
            String searchArgType
    ){
            TextField lowerSalaryRublesTextField = salaryTextFields.get(0);
            TextField lowerSalaryPennyTextField = salaryTextFields.get(1);
            
            String salaryRubles = lowerSalaryRublesTextField.getText();
            String salaryPenny = lowerSalaryPennyTextField.getText();

            String salary = salaryRubles + "." + salaryPenny;

            String searchArg = salary;

            SearchingAlgorithms searching = new SearchingAlgorithms(
                    studentsList,
                    searchArgType
            );

            List<Student> listOfFidingStudents 
                    = searching.findInformation(searchArg);

            return listOfFidingStudents;
    }
    
    public final List<Student> controlSearchSalaryUpperLimitButton(
            List<TextField> salaryTextFields,
            List<Student> studentsList,
            String searchArgType
    ){
        TextField upperSalaryRublesTextField = salaryTextFields.get(0);
        TextField upperSalaryPennyTextField = salaryTextFields.get(1);

        String salaryRubles = upperSalaryRublesTextField.getText();
        String salaryPenny = upperSalaryPennyTextField.getText();

        String salary = salaryRubles + "." + salaryPenny;

        String searchArg = salary;

        SearchingAlgorithms searching = new SearchingAlgorithms(
                studentsList,
                searchArgType
        );

        List<Student> listOfFidingStudents 
                = searching.findInformation(searchArg);

        return listOfFidingStudents;
    }
    
    public final List<Student> controlSearchSalaryBothLimitsButton(
            List<TextField> salaryTextFields,
            List<Student> studentsList,
            String searchArgType){
                  
            TextField bothLowerSalaryRublesTextField = salaryTextFields.get(0);
            TextField bothLowerSalaryPennyTextField = salaryTextFields.get(1);
            TextField bothUpperSalaryRublesTextField = salaryTextFields.get(2);
            TextField bothUpperSalaryPennyTextField = salaryTextFields.get(3);
            
            String lowerSalaryRubles = bothLowerSalaryRublesTextField.getText();
            String lowerSalaryPenny = bothLowerSalaryPennyTextField.getText();
            String upperSalaryRubles = bothUpperSalaryRublesTextField.getText();
            String upperSalaryPenny = bothUpperSalaryPennyTextField.getText();

            String salary = lowerSalaryRubles + "." + lowerSalaryPenny + ","
                          + upperSalaryRubles + "." + upperSalaryPenny;

            String searchArg = salary;
            
            SearchingAlgorithms searching = new SearchingAlgorithms(
                    studentsList,
                    searchArgType
            );

            List<Student> listOfFidingStudents 
                    = searching.findInformation(searchArg);

            return listOfFidingStudents;
    }
    

    
}
