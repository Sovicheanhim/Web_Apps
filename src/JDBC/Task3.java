package JDBC;

import java.sql.*;
import java.sql.PreparedStatement;

public class Task3 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kit","root","");
            PreparedStatement ps = c.prepareStatement("INSERT INTO b6c values (?,?)");
            ps.setString(1, "17");
            ps.setString(2, "Granger");
            ps.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
