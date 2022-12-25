package com.example.javaprojectairline;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Group g=new Group();
        Label lbl2=new Label("passport NO");
        Label lbl1=new Label("username");
        Label lbl3=new Label("password");
        lbl1.setFont(Font.font("italic", FontWeight.BOLD,18));
        lbl3.setFont(Font.font("italic", FontWeight.BOLD,18));
        lbl2.setFont(Font.font("italic", FontWeight.BOLD,18));
        lbl1.setTextFill(Color.LIGHTSKYBLUE);
        lbl2.setTextFill(Color.LIGHTSKYBLUE);
        lbl3.setTextFill(Color.LIGHTSKYBLUE);
        lbl2.setLayoutX(10);
        lbl2.setLayoutY(50);
        lbl1.setLayoutX(10);
        lbl1.setLayoutY(10);
        lbl3.setLayoutY(90);
        lbl3.setLayoutX(10);
        TextField txt1=new TextField();
        TextField txt2=new TextField();
        TextField txt3=new TextField();
        txt3.setLayoutY(90);
        txt3.setLayoutX(120);
        txt2.setLayoutX(120);
        txt2.setLayoutY(50);
        txt1.setLayoutX(120);
        txt1.setLayoutY(10);
        Button btn=new Button("login");
        Button btn1=new Button("cancel");
        btn.setLayoutX(100);
        btn.setLayoutY(130);
        btn1.setLayoutY(130);
        btn1.setLayoutX(160);
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        btn.setOnAction(new HelloController(txt1,txt2,txt3));
        g.getChildren().addAll(lbl1,lbl2,lbl3,txt1,txt2,txt3,btn1,btn);
        Scene scene = new Scene(g,500,500, Color.CHOCOLATE);
        stage.setTitle("java project");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}