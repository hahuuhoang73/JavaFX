package controler;

import daopatten.ClassesDao;
import database.Dtabase;
import entities.Classes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class List implements Initializable {



    public  TableColumn<Classes,Integer> cID;
    public  TableColumn<Classes, String> cName;
    public  TableColumn<Classes, String> cRoom;
    public TableView<Classes> tbClass;

    public void gotoHome(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../ressouver/home.fxml"));
        Home.rootStage.setScene(new Scene(root,800,600));




    }

    public void gotoCreat(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../ressouver/classer/create.fxml"));
        Home.rootStage.setScene(new Scene(root,800,600));

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cID.setCellValueFactory(new PropertyValueFactory<>("id"));
        cRoom.setCellValueFactory(new PropertyValueFactory<>("room"));
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));

        ObservableList<Classes> list = FXCollections.observableArrayList();

        ClassesDao cd= ClassesDao.getInstance();
        ArrayList<Classes> dslh = cd.getAll();
        tbClass.getItems().addAll(dslh);
        tbClass.refresh();

//        try{
//            Dtabase db =Dtabase.getInstance();
//            Statement stt = db.getStatement();
//            String sql = "select * from lophoc";
//            ResultSet rs = stt.executeQuery(sql);
//            while (rs.next()){
//               Integer id = rs.getInt("id");
//               String name = rs.getString("name");
//               String room = rs.getString("room");
//               Classes b = new Classes(id,name,room);
//               list.add(b);
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        tbClass.setItems(list);
    }
}
