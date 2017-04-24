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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author CCannon
 */
public class LabQuiz extends Application implements EventHandler{

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
        
        TextField weightTextField = new TextField();
        TextField heightTextField = new TextField();
        Label bmiLabel = new Label("0.0");
        Label bmiStatusLabel = new Label("Under/Normal/Over/Obese");
        
        dataPane.add(weightTextField, 1, 0);
        dataPane.add(heightTextField, 1, 1);
        dataPane.add(bmiLabel, 1, 2);
        dataPane.add(bmiStatusLabel, 1, 3);
        
        pane.setCenter(dataPane);
        
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(Event event) {

    }
    
}
