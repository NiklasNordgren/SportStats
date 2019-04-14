/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;

import sportstats.db.records.PlayerRecord;

/**
 *
 * @author Niklas
 */
public class Player {
    
    private PlayerRecord playerRecord;

    public Player(){
        this(new PlayerRecord());
    }
    
    public Player(PlayerRecord playerRecord){
        this.playerRecord = playerRecord;
    }

    public String getId() {
        return playerRecord.getString("id");
    }

    public void setId(String id) {
        playerRecord.setString("id", id);
    }

    public String getPlayerName() {
        return playerRecord.getString("player_name");
    }

    public void setPlayerName(String playerName) {
        playerRecord.setString("player_name", playerName);
    }

    public String getPlayerTeamMapId() {
        return playerRecord.getString("player_team_map_id");
    }

    public void setPlayerTeamMapId(String playerTeamMapId) {
        playerRecord.setString("player_team_map_id", playerTeamMapId);
    }
    
    
    
}
