package clonatarion;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseHelper{
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement prepared = null;
    private ResultSet resultSet = null;
    private final String DATABASEURL = "jdbc:mysql://localhost/";
    private final String DATABASENAME = "Clonatarion";
    private final String DATABASEUSERNAME = "clonatarion";
    private final String DATABASEPASSWORD = "clonatarion";
    
    
    public DatabaseHelper(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = DriverManager.getConnection(DATABASEURL, DATABASEUSERNAME, DATABASEPASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getMovingUnitsTable(String query){
        try {
            Statement getUnitStatement = connection.createStatement();
            if (getUnitStatement.execute(query)){
                return getUnitStatement.getResultSet();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
   
    
}