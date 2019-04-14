/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;

import sportstats.db.records.ArenaRecord;


/**
 *
 * @author Niklas
 */
public class Arena {

    private ArenaRecord arenaRecord;
    
    public Arena(){
        this(new ArenaRecord());
    }
    
    public Arena(ArenaRecord arenaRecord){
        this.arenaRecord = arenaRecord;
    }

    public String getId() {
        return arenaRecord.getString("id");
    }

    public void setId(String id) {
        arenaRecord.setString("id", id);
    }

    public String getArenaName() {
        return arenaRecord.getString("arena_name");
    }

    public void setArenaName(String arenaName) {
        arenaRecord.setString("arena_name", arenaName);
    }

    public String getArenaCity() {
        return arenaRecord.getString("arena_city");
    }

    public void setArenaCity(String arenaCity) {
        arenaRecord.setString("arena_city", arenaCity);
    }
    
}
