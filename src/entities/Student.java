package entities;

import controler.Studentlist;
import javafx.scene.control.Button;

import java.util.Date;

public class Student  {
    Integer id;
    String name;
    String email;
    Date birthday;
    String gender;
    Integer Class_id;
    Button edit;

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Student(Integer id, String name, String email, Date birthday, String gender, Integer class_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
        Class_id = class_id;
        this.edit= new Button("Edit");
        this.edit.setOnAction((event)->{
            Studentlist.editNguoidung=this;
            Studentlist.stName.setText(this.name);
            Studentlist.stEmail.setText(this.email);
            Studentlist.stDate.setText(String.valueOf(this.birthday));
            Studentlist.stGender.setText(this.gender);
            Studentlist.stID.setText(String.valueOf(this.Class_id));

        });
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getClass_id() {
        return Class_id;
    }

    public void setClass_id(Integer class_id) {
        Class_id = class_id;
    }
}
