import javafx.scene.control.Button;

public class Student {
    String Fullname;
    String Email;
    Button edit ;

    public Student(String fullname, String email) {
        Fullname = fullname;
        Email = email;
        this.edit= new Button("Edit");
        this.edit.setOnAction((event)->{
            ThongTin.editStudent =this;
            ThongTin.stFullName.setText(this.Fullname);
            ThongTin.stEmail.setText(this.Email);
        });
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
    public  String toString(){
        return this.Fullname+"--"+this.Email;
    }
}
