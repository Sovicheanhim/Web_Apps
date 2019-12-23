package JDBC;

import java.sql.*;

public class PreparedStatement {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kit", "root", "");
            java.sql.PreparedStatement p = c.prepareStatement("insert into b6c values(?,?)");
            p.setString(1, "15");
            p.setString(2, "Grock");
            p.addBatch("update b6c set sname = 'Fanny' where id = '14'");
            p.addBatch("insert b6c values(16, 'Harith')");
            p.executeBatch();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
