package com.miu.edu.cs.mpp.assignment.Lab6Prob2;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    /**
     *
     */
    @Override
    public void start(Stage stage) {
      
    	GridPane gridPane = new GridPane();
    	
    	// 1st column
    	VBox vb1 = new VBox(10);// vertical gap => 10
    	Button countBtn = new Button("Count Letters");
    	countBtn.setMaxWidth(Double.MAX_VALUE);
    	Button reverseBtn = new Button("Reverse Letter");
    	reverseBtn.setMaxWidth(Double.MAX_VALUE);
    	Button duplicateBtn = new Button("Remove Duplicate");
    	duplicateBtn.setMaxWidth(Double.MAX_VALUE);
    	vb1.getChildren().addAll(countBtn, reverseBtn, duplicateBtn);
    	
    	// 2nd column
    	VBox vb2 = new VBox();
    	Label inputLabel = new Label("Input");
    	TextField inputField = new TextField();
    	Label outputLabel = new Label("Output");
    	TextField outField = new TextField();
    	vb2.getChildren().addAll(inputLabel, inputField, outputLabel, outField);
    	
    	gridPane.add(vb1, 0, 0);
    	gridPane.add(vb2, 1, 0);
    	
    	gridPane.setPadding(new Insets(20, 10, 10, 20)); //double top, double right, double bottom, double left
    	
    	gridPane.setHgap(10); //horizontal gap in pixels => that's what you are asking for
//    	gridPane.setVgap(10); //vertical gap in pixels
    	
    	ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.CENTER);
        column1.setPercentWidth(50);
        gridPane.getColumnConstraints().addAll(column1, column1); 
        
        RowConstraints row1 = new RowConstraints();
    	row1.setValignment(VPos.CENTER);
    	gridPane.getRowConstraints().add(row1);
        
        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
        
        // count the words
        countBtn.setOnAction(v->{
        	Integer counts = null;
        	String input = inputField.getText().trim().replace(" " , "");//space character is removed since its not a letter
        	boolean isNumber = true;
        	try {// if input is not String then display InvalidInput
        		Double.parseDouble(input);
        	}catch(NumberFormatException e) {
        		isNumber = false;
        	}
        	if(!isNumber) {
        		counts = 0;
        		for(int i=0; i< input.toCharArray().length; i++) {
            		counts ++;
            	}
        	}        	
        	outField.setText(Optional.ofNullable(counts).map(count-> String.valueOf(count)).orElse("Invalid Input"));
        });
        
        // reverse the words
        reverseBtn.setOnAction(v->{
        	String input = inputField.getText().trim().replace(" " , "");//space character is removed since its not a letter
        	String reverse = "";
        	for(char c: input.toCharArray()) {
        		reverse=c+reverse;
        	}
        	outField.setText(reverse);
        });
        
        // remove duplicate
        duplicateBtn.setOnAction(v->{
        	String input = inputField.getText().trim().replace(" " , "");//space character is removed since its not a letter
//        	String duplicateRemoved = "";
//        	char[] arr = new char[input.toCharArray().length];

//        	for(int i =0; i<input.toCharArray().length; i++) {
//        		int count = 0;
//        		boolean isDuplicate = false;
//        		for(int j=0; j<duplicateRemoved.toCharArray().length; j++) {
//        			isDuplicate = false;
//        			if(input.toCharArray()[i]!=duplicateRemoved.toCharArray()[j]) {
//        				isDuplicate = true;
//        				break;
//        			}
//        		} 
//        		if(!isDuplicate)
//        		duplicateRemoved+=input.toCharArray()[i];
//        	}
        	StringBuilder sb = new StringBuilder();
        	input.chars().distinct().forEach(c -> sb.append((char) c));
        	outField.setText(sb.toString());
        });
    }

    public static void main(String[] args) {
        launch();
    }

}