package com.example.nutritioncalculator3;
import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ConnectException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primary) throws IOException, SQLException {
        Connection connection=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Connor\\Desktop\\SecureSoftwareDevelp\\nutrition-calculator-3\\LoginandPatientDatabase.db");
        if(connection!=null) {
            System.out.println("Connection was made");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        primary.setTitle("Login Page");
        Label userIDLable= new Label ("User ID:");
        userIDLable.setTextFill(Color.rgb(255,255,255));
        TextField userIDText=new TextField();
        HBox hb1=new HBox();
        hb1.getChildren().addAll(userIDLable,userIDText);
        hb1.setSpacing(15);
        hb1.setLayoutX(108);
        hb1.setLayoutY(325);


        Label passwordLabel=new Label ("Password");
        passwordLabel.setTextFill(Color.rgb(255,255,255));
        TextField userPassText=new TextField();
        HBox hb2=new HBox();
        hb2.getChildren().addAll(passwordLabel,userPassText);
        hb2.setSpacing(15);
        hb2.setLayoutX(100);
        hb2.setLayoutY(360);

        Button loginButton=new Button("Login");
        loginButton.setTextFill(Color.rgb(0,0,0));
        loginButton.setLayoutX(330);
        loginButton.setLayoutY(345);
        Group login=new Group(hb1,hb2,loginButton);
        Scene loginScene=new Scene(login, 500,750, Color.rgb(56,29,82));
        primary.setScene(loginScene);
        primary.show();

        loginButton.setOnAction(event -> {
        String userID=userIDText.getText();
        String password=userPassText.getText();
        String query="Select * from Users where userID=? and password=?";
            PreparedStatement pt= null;


            try {
                pt = connection.prepareStatement(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            try {
                pt.setString(1,userID);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            try {
                pt.setString(2,password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            ResultSet rs= null;
            try {
                rs = pt.executeQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if(rs.next())
                    {
                        primary.setScene(PatientPage.patientPage);
                    }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        });
    }

    public static void main(String[] args) {
        launch();
    }
}