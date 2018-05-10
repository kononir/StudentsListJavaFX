/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysearchjavafx;

import java.util.Optional;
import java.util.ArrayList;
import java.io.*;
import java.util.List;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import model.*;

/**
 *
 * @author Vlad
 */
public class MySearchJavaFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        List<Student> studentsList = new ArrayList();
        
        AnchorPane mainPane = new AnchorPane();
                            
        PaginationTableBuilder paginationTableBuilder
                = new PaginationTableBuilder();

        AnchorPane mainTable = paginationTableBuilder.createPaginationTable(studentsList);
        
        Button toolAddButton = new Button();
        Image imagePlus = new Image(getClass().getResourceAsStream("add.png"));
        toolAddButton.setGraphic(new ImageView(imagePlus));
        toolAddButton.setOnAction(event -> {         
            
            Stage curentDialogStage = new Stage();
            
            List<HBox> hBoxesOfCurrentDialog = new ArrayList();
            
            Label studentFirstNameLabel = new Label("Student first name");
            TextField studentFirstNameTextField = new TextField();        
            hBoxesOfCurrentDialog.add(makeNewHBox(studentFirstNameLabel, studentFirstNameTextField, 63));
            
            Label studentSurNameLabel = new Label("Student sur name");
            TextField studentSurNameTextField = new TextField();
            hBoxesOfCurrentDialog.add(makeNewHBox(studentSurNameLabel, studentSurNameTextField, 67));
            
            Label studentLastNameLabel = new Label("Student last name");
            TextField studentLastNameTextField = new TextField();
            hBoxesOfCurrentDialog.add(makeNewHBox(studentLastNameLabel, studentLastNameTextField, 65));
            
            Label fatherFirstNameLabel = new Label("Father first name");
            TextField fatherFirstNameTextField = new TextField();        
            hBoxesOfCurrentDialog.add(makeNewHBox(fatherFirstNameLabel, fatherFirstNameTextField, 71));
            
            Label fatherSurNameLabel = new Label("Father sur name");
            TextField fatherSurNameTextField = new TextField();
            hBoxesOfCurrentDialog.add(makeNewHBox(fatherSurNameLabel, fatherSurNameTextField, 75));
            
            Label fatherLastNameLabel = new Label("Father last Name");
            TextField fatherLastNameTextField = new TextField();
            hBoxesOfCurrentDialog.add(makeNewHBox(fatherLastNameLabel, fatherLastNameTextField, 71));
            
            Label fatherSalaryRublesLabel = new Label("Father salary, rubles");
            TextField fatherSalaryRublesTextField = new TextField();
            hBoxesOfCurrentDialog.add(makeNewHBox(fatherSalaryRublesLabel, fatherSalaryRublesTextField, 57));
            
            Label fatherSalaryPennyLabel = new Label("Father salary, penny");
            TextField fatherSalaryPennyTextField = new TextField();
            hBoxesOfCurrentDialog.add(makeNewHBox(fatherSalaryPennyLabel, fatherSalaryPennyTextField, 57));
            
            Label motherFirstNameLabel = new Label("Mother first name");
            TextField motherFirstNameTextField = new TextField();        
            hBoxesOfCurrentDialog.add(makeNewHBox(motherFirstNameLabel, motherFirstNameTextField, 67));
            
            Label motherSurNameLabel = new Label("Mother sur name");
            TextField motherSurNameTextField = new TextField();
            hBoxesOfCurrentDialog.add(makeNewHBox(motherSurNameLabel, motherSurNameTextField, 71));
            
            Label motherLastNameLabel = new Label("Mother last Name");
            TextField motherLastNameTextField = new TextField();
            hBoxesOfCurrentDialog.add(makeNewHBox(motherLastNameLabel, motherLastNameTextField, 67));
            
            Label motherSalaryRublesLabel = new Label("Mother salary, rubles");
            TextField motherSalaryRublesTextField = new TextField();
            hBoxesOfCurrentDialog.add(makeNewHBox(motherSalaryRublesLabel, motherSalaryRublesTextField, 53));
            
            Label motherSalaryPennyLabel = new Label("Mother salary, penny");
            TextField motherSalaryPennyTextField = new TextField();
            hBoxesOfCurrentDialog.add(makeNewHBox(motherSalaryPennyLabel, motherSalaryPennyTextField, 51));
            
            Label numberOfBrothersLabel = new Label("Number of student brothers");
            TextField numberOfBrothersTextField = new TextField();
            hBoxesOfCurrentDialog.add(makeNewHBox(numberOfBrothersLabel, numberOfBrothersTextField, 13));
            
            Label numberOfSistersLabel = new Label("Number of student sisters");
            TextField numberOfSistersTextField = new TextField();
            hBoxesOfCurrentDialog.add(makeNewHBox(numberOfSistersLabel, numberOfSistersTextField, 25));
            
            VBox curentDialogVBox = new VBox();
            curentDialogVBox.setSpacing(10);
            curentDialogVBox.setPadding(new Insets(15,20,10,10));
            for(int iter = 0; iter < hBoxesOfCurrentDialog.size(); iter++)
                curentDialogVBox.getChildren().add(hBoxesOfCurrentDialog.get(iter));
            
            Button curentDialogOk = new Button("OK");
            curentDialogOk.setOnAction(action -> {
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
                model.Parent father = new model.Parent(fatherFirstName, fatherSurName, fatherLastName, fSalary);
                model.Parent mother = new model.Parent(motherFirstName, motherSurName, motherLastName, mSalary);
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
                studentsList.add(informationAboutNewStudent);
                AnchorPane addTable = paginationTableBuilder.createPaginationTable(studentsList);
                AnchorPane.setTopAnchor(addTable, 67.0);
                AnchorPane.setLeftAnchor(addTable, 0.0);
                AnchorPane.setRightAnchor(addTable, 0.0);
                AnchorPane.setBottomAnchor(addTable, 0.0);
                
                int tableIndex = 2;
                mainPane.getChildren().remove(tableIndex);
                mainPane.getChildren().add(addTable);
                
                System.out.println("All right");
                curentDialogStage.close();
            });
            
            Button curentDialogCancel = new Button("Cancel");
            curentDialogCancel.setOnAction(action -> {
                curentDialogStage.close();
            });
            
            HBox curentDialogHBoxWithButtons = makeNewHBox(curentDialogOk, curentDialogCancel, 1);
            
            AnchorPane curentDialogAnchorPane = new AnchorPane();
            AnchorPane.setTopAnchor(curentDialogVBox, 5.0);
            AnchorPane.setLeftAnchor(curentDialogVBox, 5.0);
            AnchorPane.setBottomAnchor(curentDialogHBoxWithButtons, 10.0);
            AnchorPane.setRightAnchor(curentDialogHBoxWithButtons, 10.0);
            curentDialogAnchorPane.getChildren().addAll(curentDialogVBox, curentDialogHBoxWithButtons);
            
            Scene curentDialogScene = new Scene(curentDialogAnchorPane, 390, 600);
            
            curentDialogStage.initStyle(StageStyle.UTILITY);
            curentDialogStage.setTitle("Information about new student");
            curentDialogStage.setScene(curentDialogScene);
            curentDialogStage.show();  
        });
        
        Button toolDeleteButton = new Button();
        Image imageDelete = new Image(getClass().getResourceAsStream("delete.png"));
        toolDeleteButton.setGraphic(new ImageView(imageDelete));
        
        Button toolSearchButton = new Button();
        Image imageSearch = new Image(getClass().getResourceAsStream("search.png"));
        toolSearchButton.setGraphic(new ImageView(imageSearch));
        toolSearchButton.setOnAction(action -> {
            ChoiceDialog<String> searchChoiceDialog = new ChoiceDialog(
                    "Students FIO",
                    "Students FIO",
                    "Father FIO",
                    "Mother FIO",
                    "Number of brothers",
                    "Number of sisters",
                    "Father salary",
                    "Mother salary"
            );
            searchChoiceDialog.setTitle("JavaFX");
            searchChoiceDialog.setHeaderText(null);
            searchChoiceDialog.setContentText("Please, choice searching argument:");
            
            SearchingController searchingController
                    = new SearchingController(searchChoiceDialog);
            
            searchingController.controll(studentsList);
            
            
        });
        
        Button toolSaveButton = new Button();
        Image imageSave = new Image(getClass().getResourceAsStream("save.png"));
        toolSaveButton.setGraphic(new ImageView(imageSave));
        toolSaveButton.setOnAction(action -> {
            FileChooser fileChoose = configureFileChooser();          
            File saveFile = fileChoose.showSaveDialog(primaryStage);
            if(saveFile != null){
                String path = saveFile.getAbsolutePath();
                StudentsFile parserDOM = new StudentsFile(path);
                
                parserDOM.saveDocument(studentsList, path);
            }
        });
        
        Button toolLoadButton = new Button();
        Image imageLoad = new Image(getClass().getResourceAsStream("load.png"));
        toolLoadButton.setGraphic(new ImageView(imageLoad));
        toolLoadButton.setOnAction((ActionEvent action) -> {
            FileChooser fileChoose = configureFileChooser();
            File loadFile = fileChoose.showOpenDialog(primaryStage);         
            if(loadFile != null){
                String path = loadFile.getAbsolutePath();
                StudentsFile parserSAX = new StudentsFile(path);
                List<Student> newStudents = parserSAX.loadDocument(path);
                
                studentsList.clear();
                for(int iter = 0; iter < newStudents.size(); iter++){  
                    studentsList.add(newStudents.get(iter));
                }
                AnchorPane loadTable = paginationTableBuilder.createPaginationTable(studentsList);
                
                int tableIndex = 2;
                mainPane.getChildren().remove(tableIndex);
                mainPane.getChildren().add(loadTable);
                
                AnchorPane.setTopAnchor(loadTable, 67.0);
                AnchorPane.setLeftAnchor(loadTable, 0.0);
                AnchorPane.setRightAnchor(loadTable, 0.0);
                AnchorPane.setBottomAnchor(loadTable, 0.0);
            }
        });
        
        ToolBar toolBar = new ToolBar();
        toolBar.getItems().addAll(new Separator(),
                toolAddButton,
                toolDeleteButton,
                toolSearchButton,
                new Separator(),
                toolSaveButton,
                toolLoadButton
        );
        
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        
        MenuItem menuAddButton = new MenuItem("Add");       
        MenuItem menuSaveButton = new MenuItem("Save");
        MenuItem menuLoadButton = new MenuItem("Load");
        MenuItem menuDeleteButton = new MenuItem("Remove");
        MenuItem menuSearchButton = new MenuItem("Search");
        
        menuAddButton.setOnAction(toolAddButton.getOnAction());
        menuSaveButton.setOnAction(toolSaveButton.getOnAction());
        menuLoadButton.setOnAction(toolLoadButton.getOnAction());
        menuSearchButton.setOnAction(toolSearchButton.getOnAction());
        menuDeleteButton.setOnAction(toolDeleteButton.getOnAction());
        
        menuAddButton.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        menuSaveButton.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        menuLoadButton.setAccelerator(KeyCombination.keyCombination("Ctrl+L"));
        menuDeleteButton.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));
        menuSearchButton.setAccelerator(KeyCombination.keyCombination("Ctrl+F"));
        
        fileMenu.getItems().addAll(menuSaveButton, menuLoadButton);
        editMenu.getItems().addAll(menuAddButton, menuDeleteButton, menuSearchButton);
        menuBar.getMenus().addAll(editMenu, fileMenu);
              
        AnchorPane.setTopAnchor(menuBar, 0.0);
        AnchorPane.setLeftAnchor(menuBar, 0.0);
        AnchorPane.setRightAnchor(menuBar, 0.0);
        AnchorPane.setTopAnchor(toolBar, 25.0);
        AnchorPane.setLeftAnchor(toolBar, 0.0);
        AnchorPane.setRightAnchor(toolBar, 0.0);
        AnchorPane.setTopAnchor(mainTable, 67.0);
        AnchorPane.setLeftAnchor(mainTable, 0.0);
        AnchorPane.setRightAnchor(mainTable, 0.0);
        AnchorPane.setBottomAnchor(mainTable, 0.0);
        mainPane.getChildren().addAll(menuBar, toolBar, mainTable);
        
        ScrollPane scroll = new ScrollPane();
        scroll.setFitToHeight(true);
        scroll.setContent(mainPane);
        scroll.setPannable(true);
        
        Scene scene = new Scene(scroll, 600, 500);
        
        primaryStage.setTitle("My student list");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private HBox makeNewHBox(javafx.scene.Node node1, javafx.scene.Node node2, int spacingNumber){
        HBox hBox = new HBox();
        hBox.setSpacing(spacingNumber);
        hBox.getChildren().addAll(node1, node2);
        return hBox;
    }
    
    private FileChooser configureFileChooser(){
        FileChooser fileChoose = new FileChooser();
        fileChoose.setTitle("Choose path");
        fileChoose.setInitialDirectory(new File(System.getProperty("user.home")));

        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChoose.getExtensionFilters().add(extensionFilter);
        return fileChoose;
    }
    
}
