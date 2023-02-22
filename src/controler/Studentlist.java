package controler;

import daopatten.StudentDao;
import database.Dtabase;
import entities.Classes;
import entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class Studentlist implements Initializable {
    public static TextField stEmail;
    public static  TextField stName;
    public static  TextField stDate;
    public static  TextField stGender;
    public static  TextField stID;

    public static Student editNguoidung;
    public TableView<Student> tbStuden;
    public TableColumn<Student, Integer> cID;
    public TableColumn<Student,String> cName;
    public TableColumn<Student,String> cEmail;
    public TableColumn<Student,Date> cDate;
    public TableColumn<Student,String> cGender;
    public TableColumn<Student,Integer> cIdzoom;

    public void gotoHome(ActionEvent actionEvent)throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../ressouver/home.fxml"));
        Home.rootStage.setScene(new Scene(root,800,600));

    }

    public void gotoAdd(ActionEvent actionEvent)throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../ressouver/classer/addstudent.fxml"));
        Home.rootStage.setScene(new Scene(root,800,600));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cID.setCellValueFactory(new PropertyValueFactory<>("id"));
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cDate.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        cGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        cIdzoom.setCellValueFactory(new PropertyValueFactory<>("class_id"));
        ObservableList<Student> list1 = FXCollections.observableArrayList();

        StudentDao cd = StudentDao.getInstance();
        ArrayList<Student> dshs = cd.getAll();
        tbStuden.getItems().addAll(dshs);
        tbStuden.refresh();

//        try{
//            Dtabase db = Dtabase.getInstance();
//            Statement stt = db.getStatement();
//            String sql = "select * from sinhvien";
//            ResultSet rs = stt.executeQuery(sql);
//            while (rs.next()){
//                Integer id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                Date birthday = rs.getDate("birthday");
//                String gender = rs.getString("gender");
//                Integer idzoom = rs.getInt("class_id");
//
//               Student b = new Student(id,name,email,birthday,gender,idzoom);
//                list1.add(b);
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        tbStuden.setItems(list1);
    }
}
