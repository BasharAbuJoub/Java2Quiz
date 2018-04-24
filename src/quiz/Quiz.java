package quiz;

/********************************************************
 *  Made with love by Bashar Abu Joub.
 *  Feel free to ask me about any part in this code !
 *  Have fun reading the code ;D
 ********************************************************/

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Quiz extends Application{
    
    // Primary stage reference inorder to access it easly in the application !
    Stage primary;

    // The result scene.
    Scene result;
    Button back;
    Label txtResult;
    StackPane resultRoot;
    
    // The main scene.
    Scene main;
    GridPane rootGrid;
    TextField width;
    TextField height;
    Button calcArea;
    Button calcPerimeter;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void initResultScene(String resultValue){
        //Label to show the result which sent as parameter.
        txtResult = new Label(resultValue);
        
        //Back Button.
        back = new Button("_Back");
        back.setOnAction(e-> getBack());
        back.setMinWidth(200);
        
        //VBox.
        VBox box = new VBox(txtResult, back);
        box.setSpacing(15);
        box.setAlignment(Pos.CENTER);
        
        //Result root.
        resultRoot = new StackPane(box);
        resultRoot.setAlignment(Pos.CENTER);
        result = new Scene(resultRoot, 400, 300);
        
        //Setting the primary stage scene to result scene.
        primary.setScene(result);
    }
    
    public void initMainScene(){
        
        //Main scene root.
        rootGrid = new GridPane();
        rootGrid.setHgap(15);
        rootGrid.setVgap(15);
        rootGrid.setAlignment(Pos.CENTER);
        rootGrid.setPadding(new Insets(50));
        main = new Scene(rootGrid, 600, 300);
        
        //The input fields.
        width = new TextField();
        height = new TextField();
 
        //Width label.
        Label lblWidth = new Label("Enter _Width");
        lblWidth.setMnemonicParsing(true);
        lblWidth.setLabelFor(width);
        
        //Height label.
        Label lblHeight = new Label("Enter _Height");
        lblHeight.setMnemonicParsing(true);
        lblHeight.setLabelFor(height);

        //Calculate area button.
        calcArea = new Button("_Area");
        calcArea.setOnAction(e->calcArea(e));
        
        //Calculate perimeter button.
        calcPerimeter = new Button("_Perimeter");
        calcPerimeter.setOnAction(e->calcPerimeter(e));
        
        //Adding the nodes to the grid.
        rootGrid.add(lblWidth, 1, 1);
        rootGrid.add(width, 2, 1);
        rootGrid.add(lblHeight, 1, 2);
        rootGrid.add(height, 2, 2);
        rootGrid.add(calcArea, 1, 3);
        rootGrid.add(calcPerimeter, 2, 3);
       
        //Setting the width and height for each control in the grid.
        for(Node n : rootGrid.getChildren()){
            if(n instanceof Control){
                ((Control) n).setMinWidth(200);
                ((Control) n).setMinHeight(30);
            }
        }
    }
    
    @Override
    public void init(){
        initMainScene();//Initializing the main scene.
    }
    
    @Override
    public void start(Stage primaryStage){
        //Setting the primary stage reference to access it anywhere.
        primary = primaryStage;
        
        //Setting the initial scene to main.
        primaryStage.setScene(main);
        
        //Setting the title of the application.
        primaryStage.setTitle("Calculator");
        
        //Disable window resizing
        primaryStage.setResizable(false);
        
        //And finally showing the application window !
        primaryStage.show();
    }

    public void calcArea(ActionEvent e){
        //Making sure the input fields are not empty.
        if(!width.getText().equals("") && !height.getText().equals(""))
            //Calculating the "Area" result and send it as string to the result scene initializer.
            initResultScene("Area = " + (Double.parseDouble(width.getText()) * Double.parseDouble(height.getText())));
    }
    
    public void calcPerimeter(ActionEvent e){
        //Making sure the input fields are not empty.
        if(!width.getText().equals("") && !height.getText().equals(""))
            //Calculating the "Perimeter" result and send it as string to the result scene initializer.
            initResultScene("Perimeter = " + (2*(Double.parseDouble(width.getText()) + Double.parseDouble(height.getText()))));
    }
    
    public void getBack(){
        // Resetting the input fields values to empty string.
        width.setText("");
        height.setText("");
        
        // Setting the primary stage scene to the main scene.
        primary.setScene(main);
    }
}
