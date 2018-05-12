/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysearchjavafx;

import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import model.Student;

/**
 *
 * @author vlad
 */
public class SearchingController {
    final private Button curentDialogOk;
    final private AnchorPane curentDialogAnchorPane;
    final private String searchArgType;
    final private List<Student> studentsList;
    
    public SearchingController(
            AnchorPane curentDialogAnchorPane,
            Button curentDialogOk,
            List<Student> studentsList,
            String searchArgType,
            
    ){
        this.curentDialogAnchorPane = curentDialogAnchorPane;
        this.curentDialogOk = curentDialogOk;        
        this.studentsList = studentsList;
        this.searchArgType = searchArgType;        
    }
    
    public final void controllFullNameButton(){
        curentDialogOk.setOnAction(findBySalaryAction -> { 
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

            AnchorPane dialogTable = newDialogTable(
                    listOfFidingStudents,
                    answer
            );
        });

        curentDialogAnchorPane.getChildren().add(dialogTable);
    }
    
    private AnchorPane newDialogTable(
            List<Student> listOfFidingStudents
    ){

        AnchorPane dialogTable = new PaginationTableBuilder()
                .createPaginationTable(listOfFidingStudents);
        
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
    
    private void bothLimitsCase(){
        
    }
    
    private void newDialogStage(){
        
    }
    
}
