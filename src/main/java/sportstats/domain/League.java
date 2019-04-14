/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;

import java.util.List;
import sportstats.storage.LeagueDao;

/**
 *
 * @author Niklas
 */
public class League {
    
    private int id;
    private String leagueName;
    private int sportId;
    
    private LeagueDao leagueDao;
    
    public League(){
        this(new LeagueDao());
    }
    
    public League(LeagueDao leagueDao){
        this.leagueDao = leagueDao;
    }

    public League get(int id){
        return leagueDao.get(id);
    }
 
    public List<League> getAll(){
        return leagueDao.getAll();
    }
    
    public void save(){
        leagueDao.save(this);
    }
    
    public void update(){
        leagueDao.update(this);
    }
    
    public void delete(){
        leagueDao.delete(this);
    }
    
    public int getNumberOfColumns(){
        return leagueDao.getNumberOfColumns();
    }
    
    public String[] getColumnNames(){
        return leagueDao.getColumnNames();
    }
    
    //Getters n setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }
   
}
