package Ticker;

import Phim.Cutommer;
import dataDaoMovi.CustomDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class cus implements Initializable {
    public TableColumn<Cutommer,Integer> custom_col_id;
    public TableColumn<Cutommer,String> custom_col_tile;
    public TableColumn<Cutommer,Double> custom_col_total;
    public TableColumn<Cutommer, Date> custom_col_date;
    public TableColumn<Cutommer, Time> custom_col_time;
    public TableView<Cutommer> custom_table;
    @FXML
    private Label custom_total;

    @FXML
    private TextField custom_seach;

    @FXML
    private AnchorPane sold_from;

    @FXML
    private Label custom_id;

//    @FXML
//    private TableView<?> custom_table;

    @FXML
    private Label custom_tile;

//    @FXML
//    private TableColumn<?, ?> custom_col_time;
//
//    @FXML
//    private TableColumn<?, ?> custom_col_tile;
//
//    @FXML
//    private TableColumn<?, ?> custom_col_total;
//
//    @FXML
//    private TableColumn<?, ?> custom_col_id;

    @FXML
    private Label custom_time;

//    @FXML
//    private TableColumn<?, ?> custom_col_date;

    @FXML
    private Label custom_date;

    @FXML
    private Button custom_clear;

    @FXML
    private Button custom_delete;
    private Connection connection;
    private PreparedStatement prepared;
    private ResultSet resultSet;
    private Statement statement;
    public void gotoTo(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/Movie/movie.fxml"));

        Scene scene = new Scene(root);

        FXMLdoccument.rootStage.setScene(scene);
    }

    public void gotoShop(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/Movie/tesst2.fxml"));

        Scene scene = new Scene(root);


        FXMLdoccument.rootStage.setScene(scene);
    }

    public void gotoBack(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/tesst1.fxml"));

        Scene scene = new Scene(root);

        FXMLdoccument.rootStage.setScene(scene);
    }
    public  ObservableList<Cutommer> cutommersList() {
        ObservableList<Cutommer> cutommersL = FXCollections.observableArrayList();
        String sql = "select * from customer";
        connection = database.connectionDB();
        try {
            Cutommer cutommer;
            prepared= connection.prepareStatement(sql);
            resultSet= prepared.executeQuery();
            while (resultSet.next()){
                cutommer = new Cutommer(resultSet.getInt("id"),resultSet.getString("type"),
                resultSet.getDouble("toal"),resultSet.getDate("date"),
                resultSet.getString("time"),resultSet.getTime("time"));
                cutommersL.add(cutommer);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
return cutommersL;

    }
    public  ObservableList<Cutommer> cutoList;
    public void show(){
        cutoList = cutommersList();
        custom_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        custom_col_tile.setCellValueFactory(new PropertyValueFactory<>("title"));
        custom_col_total.setCellValueFactory(new PropertyValueFactory<>("toal"));
        custom_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        custom_col_time.setCellValueFactory(new PropertyValueFactory<>("time"));
        custom_table.setItems(cutoList);

    }
    public  void selcet(){
        Cutommer cutommer = custom_table.getSelectionModel().getSelectedItem();
        int mun = custom_table.getSelectionModel().getSelectedIndex();
        if ((mun-1)< -1){
            return;
        }
        custom_id.setText(String.valueOf(cutommer.getId()));
        custom_tile.setText(cutommer.getTitle());
        custom_total.setText(String.valueOf(cutommer.getToal()));
        custom_date.setText(String.valueOf(cutommer.getDate()));
        custom_time.setText(String.valueOf(cutommer.getTime()));

    }


    public void  delete(){
        String sql="DELETE FROM customer WHERE id ='"+custom_id.getText()+"'";
         connection =database.connectionDB();
   try{
       Alert alert;

       statement= connection.createStatement();
       if (custom_id.getText().isEmpty()|| custom_tile.getText().isEmpty()
       || custom_total.getText().isEmpty() || custom_date.getText().isEmpty()
       || custom_time.getText().isEmpty()){
           alert =new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Massger");
                alert.setHeaderText(null);
                alert.setContentText("Please select the list you want to delete!");
                alert.showAndWait();

       }else {
           alert =new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Error Massger");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you delete?"+custom_tile.getText()+"?");
           Optional<ButtonType> optional = alert.showAndWait();
           if (optional.get() == ButtonType.OK){

               statement.executeUpdate(sql);
               alert= new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Error Massger");
               alert.setHeaderText(null);
               alert.setContentText("Sucsslyy Remoer!");
               alert.showAndWait();
               show();

               clear();

           }else {
             return;
           }

       }

}catch (Exception e){
    e.printStackTrace();
}
    }
    public  void  clear(){
        custom_id.setText("");
        custom_tile.setText("");
        custom_total.setText("");
        custom_date.setText("");
        custom_time.setText("");


    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        custom_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
//        custom_col_tile.setCellValueFactory(new PropertyValueFactory<>("title"));
//        custom_col_total.setCellValueFactory(new PropertyValueFactory<>("toal"));
//        custom_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
//        custom_col_time.setCellValueFactory(new PropertyValueFactory<>("time"));
//
//        CustomDao cd = CustomDao.getInstance();
//        ArrayList<Cutommer> dscus = cd.getAll();
//        custom_table.getItems().addAll(dscus);
//        custom_table.refresh();
        show();



    }
}
