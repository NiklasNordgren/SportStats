/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;

import sportstats.db.records.ResultRecord;

/**
 *
 * @author Niklas
 */
public class Result {
    
    private ResultRecord resultRecord;

    public Result(){
        this(new ResultRecord());
    }
    
    public Result(ResultRecord resultRecord){
        this.resultRecord = resultRecord;
    }

    public String getId() {
        return resultRecord.getString("id");
    }

    public void setId(String id) {
        resultRecord.setString("id", id);
    }

    public String getHomeTeamGoals() {
        return resultRecord.getString("home_team_goals");
    }

    public void setHomeTeamGoals(String homeTeamGoals) {
        resultRecord.setString("home_team_goals", homeTeamGoals);
    }

    public String getAwayTeamGoals() {
        return resultRecord.getString("away_team_goals");
    }

    public void setAwayTeamGoals(String awayTeamGoals) {
        resultRecord.setString("away_team_goals", awayTeamGoals);
    }

}
