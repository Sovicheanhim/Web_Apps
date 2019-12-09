import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB_Transaction {
    public static void main(String[] args) {
        new DB_Transaction().transact();
    }
    Connection c = null;
    Scanner s = new Scanner(System.in);
    Statement st = null;
    int debId = 0, amt = 0, creId = 0;
    public void transact(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kit", "root", "");
            st = c.createStatement();
            c.setAutoCommit(false);
            System.out.println("Enter the id you want to debit: ");
            debId = s.nextInt();
            System.out.println("Enter the amount you want to transfer: ");
            amt = s.nextInt();
            System.out.println("Enter the id you want to credit: ");
            creId = s.nextInt();

            st.executeUpdate("update bank set amt = amt - '"+amt+"' where id = '"+debId+"'");
            st.executeUpdate("update bank set amt = amt + '"+amt+"' where id = '"+creId+"'");
            c.commit();
            System.out.println("Transaction is completed. Thank you for using our service");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            try {
                c.rollback();
                System.out.println("Transaction failed. Thank you for using our service.");
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Rollback failed. Thank you for using our service.");
            }
        }
    }
}
