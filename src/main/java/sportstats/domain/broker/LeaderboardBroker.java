/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain.broker;

import java.util.List;
import sportstats.domain.Leaderboard;

/**
 *
 * @author Niklas
 */
public class LeaderboardBroker {
    
    public List<Leaderboard> findAll(){
        return Leaderboard.findAll();
    }
    
    public Leaderboard findById(int id){
        return Leaderboard.findById(id);
    }
    
    public Leaderboard create(){
        return new Leaderboard();
    }
    
}
