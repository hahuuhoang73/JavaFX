package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public  static Connection connectionDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connec = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviticker","root","");
            return connec;


        }catch (Exception e){
e.printStackTrace();
        }
        return null;
    }

}
