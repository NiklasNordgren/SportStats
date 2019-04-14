/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sportstats.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.javalite.activejdbc.Base;
/**
 * DbConnectionSingleton is a Singleton object that manages the database connection.
 * All transactions between Data acess objects and the database is performed by this object.
 *
 * A suitable database with tables that has correct column names aswell as a user with the correct credentials is also needed for
 * this to work properly.
 *
 * @author Niklas Nordgren
 * @version 2019-02-18
 */

public class DbConnectionSingleton {
    
    private static final String DB_NAME = "sportstats";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String CONNECTION_URL = "jdbc:mysql://localhost/" + DB_NAME;
    
    private Connection connection = null;
    private Statement statement = null;
    
    private static DbConnectionSingleton instance = null;
    
    private boolean prompts = false;
    
    /**
     * Instantiates a new DbConnectionSingleton.
     */
    private DbConnectionSingleton() {}
    
    /**
     * Gets the single instance of DbConnectionSingleton.
     *
     * @return single instance of DbConnectionSingleton
     */
    public static DbConnectionSingleton getInstance() {
        if(instance == null) {
            instance = new DbConnectionSingleton();
        }
        return instance;
    }
    
    /**
     * Gets the connection.
     *
     * @return the connection
     */
    private Connection getConnection() {
        
        try {
            connection = DriverManager.getConnection(CONNECTION_URL, USER, PASSWORD);
            if(prompts)
                System.out.println("Connected to the MySQL server successfully.");
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return connection;
    }
    
    /**
     * Gets the statement.
     *
     * @param connection the connection
     * @return the statement
     */
    private Statement getStatement(Connection connection) {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println("Could not create Statement");
            System.err.println(e.getMessage());
        }
        return statement;
    }
    
    /**
     * Execute query.
     *
     * @param sqlString the sql string
     * @return the result set
     * @throws SQLException the SQL exception
     */
    public ResultSet executeQuery( String sqlString) throws SQLException {
        return this.getStatement(this.getConnection()).executeQuery(sqlString);
    }
    
    /**
     * Prepare statement.
     *
     * @param statementString the statement string
     * @return the prepared statement
     * @throws SQLException the SQL exception
     */
    public PreparedStatement prepareStatement(String statementString) throws SQLException{
        return this.getConnection().prepareStatement(statementString, Statement.RETURN_GENERATED_KEYS);
    }
    
    /**
     * Close.
     */
    public void close() {
        
        try {
            if(statement != null) statement.close();
            if(connection != null) connection.close();
            if(prompts)
                System.out.println("DB connection closed");
        }catch(SQLException e) {
            System.err.println("Could not close the statement or connection");
            System.err.println(e.getMessage());
        }
        
        if(Base.hasConnection())
            Base.close();
    }
    
    public void open(){
        
        Base.open("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost/sportstats", "root", "root");
        
    }
    
}
