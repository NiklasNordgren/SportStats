/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;

import sportstats.db.records.RefereeRecord;

/**
 *
 * @author Niklas
 */
public class Referee {
    
    private RefereeRecord refereeRecord;

    public Referee(){
        this(new RefereeRecord());
    }
    
    public Referee(RefereeRecord refereeRecord){
        this.refereeRecord = refereeRecord;
    }

    public String getId() {
        return refereeRecord.getString("id");
    }

    public void setId(String id) {
        refereeRecord.setString("id", id);
    }

    public String getRefereeName() {
        return refereeRecord.getString("referee_name");
    }

    public void setRefereeName(String refereeName) {
        refereeRecord.setString("referee_name", refereeName);
    }

    public String getRefereesGamesMapId() {
        return refereeRecord.getString("referees_games_map_id");
    }

    public void setRefereesGamesMapId(String refereesGamesMapId) {
        refereeRecord.setString("referees_games_map_id", refereesGamesMapId);
    }
    
}
