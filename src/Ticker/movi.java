package Ticker;

import Phim.Movie;
import dataDaoMovi.MoviDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
        pr1=(qty1*20);
        pr2=(qty2*10);
        total = (pr1+pr2);
      ava_priceSP.setText("$"+String.valueOf(pr1));
      ava_priceNO.setText("$"+String.valueOf(pr2));
      ava_Total.setText(String.valueOf(total));

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
}
