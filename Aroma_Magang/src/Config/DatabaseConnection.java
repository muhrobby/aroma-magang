/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.*;

/**
 *
 * @author muhrobby
 */
public class DatabaseConnection {
       public static Connection connect(){
           Connection conn = null;
           
           try {
               String url = "jdbc:mysql://localhost:3306/aroma_magang";
               String user = "root";
               String pass = "";
               conn = DriverManager.getConnection(url, user, pass);
               System.out.println("Koneksi Berhasil");
           } catch (SQLException e) {
               System.out.println("Koneksi gagal : " + e.getMessage());
           }
           
           return conn;
       }

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
