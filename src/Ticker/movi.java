package Ticker;

import Phim.Movie;
import dataDaoMovi.MoviDao;
import database.database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class movi implements Initializable {


    public TableView<Movie> tabview;
    public TableColumn<Movie,String> textile;
    public TableColumn<Movie,String> txtgenren;
    public TableColumn<Movie,Date> txtdatee;

    public TableColumn<Movie,String> txttime;
    public Label ava_movitile;
    public Label ava_Gender;
    public Label ava_date;
    public Label ava_Time;
    public ImageView ava_imgview;
    public Spinner<Integer> spiner1;
    public Spinner<Integer> spiner2;
    public Label ava_priceSP;
    public Label ava_priceNO;
    public Label ava_Total;
    public Label tenghe;
    private Image img;
    public Label ava_imgtile;


    public void gotoBack(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/tesst1.fxml"));

        Scene scene = new Scene(root);

        FXMLdoccument.rootStage.setScene(scene);

    }

    public void gotoNG(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/Movie/customers.fxml"));

        Scene scene = new Scene(root);


        FXMLdoccument.rootStage.setScene(scene);
    }

    public void gotoShop(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/Movie/tesst2.fxml"));

        Scene scene = new Scene(root);


        FXMLdoccument.rootStage.setScene(scene);
    }
    public  void select(){
        Movie movie = tabview.getSelectionModel().getSelectedItem();
        int mun = tabview.getSelectionModel().getSelectedIndex();
        if ((mun-1)<  -1){
            return;
        }
        ava_movitile.setText(movie.getTile());
        ava_Gender.setText(movie.getGenre());
        ava_date.setText(String.valueOf(movie.getDate()));
        ava_Time.setText(movie.getTime());
        getData.path =movie.getImg();
        getData.tile= movie.getTile();

    }

    public void selecMovie(){
        String url ="file:"+ getData.path;

        img = new Image(url,187,221,false,true);
        ava_imgview.setImage(img);
        ava_imgtile.setText(getData.tile);
        ava_movitile.setText("");
        ava_Gender.setText("");
        ava_date.setText("");
        ava_Time.setText("");





    }
    private SpinnerValueFactory<Integer> sp1;
    private SpinnerValueFactory<Integer> sp2;
    private  float pr1=0;
    private float pr2=0;
    private float total=0;
    private  int qty1 =0;
    private int qty2 =0;

    public void Showspiner(){
        sp1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);
        sp2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);
spiner1.setValueFactory(sp1);
spiner2.setValueFactory(sp2);
    }
    public  void total(){

        qty1 = spiner1.getValue();
        qty2= spiner2.getValue();
        pr1=(qty1*25);
        pr2=(qty2*10);
        total = (pr1+pr2);


      ava_priceSP.setText("$"+String.valueOf(pr1));
      ava_priceNO.setText("$"+String.valueOf(pr2));
      ava_Total.setText(String.valueOf(total));

    }

    private Connection connection;
    private PreparedStatement prepared;
    private ResultSet resultSet;
    public void Buy() throws Exception {
        String sql= "insert into customer(type,toal,date) values(?,?,?)";
       connection= database.connectionDB();
        String type="";
        if (pr1>0 && pr2==0){
            type="PR class";
        }else if (pr2>0 && pr1==0){
            type="NO class";
        }else  if (pr1>0 && pr2>0){
            type="PR class && NO class";
        }
        java.util.Date date = new java.util.Date();
        Date setDate = new Date(date.getTime());


        try{
           prepared = connection.prepareStatement(sql);

          prepared.setString(1,type);
            prepared.setString(2,String.valueOf(total));
            prepared.setString(3,String.valueOf(setDate));
            Alert alert;
            if (ava_imgview.getImage()==null || ava_imgtile.getText().isEmpty()){
                alert =new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Massger");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng chọn Phim trước");
                alert.showAndWait();
            }else if (pr2==0 && pr1==0){
                alert =new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Massger");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng cho biết số lượng vé bạn muốn mua.");
                alert.showAndWait();
            }else {
                prepared.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Mời bạn sang trang chọn ghế ");
                alert.showAndWait();

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
                prepared.setString(4, ava_imgtile.getText());
                prepared.setString(5, String.valueOf(0));
                prepared.execute();
                Clearr();
//


//            String sql3 = "SELECT * FROM chair_movie ORDER BY id DESC LIMIT 1";
//            prepared = connection.prepareStatement(sql3);
//            resultSet= prepared.executeQuery();
//            while (resultSet.next()){
//                String ten = resultSet.getString("chair");
//                tenghe.setText(ten);
//            }
                Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/Movie/seat.fxml"));
                Scene scene = new Scene(root);
                FXMLdoccument.rootStage.setScene(scene);
            }





        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void Clearr() {
        sp1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);
        sp2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);
        spiner1.setValueFactory(sp1);
        spiner2.setValueFactory(sp2);
        ava_priceSP.setText("$0.0");
        ava_priceNO.setText("$0.0");
        ava_Total.setText("$0.0");
        ava_imgview.setImage(null);
        ava_imgtile.setText("");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textile.setCellValueFactory(new PropertyValueFactory<>("tile"));
        txtgenren.setCellValueFactory(new PropertyValueFactory<>("genre"));
        txtdatee.setCellValueFactory(new PropertyValueFactory<>("date"));
        txttime.setCellValueFactory(new PropertyValueFactory<>("time"));


        MoviDao cd = MoviDao.getInstance();
        ArrayList<Movie> dsphim= cd.getAll();
        tabview.getItems().addAll(dsphim);
        tabview.refresh();
        Showspiner();



    }

    public void gotoGhe(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/Movie/seat.fxml"));

        Scene scene = new Scene(root);


        FXMLdoccument.rootStage.setScene(scene);
    }
}
