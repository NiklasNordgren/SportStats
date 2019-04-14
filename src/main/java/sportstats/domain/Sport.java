/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;

import java.util.ArrayList;
import java.util.List;
import org.javalite.activejdbc.Base;
import sportstats.db.records.SportRecord;

/**
 *
 * @author Niklas
 */ 
public class Sport{
    
    private final SportRecord sportRecord;
    
    public Sport(){
        this(new SportRecord());
    }
    
    public Sport(SportRecord sportRecord){
        this.sportRecord = sportRecord;
    }

    public String getId(){
        return sportRecord.getString("id");
    }
    
    public void setId(String id){
        sportRecord.setString("id", id);
    }
    
    public String getSportName(){
        return sportRecord.getString("sport_name");
    }
    
    public void setSportName(String name){
        sportRecord.setString("sport_name", name);
    }
    
    public static int getNumberOfColumns(){
        
        //TODO: Get number of columns from the database
        
        return 2;
    }
    
    public static String[] getColumnNames(){
        
        //TODO: Get the column names from the database
        
        String[] columnNames = {"id", "sport_name"};
        return columnNames;
        
    }
    
    public static List<Sport> findAll(){
        
        List<Sport> sports = new ArrayList<>();
  
        List<SportRecord> sportRecords = SportRecord.findAll();

        for(int i = 0; i < sportRecords.size(); i++){
            
            Sport sport = new Sport();
            sport.setId(sportRecords.get(i).getString("id"));
            sport.setSportName(sportRecords.get(i).getString("sport_name"));
            sports.add(sport);
        }
        
        return sports;
    }

    public static Sport findById(int id){

        SportRecord sportRecord = SportRecord.findById(id);

        Sport sport = new Sport();
        sport.setId(sportRecord.getString("id"));
        sport.setSportName(sportRecord.getString("sport_name"));

        return sport;
    }
    
    public void save(){
        this.sportRecord.save();
    }
    
    public void delete(){
        this.sportRecord.delete();
    }
    
}
