package dataDaoMovi;

import Phim.Movie;
import daopatten.StudentDao;
import database.Dtabase;
import entities.Classes;
import entities.Student;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MoviDao {
    private static MoviDao instance;
    private MoviDao(){

    }
    public static MoviDao getInstance(){
        if (instance==null)
        {
            instance = new MoviDao();
        }
        return instance;
    }
    public ArrayList<Movie> getAll() {
        ArrayList<Movie> list = new ArrayList<>();
        try{
            Dtabase db =Dtabase.getInstance();
            Statement stt = db.getStatement();
            String sql = "select * from movi";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()){
                Integer id = rs.getInt("id");
                String tile = rs.getString("tile");
                String genre = rs.getString("genre");
                String img = rs.getString("img");
                String time = rs.getString("time");
                Date date =rs.getDate("Showing_Date");

                Movie b = new Movie(id,tile,genre,img,time,date);
                list.add(b);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return list;
    }
}
