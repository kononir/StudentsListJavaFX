/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysearchjavafx;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.MoneyBr;
import model.Student;

/**
 *
 * @author Vlad
 */
public class PaginationTableBuilder {
    private int rowsPerPage;
    private int numberOfPages;
    
    public PaginationTableBuilder(int rowsPerPage){
        this.rowsPerPage = rowsPerPage;
    }
    
    public final void setRowsPerPage(int rowsPerPage){
        this.rowsPerPage = rowsPerPage;
    }
    
    public final void setNumberOfPages(int numberOfPages){
        this.numberOfPages = numberOfPages;
    }
    
    public final int getRowsPerPage(){
        return this.rowsPerPage;
    }
    
    public final int getNumberOfPages(){
        return this.numberOfPages;
    }
    
    public final AnchorPane createPaginationTable(List<Student> listOfStudents){
        int pageIndex = 0;
        int sizeOfList = listOfStudents.size();
        numberOfPages = (sizeOfList / rowsPerPage + 1);
        return createTablePage(pageIndex, listOfStudents);
    }
    
    public final AnchorPane createTablePage(
            int pageIndex,
            List<Student> listOfStudents
    ){
        
        TableView tablePart = createTable();
        
        int fromIndex = pageIndex * rowsPerPage;
        int listSize = listOfStudents.size();
        int toIndex = Math.min(fromIndex + rowsPerPage, listSize);
        
        List<Student> subList = listOfStudents
                .subList(fromIndex, toIndex);
        
        ObservableList<StudentTableClass> tableSubList 
                = makeNewTableList(subList);       
        tablePart.setItems(tableSubList);
                
        AnchorPane page = new AnchorPane(tablePart);
        AnchorPane.setBottomAnchor(tablePart, 10.0);
        
        return page;
    }
    
    private TableView createTable(){
        TableView<StudentTableClass> currentTable = new TableView();
        TableColumn<StudentTableClass, String> studentsName = new TableColumn("Students full name");
        TableColumn<StudentTableClass, String> fatherName = new TableColumn("Father full name");
        TableColumn<StudentTableClass, String> fatherSalary = new TableColumn("Father salary");
        TableColumn<StudentTableClass, String> motherName = new TableColumn("Mother full name");
        TableColumn<StudentTableClass, String> motherSalary = new TableColumn("Mother salary");
        TableColumn<StudentTableClass, String> numberOfBrothers = new TableColumn("Number of brothers");
        TableColumn<StudentTableClass, String> numberOfSisters = new TableColumn("Number of sisters");
        
        currentTable.getColumns().addAll(
                studentsName,
                fatherName,
                fatherSalary,
                motherName,
                motherSalary,
                numberOfBrothers,
                numberOfSisters
        );
        
        ObservableList<TableColumn<StudentTableClass,?>> tableColumns = currentTable.getColumns();
        for(int iter = 0; iter < tableColumns.size(); iter++)
            tableColumns.get(iter).setMinWidth(194.5);
        
        studentsName.setCellValueFactory(
                new PropertyValueFactory<>("studentsFIO")
        );
        fatherName.setCellValueFactory(
                new PropertyValueFactory<>("fatherFIO")
        );
        fatherSalary.setCellValueFactory(
                new PropertyValueFactory<>("fatherSalary")
        );
        motherName.setCellValueFactory(
                new PropertyValueFactory<>("motherFIO")
        );
        motherSalary.setCellValueFactory(
                new PropertyValueFactory<>("motherSalary")
        );
        numberOfBrothers.setCellValueFactory(
                new PropertyValueFactory<>("numberOfBrothers")
        );
        numberOfSisters.setCellValueFactory(
                new PropertyValueFactory<>("numberOfSisters")
        );
        return currentTable;
    }
    
    private ObservableList<StudentTableClass> makeNewTableList(List<Student> studentsList){
        ObservableList<StudentTableClass> tableList = FXCollections.observableArrayList();
        studentsList.forEach ((student) -> {
            StringBuilder studentFIO = new StringBuilder();
            studentFIO.append(student.getLastName()).append(" ")
                      .append(student.getFirstName()).append(" ")
                      .append(student.getSurName());        
            model.Parent father = student.getFather();
            StringBuilder fatherFIO = new StringBuilder();
            fatherFIO.append(father.getLastName()).append(" ")
                     .append(father.getFirstName()).append(" ")
                     .append(father.getSurName()); 
            MoneyBr fatherSalary = father.getEarnMoney();
            StringBuilder fatherMoney = new StringBuilder();
            fatherMoney.append(fatherSalary.getRubles()).append(".")
                       .append(fatherSalary.getPenny());
            model.Parent mother = student.getMother();
            StringBuilder motherFIO = new StringBuilder();
            motherFIO.append(mother.getLastName()).append(" ")
                     .append(mother.getFirstName()).append(" ")
                     .append(mother.getSurName()); 
            MoneyBr motherSalary = mother.getEarnMoney();
            StringBuilder motherMoney = new StringBuilder();
            motherMoney.append(motherSalary.getRubles()).append(".")
                       .append(motherSalary.getPenny());
            int numOfBrothers = student.getNumberOfBrothers();
            int numOfSisters = student.getNumberOfSisters();

            tableList.add(new StudentTableClass(
                    studentFIO.toString(),
                    fatherFIO.toString(),
                    fatherMoney.toString(),
                    motherFIO.toString(),
                    motherMoney.toString(),
                    String.valueOf(numOfBrothers),
                    String.valueOf(numOfSisters)
            ));
        });
        return tableList;
    }
}
