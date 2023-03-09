package cangtin;

import Ticker.FXMLdoccument;
import Ticker.database;
import dataDaoMovi.cuhangDao;
import entities.Cuahang;
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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Banhang implements Initializable {
    @FXML
    private Label txtTien;

    @FXML
    private TextField txtK;

    @FXML
    private Label txtTen;
    @FXML
    private Label txtTra;


    public TableColumn<Cuahang,Integer> cID;
    public TableColumn<Cuahang,String> cName;
    public TableColumn<Cuahang,Double> cTien;
    public TableView<Cuahang> tbCuahang;
    public TableColumn<Cuahang,Integer> txtID;
    public TableColumn<Cuahang,String> txtname;
    public TableColumn<Cuahang,Integer> txtSL;
    public TableColumn<Cuahang,Double> txtGT;
    public TableView<Cuahang> txtDonhang;

    public void gotoBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/cangtin.fxml"));

        Scene scene = new Scene(root);
        FXMLdoccument.rootStage.setScene(scene);
    }
    public void select(){
        Cuahang cuahang = tbCuahang.getSelectionModel().getSelectedItem();
        int mun = tbCuahang.getSelectionModel().getSelectedIndex();
        if ((mun-1)<  -1){
            return;
        }

        txtTen.setText(cuahang.getName());
        txtTien.setText("$"+String.valueOf(cuahang.getGiatien()));
        sp1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,0);

        spiner1.setValueFactory(sp1);

    }
    private SpinnerValueFactory<Integer> sp1;
    public Spinner<Integer> spiner1;
    private  float pr1=0;
    private float pr2=0;
    private float total=0;
    private  int qty1 =0;
    private int qty2 =0;
    public void total(){
        Cuahang cuahang = tbCuahang.getSelectionModel().getSelectedItem();
        qty1 = spiner1.getValue();

        pr1= (float) (qty1*cuahang.getGiatien());

        txtTien.setText("$"+String.valueOf(pr1));


    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cID.setCellValueFactory(new PropertyValueFactory<>("id"));
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cTien.setCellValueFactory(new PropertyValueFactory<>("giatien"));

        cuhangDao cb = cuhangDao.getInstance();
        ArrayList<Cuahang> ds = cb.getAll();
        tbCuahang.getItems().addAll(ds);
        tbCuahang.refresh();



    }
    private Connection connection;
    private PreparedStatement prepared;
    private ResultSet resultSet;
    public void Clear(){
        txtTen.setText("");
        txtTien.setText("");
    }
    public void thanhtoan() throws Exception {
        String sql= "insert into lichsu(name,soluong,giatien,date) values(?,?,?,?)";
        connection= database.connectionDB();
        java.util.Date date = new java.util.Date();
        Date setDate = new Date(date.getTime());
        try{

            Alert alert;
            if (txtTen.getText().isEmpty() ){
                alert =new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Massger");
                alert.setHeaderText(null);
                alert.setContentText(" vui lòng chọn sản phẩm");
                alert.showAndWait();
            }else {

                prepared = connection.prepareStatement(sql);
                prepared.setString(1,txtTen.getText());
                prepared.setString(2, String.valueOf(qty1));
                prepared.setString(3, String.valueOf(pr1));
                prepared.setString(4, String.valueOf(setDate));
                prepared.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Cảm ơn bạn đã mua");
                alert.showAndWait();
                Clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
