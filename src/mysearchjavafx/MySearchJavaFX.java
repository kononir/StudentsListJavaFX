/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysearchjavafx;

//import java.util.Optional;
import java.util.ArrayList;

import javafx.application.*;
//import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
//import javafx.stage.StageStyle.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.collections.*;
import javafx.scene.control.cell.*;
import javafx.geometry.*;

/**
 *
 * @author Vlad
 */
public class MySearchJavaFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ArrayList<Student> studentsArray = new ArrayList();
        
        TableView<StudentTableClass> curentTable = new TableView();     
        TableColumn<StudentTableClass, String> studentsName = new TableColumn("Students full name");
        TableColumn<StudentTableClass, String> fatherName = new TableColumn("Father full name");
        TableColumn<StudentTableClass, String> fatherSalary = new TableColumn("Father salary");
        TableColumn<StudentTableClass, String> motherName = new TableColumn("Mother full name");
        TableColumn<StudentTableClass, String> motherSalary = new TableColumn("Mother salary");
        TableColumn<StudentTableClass, String> numberOfBrothers = new TableColumn("Number of brothers");
        TableColumn<StudentTableClass, String> numberOfSisters = new TableColumn("Number of sisters");
        
        curentTable.getColumns().addAll(
                studentsName,
                fatherName,
                fatherSalary,
                motherName,
                motherSalary,
                numberOfBrothers,
                numberOfSisters
        );
        
        ObservableList<TableColumn<StudentTableClass,?>> tableColumns = curentTable.getColumns();
        for(int iter = 0; iter < tableColumns.size(); iter++)
            tableColumns.get(iter).setMinWidth(195);
        
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
        
        StudentTableClass std = new StudentTableClass("1","1","1","1","1","1","1");
        ObservableList<StudentTableClass> tableList = FXCollections.observableArrayList(std);
        curentTable.setItems(tableList);
        
        Button toolAddButton = new Button();
        Image imagePlus = new Image(getClass().getResourceAsStream("plus.png"));
        toolAddButton.setGraphic(new ImageView(imagePlus));
        toolAddButton.setOnAction(event -> {         
            /*String studentFirstName = newAddingDialog(
                    "Please write students first name",
                    "First name:"
            );
            if(studentFirstName == null)
                return;
            System.out.println(studentFirstName);
            
            String studentSurName = newAddingDialog(
                    "Please write students surname",
                    "Surname:"
            );
            if(studentSurName == null)
                return;
            System.out.println(studentSurName);
            
            String studentLastName = newAddingDialog(
                    "Please write students last name",
                    "Last name:"
            );
            if(studentLastName == null)
                return;
            System.out.println(studentLastName);
            
            String fatherFirstName = newAddingDialog(
                    "Please write fathers first name",
                    "First name:"
            );
            if(fatherFirstName == null)
                return;
            System.out.println(fatherFirstName);
            
            String fatherSurname = newAddingDialog(
                    "Please write fathers surname",
                    "Surname:"
            );
            if(fatherSurname == null)
                return;
            System.out.println(fatherSurname);
            
            String fatherLastName = newAddingDialog(
                    "Please write fathers last name",
                    "Last name:"
            );
            if(fatherLastName == null)
                return;
            System.out.println(fatherLastName);*/
            
            Stage curentDialogStage = new Stage();
            
            ArrayList<HBox> HBoxesOfCurrentDialog = new ArrayList();
            
            Label studentFirstNameLabel = new Label("Student first name");
            TextField studentFirstNameTextField = new TextField();        
            HBoxesOfCurrentDialog.add(makeNewHBox(studentFirstNameLabel, studentFirstNameTextField, 63));
            
            Label studentSurNameLabel = new Label("Student sur name");
            TextField studentSurNameTextField = new TextField();
            HBoxesOfCurrentDialog.add(makeNewHBox(studentSurNameLabel, studentSurNameTextField, 67));
            
            Label studentLastNameLabel = new Label("Student last name");
            TextField studentLastNameTextField = new TextField();
            HBoxesOfCurrentDialog.add(makeNewHBox(studentLastNameLabel, studentLastNameTextField, 65));
            
            Label fatherFirstNameLabel = new Label("Father first name");
            TextField fatherFirstNameTextField = new TextField();        
            HBoxesOfCurrentDialog.add(makeNewHBox(fatherFirstNameLabel, fatherFirstNameTextField, 71));
            
            Label fatherSurNameLabel = new Label("Father sur name");
            TextField fatherSurNameTextField = new TextField();
            HBoxesOfCurrentDialog.add(makeNewHBox(fatherSurNameLabel, fatherSurNameTextField, 75));
            
            Label fatherLastNameLabel = new Label("Father last Name");
            TextField fatherLastNameTextField = new TextField();
            HBoxesOfCurrentDialog.add(makeNewHBox(fatherLastNameLabel, fatherLastNameTextField, 71));
            
            Label fatherSalaryRublesLabel = new Label("Father salary, rubles");
            TextField fatherSalaryRublesTextField = new TextField();
            HBoxesOfCurrentDialog.add(makeNewHBox(fatherSalaryRublesLabel, fatherSalaryRublesTextField, 57));
            
            Label fatherSalaryPennyLabel = new Label("Father salary, penny");
            TextField fatherSalaryPennyTextField = new TextField();
            HBoxesOfCurrentDialog.add(makeNewHBox(fatherSalaryPennyLabel, fatherSalaryPennyTextField, 57));
            
            Label motherFirstNameLabel = new Label("Mother first name");
            TextField motherFirstNameTextField = new TextField();        
            HBoxesOfCurrentDialog.add(makeNewHBox(motherFirstNameLabel, motherFirstNameTextField, 67));
            
            Label motherSurNameLabel = new Label("Mother sur name");
            TextField motherSurNameTextField = new TextField();
            HBoxesOfCurrentDialog.add(makeNewHBox(motherSurNameLabel, motherSurNameTextField, 71));
            
            Label motherLastNameLabel = new Label("Mother last Name");
            TextField motherLastNameTextField = new TextField();
            HBoxesOfCurrentDialog.add(makeNewHBox(motherLastNameLabel, motherLastNameTextField, 67));
            
            Label motherSalaryRublesLabel = new Label("Mother salary, rubles");
            TextField motherSalaryRublesTextField = new TextField();
            HBoxesOfCurrentDialog.add(makeNewHBox(motherSalaryRublesLabel, motherSalaryRublesTextField, 53));
            
            Label motherSalaryPennyLabel = new Label("Mother salary, penny");
            TextField motherSalaryPennyTextField = new TextField();
            HBoxesOfCurrentDialog.add(makeNewHBox(motherSalaryPennyLabel, motherSalaryPennyTextField, 51));
            
            Label numberOfBrothersLabel = new Label("Number of student brothers");
            TextField numberOfBrothersTextField = new TextField();
            HBoxesOfCurrentDialog.add(makeNewHBox(numberOfBrothersLabel, numberOfBrothersTextField, 13));
            
            Label numberOfSistersLabel = new Label("Number of student sisters");
            TextField numberOfSistersTextField = new TextField();
            HBoxesOfCurrentDialog.add(makeNewHBox(numberOfSistersLabel, numberOfSistersTextField, 25));
            
            VBox curentDialogVBox = new VBox();
            curentDialogVBox.setSpacing(10);
            curentDialogVBox.setPadding(new Insets(15,20,10,10));
            for(int iter = 0; iter < HBoxesOfCurrentDialog.size(); iter++)
                curentDialogVBox.getChildren().add(HBoxesOfCurrentDialog.get(iter));
            
            Button curentDialogOk = new Button("OK");
            curentDialogOk.setOnAction(action ->{
                String studentFirstName = studentFirstNameTextField.getText();
                String studentSurName = studentSurNameTextField.getText();
                String studentLastName = studentLastNameTextField.getText();
                String fatherFirstName = fatherFirstNameTextField.getText();
                String fatherSurName = fatherSurNameTextField.getText();
                String fatherLastName = fatherLastNameTextField.getText();
                int fatherSalaryRubles = Integer.parseInt(fatherSalaryRublesTextField.getText());
                int fatherSalaryPenny = Integer.parseInt(fatherSalaryPennyTextField.getText());
                MoneyBr fSalary = new MoneyBr(fatherSalaryRubles,fatherSalaryPenny);
                String motherFirstName = motherFirstNameTextField.getText();
                String motherSurName = motherSurNameTextField.getText();
                String motherLastName = motherLastNameTextField.getText();
                int motherSalaryRubles = Integer.parseInt(motherSalaryRublesTextField.getText());
                int motherSalaryPenny = Integer.parseInt(motherSalaryPennyTextField.getText());  
                MoneyBr mSalary = new MoneyBr(motherSalaryRubles,motherSalaryPenny);
                Parent father = new Parent(studentFirstName, studentSurName, studentLastName, fSalary);
                Parent mother = new Parent(studentFirstName, studentSurName, studentLastName, mSalary);
                int numOfBrothers = Integer.parseInt(numberOfBrothersTextField.getText());
                int numOfSisters = Integer.parseInt(numberOfSistersTextField.getText());       
                Student informationAboutNewStudent = new Student(
                        studentFirstName,
                        studentSurName,
                        studentLastName,
                        father,
                        mother,
                        numOfBrothers,
                        numOfSisters
                );
                studentsArray.add(informationAboutNewStudent);
                
                System.out.println("All right");
                curentDialogStage.close();
            });
            
            Button curentDialogCancel = new Button("Cancel");
            curentDialogCancel.setOnAction(action ->{
                curentDialogStage.close();
            });
            
            HBox curentDialogHBoxWithButtons = makeNewHBox(curentDialogOk, curentDialogCancel, 1);
            
            AnchorPane curentDialogAnchorPane = new AnchorPane();
            AnchorPane.setTopAnchor(curentDialogVBox, 5.0);
            AnchorPane.setLeftAnchor(curentDialogVBox, 5.0);
            AnchorPane.setBottomAnchor(curentDialogHBoxWithButtons, 10.0);
            AnchorPane.setRightAnchor(curentDialogHBoxWithButtons, 10.0);
            curentDialogAnchorPane.getChildren().addAll(curentDialogVBox, curentDialogHBoxWithButtons);
            
            Scene curentDialogScene = new Scene(curentDialogAnchorPane, 355, 600);
            
            curentDialogStage.initStyle(StageStyle.UTILITY);
            curentDialogStage.setTitle("Information about new student");
            curentDialogStage.setScene(curentDialogScene);
            curentDialogStage.show();  
        });
        
        Button toolDeleteButton = new Button();
        /*Image imageDelete = new Image(getClass().getResourceAsStream("delete.png"));
        toolDeleteButton.setGraphic(new ImageView(imageDelete));*/
        
        ToolBar toolBar = new ToolBar();
        toolBar.getItems().addAll(new Separator(),
                toolAddButton,
                toolDeleteButton,
                new Separator()
        );
        
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        
        MenuItem menuAddButton = new MenuItem("Add");
        MenuItem menuRemoveButton = new MenuItem("Remove");
        MenuItem menuSaveButton = new MenuItem("Save");
        MenuItem menuLoadButton = new MenuItem("Load");
        
        menuAddButton.setOnAction(toolAddButton.getOnAction());
        
        menuAddButton.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        menuRemoveButton.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
        menuSaveButton.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        menuLoadButton.setAccelerator(KeyCombination.keyCombination("Ctrl+L"));
        
        fileMenu.getItems().addAll(menuSaveButton, menuLoadButton);
        editMenu.getItems().addAll(menuAddButton, menuRemoveButton);
        menuBar.getMenus().addAll(editMenu, fileMenu);
        
        AnchorPane root = new AnchorPane();
        AnchorPane.setTopAnchor(menuBar, 0.0);
        AnchorPane.setLeftAnchor(menuBar, 0.0);
        AnchorPane.setRightAnchor(menuBar, 0.0);
        AnchorPane.setTopAnchor(toolBar, 25.0);
        AnchorPane.setLeftAnchor(toolBar, 0.0);
        AnchorPane.setRightAnchor(toolBar, 0.0);
        AnchorPane.setTopAnchor(curentTable, 64.0);
        AnchorPane.setLeftAnchor(curentTable, 0.0);
        AnchorPane.setRightAnchor(curentTable, 0.0);
        AnchorPane.setBottomAnchor(curentTable, 25.0);
        root.getChildren().addAll(menuBar, toolBar, curentTable);
        
        Scene scene = new Scene(root, 600, 500);
        
        primaryStage.setTitle("My student list");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private HBox makeNewHBox(Node node1, Node node2, int spacingNumber){
        HBox hBox = new HBox();
        hBox.setSpacing(spacingNumber);
        hBox.getChildren().addAll(node1, node2);
        return hBox;
    }
    
    /*private String newAddingDialog(String headerText, String contentText){
        Optional<String> resultOfCurrentDialog;
        TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("JavaFX");
            dialog.setHeaderText(headerText);
            dialog.setContentText(contentText);
            String inputInformation;
            resultOfCurrentDialog = dialog.showAndWait();
            if(resultOfCurrentDialog.isPresent()){
                inputInformation = resultOfCurrentDialog.get();
                return inputInformation;
            }
            else
                return null;
    }*/
    
}
