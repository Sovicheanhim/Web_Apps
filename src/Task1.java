import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kit", "root", "");
            Statement st = c.createStatement();
            System.out.println("Enter the number of records that you want to enter:");
            B6C records[] = new B6C[s.nextInt()];
            for(int i = 0; i < num; i++){
                records[i] = new B6C();
                System.out.println("Enter your id and name:");
                records[i].setId(s.next());
                records[i].setSname(s.next());
                st.execute("insert into b6c values('"+records[i].getId()+"','"+records[i].getSname()+"')");
            }
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
