/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysearchjavafx;

import java.util.Optional;
import java.util.ArrayList;

import javafx.application.*;
//import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
//import javafx.stage.StageStyle.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyCombination;
//import javafx.geometry.*;

/**
 *
 * @author Vlad
 */
public class MySearchJavaFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ArrayList<Person> arrayAboutStudent = new ArrayList();
        
        TableView<Person> curentTable = new TableView();
        TableColumn[] tableColumns = new TableColumn[7];
        /*for(int iter = 0; iter <=){
            
        }*/
        
        Button toolAddButton = new Button();
        Image imagePlus = new Image(getClass().getResourceAsStream("plus.png"));
        toolAddButton.setGraphic(new ImageView(imagePlus));
        toolAddButton.setOnAction(event -> {         
            String studentFirstName = newAddingDialog(
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
            System.out.println(fatherLastName);
            
            /*Stage curentDialogStage = new Stage();
            
            Label studentFirstNameLabel = new Label("Student first name");
            TextField studentFirstNameTextField = new TextField();        
            HBox curentDialogHBox1 = makeNewHBox(studentFirstNameLabel, studentFirstNameTextField, 63);
            
            Label studentSurNameLabel = new Label("Student sur name");
            TextField studentSurNameTextField = new TextField();
            HBox curentDialogHBox2 = makeNewHBox(studentSurNameLabel, studentSurNameTextField, 67);
            
            Label studentLastNameLabel = new Label("Student last name");
            TextField studentLastNameTextField = new TextField();
            HBox curentDialogHBox3 = makeNewHBox(studentLastNameLabel, studentLastNameTextField, 65);
            
            Label fatherFirstNameLabel = new Label("Father last Name");
            TextField fatherFirstNameTtextField = new TextField();
            HBox curentDialogHBox4 = makeNewHBox(fatherFirstNameLabel, fatherFirstNameTtextField, 71);
            
            VBox curentDialogVBox = new VBox();
            curentDialogVBox.setSpacing(10);
            curentDialogVBox.setPadding(new Insets(15,20,10,10));
            curentDialogVBox.getChildren().addAll(
                    curentDialogHBox1, 
                    curentDialogHBox2, 
                    curentDialogHBox3, 
                    curentDialogHBox4
            );
            
            Button curentDialogOk = new Button("OK");
            curentDialogOk.setOnAction(action ->{
                String studentFirstName = studentFirstNameTextField.getText();
                String studentSurName = studentSurNameTextField.getText();
                String studentLastName = studentLastNameTextField.getText();
                PeopleFio studentFio = new PeopleFio(studentFirstName, studentSurName, studentLastName);
                PeopleFio fatherFio = new PeopleFio(studentFirstName, studentSurName, studentLastName);
                PeopleFio motherFio = new PeopleFio(studentFirstName, studentSurName, studentLastName);
                MoneyBr fatherSalary = new MoneyBr(12,12);
                MoneyBr motherSalary = new MoneyBr(12,12);
                int numberOfBrothers = 2;
                int numberOfSisters = 2;
                AboutStudent informationAboutNewStudent = new AboutStudent(
                        studentFio,
                        fatherFio,
                        fatherSalary,
                        motherFio,
                        motherSalary,
                        numberOfBrothers,
                        numberOfSisters
                );
                arrayAboutStudent.add(informationAboutNewStudent);
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
            
            Scene curentDialogScene = new Scene(curentDialogAnchorPane, 355, 250);
            
            curentDialogStage.initStyle(StageStyle.UTILITY);
            curentDialogStage.setTitle("Information about new student");
            curentDialogStage.setScene(curentDialogScene);
            curentDialogStage.show();*/

            
        });
        
        ToolBar toolBar = new ToolBar();
        toolBar.getItems().addAll(new Separator(),
                toolAddButton,
                new Separator()
        );
        //toolBar.orientationProperty(); //развернуть по вертикали
        //посмотреть, что можно добавлять в меню
        //привязать событие кнопки addButton к "кнопке" меню
        
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
        root.getChildren().addAll(menuBar, toolBar);
        
        Scene scene = new Scene(root, 600, 500);
        
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
    
    private HBox makeNewHBox(Node node1, Node node2, int spacingNumber){
        HBox hBox = new HBox();
        hBox.setSpacing(spacingNumber);
        hBox.getChildren().addAll(node1, node2);
        return hBox;
    }
    
    private String newAddingDialog(String headerText, String contentText){
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
    }
    
}
