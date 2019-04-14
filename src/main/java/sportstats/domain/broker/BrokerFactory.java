/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain.broker;

/**
 *
 * @author Niklas
 */
public class BrokerFactory {
    
    public SportBroker getSportBroker(){
        return new SportBroker();
    }
    
    public SeasonBroker getSeasonBroker(){
        return new SeasonBroker();
    }
    
    public LeagueBroker getLeagueBroker(){
        return new LeagueBroker();
    }
    
    public LeaderboardBroker getLeaderboardBroker(){
        return new LeaderboardBroker();
    }
        
}
