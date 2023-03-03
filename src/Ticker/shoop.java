package Ticker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class shoop implements Initializable {
    @FXML
    private Label sold_movies;

    @FXML
    private AnchorPane sold_from;

    @FXML
    private Label sold_ticket;



    @FXML
    private Label sold_today;
    private Connection connection;
    private PreparedStatement prepared;
    private ResultSet resultSet;
    public void gotoBack(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/tesst1.fxml"));

        Scene scene = new Scene(root);

        FXMLdoccument.rootStage.setScene(scene);



    }

    public void gotoMovi(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/Movie/movie.fxml"));

        Scene scene = new Scene(root);

        FXMLdoccument.rootStage.setScene(scene);

    }



    public void gotoTO(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/Movie/customers.fxml"));

        Scene scene = new Scene(root);


        FXMLdoccument.rootStage.setScene(scene);
    }
private int TotalMovi;
    public void totalmovie(){
        String sql= " select count(id) from movi  ";
        connection= database.connectionDB();
        try {
            prepared= connection.prepareStatement(sql);
            resultSet=prepared.executeQuery();
            if (resultSet.next()){
                TotalMovi=resultSet.getInt("count(id)");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void displaytotalMovie(){
        totalmovie();
        sold_movies.setText(String.valueOf(TotalMovi));
    }
private float totalIncom;
public void  totalIncomToday(){
    java.util.Date date = new java.util.Date();
   java.sql.Date sqlDate = new java.sql.Date(date.getTime());
   String sql =" select sum(toal) from customer where date ='"+String.valueOf(sqlDate)+"' ";
   connection=database.connectionDB();
   try {
       prepared= connection.prepareStatement(sql);
       resultSet= prepared.executeQuery();
       if (resultSet.next()){
           totalIncom= (float) resultSet.getDouble("SUM(toal)");
       }
   }catch (Exception e){
       e.printStackTrace();
   }
}
public void displayTotalIncom(){
    totalIncomToday();
    sold_today.setText(String.valueOf(totalIncom));
}
    private  int soldTicket;
    public  void countTicket(){
        String sql= " select count(id) from customer  ";
        connection= database.connectionDB();
        try {
            prepared= connection.prepareStatement(sql);
            resultSet=prepared.executeQuery();
            while (resultSet.next()){
                soldTicket=resultSet.getInt("count(id)");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void displayTotalTickey(){
        countTicket();
        sold_ticket.setText(String.valueOf(soldTicket));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayTotalTickey();
        displayTotalIncom();
        displaytotalMovie();
    }
}
