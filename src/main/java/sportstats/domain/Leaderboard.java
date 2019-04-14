/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;

import java.util.ArrayList;
import java.util.List;
import sportstats.db.records.LeaderboardRecord;

/**
 *
 * @author Niklas
 */

public class Leaderboard{
    
    private final LeaderboardRecord leaderboardRecord;
    
    public Leaderboard(){
        this(new LeaderboardRecord());
    }
    
    public Leaderboard(LeaderboardRecord leaderboardRecord){
        this.leaderboardRecord = leaderboardRecord;
    }
    
   public String getId(){
        return leaderboardRecord.getString("id");
    }
    
    public void setId(String id){
        leaderboardRecord.setString("id", id);
    }
    
    public String getSeasonId(){
        return leaderboardRecord.getString("season_id");
    }
    
    public void setSeasonId(String seasonId){
        leaderboardRecord.setString("season_id", seasonId);
    }
    
    public static int getNumberOfColumns(){
        return 2;
    }
    
    public static String[] getColumnNames(){
        String[] columnNames = {"id", "season_id"};
        return columnNames;
    }
    
    public static List<Leaderboard> findAll(){
        
        List<Leaderboard> leaderboards = new ArrayList<>();
        List<LeaderboardRecord> leaderboardRecords = LeaderboardRecord.findAll();
        
        for(int i = 0; i < leaderboardRecords.size(); i++){
            
            Leaderboard leaderboard = new Leaderboard();
            leaderboard.setId(leaderboardRecords.get(i).getString("id"));
            leaderboard.setSeasonId(leaderboardRecords.get(i).getString("season_id"));
            leaderboards.add(leaderboard);
        }
        
        return leaderboards;
    }

    public static Leaderboard findById(int id){
        
        LeaderboardRecord leaderboardRecord = LeaderboardRecord.findById(id);
        
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.setId(leaderboardRecord.getString("id"));
        leaderboard.setSeasonId(leaderboardRecord.getString("season_id"));

        return leaderboard;
    }
    
    public void save(){
        this.leaderboardRecord.save();
    }
    
    public void delete(){
        this.leaderboardRecord.delete();
    }

}
