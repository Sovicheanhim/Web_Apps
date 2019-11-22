import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB_Operation {
    static Scanner s = new Scanner(System.in);
    static Statement st = null;
    static Connection c = null;
    public void getStatement() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kit", "root", "");
            st = c.createStatement();
    }
    public void insertRecord(B6C[] records) {
        try {
            getStatement();
            for(B6C record: records){
                st.execute("insert into b6c values('"+record.getId()+"','"+record.getSname()+"')");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
