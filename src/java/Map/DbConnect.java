/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Map;
import java.sql.*;
/**
 *
 * @author pc
 */
public class DbConnect {
     private static Connection con;

    public static Connection getConnection() {
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/wedding?useSSL=false","root","Root@123");
                System.out.println("Successfully Connected to Database !! ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return con;
    }
}
