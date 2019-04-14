/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sportstats.storage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sportstats.db.DbConnectionSingleton;
import sportstats.domain.League;

/**
 *
 * @author Niklas
 */
public class LeagueDao implements IDao<League> {
    
    private final DbConnectionSingleton dbConnectionSingleton;
    
    /**
     * Instantiates a new course DAO.
     */
    public LeagueDao() {
        dbConnectionSingleton = DbConnectionSingleton.getInstance();
    }
    
    @Override
    public League get(int id) {
        
        String leagueId = "'" + id + "'";
        
        League league = new League();
  
        try {
            ResultSet resultSet = dbConnectionSingleton.executeQuery("SELECT * FROM leagues WHERE id = " + leagueId);
            while(resultSet.next()) {
                
                league.setId(resultSet.getInt(1));
                league.setLeagueName(resultSet.getString(2));
                league.setSportId(resultSet.getInt(3));

            }
            dbConnectionSingleton.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return league;
    }
    
    @Override
    public List<League> getAll() {
        
        ArrayList<League> list = new ArrayList<>();
        
        try {
            ResultSet resultSet = dbConnectionSingleton.executeQuery("SELECT * FROM leagues");
            while(resultSet.next()) {
                
                League league = new League();
                
                league.setId(resultSet.getInt(1));
                league.setLeagueName(resultSet.getString(2));
                league.setSportId(resultSet.getInt(3));
                
                list.add(league);
            }
            dbConnectionSingleton.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    @Override
    public void save(League t) {
        
        PreparedStatement preparedStatement = null;
        
        try {
            
            preparedStatement = dbConnectionSingleton.prepareStatement("INSERT INTO leagues "+
                    "VALUES (?, ?, ?)");
            
            preparedStatement.setInt(1, t.getId());
            preparedStatement.setString(2, t.getLeagueName());
            preparedStatement.setInt(3, t.getSportId());
            preparedStatement.executeUpdate();
            
        }
        catch (SQLException e) {
            System.out.println("Primary key already exists");
        }
        
    }
    
    @Override
    public void update(League t) {
        
        PreparedStatement preparedStatement = null;
        
        try {
            
            preparedStatement = dbConnectionSingleton.prepareStatement("UPDATE leagues SET "
                    + "league_id = ?, "
                    + "league_name = ?, "
                    + "sport_id =  ?, "
            );
            
            preparedStatement.setInt(1, t.getId());
            preparedStatement.setString(2, t.getLeagueName());
            preparedStatement.setInt(3, t.getSportId());
            
            preparedStatement.executeUpdate();
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void delete(League t) {
        
        PreparedStatement preparedStatement = null;
        
        String leagueId = "'" + t.getId() + "'";
        
        try {
            
            preparedStatement = dbConnectionSingleton.prepareStatement("DELETE FROM seasons WHERE league_id = " + leagueId);
            preparedStatement.executeUpdate();
            
            preparedStatement = dbConnectionSingleton.prepareStatement("DELETE FROM leagues WHERE id = " + leagueId);
            preparedStatement.executeUpdate();
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public int getNumberOfColumns(){
        
        int columnCount = 0;
        
        try {
            ResultSet resultSet = dbConnectionSingleton.executeQuery("SELECT * FROM leagues");
            columnCount = resultSet.getMetaData().getColumnCount();
            dbConnectionSingleton.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return columnCount;
        
    }
    
    public String[] getColumnNames(){
        
        String[] columnNames = new String[getNumberOfColumns()];
        
        try {
            ResultSet resultSet = dbConnectionSingleton.executeQuery("SELECT * FROM leagues");
            ResultSetMetaData rsmd = resultSet.getMetaData();
            
            columnNames[0] = rsmd.getColumnName(1);
            columnNames[1] = rsmd.getColumnName(2);
            columnNames[2] = rsmd.getColumnName(3);

            dbConnectionSingleton.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
  
        return columnNames;
        
    }
    
}
