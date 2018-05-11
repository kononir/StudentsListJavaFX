/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysearchjavafx;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Student;

/**
 *
 * @author vlad
 */
public class SearchingController {
    final private Optional<String> answerOptional;
    
    public SearchingController(Optional<String> answerOptional){
        this.answerOptional = answerOptional;
    }
    
    public final void controll(List<Student> studentsList){
               
        answerOptional.ifPresent(answer -> { 
            Stage curentDialogStage = new Stage();
            
            AnchorPane curentDialogAnchorPane = new AnchorPane();
            
            ScrollPane scroll = new ScrollPane();
            scroll.setFitToHeight(true);
            scroll.setFitToWidth(true);
            scroll.setContent(curentDialogAnchorPane);
            scroll.setPannable(true); 

            List<HBox> hBoxesOfCurrentDialog = new ArrayList();

            Button curentDialogOk = new Button("OK");

            Button curentDialogCancel = new Button("Cancel");
            curentDialogCancel.setOnAction(action2 -> {
                curentDialogStage.close();
            });

            switch(answer){
                case "Students FIO":                                                                                     
                case "Father FIO":
                case "Mother FIO":
                    Label firstNameLabel = new Label("First name");
                    TextField firstNameTextField = new TextField();        
                    hBoxesOfCurrentDialog.add(makeNewHBox(
                            firstNameLabel,
                            firstNameTextField,
                            63
                    ));

                    Label surNameLabel = new Label("Surname");
                    TextField surNameTextField = new TextField();        
                    hBoxesOfCurrentDialog.add(makeNewHBox(
                            surNameLabel,
                            surNameTextField,
                            70
                    ));

                    Label lastNameLabel = new Label("Last name");
                    TextField lastNameTextField = new TextField();        
                    hBoxesOfCurrentDialog.add(makeNewHBox(
                            lastNameLabel,
                            lastNameTextField,
                            63
                    ));

                    curentDialogOk.setOnAction(findByNameAction -> {
                        String firstName = firstNameTextField.getText();
                        String surName = surNameTextField.getText();
                        String lastName = lastNameTextField.getText();
                        
                        String fullName  = firstName + " " + surName 
                                         + " " + lastName;

                        String searchArg = fullName;

                        newDialogTable(
                                studentsList,
                                answer,
                                searchArg,
                                curentDialogAnchorPane
                        );
                    });

                    break;
                case "Number of brothers":
                case "Number of sisters":
                    Label numberLabel = new Label("Number");
                    TextField numberTextField = new TextField();
                    hBoxesOfCurrentDialog.add(makeNewHBox(
                            numberLabel,
                            numberTextField,
                            25
                    ));

                    curentDialogOk.setOnAction(findByRelativesNumberAction -> {
                        String relativesNumber = numberTextField.getText();
                        String searchArg = relativesNumber;

                        newDialogTable(
                                studentsList,
                                answer,
                                searchArg,                                
                                curentDialogAnchorPane
                        );
                    });

                    break;
                case "Father salary":
                case "Mother salary":
                    ChoiceDialog<String> searchLimitChoiceDialog = new ChoiceDialog(
                            "by lower limit",
                            "by lower limit",
                            "by upper limit",
                            "by both limits"
                    );
                    searchLimitChoiceDialog.setTitle("JavaFX");
                    searchLimitChoiceDialog.setHeaderText(null);
                    searchLimitChoiceDialog.setContentText("Please, choice searching argument:");
                    
                    Optional<String> answerLimitOptional = searchLimitChoiceDialog.showAndWait();
        
                    answerLimitOptional.ifPresent(answerLimit -> {
                        String searchArgType = answer + " " + answerLimit;
                        
                        switch(answerLimit){
                            case("by lower limit"):
                                Label lowerSalaryRublesLabel = new Label("Lower limit, rubles");
                                    TextField lowerSalaryRublesTextField = new TextField();
                                    hBoxesOfCurrentDialog.add(makeNewHBox(
                                            lowerSalaryRublesLabel,
                                            lowerSalaryRublesTextField,
                                            53
                                    ));

                                    Label lowerSalaryPennyLabel = new Label("Lower limit, penny");
                                    TextField lowerSalaryPennyTextField = new TextField();
                                    hBoxesOfCurrentDialog.add(makeNewHBox(
                                            lowerSalaryPennyLabel,
                                            lowerSalaryPennyTextField,
                                            51
                                    ));
                                    
                                curentDialogOk.setOnAction(findBySalaryAction -> {
                                    String salaryRubles = lowerSalaryRublesTextField.getText();
                                    String salaryPenny = lowerSalaryPennyTextField.getText();

                                    String salary = salaryRubles + "." + salaryPenny;

                                    String searchArg = salary;

                                    newDialogTable(
                                            studentsList,
                                            searchArgType,
                                            searchArg,                                
                                            curentDialogAnchorPane
                                    );

                                });
                            
                            case("by upper limit"):
                                Label upperSalaryRublesLabel = new Label("Upper limit, rubles");
                                TextField upperSalaryRublesTextField = new TextField();
                                hBoxesOfCurrentDialog.add(makeNewHBox(
                                        upperSalaryRublesLabel,
                                        upperSalaryRublesTextField,
                                        53
                                ));

                                Label upperSalaryPennyLabel = new Label("Upper limit, penny");
                                TextField upperSalaryPennyTextField = new TextField();
                                hBoxesOfCurrentDialog.add(makeNewHBox(
                                        upperSalaryPennyLabel,
                                        upperSalaryPennyTextField,
                                        51
                                ));
                                    
                                curentDialogOk.setOnAction(findBySalaryAction -> {                                    
                                    String salaryRubles = upperSalaryRublesTextField.getText();
                                    String salaryPenny = upperSalaryPennyTextField.getText();

                                    String salary = salaryRubles + "." + salaryPenny;

                                    String searchArg = salary;

                                    newDialogTable(
                                            studentsList,
                                            searchArgType,
                                            searchArg,                                
                                            curentDialogAnchorPane
                                    );

                                });
                            
                            case("by both limits"):
                                Label bothLowerSalaryRublesLabel
                                        = new Label("Lower limit, rubles");
                                TextField bothLowerSalaryRublesTextField
                                        = new TextField();
                                hBoxesOfCurrentDialog.add(makeNewHBox(
                                        bothLowerSalaryRublesLabel,
                                        bothLowerSalaryRublesTextField,
                                        53
                                ));

                                Label bothLowerSalaryPennyLabel
                                        = new Label("Lower limit, penny");
                                TextField bothLowerSalaryPennyTextField
                                        = new TextField();
                                hBoxesOfCurrentDialog.add(makeNewHBox(
                                        bothLowerSalaryPennyLabel,
                                        bothLowerSalaryPennyTextField,
                                        51
                                ));

                                Label bothUpperSalaryRublesLabel
                                        = new Label("Upper limit, rubles");
                                TextField bothUpperSalaryRublesTextField
                                        = new TextField();
                                hBoxesOfCurrentDialog.add(makeNewHBox(
                                        bothUpperSalaryRublesLabel,
                                        bothUpperSalaryRublesTextField,
                                        53
                                ));

                                Label bothUpperSalaryPennyLabel
                                        = new Label("Upper limit, penny");
                                TextField bothUpperSalaryPennyTextField
                                        = new TextField();
                                hBoxesOfCurrentDialog.add(makeNewHBox(
                                        bothUpperSalaryPennyLabel,
                                        bothUpperSalaryPennyTextField,
                                        51
                                ));

                                curentDialogOk.setOnAction(findBySalaryAction -> {

                                    String lowerSalaryRubles
                                            = bothLowerSalaryRublesTextField.getText();
                                    String lowerSalaryPenny
                                            = bothLowerSalaryPennyTextField.getText();
                                    String upperSalaryRubles
                                            = bothUpperSalaryRublesTextField.getText();
                                    String upperSalaryPenny
                                            = bothUpperSalaryPennyTextField.getText();

                                    String salary = lowerSalaryRubles + "."
                                                  + lowerSalaryPenny + ","
                                                  + upperSalaryRubles + "."
                                                  + upperSalaryPenny;

                                    String searchArg = salary;

                                    newDialogTable(
                                            studentsList,
                                            searchArgType,
                                            searchArg,                                
                                            curentDialogAnchorPane
                                    );

                                });
                        }
                        
                    });                    
                    
                    break;
            }

            VBox curentDialogVBox = new VBox();
            curentDialogVBox.setSpacing(10);
            curentDialogVBox.setPadding(new Insets(15,20,10,10));
            for(int iter = 0; iter < hBoxesOfCurrentDialog.size(); iter++){
                HBox iterHBox = hBoxesOfCurrentDialog.get(iter);                                  
                curentDialogVBox.getChildren().add(iterHBox);
            }

            HBox curentDialogHBoxWithButtons 
                    = makeNewHBox(curentDialogOk, curentDialogCancel, 1);

            AnchorPane.setTopAnchor(curentDialogVBox, 5.0);
            AnchorPane.setLeftAnchor(curentDialogVBox, 5.0);
            AnchorPane.setBottomAnchor(curentDialogHBoxWithButtons, 10.0);
            AnchorPane.setRightAnchor(curentDialogHBoxWithButtons, 10.0);
            curentDialogAnchorPane.getChildren().addAll(
                    curentDialogVBox, 
                    curentDialogHBoxWithButtons
            ); 

            Scene curentDialogScene = new Scene(scroll, 600, 500);
            curentDialogStage.setTitle(answer);
            curentDialogStage.setScene(curentDialogScene);
            curentDialogStage.show();
        });
    }
    
    private HBox makeNewHBox(javafx.scene.Node node1, javafx.scene.Node node2, int spacingNumber){
        HBox hBox = new HBox();
        hBox.setSpacing(spacingNumber);
        hBox.getChildren().addAll(node1, node2);
        return hBox;
    }
    
    private void newDialogTable(
            List<Student> studentsList,
            String searchArgType,
            String searchArg,
            AnchorPane curentDialogAnchorPane
    ){
        SearchingAlgorithms searching = new SearchingAlgorithms(
                studentsList,
                searchArgType
        );

        List<Student> listOfFidingStudents 
                = searching.findInformation(searchArg);
        PaginationTableBuilder paginationBuilder = new PaginationTableBuilder();

        AnchorPane dialogTable = paginationBuilder
                .createPaginationTable(listOfFidingStudents);

        curentDialogAnchorPane.getChildren().add(dialogTable);

        AnchorPane.setTopAnchor(dialogTable, 120.0);
        AnchorPane.setLeftAnchor(dialogTable, 0.0);
        AnchorPane.setBottomAnchor(dialogTable, 0.0);
    }
    
    private void bothLimitsCase(){
        
    }
    
    private void newDialogStage(){
        
    }
    
}
