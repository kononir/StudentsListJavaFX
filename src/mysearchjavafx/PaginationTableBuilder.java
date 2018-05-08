/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysearchjavafx;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import model.MoneyBr;
import model.Student;

/**
 *
 * @author Vlad
 */
public class PaginationTableBuilder {
    private int rowsPerPage;
    private int numberOfPages;
    private int pageIndex;
    private int numberOfStudents;
    
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
        numberOfStudents = listOfStudents.size();
        if(numberOfStudents % rowsPerPage == 0){
            numberOfPages = (numberOfStudents / rowsPerPage);
        }
        else{
            numberOfPages = (numberOfStudents / rowsPerPage + 1);
        }
        
        pageIndex = 0;
        
        TableView tablePart = createTable();
        ObservableList<StudentTableClass> tableSubList
                = makeNewTableList(listOfStudents);   
        tablePart.setItems(tableSubList);

        int currentPageNumber = pageIndex + 1;
        Label pagesLabel = new Label("Page: " + currentPageNumber + "/" + numberOfPages);
        pagesLabel.setFont(new Font("Arial", 15));
        
        Button firstPageButton = new Button("First page");
        firstPageButton.setOnAction(firstPageAction -> {
            if(pageIndex == 0)
                return;
            
            pageIndex = 0;
            int currentPageNumberAction = pageIndex + 1;
            pagesLabel.setText("Page: " + currentPageNumberAction + "/" + numberOfPages);
            
            tableSubList.clear();           
            ObservableList<StudentTableClass> newTableSubList
                    = makeNewTableList(listOfStudents);
            newTableSubList.forEach((student) -> {
                tableSubList.add(student);
            });
        });
        
        Button lastPageButton = new Button("Last page");
        lastPageButton.setOnAction(lastPageAction -> {
            if(pageIndex == numberOfPages - 1)
                return;
            
            pageIndex = numberOfPages - 1;
            int currentPageNumberAction = pageIndex + 1;
            pagesLabel.setText("Page: " + currentPageNumberAction + "/" + numberOfPages);
            
            tableSubList.clear();           
            ObservableList<StudentTableClass> newTableSubList
                    = makeNewTableList(listOfStudents);
            newTableSubList.forEach((student) -> {
                tableSubList.add(student);
            });
        });
        
        Button nextPageButton = new Button("Next page");
        nextPageButton.setOnAction(nextPageAction -> {
            if(pageIndex == numberOfPages - 1)
                return;
            
            pageIndex++;
            int currentPageNumberAction = pageIndex + 1;
            pagesLabel.setText("Page: " + currentPageNumberAction + "/" + numberOfPages);
            
            tableSubList.clear();           
            ObservableList<StudentTableClass> newTableSubList
                    = makeNewTableList(listOfStudents);
            newTableSubList.forEach((student) -> {
                tableSubList.add(student);
            });
        }); 
        
        Button prevPageButton = new Button("Prev page");
        prevPageButton.setOnAction(prevPageAction -> {
            if(pageIndex == 0)
                return;
            
            pageIndex--;
            int currentPageNumberAction = pageIndex + 1;
            pagesLabel.setText("Page: " + currentPageNumberAction + "/" + numberOfPages);
            
            tableSubList.clear();           
            ObservableList<StudentTableClass> newTableSubList
                    = makeNewTableList(listOfStudents);
            newTableSubList.forEach((student) -> {
                tableSubList.add(student);
            });
        });
        
        Label recordsLabel = new Label();
        recordsLabel.setText("Number of records: " + rowsPerPage
                                + "/" + numberOfStudents);
        recordsLabel.setFont(new Font("Arial", 15));
        
        TextField rowsPerPageTextField = new TextField();
        
        Button rowsPerPageButton = new Button("Change");
        rowsPerPageButton.setOnAction(actionRowsPerPage -> {
            String rowsPerPageString = rowsPerPageTextField.getText();
            
            rowsPerPage = Integer.parseInt(rowsPerPageString);
            pageIndex = 0;
            
            if(numberOfStudents % rowsPerPage == 0){
                numberOfPages = (numberOfStudents / rowsPerPage);
            }
            else{
                numberOfPages = (numberOfStudents / rowsPerPage + 1);
            }
            
            int currentPageNumberAction = pageIndex + 1;
            
            pagesLabel.setText("Page: " + currentPageNumberAction + "/" + numberOfPages);
            
            recordsLabel.setText("Number of records: " + rowsPerPageString
                                    + "/" + numberOfStudents);
                    
            tableSubList.clear();           
            ObservableList<StudentTableClass> newTableSubList
                    = makeNewTableList(listOfStudents);
            newTableSubList.forEach((student) -> {
                tableSubList.add(student);
            });
        });    
        
        HBox pageHBox = new HBox
        (
                pagesLabel,
                firstPageButton,
                nextPageButton,                
                prevPageButton,
                lastPageButton
        );
        
        HBox recordsHBox = new HBox
        (
                recordsLabel,
                rowsPerPageTextField,
                rowsPerPageButton
        );
        
        pageHBox.setSpacing(5.0);  
        recordsHBox.setSpacing(5.0);       
                
        AnchorPane page = new AnchorPane(tablePart,recordsHBox, pageHBox);
        AnchorPane.setTopAnchor(tablePart, 0.0);
        AnchorPane.setBottomAnchor(tablePart, 70.0);
        AnchorPane.setBottomAnchor(recordsHBox, 35.0);
        AnchorPane.setBottomAnchor(pageHBox, 5.0);
              
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
        int fromIndex = pageIndex * rowsPerPage;
        int listSize = studentsList.size();
        int toIndex = Math.min(fromIndex + rowsPerPage, listSize);
        
        List<Student> subList = studentsList.subList(fromIndex, toIndex);       
        ObservableList<StudentTableClass> tableList = FXCollections.observableArrayList();
        
        subList.forEach ((student) -> {
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
