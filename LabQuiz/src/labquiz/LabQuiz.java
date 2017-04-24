/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labquiz;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author CCannon
 */
public class LabQuiz extends Application implements EventHandler{

    private TextField weightTextField;
    private TextField heightTextField;
    private Label bmiLabel;
    private Label bmiStatusLabel;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        
        pane.setTop(new Label("BMI Calculator"));
        
        GridPane dataPane = new GridPane();
        
        dataPane.add(new Label("Weight (lbs):"), 0, 0);
        dataPane.add(new Label("Height (in):"), 0, 1);
        dataPane.add(new Label("Body Mass Index:"), 0, 2);
        dataPane.add(new Label("BMI Status:"), 0, 3);
        
        weightTextField = new TextField();
        heightTextField = new TextField();
        bmiLabel = new Label("0.0");
        bmiStatusLabel = new Label("Under/Normal/Over/Obese");
        
        dataPane.add(weightTextField, 1, 0);
        dataPane.add(heightTextField, 1, 1);
        dataPane.add(bmiLabel, 1, 2);
        dataPane.add(bmiStatusLabel, 1, 3);
        
        pane.setCenter(dataPane);
        
        HBox commandPane = new HBox();
        
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(this);
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(this);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(this);
        
        commandPane.getChildren().addAll(calculateButton, resetButton, closeButton);
        
        pane.setBottom(commandPane);
        
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    @Override
    public void handle(Event event) {
        Button pressed = (Button) event.getSource();
        
        if(pressed.getText().equals("Calculate")){
            double height = 0.0;
            double weight = 0.0;
            try{
                height = Double.parseDouble(heightTextField.getText().trim());
                weight = Double.parseDouble(weightTextField.getText().trim());
                
                double bmi = (weight / (height*height)) * 730.0;
                
                bmiLabel.setText(bmi + "");
                
                if(bmi < 18.5){
                    bmiStatusLabel.setText("Under");
                }else if(bmi <= 24.9){
                    bmiStatusLabel.setText("Normal");
                }else if(bmi <= 29.9){
                    bmiStatusLabel.setText("Over");
                }else{
                    bmiStatusLabel.setText("Obese");
                }
            }catch(Exception e){
                Alert inputAlert = new Alert(Alert.AlertType.ERROR, "Please Enter A Positive Numerical Value for Height and Weight");
                inputAlert.showAndWait();
            }
        }else if(pressed.getText().equals("Reset")){
            heightTextField.clear();
            weightTextField.clear();
            bmiLabel.setText("0.0");
            bmiStatusLabel.setText("Under/Normal/Over/Obese");
        }else if(pressed.getText().equals("Close")){
            System.exit(0);
        }
    }
    
}
