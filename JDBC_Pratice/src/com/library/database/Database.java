package com.library.database;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    static  Connection con;
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user="root";
            String password="Admin@123";
            String url="jdbc:mysql://localhost:3306/LibraryManagement?autoReconnect=true&useSSL=false";
//              con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_Pratice?user=root&password=Admin@123");
            con=DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}
