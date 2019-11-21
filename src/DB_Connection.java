import java.sql.*;

public class DB_Connection {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/kit";
            String user = "root";
            String pass = "";
            Connection c = DriverManager.getConnection(url, user, pass);
            Statement s = c.createStatement();

            s.executeUpdate("update b6c set sname = 'Sovichea' where id = 0");
//            for (int i = 1; i < 6; i++){
//                s.executeUpdate("delete from b6c where id = " + i);
//            }

            ResultSet rs = s.executeQuery("select * from b6c");
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
