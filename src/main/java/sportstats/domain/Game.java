/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;

import sportstats.db.records.GameRecord;

/**
 *
 * @author Niklas
 */
public class Game {
    
    private GameRecord gameRecord;

    public Game(){
        this(new GameRecord());
    }
    
    public Game(GameRecord gameRecord){
        this.gameRecord = gameRecord;
    }

    public String getId() {
        return gameRecord.getString("id");
    }

    public void setId(String id) {
        gameRecord.setString("id", id);
    }

    public String getGameDate() {
        return gameRecord.getString("game_date");
    }

    public void setGameDate(String gameDate) {
        gameRecord.setString("game_date", gameDate);
    }

    public String getHomeTeamId() {
        return gameRecord.getString("home_team_id");
    }

    public void setHomeTeamId(String homeTeamId) {
        gameRecord.setString("home_team_id", homeTeamId);
    }

    public String getAwayTeamId() {
        return gameRecord.getString("away_team_id");
    }

    public void setAwayTeamId(String awayTeamId) {
        gameRecord.setString("away_team_id", awayTeamId);
    }

    public String getRoundId() {
        return gameRecord.getString("round_id");
    }

    public void setRoundId(String roundId) {
        gameRecord.setString("round_id", roundId);
    }

    public String getResultId() {
        return gameRecord.getString("result_id");
    }

    public void setResultId(String resultId) {
        gameRecord.setString("result_id", resultId);
    }

    public String getArenaId() {
        return gameRecord.getString("arena_id");
    }

    public void setArenaId(String arenaId) {
        gameRecord.setString("arena_id", arenaId);
    }

    public String getRefereesGamesMapId() {
        return gameRecord.getString("referees_games_map_id");
    }

    public void setRefereesGamesMapId(String refereesGamesMapId) {
        gameRecord.setString("referees_games_map_id", refereesGamesMapId);
    }
  
}
