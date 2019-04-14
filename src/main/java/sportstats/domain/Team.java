/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;

import sportstats.db.records.TeamRecord;

/**
 *
 * @author Niklas
 */
public class Team {
    
    private TeamRecord teamRecord;

    public Team(){
        this(new TeamRecord());
    }
    
    public Team(TeamRecord teamRecord){
        this.teamRecord = teamRecord;
    }

    public String getId() {
        return teamRecord.getString("id");
    }

    public void setId(String id) {
        teamRecord.setString("id", id);
    }

    public String getTeamName() {
        return teamRecord.getString("team_name");
    }

    public void setTeamName(String teamName) {
        teamRecord.setString("team_name", teamName);
    }

    public String getArenaId() {
        return teamRecord.getString("arena_id");
    }

    public void setArenaId(String arenaId) {
        teamRecord.setString("arena_id", arenaId);
    }

    public String getPlayerTeamMapId() {
        return teamRecord.getString("player_team_map_id");
    }

    public void setPlayerTeamMapId(String playerTeamMapId) {
        teamRecord.setString("player_team_map_id", playerTeamMapId);
    }

    public String getSeasonTeamMapId() {
        return teamRecord.getString("season_team_map_id");
    }

    public void setSeasonTeamMapId(String seasonTeamMapId) {
        teamRecord.setString("season_team_map_id", seasonTeamMapId);
    }

}
