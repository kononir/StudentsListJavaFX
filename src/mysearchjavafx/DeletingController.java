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
public class DeletingController {
    final private Button curentDialogOk;
    
    public DeletingController(
            Button curentDialogOk    
    ){
        this.curentDialogOk = curentDialogOk;        
    }
    
    public final List<Student> controlFullNameDeleteButton(
            List<TextField> nameTextFields,
            List<Student> studentsList,
            String searchArgType
    ){
        SearchingController nameSearchingController
                = new SearchingController(curentDialogOk);
        
        List<Student> listOfFidingStudents
                = nameSearchingController.controlSearchFullNameButton(
                        nameTextFields,
                        studentsList,
                        searchArgType
                );
        
        List<Student> newStudentsList
                = deleteStudents(studentsList, listOfFidingStudents);
        
        return newStudentsList;
    }
    
    public final List<Student> controlSearchNumberOfRelativesButton(
            TextField nameTextField,
            List<Student> studentsList,
            String searchArgType
    ){
        SearchingController nameSearchingController
                = new SearchingController(curentDialogOk);
        
        List<Student> listOfFidingStudents
                = nameSearchingController.controlSearchNumberOfRelativesButton(
                        nameTextField,
                        studentsList,
                        searchArgType
                );
        
        List<Student> newStudentsList
                = deleteStudents(studentsList, listOfFidingStudents);
        
        return newStudentsList;
    }
    
    public final List<Student> controlSearchSalaryLowerLimitButton(
            List<TextField> nameTextFields,
            List<Student> studentsList,
            String searchArgType
    ){
        SearchingController nameSearchingController
                = new SearchingController(curentDialogOk);
        
        List<Student> listOfFidingStudents
                = nameSearchingController.controlSearchSalaryLowerLimitButton(
                        nameTextFields,
                        studentsList,
                        searchArgType
                );
        
        List<Student> newStudentsList
                = deleteStudents(studentsList, listOfFidingStudents);
        
        return newStudentsList;
    }
    
    public final List<Student> controlSearchSalaryUpperLimitButton(
            List<TextField> nameTextFields,
            List<Student> studentsList,
            String searchArgType
    ){
        SearchingController nameSearchingController
                = new SearchingController(curentDialogOk);
        
        List<Student> listOfFidingStudents
                = nameSearchingController.controlSearchSalaryUpperLimitButton(
                        nameTextFields,
                        studentsList,
                        searchArgType
                );
        
        List<Student> newStudentsList
                = deleteStudents(studentsList, listOfFidingStudents);
        
        return newStudentsList;
    }
    
    public final List<Student> controlSearchSalaryBothLimitsButton(
            List<TextField> nameTextFields,
            List<Student> studentsList,
            String searchArgType
    ){
        SearchingController nameSearchingController
                = new SearchingController(curentDialogOk);
        
        List<Student> listOfFidingStudents
                = nameSearchingController.controlSearchSalaryBothLimitsButton(
                        nameTextFields,
                        studentsList,
                        searchArgType
                );
        
        List<Student> newStudentsList
                = deleteStudents(studentsList, listOfFidingStudents);
        
        return newStudentsList;
    }
    
    private List<Student> deleteStudents(
            List<Student> studentsFullList,
            List<Student> listOfFidingStudents
    ){
        boolean checkDeleting = studentsFullList.removeAll(listOfFidingStudents);
        
        if(checkDeleting)
            System.out.println("Deleting sucess!");
        
        return studentsFullList;
    }
}
