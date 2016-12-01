/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import test.JdbcUtil;

/**
 *
 * @author Samaya
 */
public class LoginService {
    public boolean checkLogin(String username, String password){
        try {
             Connection conn = JdbcUtil.getConnection();
             String query = "Select * from accounts where email=? and password=?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, username);
             ps.setString(2, password);
             
             
             ResultSet rs = ps.executeQuery();
             
//             if(rs == null){
//                 return false
//             }
             if(rs.next())
             {
              return true;
             }
                
        } catch (Exception e) {
        }
       
        return false;
    }
    public boolean checkProfile(String username){
        try {
             Connection conn = JdbcUtil.getConnection();
             String query = "Select profile from accounts where email=? and profile=0";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, username);
          
             ResultSet rs = ps.executeQuery();
             
//             if(rs == null){
//                 return false
//             }
             if(rs.next())
             {
                
              return true;
             }
                
        } catch (Exception e) {
        }
       
        return false;
    }
    
    public static void main(String [] args){
        LoginService l = new LoginService();
        boolean res = l.checkLogin("test.com", "test");
        System.out.println(res);
    }
    
   
   
}
