package com.miu.edu.cs.mpp.assignment.Lab6Prob1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
           
        TextField nameField = new TextField();
        TextField streetField = new TextField();
        TextField cityField = new TextField();
        
        TextField stateField = new TextField();
        TextField zipField = new TextField();
        
        GridPane gridPane = new GridPane();    
        
        Label l1 = new Label("Name");
        Label l2 = new Label("Street");
        Label l3 = new Label("City");
        
        VBox vb3 = new VBox(10);
        VBox vb4 = new VBox(10);
        VBox vb5 = new VBox(10);
        
        // first row
        vb3.getChildren().add(l1); 
        vb3.getChildren().add(nameField); 
        
        vb4.getChildren().add(l2); 
        vb4.getChildren().add(streetField); 
        
        vb5.getChildren().add(l3); 
        vb5.getChildren().add(cityField); 
       
        
        // second row
        gridPane.add(vb3, 0, 0); 
        gridPane.add(vb4, 1, 0); 
        gridPane.add(vb5, 2, 0); 
        
        
        // 2nd row for two fields and labels
        VBox vb1 = new VBox(10);
        vb1.getChildren().add(new Label("State"));
        vb1.getChildren().add(stateField);
        
        VBox vb2 = new VBox(10);
        vb2.getChildren().add(new Label("Zip"));
        vb2.getChildren().add(zipField);
        
        HBox hb1 = new HBox(10);
        hb1.getChildren().add(vb1);
        hb1.getChildren().add(vb2);
        GridPane.setMargin(hb1, new Insets(0, 30, 0, 30));
        gridPane.add(hb1, 0, 2, 3, 1);
        
        // 3rd row for last button
        Button button = new Button("Submit");
        gridPane.add(button, 0, 4, 3, 1);// Node node,  int columnIndex, int rowIndex, int colspan, int rowspan

        // adding column alignment for 3 columns => center alignment
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.CENTER);
        gridPane.getColumnConstraints().addAll(column1, column1, column1); 
        
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        //Setting the padding  
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 

        var scene = new Scene(gridPane, 300, 300);
        stage.setScene(scene);
        stage.show();
        
        button.setOnAction(v-> {
        	String name = nameField.getText().toString().trim();
        	String street = streetField.getText().toString().trim();
        	String city = cityField.getText().toString().trim();
        	String state = stateField.getText().toString().trim();
        	String zip = zipField.getText().toString().trim();
        	System.out.println(String.format("%s\n%s\n%s, %s %s", name, street, city, state, zip));
        });
        
    }

    public static void main(String[] args) {
        launch();
    }

}