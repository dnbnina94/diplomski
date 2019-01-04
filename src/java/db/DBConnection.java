/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nina
 */
public class DBConnection {
    
    private static String dbDriver = "com.mysql.jdbc.Driver";
    private static String dbName = "jdbc:mysql://localhost:3306/diplomski?useUnicode=true&characterEncoding=UTF-8";
    private static String dbUsername = "root";
    private static String dbPassword = "";
    
    public static void executeUpdate(String query){
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbName, dbUsername, dbPassword);
            stat = conn.createStatement();
            stat.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                conn.close();
            }catch(Exception e){
               Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public static ResultSet executeQuery(String query){
        Connection conn = null;
        Statement stat = null;
        ResultSet retValue = null;


        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbName, dbUsername, dbPassword);
            stat = conn.createStatement();
            retValue = stat.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retValue;
    }
    
}
