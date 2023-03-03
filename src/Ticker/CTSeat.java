package Ticker;

import database.Dtabase;
import javafx.animation.ParallelTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class CTSeat implements Initializable {

    public Button seatA1;
    public Button seatA2;
    public Button seatA3;
    public Button seatA4;
    public Button seatA5;
    public Button seatA6;
    public Button seatA7;
    public Button seatA8;
    public Button seatA9;
    public Button seatA10;
    public Button seatB1;
    public Button seatB2;
    public Button seatB3;
    public Button seatB4;
    public Button seatB5;
    public Button seatB6;
    public Button seatB7;
    public Button seatB8;
    public Button seatB9;
    public Button seatB10;
    public Button seatC1;
    public Button seatC2;
    public Button seatC3;
    public Button seatC4;
    public Button seatC5;
    public Button seatC6;
    public Button seatC7;
    public Button seatC8;
    public Button seatC9;
    public Button seatC10;
    public Button seatD1;
    public Button seatD2;
    public Button seatD3;
    public Button seatD4;
    public Button seatD5;
    public Button seatD6;
    public Button seatD7;
    public Button seatD8;
    public Button seatD9;
    public Button seatD10;
    public Button seatE1;
    public Button seatE2;
    public Button seatE3;
    public Button seatE4;
    public Button seatE5;
    public Button seatE6;
    public Button seatE8;
    public Button seatE7;
    public Button seatE9;
    public Button seatE10;
    public Button seatF1;
    public Button seatF2;
    public Button seatF11;
    public Button seatF12;
    public Button seatF13;
    public Button seatF14;
    public Button seatF15;
    public Button seatF16;
    public Button seatF9;
    public Button seatF10;
    public Button seatG1;
    public Button seatG2;
    public Button seatG11;
    public Button seatG12;
    public Button seatG13;
    public Button seatG14;
    public Button seatG15;
    public Button seatG16;
    public Button seatG9;
    public Button seatG10;
    public Button seatH1;
    public Button seatH2;
    public Button seatH11;
    public Button seatH12;
    public Button seatH13;
    public Button seatH14;
    public Button seatH15;
    public Button seatH16;
    public Button seatH9;
    public Button seatH10;
    public Button seatI21;
    public Button seatI22;
    public Button seatI20;

    public  Label selectedSeatsLabel;
    public AnchorPane seatPane;

    public Label selectedSeatsLabel11;
    public Label selectedSeatsLabel12;
    public Label gt;
    public Label gv;
    public Label gd;
    public Text total1;
    public Label ghe;
    public Label tenphim;
    private Button confirmButton;
    private String selectedSeats = "";
    private  float pr1=0;
    private float pr2=0;
    private float total=0;
    private  int pr3 =0;
    private int qty2 =0;



    @FXML
    public void onSeatClick(ActionEvent event) {

        int value = 15;
        seatA1.setUserData(value);
        seatA2.setUserData(value);
        seatA3.setUserData(value);
        seatA4.setUserData(value);
        seatA5.setUserData(value);
        seatA6.setUserData(value);
        seatA7.setUserData(value);
        seatA8.setUserData(value);
        seatA9.setUserData(value);
        seatA10.setUserData(value);

        seatB1.setUserData(value);
        seatB2.setUserData(value);
        seatB3.setUserData(value);
        seatB4.setUserData(value);
        seatB5.setUserData(value);
        seatB6.setUserData(value);
        seatB7.setUserData(value);
        seatB8.setUserData(value);
        seatB9.setUserData(value);
        seatB10.setUserData(value);

        seatC1.setUserData(value);
        seatC2.setUserData(value);
        seatC3.setUserData(value);
        seatC4.setUserData(value);
        seatC5.setUserData(value);
        seatC6.setUserData(value);
        seatC7.setUserData(value);
        seatC8.setUserData(value);
        seatC9.setUserData(value);
        seatC10.setUserData(value);

        seatD1.setUserData(value);
        seatD2.setUserData(value);
        seatD3.setUserData(value);
        seatD4.setUserData(value);
        seatD5.setUserData(value);
        seatD6.setUserData(value);
        seatD7.setUserData(value);
        seatD8.setUserData(value);
        seatD9.setUserData(value);
        seatD10.setUserData(value);

        seatE1.setUserData(value);
        seatE2.setUserData(value);
        seatE3.setUserData(value);
        seatE4.setUserData(value);
        seatE5.setUserData(value);
        seatE6.setUserData(value);
        seatE7.setUserData(value);
        seatE8.setUserData(value);
        seatE9.setUserData(value);
        seatE10.setUserData(value);

        seatF1.setUserData(value);
        seatF2.setUserData(value);
        seatF9.setUserData(value);
        seatF10.setUserData(value);
        seatG1.setUserData(value);
        seatG2.setUserData(value);
        seatG9.setUserData(value);
        seatG10.setUserData(value);
        seatH1.setUserData(value);
        seatH2.setUserData(value);
        seatH9.setUserData(value);
        seatH10.setUserData(value);

        int value1=20;
        seatF11.setUserData(value1);
        seatF12.setUserData(value1);
        seatF13.setUserData(value1);
        seatF14.setUserData(value1);
        seatF15.setUserData(value1);
        seatF16.setUserData(value1);

        seatG11.setUserData(value1);
        seatG12.setUserData(value1);
        seatG13.setUserData(value1);
        seatG14.setUserData(value1);
        seatG15.setUserData(value1);
        seatG16.setUserData(value1);

        seatH11.setUserData(value1);
        seatH12.setUserData(value1);
        seatH13.setUserData(value1);
        seatH14.setUserData(value1);
        seatH15.setUserData(value1);
        seatH16.setUserData(value1);

        int values2 =30;
        seatI20.setUserData(values2);
        seatI21.setUserData(values2);
        seatI22.setUserData(values2);

        Button button = (Button) event.getSource();
        String seatNumber = button.getText();
        int seatValue = (int) button.getUserData();


        if (button.getStyleClass().contains("selected")) {
            button.getStyleClass().remove("selected");
            button.setStyle(null);
           button.setUserData(null);
            selectedSeats = selectedSeats.replaceAll(seatNumber, "");




        } else {

            button.getStyleClass().add("selected");
            button.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #fff");
          button.setUserData(seatValue);

            selectedSeats += seatNumber + " ";
//
//            System.out.println("Seat " + seatNumber );
//            ghe.setText(selectedSeats);

        }


//        selectedSeatsLabel.setText(selectedSeats);
        int seatNumber1 = Integer.parseInt(button.getText().substring(1));
        int selectedCount = 0;
        int selectedCount1 = 0;
        int selectedCount2 = 0;
        for (Node node : seatPane.getChildren()) {
            Button seatButton = null;


            if (node instanceof Button) {
                seatButton = (Button) node;
                seatNumber1 = Integer.parseInt(seatButton.getText().substring(1));
            }

            if (seatNumber1 >= 1 && seatNumber1 <= 10) {
                if (seatButton != null && seatButton.getStyleClass().contains("selected")) {
                    selectedCount++;


                }
            } else if (seatNumber1 >= 11 && seatNumber1 <= 16) {
                if (seatButton != null && seatButton.getStyleClass().contains("selected")) {
                    selectedCount1++;


                }
            }else {
                if (seatButton != null && seatButton.getStyleClass().contains("selected")) {
                    selectedCount2++;

                }
            }
        }
        total=(selectedCount*15+selectedCount1*20+selectedCount2*30);
        pr1=(selectedCount*15);
        pr2=(selectedCount1*20);
        pr3=(selectedCount2*30);

        gt.setText("$"+String.valueOf(selectedCount*15));
        gv.setText("$"+String.valueOf(selectedCount1*20));
        gd.setText("$"+String.valueOf(selectedCount2*30));
        total1.setText("$"+String.valueOf((total)));


//        for (Node node : seatPane.getChildren()) {
//            if (seatNumber1 >= 1 && seatNumber1 <= 10) {
//                if (node instanceof Button) {
//
//                    Button seatButton = (Button) node;
//                    if (seatButton.getStyleClass().contains("selected")) {
//                        selectedCount++;
//                        System.out.println("Số ghế được chọn: " + selectedCount);
//                    }
//                }
//            }
//        }
//        for (Node node : seatPane.getChildren()) {
//                    if (seatNumber1>=11 &&seatNumber1<=16) {
//                        if (node instanceof Button) {
//                            Button seatButton = (Button) node;
//                            if (seatButton.getStyleClass().contains("selected")) {
//                                selectedCount1++;
//                                System.out.println("Số ghế VIP được chọn: " + selectedCount1);
//                            }
//                        }
//                    }
//
//        }






//        System.out.println("Số tien: " + selectedCount*seatValue);
//        selectedSeatsLabel.setText(String.valueOf(selectedCount*seatValue));

//        selectedSeatsLabel.setText();

    }



    private Connection connection;
    private PreparedStatement prepared;
    private ResultSet resultSet;
    public <NextPageController> void onConfirmClick(ActionEvent event) throws IOException {
        ArrayList<Button> selectedButtons = new ArrayList<>();
        for (Node node : seatPane.getChildren()) {
            if (node instanceof Button && node.getStyleClass().contains("selected")) {
                selectedButtons.add((Button) node);
            }
        }

        // Kiểm tra nếu có ghế được chọn
        if (!selectedButtons.isEmpty()) {
            // Thêm thông báo cho người dùng
            String message = "Seats ";
            for (Button button : selectedButtons) {
                message += button.getText() + " ";
            }
            message += "have been selected.";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();

            // Disable buttons
            for (Button button : selectedButtons) {
                button.setDisable(true);
               gotoMovi(null);
            }
        } else {
            // Thêm thông báo cho người dùng
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No seat selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a seat before confirming.");
            alert.showAndWait();
        }

//        int selectedCount = 0;
//        for (Node node : seatPane.getChildren()) {
//            if (node instanceof Button) {
//                Button seatButton = (Button) node;
//                if (seatButton.getStyleClass().contains("selected")) {
//                    selectedCount++;
//                }
//            }
//        }
//        Button button = (Button) event.getSource();
//        int seatNumber1 = Integer.parseInt(button.getText().substring(1));
//        int selectedCount = 0;
//        int selectedCount1 = 0;
//        int selectedCount2 = 0;
//        for (Node node : seatPane.getChildren()) {
//            Button seatButton = null;
//
//
//            if (node instanceof Button) {
//                seatButton = (Button) node;
//                seatNumber1 = Integer.parseInt(seatButton.getText().substring(1));
//            }
//
//            if (seatNumber1 >= 1 && seatNumber1 <= 10) {
//                if (seatButton != null && seatButton.getStyleClass().contains("selected")) {
//                    selectedCount++;
//
//
//                }
//            } else if (seatNumber1 >= 11 && seatNumber1 <= 16) {
//                if (seatButton != null && seatButton.getStyleClass().contains("selected")) {
//                    selectedCount1++;
//
//
//                }
//            }else {
//                if (seatButton != null && seatButton.getStyleClass().contains("selected")) {
//                    selectedCount2++;
//
//                }
//            }
//        }
//        total=(selectedCount*15+selectedCount1*20+selectedCount2*30);
//        gt.setText("$"+String.valueOf(selectedCount*15));
//        gv.setText("$"+String.valueOf(selectedCount1*20));
//        gd.setText("$"+String.valueOf(selectedCount2*30));
//        total1.setText("$"+String.valueOf((total)));


        String sql= "insert into customer(type,toal,date,title,time) values(?,?,?,?,?)";
        connection= database.connectionDB();
        String type="";
        if (pr1>0 && pr2==0 && pr3==0){
            type="NORMAL";
        }else if (pr2>0 && pr1==0 && pr3==0){
            type="V.I.P";
        }else if (pr1==0 && pr2==0 && pr3>0){
            type="DOUBLE";
        }else if (pr1>0 && pr2>0 && pr3>0){
            type="DOUBLE && V.I.P && NORMAL";
        }else if (pr1>0 && pr2>0 && pr3==0){
            type="NORMAL && V.I.P";
        }else if (pr1>0 && pr2==0 && pr3>0){
            type="NORMAL && DOUBLE";
        }else if (pr1==0 && pr2>0 && pr3>0){
            type="V.I.P && DOUBLE";
        }
        java.util.Date date = new java.util.Date();
        Date setDate = new Date(date.getTime());


        try{
            Alert alert;
            if (pr1==0 && pr3==0 && pr2==0) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Massger");
                alert.setHeaderText(null);
                alert.setContentText("Please indicate the number of seats you would like to purchase.");
                alert.showAndWait();
            }else {

                LocalTime localTime = LocalTime.now();
                Time time = Time.valueOf(localTime);
                String sql3 = "SELECT * FROM chair_movie ORDER BY id DESC LIMIT 1";
                prepared = connection.prepareStatement(sql3);
                resultSet = prepared.executeQuery();
                while (resultSet.next()) {
                    String ten = resultSet.getString("chair");
                    tenphim.setText(ten);
                }

                prepared = connection.prepareStatement(sql);
                prepared.setString(1, type);
                prepared.setString(2, String.valueOf(total));
                prepared.setString(3, String.valueOf(setDate));
                prepared.setString(4, tenphim.getText());
                prepared.setString(5, String.valueOf(time));
                prepared.executeUpdate();
                String sql1 = "select * from customer";
                prepared = connection.prepareStatement(sql1);
                resultSet = prepared.executeQuery();
                int num = 0;
                while (resultSet.next()) {
                    num = resultSet.getInt("id");
                }


                String sql2 = "INSERT INTO  costomer_info(cutomer_id,type,total,movietitle,tienghe) values(?,?,?,?,?)";
                prepared = connection.prepareStatement(sql2);
                prepared.setString(1, String.valueOf(num));
                prepared.setString(2, type);
                prepared.setString(3, String.valueOf(total));
                prepared.setString(4, tenphim.getText());
                prepared.setString(5, selectedSeats);
                prepared.execute();

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("tin"+total);






//        try {
//            String nameGhe =selectedSeatsLabel.getText();
//            if (nameGhe.isEmpty()){
//                throw new Exception("Vui long chon ghe!");
//            }
//            Dtabase db =Dtabase.getInstance();
//            Statement stt = db.getStatement();
//            String sql ="insert into chair_movie(chair) values('"+nameGhe+"')";
//            stt.executeUpdate(sql);
//
//
//
//        }  catch (Exception e) {
//            throw new RuntimeException(e);
//        }

    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void gotoMovi(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/Movie/movie.fxml"));

        Scene scene = new Scene(root);


        FXMLdoccument.rootStage.setScene(scene);
    }
}
