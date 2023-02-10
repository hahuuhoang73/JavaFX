import javafx.scene.control.Button;

public class Nguoidung {

    String Name;
    String Phone;
    Button edit;

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Nguoidung(String name, String phone) {
        Name = name;
        Phone = phone;
        this.edit= new Button("Edit");
        this.edit.setOnAction((event)->{
           Danhba.editNguoidung=this;
           Danhba.stName.setText(this.Name);
         Danhba.stPhone.setText(this.Phone);
        });

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
    public  String toString(){
        return this.Name;
    }


}
