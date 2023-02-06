import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Danhba {


    public TextField txtPhone;
    public TextField txtName;
    public Nguoidung editNguoidung;
    public ListView<Nguoidung> lv;
    public ObservableList<Nguoidung> listNguoidung = FXCollections.observableArrayList();

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
      lv.setItems(listNguoidung);
      lv.refresh();
      clearInput();

    }

    public void edit(MouseEvent mouseEvent) {
        editNguoidung=lv.getSelectionModel().getSelectedItem();
        txtName.setText(editNguoidung.Name);
        txtPhone.setText(editNguoidung.Phone);

    }
    void clearInput(){
        txtName.clear();
        txtPhone.clear();
    }
    private boolean ascending = true;
    public void sumit1(ActionEvent actionEvent) {
         ascending = !ascending;
     Collections.sort(listNguoidung, new Comparator<Nguoidung>() {
         @Override
         public int compare(Nguoidung o1, Nguoidung o2) {
             if (ascending) {
                 return o1.Name.compareTo(o2.Name);
             } else {
                 return o2.Name.compareTo(o1.Name);
             }
         }
     });


    }
}
