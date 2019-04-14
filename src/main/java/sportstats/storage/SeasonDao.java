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
import java.util.ArrayList;
import java.util.List;
import sportstats.db.DbConnectionSingleton;
import sportstats.domain.Season;

/**
 *
 * @author Niklas
 */
public class SeasonDao implements IDao<Season> {
    
    private final DbConnectionSingleton dbConnectionSingleton;
    
    /**
     * Instantiates a new course DAO.
     */
    public SeasonDao() {
        dbConnectionSingleton = DbConnectionSingleton.getInstance();
    }

    @Override
    public Season get(int id) {
        
        String seasonId = "'" + id + "'";
        
        Season season = new Season();
  
        try {
            ResultSet resultSet = dbConnectionSingleton.executeQuery("SELECT * FROM seasons WHERE id = " + seasonId);
            while(resultSet.next()) {
                
                season.setId(resultSet.getInt(1));
                season.setStartYear(resultSet.getInt(2));
                season.setEndYear(resultSet.getInt(3));
                season.setLeagueId(resultSet.getInt(4));
                season.setSeasonTeamMapId(resultSet.getInt(5));

            }
            dbConnectionSingleton.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return season;
    }

    @Override
    public List<Season> getAll() {
        
        ArrayList<Season> list = new ArrayList<>();

        try {
            ResultSet resultSet = dbConnectionSingleton.executeQuery("SELECT * FROM seasons");
            while(resultSet.next()) {
                
                Season season = new Season();
                
                season.setId(resultSet.getInt(1));
                season.setStartYear(resultSet.getInt(2));
                season.setEndYear(resultSet.getInt(3));
                season.setLeagueId(resultSet.getInt(4));
                season.setSeasonTeamMapId(resultSet.getInt(5));
                
                list.add(season);
                
            }
            dbConnectionSingleton.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
        
    }

    @Override
    public void save(Season t) {
        
        PreparedStatement preparedStatement = null;
        
        try {
            
            preparedStatement = dbConnectionSingleton.prepareStatement("INSERT INTO seasons "+
                    "VALUES (?, ?, ?, ?, ?)");
            
            preparedStatement.setInt(1, t.getId());
            preparedStatement.setInt(2, t.getStartYear());
            preparedStatement.setInt(3, t.getEndYear());
            preparedStatement.setInt(4, t.getLeagueId());
            preparedStatement.setInt(5, t.getSeasonTeamMapId());
            preparedStatement.executeUpdate();
            
        }
        catch (SQLException e) {
            System.out.println("Primary key already exists");
        }
        
    }

    @Override
    public void update(Season t) {
        
        PreparedStatement preparedStatement = null;
        
        try {
            
            preparedStatement = dbConnectionSingleton.prepareStatement("UPDATE seasons SET "
                    + "season_id = ?, "
                    + "start_year = ?, "
                    + "end_year =  ?, "
                    + "league_id = ?, "
                    + "season_team_map_id = ?"
            );
            
            preparedStatement.setInt(1, t.getId());
            preparedStatement.setInt(2, t.getStartYear());
            preparedStatement.setInt(3, t.getEndYear());
            preparedStatement.setInt(4, t.getLeagueId());
            preparedStatement.setInt(5, t.getSeasonTeamMapId());
            
            preparedStatement.executeUpdate();
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void delete(Season t) {
        
        PreparedStatement preparedStatement = null;
        
        String seasonId = "'" + t.getId() + "'";
        
        try {
           
            preparedStatement = dbConnectionSingleton.prepareStatement("DELETE FROM leaderboards WHERE season_id = " + seasonId);
            preparedStatement.executeUpdate();
            
            preparedStatement = dbConnectionSingleton.prepareStatement("DELETE FROM rounds WHERE season_id = " + seasonId);
            preparedStatement.executeUpdate();
            
            preparedStatement = dbConnectionSingleton.prepareStatement("DELETE FROM seasons_teams_map WHERE season_id = " + seasonId);
            preparedStatement.executeUpdate();
            
            preparedStatement = dbConnectionSingleton.prepareStatement("DELETE FROM seasons WHERE id = " + seasonId);
            preparedStatement.executeUpdate();
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public int getNumberOfColumns(){
        
        int columnCount = 0;
        
        try {
            ResultSet resultSet = dbConnectionSingleton.executeQuery("SELECT * FROM seasons");
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
            ResultSet resultSet = dbConnectionSingleton.executeQuery("SELECT * FROM seasons");
            ResultSetMetaData rsmd = resultSet.getMetaData();
            
            columnNames[0] = rsmd.getColumnName(1);
            columnNames[1] = rsmd.getColumnName(2);
            columnNames[2] = rsmd.getColumnName(3);
            columnNames[3] = rsmd.getColumnName(4);
            columnNames[4] = rsmd.getColumnName(5);

            dbConnectionSingleton.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
  
        return columnNames;
        
    }
    
}
