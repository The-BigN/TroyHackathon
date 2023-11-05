package com.example.nutritioncalculator3;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ListOfPatients
{
    public static Label[] labels = new Label[28];
    public static Button[] buttons=new Button[8];
    public static Scene listOfPatients() {
        GridPane list=new GridPane();
        for (int i = 0; i < 28; i++)
        {
        labels[i]=new Label("_");
        labels[i].setTextFill(Color.rgb(255,255,255));
        }
        int l=0;
        for(int j=0; j<7;j++)
            for (int k=0; k<4;k++) {
                list.add(labels[l],j,k);
                l++;
            }
        for (int i=0;i<8;i++)
        {
            buttons[i]=new Button("skee");
        }
        list.add(buttons[0],8,0);
        list.add(buttons[1],9,0);
        list.add(buttons[2],8,1);
        list.add(buttons[3],9,1);
        list.add(buttons[4],8,2);
        list.add(buttons[5],9,2);
        list.add(buttons[6],8,3);
        list.add(buttons[7],9,3);

        list.setVgap(15);
        list.setHgap(10);
        list.setAlignment(Pos.CENTER);
        Group root=new Group(list);
        root.setLayoutX(200);
        root.setLayoutY(100);
    Scene patientlist=new Scene(root,500,500,Color.rgb(56,29,82));
    return patientlist;

    }

}
