package cangtin;

import Ticker.FXMLdoccument;
import dataDaoMovi.lichsuDao;
import entities.Cuahang;
import entities.Lichsu;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class LSmua implements Initializable {

    public TableView<Lichsu> tbView;
    public TableColumn<Lichsu,Integer> txtID;
    public TableColumn<Lichsu,String> txtName;
    public TableColumn<Lichsu,Integer> txtSL;
    public TableColumn<Lichsu,Double> txtGT;
    public TableColumn<Lichsu, Date> txtNg;

    public void gotoBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/cangtin.fxml"));

        Scene scene = new Scene(root);


        FXMLdoccument.rootStage.setScene(scene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtID.setCellValueFactory(new PropertyValueFactory<>("id"));
        txtName.setCellValueFactory(new PropertyValueFactory<>("name"));
        txtSL.setCellValueFactory(new PropertyValueFactory<>("soluong"));
        txtGT.setCellValueFactory(new PropertyValueFactory<>("giatien"));
        txtNg.setCellValueFactory(new PropertyValueFactory<>("date"));
        lichsuDao cb =lichsuDao.getInstance();
       ArrayList<Lichsu> ls =cb.getAll();
       tbView.getItems().addAll(ls);
       tbView.refresh();


    }
}
