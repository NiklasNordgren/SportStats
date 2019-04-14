/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;

import java.util.List;
import sportstats.storage.SeasonDao;

/**
 *
 * @author Niklas
 */
public class Season {
    
    private int id;
    private int startYear;
    private int endYear;
    private int leagueId;
    private int seasonTeamMapId;
    
    private final SeasonDao seasonDao;
    
    public Season(){
        this(new SeasonDao());
    }
    
    public Season(SeasonDao seasonDao){
        this.seasonDao = seasonDao;
    }

    public Season get(int id){
        return seasonDao.get(id);
    }
 
    public List<Season> getAll(){
        return seasonDao.getAll();
    }
    
    public void save(){
        seasonDao.save(this);
    }
    
    public void update(){
        seasonDao.update(this);
    }
    
    public void delete(){
        seasonDao.delete(this);
    }
    
    public int getNumberOfColumns(){
        return seasonDao.getNumberOfColumns();
    }
    
    public String[] getColumnNames(){
        return seasonDao.getColumnNames();
    }
    
    //Getters n setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public int getSeasonTeamMapId() {
        return seasonTeamMapId;
    }

    public void setSeasonTeamMapId(int seasonTeamMapId) {
        this.seasonTeamMapId = seasonTeamMapId;
    }

}
