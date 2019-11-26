import java.sql.*;
import java.sql.PreparedStatement;

public class Section_C {
    public static void main(String[] args) {
        try {
            String[] names = {"Born Sothanak",
                    "Chen sokheng",
                    "Chhy Sokuntevy",
                    "Chor Visalrotanak",
                    "Chrea Chanchhunneng",
                    "Horn Kimhorng",
                    "Ichigo Taga",
                    "Iv Layhort",
                    "Kong Panhabot",
                    "Kosal Sotherny",
                    "kim Theara",
                    "Kuoch ariya",
                    "Khy Vireakpanha",
                    "Lab Daro",
                    "Lim Chansamnang",
                    "Lol sreysa",
                    "Meas Soknoy",
                    "Nhim Sovichea",
                    "Ny Yanty",
                    "Ou Mengheang",
                    "Ouk yulong",
                    "Prom Suthirak",
                    "Phon Sokpheaktra",
                    "Rin Kimhun",
                    "Sary Sodaney",
                    "Seng Sovanndy",
                    "Sum Sovann",
                    "Soun senghout",
                    "Sin Sovannmony",
                    "Thy Makra",
                    "Toun Phanhavireakboth",
                    "Uon Sokhuong",
                    "Yeoh Soon Keat"};
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kit","root", "");
            PreparedStatement ps = c.prepareStatement("insert into sectionC values(?,?)");
            for(int i = 0; i < names.length -1 ; i++){
                ps.setString(1, String.valueOf(i+1));
                ps.setString(2, names[i]);
                ps.addBatch();
            }

            ps.executeBatch();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
