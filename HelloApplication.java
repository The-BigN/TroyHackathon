package com.example.nutritioncalculator3;
import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ConnectException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primary) throws IOException, SQLException {
        Connection connection=DriverManager.getConnection("jdbc:sqlite:/Users/issacbarkley/IdeaProjects/TroyHackathon/LoginandPatientDatabase.db");
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
        Button createAccountButton=new Button("Create Account");
        createAccountButton.setTextFill(Color.rgb(0,0,0));
        createAccountButton.setLayoutX(200);
        createAccountButton.setLayoutY(650);
        Group login=new Group(hb1,hb2,loginButton,createAccountButton);
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
                        primary.setTitle("Patient Page");
                        primary.setScene(PatientPage.patientPage);
                    }
            } catch (SQLException e) {
                throw new RuntimeException(e);
                //skrrrt
            }
            try {
                if(!rs.next())
                {
                    primary.setTitle("Create Account");
                    primary.setScene(CreateAccount.account);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });
        createAccountButton.setOnAction(actionEvent -> {
            primary.setScene(CreateAccount.account);
            primary.setTitle("Create Account");
            Label userIDLable2= new Label ("User ID:");
            userIDLable.setTextFill(Color.rgb(255,255,255));
            TextField userIDText2=new TextField();
            HBox hb3=new HBox();
            hb3.getChildren().addAll(userIDLable2,userIDText2);
            hb3.setSpacing(15);
            hb3.setLayoutX(108);
            hb3.setLayoutY(325);


            Label passwordLabel2=new Label ("Password");
            passwordLabel.setTextFill(Color.rgb(255,255,255));
            TextField userPassText2=new TextField();
            HBox hb4=new HBox();
            hb4.getChildren().addAll(passwordLabel2,userPassText2);
            hb4.setSpacing(15);
            hb4.setLayoutX(100);
            hb4.setLayoutY(360);

            Button createAccountButton2=new Button("Create Account");
            createAccountButton2.setTextFill(Color.rgb(0,0,0));
            createAccountButton2.setLayoutX(200);
            createAccountButton2.setLayoutY(400);
            Group createAccount=new Group(hb1,hb2,createAccountButton2);
            Scene createAccountScene=new Scene(createAccount, 500,750, Color.rgb(56,29,82));
            primary.setScene(createAccountScene);
            primary.show();

            createAccountButton2.setOnAction(event -> {
                String userID=userIDText.getText();
                String password=userPassText.getText();
                String query="INSERT into Users values(?,?)";
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

                try {
                     pt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                primary.setTitle("Login");
                primary.setScene(LoginScene.LogIn);
                Label userIDLable3= new Label ("User ID:");
                userIDLable3.setTextFill(Color.rgb(255,255,255));
                TextField userIDText3=new TextField();
                HBox hb5=new HBox();
                hb5.getChildren().addAll(userIDLable3,userIDText3);
                hb5.setSpacing(15);
                hb5.setLayoutX(108);
                hb5.setLayoutY(325);


                Label passwordLabel3=new Label ("Password");
                passwordLabel3.setTextFill(Color.rgb(255,255,255));
                TextField userPassText3=new TextField();
                HBox hb6=new HBox();
                hb6.getChildren().addAll(passwordLabel3,userPassText3);
                hb6.setSpacing(15);
                hb6.setLayoutX(100);
                hb6.setLayoutY(360);

                Button loginButton2=new Button("Login");
                loginButton2.setTextFill(Color.rgb(0,0,0));
                loginButton2.setLayoutX(330);
                loginButton2.setLayoutY(345);
                Group login2=new Group(hb5,hb6,loginButton);
                Scene loginScene2=new Scene(login2, 500,750, Color.rgb(56,29,82));
                primary.setScene(loginScene2);
                primary.show();

                loginButton.setOnAction(event2 -> {
                    String userID2=userIDText.getText();
                    String password2=userPassText.getText();
                    String query2="Select * from Users where userID=? and password=?";
                    PreparedStatement pt2= null;

                    try {
                        pt2 = connection.prepareStatement(query2);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        pt2.setString(1,userID2);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        pt2.setString(2,password2);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    ResultSet rs= null;
                    try {
                        rs = pt2.executeQuery();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        if(rs.next())
                        {
                            primary.setTitle("Patient Page");
                            primary.setScene(PatientPage.patientPage);
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                        //skrrrt
                    }
                    try {
                        if(!rs.next())
                        {
                            primary.setTitle("Create Account");
                            primary.setScene(CreateAccount.account);
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                });
            });

        });

    }

    public static void main(String[] args) {
        launch();
    }
}
