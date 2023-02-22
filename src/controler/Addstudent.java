package controler;

import daopatten.ClassesDao;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Addstudent implements Initializable {
    public TextField txtName;
    public TextField txtEmail;



    public DatePicker txtbirthay;

    public ComboBox<Classes> txtID;
    public ComboBox<String> txtGender;

    public void gotoStudentlist(ActionEvent actionEvent)throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../ressouver/classer/studenlist.fxml"));
        Home.rootStage.setScene(new Scene(root,800,600));
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> gt = FXCollections.observableArrayList();
        gt.add("Maile");
        gt.add("Female");
        txtGender.setItems(gt);
//        try
//        {
//            Dtabase db = Dtabase.getInstance();
//            Statement stt = db.getStatement();
//            String sql ="SELECT * FROM lophoc";
//            ResultSet rs = stt.executeQuery(sql);
//            ObservableList<Classes> options = FXCollections.observableArrayList();
//            while (rs.next()){
//                Integer id = rs.getInt("id");
//                String name = rs.getString("name");
//                String room = rs.getString("room");
//                Classes c = new Classes(id,name,room);
//                options.add(c);
//                txtID.setItems(options);
//            }
//
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText(e.getMessage());
//            alert.show();
//
//        }

        ClassesDao cd= ClassesDao.getInstance();
        ArrayList<Classes> dslh = cd.getAll();


        txtID.getItems().addAll(dslh);



    }


    public void Submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String date = Date.valueOf(txtbirthay.getValue()).toString();
            String gender =txtGender.getValue();


            Integer id = txtID.getValue().getId();

            if (name.isEmpty() || email.isEmpty() || gender.isEmpty()   ){
                throw  new Exception(" vui long dien day du thong tin  ok!");
            }
//            Dtabase db = Dtabase.getInstance();
//            Statement stt = db.getStatement();
//            String sql = "insert into sinhvien(name,email,birthday,gender,class_id) values('"+name+"','"+email+"','"+date+"','"+gender+"','"+id+"')";
//            stt.executeUpdate(sql);
            Student c = new Student(null,name,email,Date.valueOf(date),gender,id);
            StudentDao cd = StudentDao.getInstance() ;
            if (cd.addStudent(c))
                gotoStudentlist(null);
            else
                throw  new Exception("Khong the tao sv");


//            gotoStudentlist(null);
        }catch (Exception e){
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();

        }

    }
}
