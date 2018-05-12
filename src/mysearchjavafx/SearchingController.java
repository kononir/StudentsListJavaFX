/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysearchjavafx;

import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Student;

/**
 *
 * @author vlad
 */
public class SearchingController {   
    final private AnchorPane curentDialogAnchorPane;
    final private Button curentDialogOk;
    final private String searchArgType;
    final private List<Student> studentsList;
    
    public SearchingController(
            AnchorPane curentDialogAnchorPane,
            Button curentDialogOk,
            List<Student> studentsList,
            String searchArgType           
    ){
        this.curentDialogAnchorPane = curentDialogAnchorPane;
        this.curentDialogOk = curentDialogOk;        
        this.studentsList = studentsList;
        this.searchArgType = searchArgType;        
    }
    
    public final void controlFullNameButton(List<TextField> nameTextFields){
        curentDialogOk.setOnAction(findByNameAction -> { 
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

            AnchorPane dialogTable = newDialogTable(listOfFidingStudents);
            
            curentDialogAnchorPane.getChildren().add(dialogTable);
        });
        
    }

    public final void controlNumberOfRelativesButton(TextField numberTextField){
        curentDialogOk.setOnAction(findByNumberOfRelativesAction -> {

            String relativesNumber = numberTextField.getText();
            String searchArg = relativesNumber;

            SearchingAlgorithms searching = new SearchingAlgorithms(
                    studentsList,
                    searchArgType
            );

            List<Student> listOfFidingStudents 
                    = searching.findInformation(searchArg);

            AnchorPane dialogTable = newDialogTable(listOfFidingStudents);
        });
        
    }
    
    public final void controlSalaryLowerLimitButton(List<TextField> salaryTextFields){
        curentDialogOk.setOnAction(findByLowerLimitOfSalaryAction -> {

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

            AnchorPane dialogTable = newDialogTable(listOfFidingStudents);
        });
        
    }
    
    public final void controlSalaryUpperLimitButton(List<TextField> salaryTextFields){
        curentDialogOk.setOnAction(findByLowerLimitOfSalaryAction -> {

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

            AnchorPane dialogTable = newDialogTable(listOfFidingStudents);
        });
    }
    
    private AnchorPane newDialogTable(List<Student> listOfFidingStudents){

        AnchorPane dialogTable = new PaginationTableBuilder()
                .createPaginationTable(listOfFidingStudents);
        
        curentDialogAnchorPane.getChildren().add(dialogTable);
        
        AnchorPane.setLeftAnchor(dialogTable, 0.0);
        AnchorPane.setBottomAnchor(dialogTable, 0.0);
        
        switch(searchArgType){
            case "Students FIO": 
            case "Father FIO":
            case "Mother FIO":
            case "Father salary by lower limit":
            case "Father salary by upper limit":
            case "Mother salary by lower limit":
            case "Mother salary by upper limit":
                AnchorPane.setTopAnchor(dialogTable, 120.0);
            case "Number of brothers":
            case "Number of sisters":
                AnchorPane.setTopAnchor(dialogTable, 40.0);           
            case "Father salary by both limits":
            case "Mother salary by both limits":
                AnchorPane.setTopAnchor(dialogTable, 160.0);
        }
        
        return dialogTable;
    }
    
}
