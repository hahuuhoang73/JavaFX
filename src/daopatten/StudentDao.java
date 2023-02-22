package daopatten;

import database.Dtabase;
import entities.Classes;
import entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class StudentDao {
    private static  StudentDao instance;
    private StudentDao(){

    }
    public static StudentDao getInstance(){
        if (instance==null)
        {
            instance = new StudentDao();
        }
        return instance;
    }
    public  ArrayList<Student> getAll(){
        ArrayList<Student> list1 = new ArrayList<>();
        try{
            Dtabase db =Dtabase.getInstance();
            Statement stt = db.getStatement();
            String sql = "select * from sinhvien";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birthday = rs.getDate("birthday");
                String gender = rs.getString("gender");
                Integer idzoom = rs.getInt("class_id");
                Student b = new Student(id,name,email,birthday,gender,idzoom);
                list1.add(b);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return list1;
    }
    public  Boolean addStudent(Student student){
        try{
            Dtabase db = Dtabase.getInstance();
            Statement stt = db.getStatement();
            String sql = "insert into sinhvien(name,email,birthday,gender,class_id) values('"+student.getName()+"','"+student.getEmail()+"','"+student.getBirthday()+"','"+student.getGender()+"','"+student.getClass_id()+"')";
            if (stt.executeUpdate(sql)>0){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  false;

    }



}
