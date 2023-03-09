package dataDaoMovi;

import database.Dtabase;
import entities.Classes;
import entities.Cuahang;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class cuhangDao {
    private  static cuhangDao instance;
    private  cuhangDao(){

    }
    public  static cuhangDao getInstance(){
        if (instance==null){
            instance = new cuhangDao();
        }
        return instance;
    }
    public ArrayList<Cuahang> getAll() {
        ArrayList<Cuahang> list = new ArrayList<>();
        try {
            Dtabase db = Dtabase.getInstance();
            Statement stt = db.getStatement();
            String sql = "select * from cuahang";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                Double giatien = rs.getDouble("giatien");
               Cuahang b = new Cuahang(id, name,giatien);
                list.add(b);
            }
        } catch (Exception e) {

        }
        return list;
    }
}
