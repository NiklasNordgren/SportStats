/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;

import sportstats.db.records.RoundRecord;

/**
 *
 * @author Niklas
 */
public class Round {
    
    private RoundRecord roundRecord;
  
    public Round(){
        this(new RoundRecord());
    }
    
    public Round(RoundRecord roundRecord){
        this.roundRecord = roundRecord;
    }

    public String getId() {
        return roundRecord.getString("id");
    }

    public void setId(String id) {
        roundRecord.setString("id", id);
    }

    public String getRoundNumber() {
        return roundRecord.getString("round_number");
    }

    public void setRoundNumber(String roundNumber) {
        roundRecord.setString("round_number", roundNumber);
    }

    public String getSeasonId() {
        return roundRecord.getString("season_id");
    }

    public void setSeasonId(String seasonId) {
        roundRecord.setString("season_id", seasonId);
    }
 
}
