package com.example.javaprojectairline;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
public class HelloController implements EventHandler<ActionEvent>{
    @FXML
    TextField txt1,txt2,txt3;
   public double rad(){

    Random det=new Random();
    double no,cot;
    no=0;
    for(cot=1;cot<=5;cot++)
    {
        no= det.nextInt(5);
    }
   return no;
   }
String str1;
String str2;
String str3;
    @FXML
    private Label welcomeText;
    private Object stage;

    HelloController(TextField txt1,TextField txt2,TextField txt3)
    {
        this.txt1=txt1;
        this.txt2=txt2;
        this.txt3=txt3;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        str1=txt1.getText();
        str2=txt2.getText();
        str3=txt3.getText();

        Nconn conn=new Nconn();
        conn.conMethod();

        queryHandler();
    }
   private void queryHandler()
    { Alert ar=new Alert(Alert.AlertType.INFORMATION);
        try{
            Nconn db=new Nconn();
            Connection connection=db.conMethod();
            Statement stmt=connection.createStatement();
           String sql="select * from userinformation where username='"+ str1 +"'and passport_number='"+ str2 +"'and password='"+ str3 +"'";
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()) {
            ar.setContentText("yess");
            ar.showAndWait();
                Stage stg=new Stage();
                Group g1=new Group();
                Button btnt=new Button("NEW TICKET");
                Button btnc=new Button("ALREADY BOUGHT");
                btnt.setLayoutX(100);
                btnt.setLayoutY(130);
                btnc.setLayoutY(130);
                btnc.setLayoutX(200);
                btnt.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Stage stg2=new Stage();
                        Group g2=new Group();

                        Label lbld=new Label("Date");
                        lbld.setFont(Font.font("italic", FontWeight.BOLD,24));
                        lbld.setTextFill(Color.LIGHTGRAY);
                        lbld.setLayoutX(10);
                        lbld.setLayoutY(10);
                        TextField txtd=new TextField();
                        txtd.setLayoutX(70);
                        txtd.setLayoutY(10);
                        Label lblcx=new Label("starting place");
                        lblcx.setFont(Font.font("italic", FontWeight.BOLD,20));
                        lblcx.setTextFill(Color.LIGHTGRAY);
                        lblcx.setLayoutX(10);
                        lblcx.setLayoutY(50);
                        TextField txtx1=new TextField();
                        txtx1.setLayoutX(190);
                        txtx1.setLayoutY(50);
                      /*  String[] list={"Addis Ababa","BahirDar","Hawassa","Mekelle","Arbaminch","Gondar"};
                        ComboBox cb = new ComboBox(FXCollections.observableArrayList(list));
                        cb.getSelectionModel().selectFirst();
                        ListView<String> listView= new ListView<>(FXCollections.observableArrayList(list));
                        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                        listView.setPrefWidth(3);
                        cb.setLayoutX(190);
                        cb.setLayoutY(50);*/
                        Label lbldp=new Label("destination place");
                        lbldp.setFont(Font.font("italic", FontWeight.BOLD,20));
                        lbldp.setTextFill(Color.LIGHTGRAY);
                        lbldp.setLayoutX(10);
                        lbldp.setLayoutY(90);
                        TextField txtx=new TextField();
                        txtx.setLayoutY(90);
                        txtx.setLayoutX(190);
                       // String[] list2={"Addis Ababa","BahirDar","Hawassa","Mekelle","Arbaminch","Gondar"};
                       // ComboBox cb2 = new ComboBox(FXCollections.observableArrayList(list2));
                       // cb.getSelectionModel().selectFirst();
                        //ListView<String> list2View= new ListView<>(FXCollections.observableArrayList(list2));
                       /* listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                        listView.setPrefWidth(3);
                        cb2.setLayoutY(90);
                        cb2.setLayoutX(190);*/
                        Button btnsub=new Button("Submmit");
                        Button btnbak=new Button("Back");
                        btnsub.setLayoutX(50);
                        btnsub.setLayoutY(150);
                        btnbak.setLayoutX(150);
                        btnbak.setLayoutY(150);

                   btnsub.setOnAction((new EventHandler<ActionEvent>() {
                       @Override
                       public void handle(ActionEvent actionEvent) {
                           Alert ar1=new Alert(Alert.AlertType.INFORMATION);
                           String sr=txtx1.getText();
                           String sr1=txtx.getText();
                           String sr2=txtd.getText();
try{
                           Nconn db1=new Nconn();
                           Connection connection1=db1.conMethod();
                           Statement stmt1=connection1.createStatement();
                           String sql1="select * from FLIGHT_INFORMATION where DEPARTURE_PLACE='"+ sr +"'and DESTINATION_PLACE ='"+ sr1 +"'and FLIGHT_DATE='"+ sr2 +"'";
                           ResultSet rs1=stmt1.executeQuery(sql1);

    if(rs1.next()){
double a=rad();
String ss=Double.toString(a);
        String pp=rs1.getString("FLIGHT_NUMBER");
        String dp=rs1.getString("departure_place");
        String des=rs1.getString("destination_place");
        String dpt=rs1.getString("departure_time");
        String art= rs1.getString("arrival_time");
        String dt= rs1.getString("flight_date");
        ar1.setContentText("your ticket infomation is \n"+str1+" "+dp+" to "+des+" \n"+dpt+" "+art+" "+dt+ss+"\n");
    ar1.showAndWait();
        String st="Insert into DATATABLE(USERNAME,DEPARTURE_PLACE,DESTINATION_PLACE,TICKET_NUMBER,DEPARTURE_TIME,ARRIVAL_TIME,FLIGHT_NUMBER) VALUES('" + str1 + "','" + sr + "','"+ sr1 +"','"+ss+"','"+dpt+"','"+art+"','"+pp+"')";
        stmt1.executeQuery(st);
    }
    else{
        ar1.setContentText("there is no flight in this day");
    ar1.showAndWait();}}
catch (SQLException e) {
    throw new RuntimeException(e);
}
                       }
                   }));
                        g2.getChildren().addAll(txtx,lbldp,txtx1,lblcx,txtd,lbld,btnsub,btnbak);

                        stg2.setTitle("ticket form");
                        Scene scene2 = new Scene(g2, 500, 500, Color.CHOCOLATE);
                        stg2.setScene(scene2);
                        stg2.setResizable(false);
                        stg2.show();

                    }
                });

                btnc.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        Stage stg3=new Stage();
                        Group g3=new Group();


                        Label lblsp=new Label("starting place");
                        lblsp.setFont(Font.font("italic", FontWeight.BOLD,20));
                        lblsp.setTextFill(Color.LIGHTGRAY);
                        lblsp.setLayoutX(10);
                        lblsp.setLayoutY(10);

                        Label lbldes=new Label("destination place");
                        lbldes.setFont(Font.font("italic", FontWeight.BOLD,20));
                        lbldes.setTextFill(Color.LIGHTGRAY);
                        lbldes.setLayoutX(10);
                        lbldes.setLayoutY(40);

                        Label lbltn=new Label("ticket number");
                        lbltn.setFont(Font.font("italic", FontWeight.BOLD,20));
                        lbltn.setTextFill(Color.LIGHTGRAY);
                        lbltn.setLayoutX(10);
                        lbltn.setLayoutY(80);

                        Label lblfn=new Label("flight number");
                        lblfn.setFont(Font.font("italic", FontWeight.BOLD,20));
                        lblfn.setTextFill(Color.LIGHTGRAY);
                        lblfn.setLayoutX(10);
                        lblfn.setLayoutY(120);

                        Label lblpn=new Label("passport number");
                        lblpn.setFont(Font.font("italic", FontWeight.BOLD,20));
                        lblpn.setTextFill(Color.LIGHTGRAY);
                        lblpn.setLayoutX(10);
                        lblpn.setLayoutY(160);

                        TextField txtt1=new TextField();
                        txtt1.setLayoutX(180);
                        txtt1.setLayoutY(10);

                        TextField txtt2=new TextField();
                        txtt2.setLayoutX(180);
                        txtt2.setLayoutY(40);

                        TextField txtt3=new TextField();
                        txtt3.setLayoutX(180);
                        txtt3.setLayoutY(80);

                        TextField txtt5=new TextField();
                        txtt5.setLayoutX(180);
                        txtt5.setLayoutY(130);

                        TextField txtt6=new TextField();
                        txtt6.setLayoutX(180);
                        txtt6.setLayoutY(160);
                        Button btnct=new Button("cancle ticket");
                        Button btnbak1=new Button("Back");
                        btnct.setLayoutX(50);
                        btnct.setLayoutY(250);
                        btnbak1.setLayoutX(150);
                        btnbak1.setLayoutY(250);
                        g3.getChildren().addAll(txtt6,txtt5,txtt1,txtt2,txtt3,lblsp,lbldes,lblfn,lblpn,lbltn,btnbak1,btnct);
                        btnbak1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
System.exit(0);
                            }
                        });

                        btnct.setOnAction(new EventHandler<ActionEvent>() {

                            String pp= txtt3.getText();
                            public void handle(ActionEvent actionEvent) {
                                Nconn db1=new Nconn();
                                Connection connection1=db1.conMethod();
                                try {
                                    Statement stmt2=connection1.createStatement();
                                    String dd="delete from datatable where flight_number='"+pp+"'";
                                    stmt2.executeQuery(dd);
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        });
                        stg3.setTitle("ticket form");
                        Scene scene2 = new Scene(g3, 500, 500, Color.CHOCOLATE);
                        stg3.setScene(scene2);
                        stg3.setResizable(false);
                        stg3.show();
                    }
                });


                g1.getChildren().addAll(btnt,btnc);


                stg.setTitle("ticket form");
                Scene scene1 = new Scene(g1, 500, 500, Color.CHOCOLATE);
                stg.setScene(scene1);
                stg.setResizable(false);
                stg.show();
            }
            else{
             ar.setContentText("no");
            ar.showAndWait();
        }}
        catch(Exception e)
        {

            ar.setContentText("noooooooo");
            ar.showAndWait();
        }
    }

}