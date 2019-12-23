package JDBC;

import java.sql.*;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kit", "root", "");
            Statement s = c.createStatement();
//            readAll
//            ResultSet rs = s.executeQuery("SELECT * FROM b6c");
//            read a singTle value
//            ResultSet rs = s.executeQuery("SELECT * FROM b6c WHERE id = '01'");
//            read a specific record
            System.out.println("Enter the id that you want to search ");
            int inputId = sc.nextInt();
            ResultSet rs = s.executeQuery("SELECT * FROM b6c WHERE id = '"+inputId+"'");
            while(rs.next()){
                String name = rs.getString("sname");
                String id = rs.getString("id");
                System.out.println(id + " : " + name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
