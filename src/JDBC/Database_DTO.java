package JDBC;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class Database_DTO {
    public static void main(String[] args) {
        String name = "";
        String id = "";
        Scanner s = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kit", "root", "");
            Statement st = c.createStatement();
            System.out.println("Enter your id and name");
            id = s.next();
            name = s.next();
            B6C dto = new B6C();
            dto.setId(id);
            dto.setSname(name);
            st.execute("insert into b6c values('"+dto.getId()+"','"+dto.getSname()+"')");

            ResultSet rs = st.executeQuery("select * from b6c");
            while(rs.next()){
                String nameResult = rs.getString("sname");
                String idResult = rs.getString("id");
                System.out.println(idResult + " : " + nameResult);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
