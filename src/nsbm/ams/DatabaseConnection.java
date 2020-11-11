/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nimesh
 */
public class DatabaseConnection {
    
    static final String db_url = "jdbc:mysql://localhost:3306/nsbm_ams?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String username = "root";
    static final String password = "";
    
    public static Connection ConnectDatabase(){
        
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(db_url,username,password);
            return con;
        }
        catch (Exception ex) {
            return null;
        }
        
        
    }
    
//    public static Connection getConnection(){
//        
//        Connection conn = null;
//    
//    try{
//        Class.forName("com.mysql.jdbc.Driver");
//    }
//    catch(ClassNotFoundException ex){
//        Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
//    }
//                    
//    try {
//        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nsbm_ams?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
//    }
//    catch (SQLException ex) {
//        Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
//    }
//
//    return conn;
//        
//    }    
//                     
}
