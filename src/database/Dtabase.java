package database;

import entities.Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dtabase {
private static Dtabase instance;
    private  Statement statement;

    private Dtabase() throws Exception{

            Class.forName("com.mysql.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/cangtin";
            String user ="root";
            String pwd = "";
            Connection conn= DriverManager.getConnection(connectionString, user, pwd);
            this.statement = conn.createStatement();

    }
    public static Dtabase getInstance() throws Exception {
        if (instance == null){
            instance = new Dtabase();
        }
        return instance;
    }
    public  Statement getStatement(){
        return statement;
    }
}
