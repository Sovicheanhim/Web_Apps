import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the number of records that you want to enter:");
        B6C records[] = new B6C[s.nextInt()];
        for (int i = 0; i < records.length; i++) {
            records[i] = new B6C();
            System.out.println("Enter your id and name:");
            records[i].setId(s.next());
            records[i].setSname(s.next());
        }
        DB_Operation op = new DB_Operation();
        op.insertRecord(records);
    }
}
