package JDBC;

import JDBC.B6C;
import JDBC.DB_Operation;

import java.sql.*;
import java.util.Scanner;

public class Task1 {
    static Scanner s = new Scanner(System.in);
    static String id = "";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        System.out.println("Enter the number of records that you want to enter:");
//        JDBC.B6C records[] = new JDBC.B6C[s.nextInt()];
//        for (int i = 0; i < records.length; i++) {
//            records[i] = new JDBC.B6C();
//            System.out.println("Enter your id and name:");
//            records[i].setId(s.next());
//            records[i].setSname(s.next());
//        }
        System.out.println("Enter the id that you want to search:");
        id = s.next();
        DB_Operation op = new DB_Operation();
//        op.insertRecords(records);
        B6C readData = op.readRecord(id);
        System.out.println(readData.getId()+" : "+ readData.getSname());
        op.preparedStatement();
    }
}
