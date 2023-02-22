package controler;

import daopatten.ClassesDao;
import database.Dtabase;
import entities.Classes;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Statement;

import static com.sun.java.accessibility.util.GUIInitializedMulticaster.add;

public class Creat  {

    public TextField txtName;
    public TextField txtZoom;



    public void gotoList(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../ressouver/classer/list.fxml"));
        Home.rootStage.setScene(new Scene(root,800,600));


    }


    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String room = txtZoom.getText();
            if (name.isEmpty() || room.isEmpty()){
                throw  new Exception(" vui long dien day du thong tin  ok!");
            }
//            Dtabase db = Dtabase.getInstance();
//            Statement stt = db.getStatement();
//            String sql = "insert into lophoc(name,room) values('"+name+"','"+room+"')";
//            stt.executeUpdate(sql);

            Classes c = new Classes(null,name,room);
            ClassesDao cd = ClassesDao.getInstance() ;
            if (cd.creadte(c))
                gotoList(null);
            else
                throw  new Exception("Khong the tao lop hoc");
//            gotoList(null);

        }catch (Exception e){
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();

        }



    }
}
