/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nimesh
 */
public class MarkAttendance {
    
    String studentid;
    String date;
    String atdday;
    int today;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public MarkAttendance(String stdid, String atddate, int day) {
        
        studentid = stdid;
        date = atddate;
        today = day;
        
        switch (today) {
          case 1:
            atdday = "Sun";
            break;
          case 2:
            atdday = "Mon";
            break;
          case 3:
            atdday = "Tue";
            break;
          case 4:
            atdday = "Wed";
            break;
          case 5:
            atdday = "Thu";
            break;
          case 6:
            atdday = "Fri";
            break;
          case 7:
            atdday = "Sat";
            break;
        }
        
        con = DatabaseConnection.ConnectDatabase();
                
        if(con != null){
                    
            try{
                        
                PreparedStatement pstmt;
                pstmt = (PreparedStatement)
                    con.prepareStatement("insert into attendance (stdid, date, day) values (?,?,?)");
                        
                    pstmt.setString(1, studentid);
                    pstmt.setString(2, date);
                    pstmt.setString(3, atdday);
                        
                    pstmt.executeUpdate();
                                                
                }
            
            catch(SQLException ex){
                
                ex.printStackTrace();
                
            }
            }
        
    }

}
