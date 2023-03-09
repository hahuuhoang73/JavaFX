package dataDaoMovi;

import database.Dtabase;
import entities.Cuahang;
import entities.Lichsu;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class lichsuDao {
    private  static lichsuDao instance;
    private  lichsuDao(){

    }
    public  static lichsuDao getInstance(){
        if (instance==null){
            instance = new lichsuDao();
        }
        return instance;
    }
    public ArrayList<Lichsu> getAll(){
        ArrayList<Lichsu> list= new ArrayList<>();
        try{
            Dtabase db = Dtabase.getInstance();
            Statement stt = db.getStatement();
            String sql = "select * from lichsu";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                Integer soluong = rs.getInt("soluong");
                Double giatien = rs.getDouble("giatien");
                Date date = rs.getDate("date");
                Lichsu b = new Lichsu(id,name,soluong,giatien,date);
                list.add(b);
            }
        }catch (Exception e){

        }
        return list;
    }





}
