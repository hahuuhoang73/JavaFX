package daopatten;

import database.Dtabase;
import entities.Classes;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClassesDao {
    private static ClassesDao instance;
    private  ClassesDao(){

    }
    public static ClassesDao getInstance(){
        if (instance==null)
        {
            instance = new ClassesDao();
        }
        return instance;
    }
    public ArrayList<Classes> getAll(){
        ArrayList<Classes> list = new ArrayList<>();
        try{
            Dtabase db =Dtabase.getInstance();
            Statement stt = db.getStatement();
            String sql = "select * from lophoc";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String room = rs.getString("room");
                Classes b = new Classes(id,name,room);
                list.add(b);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return list;
    }
    public boolean creadte(Classes classes){
        try{
            Dtabase db = Dtabase.getInstance();
            Statement stt = db.getStatement();
            String sql = "insert into lophoc(name,room) values('"+classes.getName()+"','"+classes.getRoom()+"')";
         if (stt.executeUpdate(sql)>0){
             return true;
         }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  false;
    }
    public  boolean update(Classes classes){
        try {
            Dtabase db = Dtabase.getInstance();
            Statement stt = db.getStatement();
            String sql = "update lophoc set name='" + classes.getName() + "', room='" + classes.getRoom() + "' where id=" + classes.getId();
            if (stt.executeUpdate(sql) > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;





    }
    public boolean delete(Classes classes){
        try {
            Dtabase db =  Dtabase.getInstance();
            Statement stt = db.getStatement();
            String sql = "delete from lophoc where id=" + classes.getId();
            if (stt.executeUpdate(sql) > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

  public  Classes find(Integer id){
      try{
          Dtabase db =Dtabase.getInstance();
          Statement stt = db.getStatement();
          String sql = "select * from lophoc where id="+id;
          ResultSet rs = stt.executeQuery(sql);
          while (rs.next()){

              String name = rs.getString("name");
              String room = rs.getString("room");
              Classes b = new Classes(id,name,room);
             return  b;
          }
      }catch (Exception e){
          System.out.println(e.getMessage());
      }
      return  null;
  }
}
