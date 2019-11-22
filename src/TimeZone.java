import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TimeZone {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kit", "root", "");
            Statement st = c.createStatement();
            st.execute("SET @@global.time_zone = '+00:00'");
            st.execute("SET @@session.time_zone = '+00:00'");
            st.execute("SELECT @@global.time_zone, @@session.time_zone");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
