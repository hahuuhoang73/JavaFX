import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ThongTin implements Initializable{
    public TextField txtFullName;
    public TextField txtEmail;
    public static TextField stFullName;
    public static TextField stEmail;





    public Text txtInfo;
//    public ArrayList<Student> listStudent = new ArrayList<>();

    public static Student editStudent;

    public ObservableList<Student> listStudent = FXCollections.observableArrayList();

    public TableView<Student> tbview;
    public TableColumn<Student,String> cfullname;
    public TableColumn<Student,String> cemail;
    public TableColumn<Student, Button> caction;

    public void submit(ActionEvent actionEvent) {
        String fn = txtFullName.getText();
        String em = txtEmail.getText();
        if (editStudent == null){
            Student s= new Student(fn,em);
            listStudent.add(s);
//       String txt  = "";
//       for (Student sv: listStudent){
//           txt ="\n=========\n"+sv.toString();
//       }
//       txtInfo.setText(txt);
//            lv.setItems(listStudent);

        }else {
//            editStudent.setFullname(fn);
//            editStudent.setEmail(em);
            for (Student s: listStudent){
                if (s.Email.equals(editStudent.Email)&& s.Fullname.equals(editStudent.Fullname)){
                    s.setFullname(fn);
                    s.setEmail(em);
                }
            }

        }
        tbview.setItems(listStudent);
//        lv.setItems(listStudent);
//        lv.refresh();
        tbview.refresh();
        editStudent = null;
        clearInput();
//        String txt = txtInfo.getText();

//        txt += "\n=================";
//        txt += "\nFullname: "+fn+"\n"+"Email: "+em;
//        txtInfo.setText(txt);

//       Student s= new Student(fn,em);
//       listStudent.add(s);
//       String txt  = "";
//       for (Student sv: listStudent){
//           txt ="\n=========\n"+sv.toString();
//       }
//       txtInfo.setText(txt);
//        lv.setItems(listStudent);
//        clearInput();

        //    IStudent s = new IStudent() {
//        @Override
//        public void leand() {
//
//        }
//    };
//        IStudent s1 =(a) ->{
//
//        };
//        s1.leand(5);
//        ArrayList<String> arrs = new ArrayList<>();
//        arrs.add("Hello");
//        arrs.add("world");
//
//        arrs.stream().filter(s->!s.equals("a")).forEach(s->{
//            System.out.println(s);
//        });
    }
    void clearInput(){
        txtEmail.clear();
        txtFullName.clear();
    }

    public void edit(MouseEvent mouseEvent) {
//         editStudent =lv.getSelectionModel().getSelectedItem();
        txtFullName.setText(editStudent.Fullname);
        txtEmail.setText(editStudent.Email);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cfullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        caction.setCellValueFactory(new PropertyValueFactory<>("edit"));

        stFullName=txtFullName;
        stEmail=txtEmail;
    }
}
