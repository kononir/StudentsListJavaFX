/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysearchjavafx;

import java.util.ArrayList;
import java.util.List;
//import javafx.scene.layout.AnchorPane;
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
    //private AnchorPane dialogAnchorPane;
    
    public void SearchDialogController(){
    }

    public void initialize() {   
    }  
    
    public List<Student> findInformation(){       
        if(currentStudentsList.isEmpty()){
            System.out.println("NoElements");
            return null;
        }
            
        List<Student> listOfFidingStudents = new ArrayList();
        for(int iter = 0; iter < currentStudentsList.size(); iter++){
            Student student = currentStudentsList.get(iter);
            String studentFirstName = student.getFirstName();
            String studentSurname = student.getSurName();
            String studentLastName = student.getLastName();
            String studentFullName = studentFirstName + " " + studentSurname
                                   + " " + studentLastName;
            if(studentFullName.equals(searchArg)){
                listOfFidingStudents.add(student);
            }
        }
        return listOfFidingStudents;
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
    
    /*public void setDialogAnchorPane(AnchorPane dialogAnchorPane) {
        this.dialogAnchorPane = dialogAnchorPane;
    } */
 
}
