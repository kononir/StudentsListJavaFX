/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysearchjavafx;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.Student;

/**
 * FXML Controller class
 *
 * @author vlad
 */
public class SearchDialogController {
    
    private List<Student> currentStudentsList;
    private String searchArg;
    private String classOfSearchArg;
    private TableView dialogTableView;
    
    public void SearchDialogController(){
    }

    public void initialize() {   
    }  
    
    @FXML
    private void findInformation(){
        List<Student> listOfFidingStudents = new ArrayList();
        for(int iter = 0; iter < currentStudentsList.size(); iter++){
            Student student = currentStudentsList.get(iter);
            String studentFirstName = student.getFirstName();
            String studentSurname = student.getSurName();
            String studentLastName = student.getLastName();
            String studentFullName = studentFirstName + "" + studentSurname
                                   + "" + studentLastName;
            if(studentFullName.equals(searchArg)){
                listOfFidingStudents.add(student);
            }
        }
        ObservableList<StudentTableClass> tableListOfFidingStudents = FXCollections.observableArrayList();
                tableListOfFidingStudents = new MySearchJavaFX()
                        .makeNewTableList(listOfFidingStudents);
        dialogTableView = new TableView(tableListOfFidingStudents);
    }
    
    public void setCurrentStudentsList(List<Student> currentStudentsList) {
        this.currentStudentsList = currentStudentsList;
    }  
    
    public void setClassOfSearchArg(String classOfSearchArg) {
        this.classOfSearchArg = classOfSearchArg;
    } 
    
    public void setSearchArg(String searchArg) {
        this.searchArg = searchArg;
    } 
 
}
