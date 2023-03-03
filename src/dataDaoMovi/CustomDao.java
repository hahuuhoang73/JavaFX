package dataDaoMovi;

import Phim.Cutommer;
import database.Dtabase;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class CustomDao {
    private static CustomDao instance;
    private CustomDao() {
    }


    public static CustomDao getInstance(){
        if (instance==null)
        {
            instance = new CustomDao();
        }
        return instance;
    }
    public ArrayList<Cutommer> getAll(){
        ArrayList<Cutommer> list = new ArrayList<>();
        try {
            Dtabase db =Dtabase.getInstance();
            Statement stt = db.getStatement();
            String sql = "select * from customer";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()){
                Integer id = rs.getInt("id");
                String type= rs.getString("type");
                Double toal = rs.getDouble("toal");
                Date date = rs.getDate("date");
                String title= rs.getString("title");
                Time time = rs.getTime("time");
                Cutommer b = new Cutommer(id,type,toal,date,title,time);
                list.add(b);

            }




        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return list;
    }

}
