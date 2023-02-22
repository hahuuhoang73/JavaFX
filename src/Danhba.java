import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.*;

public class Danhba implements Initializable {


    public TextField txtPhone;
    public TextField txtName;
    public static  TextField stPhone;
    public static  TextField stName;
    public static  Nguoidung editNguoidung;

    public ObservableList<Nguoidung> listNguoidung = FXCollections.observableArrayList();
    public TableColumn<Nguoidung,String> cfullname;
    public TableColumn<Nguoidung,String> cphone;
    public TableView<Nguoidung> tbview;

    public TableColumn<Nguoidung,Button> action;


    public void sumit(ActionEvent actionEvent) {
       String ten = txtName.getText();
       String sdt =txtPhone.getText();
       if (editNguoidung == null){
           Nguoidung s = new Nguoidung(ten,sdt);
           listNguoidung.add(s);
       }else {
           for (Nguoidung s: listNguoidung){
               if (s.Name.equals(editNguoidung.Name)&& s.Phone.equals(editNguoidung.Phone)){
                   s.setName(ten);
                   s.setPhone(sdt);
               }
           }
       }
        tbview.setItems(listNguoidung);
        tbview.refresh();
        editNguoidung = null;
//      lv.setItems(listNguoidung);
//      lv.refresh();
      clearInput();

    }

    public void edit(MouseEvent mouseEvent) {
//        editNguoidung=lv.getSelectionModel().getSelectedItem();
        txtName.setText(editNguoidung.Name);
        txtPhone.setText(editNguoidung.Phone);

    }
    void clearInput(){
        txtName.clear();
        txtPhone.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cfullname.setCellValueFactory(new PropertyValueFactory<>("name"));
        cphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        action.setCellValueFactory(new PropertyValueFactory<>("edit"));

        stName=txtName;
        stPhone=txtPhone;

    }
//    private boolean ascending = true;
//    public void sumit1(ActionEvent actionEvent) {
//         ascending = !ascending;
//     Collections.sort(listNguoidung, new Comparator<Nguoidung>() {
//         @Override
//         public int compare(Nguoidung o1, Nguoidung o2) {
//             if (ascending) {
//                 return o1.Name.compareTo(o2.Name);
//             } else {
//                 return o2.Name.compareTo(o1.Name);
//             }
//         }
//     });


//    }
}
